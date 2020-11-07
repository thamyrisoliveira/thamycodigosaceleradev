package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "candidate")

public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @Autowired
    private CandidateMapper candidateMapper;

    @GetMapping(path = "/{userId}/{accelerationId}/{companyId}")
    public CandidateDTO findById(@PathVariable Long userId,@PathVariable Long companyId,@PathVariable Long accelerationId){
        Candidate candidate = candidateService.findById( userId, companyId,accelerationId).orElse(null);
        return candidateMapper.map(candidate);
    }

    @GetMapping(params = "companyId" )
    public List<CandidateDTO> findByCompanyId(@RequestParam Long companyId){
        List<Candidate> candidates = candidateService.findByCompanyId(companyId);
        return  candidateMapper.map(candidates);
    }

    @RequestMapping(path = "/acceleration/{accelerationId}", method = RequestMethod.GET)
    public List<CandidateDTO> findByAccelerationId(@PathVariable Long accelerationId){
        return candidateMapper.map(candidateService.findByAccelerationId(accelerationId));
    }

}

package com.challenge.endpoints;

import com.challenge.dto.SubmissionDTO;
import com.challenge.entity.Submission;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(path = "submission")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @Autowired
    private SubmissionMapper submissionMapper;

    @GetMapping(params = {"accelerationId", "accelerationId"})
    public List<SubmissionDTO> getAllSubmissions(@RequestParam Long challengeId, @RequestParam Long accelerationId){
        List<Submission> submissions = submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
        return submissionMapper.map(submissions);
    }
}

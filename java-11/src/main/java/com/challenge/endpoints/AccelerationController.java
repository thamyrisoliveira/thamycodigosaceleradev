package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/acceleration")
public class AccelerationController {

    @Autowired
    private AccelerationService accelerationService;

    @GetMapping(path = "/{accelerationId}")
    public Acceleration findById(@PathVariable("accelerationId") Long accelerationId){
        return accelerationService.findById(accelerationId).orElse(null);
    }

    @GetMapping(params = "companyId")
    public List<Acceleration> findByCompanyId(@RequestParam("companyId") Long companyId){
        return accelerationService.findByCompanyId(companyId);
    }


}

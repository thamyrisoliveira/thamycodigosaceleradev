package com.challenge.endpoints;


import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping(path = "/{companyId}", method = RequestMethod.GET)
    public Company findById(@PathVariable Long companyId){
        return companyService.findById(companyId).orElse(null);
    }

    @GetMapping(params = "accelerationId")
    public List<Company> findByAccelerationId(@RequestParam Long accelerationId){
        return companyService.findByAccelerationId(accelerationId);
    }

    @GetMapping(params = "userId")
    public List<Company> findByUserId(@RequestParam Long userId){
        return companyService.findByUserId(userId);

    }

}

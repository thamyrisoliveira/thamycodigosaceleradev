package com.challenge.endpoints;


import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "challenge")
public class ChallengeController {
    @Autowired
    private ChallengeService challengeService;


    @GetMapping(params = {"accelerationId" , "userId"})
    public List<Challenge> findByAccelerationIdAndUserId(@RequestParam Long accelerationId, @RequestParam Long userId){
      return challengeService.findByAccelerationIdAndUserId( accelerationId, userId);
    }


}

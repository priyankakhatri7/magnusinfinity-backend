package com.magnusinfinity.magnusinfinitybackend.controller;

import com.amazonaws.util.StringUtils;
import com.magnusinfinity.magnusinfinitybackend.dao.entity.Candidate;
import com.magnusinfinity.magnusinfinitybackend.dao.entity.ProductInfo;
import com.magnusinfinity.magnusinfinitybackend.dao.repository.CandidateRepository;
import com.magnusinfinity.magnusinfinitybackend.dao.repository.ProductInfoRepository;
import com.magnusinfinity.magnusinfinitybackend.util.CustomizeBeanUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@RestController("candidate")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping("/register")
    public String register(@RequestBody Candidate candidate){
        String password = candidate.getPassword();
        String md5Hex = DigestUtils.md5Hex(password).toUpperCase();
        candidate.setPassword(md5Hex);
        Candidate candidate1 = candidateRepository.save(candidate);
        return candidate1.getEmailId();
    }

    @GetMapping("/get")
    public Optional<Candidate> get(@RequestParam("emailId") String emailId){
        return candidateRepository.findById(emailId);
    }

    @PostMapping("/profileUpdate")
    public String profileUpdate(@RequestBody Candidate candidate){
        Optional<Candidate> candidate1 = candidateRepository.findById(candidate.getEmailId());
        candidate1.ifPresent( k -> {
            CustomizeBeanUtils.copyNonNullProperties(candidate, k);
            candidateRepository.save(k);
        });
        return candidate.getEmailId();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Candidate candidate){
        Optional<Candidate> candidate1 = candidateRepository.findById(candidate.getEmailId());
        if(candidate1.isEmpty() || StringUtils.isNullOrEmpty(candidate.getPassword())){
            return ResponseEntity.badRequest().build();
        } else {
            String pass = candidate.getPassword();
            String md5Hex = DigestUtils.md5Hex(pass).toUpperCase();

            if(md5Hex.equals(candidate1.get().getPassword())){
                return ResponseEntity.ok("success");
            } else {
                return ResponseEntity.badRequest().build();
            }
        }
    }


}

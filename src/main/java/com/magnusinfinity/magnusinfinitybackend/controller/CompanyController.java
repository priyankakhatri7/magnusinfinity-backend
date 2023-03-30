package com.magnusinfinity.magnusinfinitybackend.controller;

import com.magnusinfinity.magnusinfinitybackend.dao.entity.Company;
import com.magnusinfinity.magnusinfinitybackend.dao.entity.Employer;
import com.magnusinfinity.magnusinfinitybackend.dao.repository.CompanyRepository;
import com.magnusinfinity.magnusinfinitybackend.dao.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController("company")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private EmployerRepository employerRepository;


    @PostMapping("/registerEmployer")
    public String registerEmployer(@RequestBody Employer employer){
        employerRepository.save(employer);
        return "success";
    }

    @GetMapping("/getCompany")
    public Optional<Company> getCompany(@RequestParam("companyName") String companyName){
        return companyRepository.findById(companyName);
    }
}

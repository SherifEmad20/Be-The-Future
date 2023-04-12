package com.example.BeTheFutureBackend.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/company")
@CrossOrigin(origins = "*")
public class CompanyController {
    private final CompanyModel companyModel;
    @Autowired
    public CompanyController(CompanyModel companyModel) {
        this.companyModel = companyModel;
    }
    //add company

    @PostMapping("/add_company")
    public Company addCompany(@RequestBody Company company) {
        return companyModel.addCompany(company);
    }
    //get all companies

    @GetMapping("/getAllCompanies")
    public Iterable<Company> getAllCompanies() {
        return companyModel.getAllCompanies();
    }
    //add manager to company

    @PutMapping("/addManagerToCompany/{managerName}/{companyID}")
    public Boolean addManagerToCompany(@PathVariable("managerName") String managerName,@PathVariable("companyID") Long companyID) {
        return companyModel.addManagerToCompany(managerName, companyID);
    }



}

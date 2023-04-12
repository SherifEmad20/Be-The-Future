package com.example.BeTheFutureBackend.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "company")
@CrossOrigin(origins = "*")
public class CompanyController {
    private final CompanyModel companyModel;
    @Autowired
    public CompanyController(CompanyModel companyModel) {
        this.companyModel = companyModel;
    }
    //add company
    public Company addCompany(Company company) {
        return companyModel.addCompany(company);
    }
    //get all companies
    public Iterable<Company> getAllCompanies() {
        return companyModel.getAllCompanies();
    }
    //add manager to company
    public Boolean addManagerToCompany(String managerName, Long companyid) {
        return companyModel.addManagerToCompany(managerName, companyid);
    }



}

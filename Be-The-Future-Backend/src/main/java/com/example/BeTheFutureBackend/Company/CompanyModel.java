package com.example.BeTheFutureBackend.Company;

import com.example.BeTheFutureBackend.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyModel {
    private final UserRepository managerRepository;
    private final CompanyRepository companyRepository;
    @Autowired
    public CompanyModel(UserRepository managerRepository, CompanyRepository companyRepository) {
        this.managerRepository = managerRepository;
        this.companyRepository = companyRepository;
    }

    public Company addCompany(Company company){
        return companyRepository.save(company);
    }

    public Iterable<Company> getAllCompanies(){
        return companyRepository.findAll();
    }
    public Company getCompanyById(Long id){
        return companyRepository.findById(id).orElse(null);
    }
    public Company updateCompany(Company company){
        return companyRepository.save(company);
    }
    public void deleteCompany(Long id){
        companyRepository.deleteById(id);
    }
    public Boolean addManagerToCompany(String managerName, Long companyid){
        Company company = companyRepository.findById(companyid).get();
        if (company == null) return false;
        //find manager by name
        managerRepository.findById(managerName).map(manager -> {
            manager.setCompany(company);
            managerRepository.save(manager);
            company.addManager(manager);
            companyRepository.save(company);
            return true;
        });
        return false;
    }
}

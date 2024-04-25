package com.microservice.companyservice.company.impl;

import com.microservice.companyservice.company.Company;
import com.microservice.companyservice.company.CompanyRepository;
import com.microservice.companyservice.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    /**
     * @return list of companies
     */
    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    /**
     * @param company Company
     */
    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    /**
     * @param id company id
     * @return company details
     */
    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    /**
     * @param id company id
     * @return boolean
     */
    @Override
    public boolean deleteCompanyById(Long id) {
        try {
            companyRepository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    /**
     * @param id company id
     * @param company Company
     * @return boolean
     */
    @Override
    public boolean updateCompanyById(Long id, Company company) {
        Optional<Company> res = companyRepository.findById(id);
        if (res.isPresent()) {
            updateCompanyDetails(res.get(), company);
            return true;
        }
        return false;
    }

    private void updateCompanyDetails(Company companyDetails, Company company) {
        if (company.getName() != null) {
            companyDetails.setName(company.getName());
        }
        if (company.getDescription() != null) {
            companyDetails.setDescription(company.getDescription());
        }
        companyRepository.save(companyDetails);
    }
}

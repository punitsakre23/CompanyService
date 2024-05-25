package com.microservice.companyservice.company;

import com.microservice.companyservice.company.dto.ReviewMessage;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();

    void createCompany(Company company);

    Company getCompanyById(Long id);

    boolean deleteCompanyById(Long id);

    boolean updateCompanyById(Long id, Company company);

    void updateCompanyRating(ReviewMessage reviewMessage);
}

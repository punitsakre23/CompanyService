package com.microservice.companyservice.company.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "REVIEW-SERVICE")
public interface ReviewClient {

    @GetMapping("/reviews/averageRating")
    Double getAverageRatingForACompany(@RequestParam("companyId") Long companyId);
}
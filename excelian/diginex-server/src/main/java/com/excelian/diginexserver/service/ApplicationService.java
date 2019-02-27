package com.excelian.diginexserver.service;

import com.excelian.diginexserver.config.ApplicationProperties;
import org.openapitools.client.ApiClient;
import org.openapitools.client.api.ApplicationsApi;
import org.openapitools.client.model.ProductApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    private ApplicationProperties appProperties;
    private ApplicationsApi api;

    @Autowired
    public ApplicationService(ApplicationProperties applicationProperties) {
        this.appProperties = applicationProperties;
        this.api =  new ApiClient(appProperties.getAuthName(),appProperties.getApiKey()).buildClient(ApplicationsApi.class);
    }

    public List<ProductApplication> getApplications(String profileId) {

        List<ProductApplication> productApplications = api.profilesProfileIdApplicationsGet(profileId);

        return productApplications;
    }
}

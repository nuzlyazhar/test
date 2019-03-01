package com.excelian.diginexserver.service;

import com.excelian.diginexserver.config.ApplicationProperties;
import org.openapitools.client.ApiClient;
import org.openapitools.client.api.ApplicationsApi;
import org.openapitools.client.api.ChecksApi;
import org.openapitools.client.model.CheckResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChecksService {

    private ApplicationProperties appProperties;
    private ChecksApi api;

    @Autowired
    public ChecksService(ApplicationProperties appProperties) {
        this.appProperties = appProperties;
        this.api =  new ApiClient(appProperties.getAuthName(),appProperties.getApiKey()).buildClient(ChecksApi.class);
    }

    public List<CheckResource> getChecks(String profileId) {

        List<CheckResource> checkResources = api.profilesProfileIdChecksGet(profileId);

        return checkResources;
    }

    public CheckResource getCheck(String profileId, String checkId) {

        CheckResource checkResource = api.profilesProfileIdChecksCheckIdGet(profileId, checkId);

        return checkResource;
    }
}

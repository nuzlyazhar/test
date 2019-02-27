package com.excelian.diginexserver.service;

import com.excelian.diginexserver.config.ApplicationProperties;
import org.openapitools.client.ApiClient;
import org.openapitools.client.api.ProfilesApi;
import org.openapitools.client.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private ApplicationProperties appProperties;

    @Autowired
    public ProfileService(ApplicationProperties applicationProperties) {
        this.appProperties = applicationProperties;
    }

    public ProfileResource createProfile(){
        ProfilesApi api = new ApiClient(appProperties.getAuthName(),appProperties.getApiKey()).buildClient(ProfilesApi.class);

        ProfileResource newProfile = new ProfileResource().collectedData(new IndividualData().personalDetails(new PersonalDetails().name(new FullName().familyName("DOE")))).role(Role.INDIVIDUAL_CUSTOMER);
        ProfileResource profileResource = api.profilesPost(newProfile);
        return profileResource;

    }}
package com.excelian.diginexserver.service;

import com.excelian.diginexserver.config.ApplicationProperties;
import com.excelian.diginexserver.domain.UserDetails;
import org.openapitools.client.ApiClient;
import org.openapitools.client.api.ProfilesApi;
import org.openapitools.client.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ProfileService {

    private ApplicationProperties appProperties;

    private ProfilesApi api;

    @Autowired
    public ProfileService(ApplicationProperties applicationProperties) {
        this.appProperties = applicationProperties;
        this.api = new ApiClient(appProperties.getAuthName(),appProperties.getApiKey()).buildClient(ProfilesApi.class);
    }

    ProfileService(ApplicationProperties appProperties, ProfilesApi api) {
        this.appProperties = appProperties;
        this.api = api;
    }

    public ProfileResource createProfile(UserDetails userDetails){
        ProfileResource newProfile = createProfileResource(userDetails);

        ProfileResource profileResource = api.profilesPost(newProfile);
        return profileResource;
    }

    ProfileResource createProfileResource(UserDetails userDetails) {
        return new ProfileResource().collectedData(
                new IndividualData().personalDetails(
                        new PersonalDetails()
                                .name(new FullName()
                                        .familyName(userDetails.getFamilyName())
                                        .givenNames(Collections.singletonList(userDetails.getGivenName())))
                                .dob(userDetails.getBirthdate())

                )
        ).role(Role.INDIVIDUAL_CUSTOMER);
    }
}
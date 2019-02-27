package com.excelian.diginexserver.web.rest;


import com.excelian.diginexserver.service.ProfileService;
import io.swagger.annotations.ApiOperation;
import org.openapitools.client.model.ProfileResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
@Validated
public class PassfortProfileController {


    static final int DEFAULT_PAGE_SIZE = 10;


    private ProfileService profileService;

    @Autowired
    public PassfortProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping(value = "/profile", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Create Profile",
            notes = "creates a profile in passfort",
            response = ProfileResource.class)
    public ProfileResource createProfile() {

        ProfileResource profileResource = profileService.createProfile();

        return profileResource;
    }


}

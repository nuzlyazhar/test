package com.excelian.diginexserver.web.rest;

import com.excelian.diginexserver.service.ApplicationService;
import io.swagger.annotations.ApiOperation;
import org.openapitools.client.model.ProductApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@Validated
public class PassfortApplicationController {

    static final int DEFAULT_PAGE_SIZE = 10;

    private ApplicationService applicationService;

    @Autowired
    public PassfortApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping(value = "/applications/{profileId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Get Application(s)",
            notes = "Return a list of Applications for a given Profile in PassFort",
            response = List.class)
    public List<ProductApplication> getApplications(@PathVariable("profileId") String profileId) {

        List<ProductApplication> applications = applicationService.getApplications(profileId);

        return applications;
    }
}

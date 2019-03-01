package com.excelian.diginexserver.web.rest;

import com.excelian.diginexserver.service.ApplicationService;
import com.excelian.diginexserver.service.ChecksService;
import io.swagger.annotations.ApiOperation;
import org.openapitools.client.model.CheckResource;
import org.openapitools.client.model.ProfileResource;
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
public class PassfortChecksController {

    private ChecksService checksService;

    public PassfortChecksController(ChecksService checksService) {
        this.checksService = checksService;
    }

    @GetMapping(value = "/checks/{profileId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Get All checks(s)",
            notes = "Gets a list of checks for a given Profile in PassFort",
            response = CheckResource.class)
    public List<CheckResource> getChecks(@PathVariable("profileId") String profileId) {

        List<CheckResource> checks = checksService.getChecks(profileId);

        return checks;
    }


    @GetMapping(value = "/checks/{profileId}/checks/{checkId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Get results of a specific check.",
            notes = "Returns the current status and result of an instructed check.",
            response = CheckResource.class)
    public CheckResource getCheck(@PathVariable("profileId") String profileId, @PathVariable("checkId") String checkId) {

        CheckResource check = checksService.getCheck(profileId, checkId);

        return check;
    }
}



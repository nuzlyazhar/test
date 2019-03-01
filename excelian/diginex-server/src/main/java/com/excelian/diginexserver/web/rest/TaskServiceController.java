package com.excelian.diginexserver.web.rest;

import com.excelian.diginexserver.service.TaskService;
import io.swagger.annotations.ApiOperation;
import org.openapitools.client.model.ProfileResource;
import org.openapitools.client.model.TaskResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@Validated
public class TaskServiceController {

    private TaskService taskService;

    @Autowired
    public TaskServiceController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/task/{profileId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Get all tasks on a profile",
            notes = "Returns a list of tasks associated with a profile",
            response = ProfileResource.class)

    public List<TaskResource> getTasks(@PathVariable String profileId) {

        List<TaskResource> profileResource = taskService.getChecks(profileId);
        return profileResource;
    }
}

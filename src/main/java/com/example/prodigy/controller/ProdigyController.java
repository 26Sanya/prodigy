package com.example.prodigy.controller;

import com.example.prodigy.entity.SaveResponseEntity;
import com.example.prodigy.entity.UploadEntity;
import com.example.prodigy.exception.ProdigyExceptionHandler;
import com.example.prodigy.service.ProdigyService;
import com.example.prodigy.utils.ApiKeyValidatorUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = {"Prodigy"})
@RequestMapping(value = "/prodigy")
public class ProdigyController {
    private static final Logger logger = LogManager.getLogger(ProdigyController.class);

    @Autowired
    private ProdigyService prodigyService;

    @PostMapping(value = "/saveTeacher", produces = { "application/json" })
    @ApiOperation(value = "This method is used to save teacher's info")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ResponseEntity<SaveResponseEntity> saveTeacher(@RequestHeader("UPLOAD-API-KEY")String teacherUploadApiKey , @RequestBody UploadEntity teacherUpload){
        if (!ApiKeyValidatorUtils.UploadKeyValidation(teacherUploadApiKey)) {
            throw new ProdigyExceptionHandler("Key ValidationFailed", HttpStatus.FORBIDDEN.value());
        }
        SaveResponseEntity inserted = prodigyService.saveTeacher(teacherUpload);
        return new ResponseEntity<>(inserted,HttpStatus.OK);
    }

    @PostMapping(value = "/saveConsumer", produces = { "application/json" })
    @ApiOperation(value = "This method is used to save consumer's info")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ResponseEntity<SaveResponseEntity> saveConsumer(@RequestHeader("UPLOAD-API-KEY")String teacherUploadApiKey , @RequestBody UploadEntity teacherUpload){
        if (!ApiKeyValidatorUtils.UploadKeyValidation(teacherUploadApiKey)) {
            throw new ProdigyExceptionHandler("Key ValidationFailed", HttpStatus.FORBIDDEN.value());
        }
        SaveResponseEntity inserted = prodigyService.saveTeacher(teacherUpload);
        return new ResponseEntity<>(inserted,HttpStatus.OK);
    }
}

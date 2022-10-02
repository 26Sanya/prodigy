package com.example.prodigy.entity;

import com.example.prodigy.constants.ProdigyConstants;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SaveResponseEntity {

    @ApiModelProperty(notes = "Error code 0 - Success, 1 - Failure")
    private Integer responseCode = ProdigyConstants.SUCCESS_CODE;
    @ApiModelProperty(notes ="Error message incase of failure / Success Message incase of success")
    private String responseMessage = ProdigyConstants.SUCCESS_MSG;
    private Integer count = 0;

    public SaveResponseEntity(Integer responseCode, String responseMessage){
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }
    public SaveResponseEntity(Integer responseCode){
        this.responseCode = responseCode;
    }
}

package com.example.prodigy.utils;

import com.example.prodigy.component.ConfigProperties;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiKeyValidatorUtils {
    private static final Logger logger = LogManager.getLogger(ApiKeyValidatorUtils.class);
    @Autowired
    private static ConfigProperties configProperties;
    public static boolean UploadKeyValidation(String UploadApiKey) {

        if (StringUtils.isNotBlank(UploadApiKey) && UploadApiKey.equalsIgnoreCase(configProperties.getTeacherUploadApiKey())) {
            logger.info("Exiting api Key Validation : Successful Validation of the API Key");
            return true;
        }
        logger.info("Exiting api Key Validation : Invalid API Key.");
        return false;
    }
}

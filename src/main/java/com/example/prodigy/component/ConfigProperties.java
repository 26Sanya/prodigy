package com.example.prodigy.component;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class ConfigProperties {
    @Value("${TEACHER-UPLOAD-API-KEY}")
    String teacherUploadApiKey;
}

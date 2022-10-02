package com.example.prodigy.service;

import com.example.prodigy.entity.SaveResponseEntity;
import com.example.prodigy.entity.UploadEntity;

public interface ProdigyService {

    SaveResponseEntity saveTeacher(UploadEntity teacherUpload);
}

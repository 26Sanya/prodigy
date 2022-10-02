package com.example.prodigy.service;

import com.example.prodigy.constants.ProdigyConstants;
import com.example.prodigy.entity.SaveResponseEntity;
import com.example.prodigy.entity.UploadEntity;
import com.example.prodigy.repos.TeacherRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdigyServiceImp implements ProdigyService{
    private static final Logger logger = LogManager.getLogger(ProdigyService.class);

    @Autowired
    private TeacherRepo teacherRepo;
    @Override
    public SaveResponseEntity saveTeacher(UploadEntity teacherUpload) {
        logger.info("************* In saveTeacher with request ********************");
        Integer count = 0;
        if(teacherUpload.getTeacherList() != null && !teacherUpload.getTeacherList().isEmpty())
        {
            try {
                teacherRepo.saveAll(teacherUpload.getTeacherList());
                logger.info("SUCCESS upload");
                count += teacherUpload.getTeacherList().size();
            }catch (Exception e){
                return new SaveResponseEntity(ProdigyConstants.FAILURE_CODE, ProdigyConstants.FAILURE_MSG);
            }
        }
        return new SaveResponseEntity(count);
    }
}

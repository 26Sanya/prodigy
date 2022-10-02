package com.example.prodigy.repos;

import com.example.prodigy.entity.TeacherEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TeacherRepo extends ElasticsearchRepository<TeacherEntity, String>{
}

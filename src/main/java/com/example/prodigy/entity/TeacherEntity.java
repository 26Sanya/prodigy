package com.example.prodigy.entity;

import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;

@Data
public class TeacherEntity {
    @Generated
    @Id
    public String id;

    public String mobileNumber;

    public String emailId;

    public String country;

    public String name;

    public String location;
}

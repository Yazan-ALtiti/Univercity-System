package com.sdk.university.Controller;

import com.sdk.university.Reposotories.teachrtReposotory;
import com.sdk.university.entity.teacherEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class dbTeacherController {
    @Autowired
    teachrtReposotory teachrtReposotory;

    @PostMapping("/dbteacher/add")
    public HttpStatus newteacher(@RequestParam String name, @RequestParam String phone,@RequestParam String major) {
        teacherEntity  teacherEntity = new teacherEntity(name,major);
        teachrtReposotory.save(teacherEntity);
        return HttpStatus.OK;
    }

    @PostMapping("/dbteacher/find")
    public teacherEntity findclases(@RequestParam Long id) {
        teacherEntity teacher = teachrtReposotory.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid user id" + id));
        return teacher;
    }
}

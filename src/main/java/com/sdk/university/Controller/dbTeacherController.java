package com.sdk.university.Controller;

import com.sdk.university.Reposotories.teachrtReposotory;
import com.sdk.university.entity.teacherEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class dbTeacherController {
    @Autowired
    teachrtReposotory teachrtReposotory;

    @PostMapping("/dbteacher/add")
    public HttpStatus newteacher(@RequestParam String name, @RequestParam String phone, @RequestParam String major) {
        teacherEntity teacherEntity = new teacherEntity(name, major);
        teachrtReposotory.save(teacherEntity);
        return HttpStatus.OK;
    }

    @PostMapping("/dbteacher/find")
    public teacherEntity findclases(@RequestParam Long id) {
        teacherEntity teacher = teachrtReposotory.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid user id" + id));
        return teacher;
    }

    @GetMapping("/dbteacher/findname/{name}")
    public teacherEntity findname(@PathVariable("name") String name) {
        teacherEntity teacher = teachrtReposotory.findByname(name);
        return teacher;
    }

    @GetMapping("/dbteacher/findmajor/{major}")
    public teacherEntity findmajor(@PathVariable("major") String major) {
        teacherEntity teacher = teachrtReposotory.findBymajor(major);
        return teacher;

    }

    @DeleteMapping("/dbteacher/delete/{id}")
    public HttpStatus delete(@PathVariable("id") Long id) {
        teachrtReposotory.deleteById(id);
        return HttpStatus.OK;
    }

    @PutMapping("/dbteacher/update/{id}")
    public HttpStatus update(@PathVariable("id") Long id, @RequestParam String name, @RequestParam String major) {
        teacherEntity teacher = teachrtReposotory.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid id" + id));
        teacher.setName(name);
        teacher.setMajor(major);
        teachrtReposotory.save(teacher);
        return HttpStatus.OK;

    }

}

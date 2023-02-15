package com.sdk.university.Controller;

import com.sdk.university.Reposotories.colligeReposotory;
import com.sdk.university.entity.colligeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class dbColligeController {
    @Autowired
    colligeReposotory colligeReposotory;

    @PostMapping("/dbcollig/adding")
    public HttpStatus newcollige(@RequestParam String name, @RequestParam String phone) {
        colligeEntity colligeEntity = new colligeEntity(name, phone);
        colligeReposotory.save(colligeEntity);
        return HttpStatus.OK;
    }

    @PostMapping("/dbcolloge/find")
    public colligeEntity findclases(@RequestParam Long id) {
        colligeEntity collige = colligeReposotory.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid user id" + id));
        return collige;
    }
}

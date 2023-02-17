package com.sdk.university.Controller;

import com.sdk.university.Reposotories.colligeReposotory;
import com.sdk.university.entity.colligeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/collige/findname/{name}")
    public colligeEntity findname(@PathVariable("name") String name) {
        colligeEntity collige = colligeReposotory.findByname(name);
        return collige;


    }
    @GetMapping("/collige/findphone/{phone}")
    public colligeEntity findphone(@PathVariable("phone")String phone){
        colligeEntity collige=colligeReposotory.findByphone(phone);
        return collige;
    }
    @DeleteMapping("/collige/delete/{id}")
    public HttpStatus deletecollige(@PathVariable("id")Long id){
        colligeReposotory.deleteById(id);
        return HttpStatus.OK;
    }
    @PutMapping("/collige/update/{id}")
    public HttpStatus updatecollige(@PathVariable("id")Long id,@RequestParam String name,@RequestParam String phone){
        colligeEntity collige=colligeReposotory.findById(id).orElseThrow(()-> new IllegalArgumentException("invalid id"+id));
        collige.setName(name);
        collige.setPhone(phone);
        colligeReposotory.save(collige);
        return HttpStatus.OK;
    }
}

package com.sdk.university.Controller;

import com.sdk.university.Reposotories.clasesReposotory;
import com.sdk.university.entity.clasesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class dbClasesCotroller {
    @Autowired
    clasesReposotory clasesReposotory;

    @PostMapping("/class/add")
    public HttpStatus newclases(@RequestParam String location, @RequestParam String name) {
        clasesEntity clasesEntity = new clasesEntity(location, name);
        clasesReposotory.save(clasesEntity);
        return HttpStatus.OK;

    }

    @PostMapping("/dbclase/find")
    public clasesEntity findClass(@RequestParam Long id) {
        clasesEntity clases = clasesReposotory.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid user id" + id));
        return clases;
    }

    @GetMapping("/class/findname/{name}")
    public clasesEntity findName(@PathVariable("name") String name) {
        clasesEntity classe = clasesReposotory.findByname(name);
        return classe;

    }

    @GetMapping("/class/findlocation/{location}")
    public clasesEntity findLocation(@PathVariable("location") String location) {
        clasesEntity clasess = clasesReposotory.findBylocation(location);
        return clasess;
    }

    @DeleteMapping("/class/delete/{id}")
    public HttpStatus deleteClass(@PathVariable("id") Long id) {

        clasesReposotory.deleteById(id);
        return HttpStatus.OK;


    }
    @PutMapping("/class/update/{id}")
    public HttpStatus updateClases(@PathVariable("id")Long id,@RequestParam String location,@RequestParam String name){
        clasesEntity clases = clasesReposotory.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid user id" + id));
        clases.setName(name);
        clases.setLocation(location);
        clasesReposotory.save(clases);
        return HttpStatus.OK;
    }
}

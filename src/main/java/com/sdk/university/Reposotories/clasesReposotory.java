package com.sdk.university.Reposotories;

import com.sdk.university.entity.clasesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clasesReposotory extends JpaRepository <clasesEntity,Long> {
    clasesEntity findByname(String name);
    clasesEntity findBylocation(String location);

}

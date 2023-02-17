package com.sdk.university.Reposotories;

import com.sdk.university.entity.colligeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface colligeReposotory extends JpaRepository<colligeEntity,Long> {
    colligeEntity findByname(String name);
    colligeEntity findByphone(String phone);


}

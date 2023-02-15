package com.sdk.university.Reposotories;

import com.sdk.university.entity.teacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface teachrtReposotory extends JpaRepository<teacherEntity,Long> {
}

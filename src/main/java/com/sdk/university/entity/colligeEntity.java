package com.sdk.university.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class colligeEntity {
    @Id
    @GeneratedValue
    Long id;
    @NonNull
    String name;
    @NonNull
    String phone;



    @OneToMany(mappedBy = "college")
    List<clasesEntity> classes;

    @OneToMany(mappedBy = "college")
    List<teacherEntity> teacher;


}

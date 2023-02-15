package com.sdk.university.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class teacherEntity {
   @Id
   @GeneratedValue
    Long id;
   @NonNull
    String name;
   @NonNull
    String major;

    @ManyToOne
    @JoinColumn(name = "college_id")
    colligeEntity college;


}

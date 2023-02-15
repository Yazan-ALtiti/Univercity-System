package com.sdk.university.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class clasesEntity {
    @Id
    @GeneratedValue
    Long id;
    @NonNull
    String location;
    @NonNull
    String name;

    @ManyToOne
    @JoinColumn(name = "collige_id")
    colligeEntity college;



}

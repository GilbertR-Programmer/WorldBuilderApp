package com.sparta.grr.worldbuilderapi.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "parent_child")
public class ParentChild {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long parentId;
    private long childId;

}

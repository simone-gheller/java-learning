package com.capgemini.reflection;

import java.time.LocalDate;

public class SampleBean {

    @PrimaryKey
    private long id;
    @Column
    private String name;
    @Column
    private LocalDate birthDate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

}

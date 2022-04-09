package com.example.boot.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    @Pattern(regexp = "[A-Za-zА-яа-я]{2,15}", message = "Name should be between 2 and 15 latin characters")
    private String name;

    @Column(name = "Surname")
    @Pattern(regexp = "[A-Za-zА-яа-я]{2,15}", message = "Surname should be between 2 and 15 latin characters")
    private String surname;

    @Column(name = "Patronymic")
    @Pattern(regexp = "[A-Za-zА-яа-я]{2,15}", message = "Отчество должно содержать от 2 до 15 латинских символов.")
    private String patronymic;

    @Column(name = "Age")
    @Min(value = 0, message = "Age should be >= 0")
    @Max(value = 127, message = "Age should be < 128")
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}

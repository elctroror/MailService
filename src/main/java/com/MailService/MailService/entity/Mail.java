package com.MailService.MailService.entity;

import jakarta.persistence.*;

@Entity
public class Mail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String email;
    @Column
    private String name;

    @Column
    private String secondName;

    @Column
    private String dni;

    @Column
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Mail(){}

    public Mail(String email, String name, String secondName, String dni, String text) {
        this.email = email;
        this.name = name;
        this.secondName = secondName;
        this.dni = dni;
        this.text = text;
    }
}

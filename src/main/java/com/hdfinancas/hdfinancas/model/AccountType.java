package com.hdfinancas.hdfinancas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "accountType")
@AllArgsConstructor
@NoArgsConstructor
public class AccountType {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private long id;

    @Column(length = 50, nullable = false)
    @Getter @Setter
    private String name;
}

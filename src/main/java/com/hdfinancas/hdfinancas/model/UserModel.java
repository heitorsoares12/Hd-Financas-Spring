package com.hdfinancas.hdfinancas.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 100)
    @Getter @Setter
    @ApiModelProperty(notes = "The user's  full name")
    private String name;

    @Column(nullable = false, length = 11)
    @Getter @Setter
    @ApiModelProperty(notes = "A valid cfp")
    private String cpf;

    @Column(nullable = false, length = 100)
    @Getter @Setter
    @ApiModelProperty(notes = "A valid email address")
    private String email;

    @Column(nullable = false, length = 10)
    @Getter @Setter
    @ApiModelProperty(notes = "A valid password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "accountType_id")
    @Getter @Setter
    private AccountType accountType;
}

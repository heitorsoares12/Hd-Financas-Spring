package com.hdfinancas.hdfinancas.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class UserModel extends RepresentationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @ApiModelProperty(notes = "The id")
    private long id;

    @Column(name = "name", nullable = false, length = 100)
    @Getter @Setter
    @ApiModelProperty(notes = "The user's  full name")
    private String name;

    @Column(nullable = false, length = 11)
    @Getter @Setter
    @ApiModelProperty(notes = "A valid cfp")
    private String cpf;

    @Column(nullable = true, length = 100)
    @Getter @Setter
    @ApiModelProperty(notes = "A valid email address")
    private String email;

    @ManyToOne
    @JoinColumn(name = "accountType_id")
    @Getter @Setter
    private AccountTypeModel accountType;
}

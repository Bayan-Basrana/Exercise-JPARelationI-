package com.example.schoolmanagement.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @NotEmpty(message = "name is mandatory")
    @Column(columnDefinition = "varchar(50) not null")
    private String name;

    @NotNull(message = "age is mandatory")
    @Min(25)
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotEmpty(message = "email is mandatory")
    @Email(message = "invalid Email")
    @Column(columnDefinition = "varchar(50) not null")
    private String email;

    @NotNull(message = "salary is mandatory")
    @Column(columnDefinition = "int not null")
    private Integer salary;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;

}

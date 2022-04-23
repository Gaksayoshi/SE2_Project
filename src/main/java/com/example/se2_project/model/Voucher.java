package com.example.se2_project.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

@Entity
public class Voucher  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty(message = "This field is mandatory")
    @Length(max = 30)
    private String name;

    @NotEmpty(message = "This field is mandatory")
    @Length(max = 20)
    private String code;

    @NotEmpty(message = "This field is mandatory")
    private Date DateStart;

    @NotEmpty(message = "This field is mandatory")
    private Date DateEnd;

    @NotEmpty(message = "This field is mandatory")
    private Double discount;

    @OneToOne
    private Orders order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

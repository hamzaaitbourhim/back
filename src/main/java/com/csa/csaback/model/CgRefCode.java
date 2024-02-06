package com.csa.csaback.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cg_ref_codes")
public class CgRefCode {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "rv_abbreviation", length = 240)
    private String rvAbbreviation;

    @Column(name = "rv_domain", nullable = false, length = 100)
    private String rvDomain;

    @Column(name = "rv_high_value", length = 240)
    private String rvHighValue;

    @Column(name = "rv_low_value", nullable = false, length = 240)
    private String rvLowValue;

    @Column(name = "rv_meaning", length = 240)
    private String rvMeaning;

}
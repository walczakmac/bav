package com.bav.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "iban_plus_structure")
public class Structure implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "country_code", nullable = false)
    private String countryCode;

    @Column(name = "country_code_position", nullable = false)
    private Integer countryCodePosition;

    @Column(name = "country_code_length", nullable = false)
    private Integer countryCodeLength;

    @Column(name = "check_digits_position", nullable = false)
    private Integer checkDigitsPosition;

    @Column(name = "check_digits_length", nullable = false)
    private Integer checkDigitsLength;

    @Column(name = "bank_identifier_position", nullable = false)
    private Integer bankIdentifierPosition;

    @Column(name = "bank_identifier_length", nullable = false)
    private Integer bankIdentifierLength;

    @Column(name = "branch_identifier_position")
    private Integer branchIdentifierPosition = null;

    @Column(name = "branch_identifier_length", nullable = false)
    private Integer branchIdentifierLength;

    @Column(name = "national_id_length", nullable = false)
    private Integer nationalIdLength;

    @Column(name = "account_number_position", nullable = false)
    private Integer accountNumberPosition;

    @Column(name = "account_number_length", nullable = false)
    private Integer accountNumberLength;

    @Column(name = "total_length", nullable = false)
    private Integer totalLength;

    @Column(name = "is_sepa", nullable = false)
    private Boolean sepa;

    @Column(name = "commence_date_optional")
    private Timestamp commenceDateOptional;

    @Column(name = "commence_date_mandatory")
    private Timestamp commenceDateMandatory;

    @Column(name = "modified_at", nullable = false)
    private Timestamp modifiedAt;

    
}
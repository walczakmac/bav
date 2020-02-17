package com.bav.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Table(name = "iban_plus_exclusion")
@Data
@Entity
public class Exclusion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "record_key", nullable = false)
    private String recordKey;

    @Column(name = "country_code", nullable = false)
    private String countryCode;

    @Column(name = "iban_national_id", nullable = false)
    private String ibanNationalId;

    @Column(name = "bic")
    private String bic = "NULL";

    @Column(name = "valid_from")
    private Timestamp validFrom;

    @Column(name = "field_a")
    private String fieldA = "NULL";

    @Column(name = "field_b")
    private String fieldB = "NULL";

    @Column(name = "modified_at", nullable = false)
    private Timestamp modifiedAt;

    
}
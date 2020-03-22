package com.jav.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "iban_plus")
@Data
public class IbanPlus implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "record_key", nullable = false)
    private String recordKey;

    @Column(name = "institution_name", nullable = false)
    private String institutionName;

    @Column(name = "country_name", nullable = false)
    private String countryName;

    @Column(name = "iso_country_code", nullable = false)
    private String isoCountryCode;

    @Column(name = "iban_iso_country_code", nullable = false)
    private String ibanIsoCountryCode;

    @Column(name = "iban_bic", nullable = false)
    private String ibanBic;

    @Column(name = "routing_bic", nullable = false)
    private String routingBic;

    @Column(name = "iban_national_id", nullable = false)
    private String ibanNationalId;

    @Column(name = "service_context")
    private String serviceContext = "NULL";

    @Column(name = "field_a")
    private String fieldA = "NULL";

    @Column(name = "field_b")
    private String fieldB = "NULL";

    @Column(name = "modified_at", nullable = false)
    private Timestamp modifiedAt;
}
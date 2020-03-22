package com.jav.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "bank_directory")
public class BankDirectory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "record_key", nullable = false)
    private String recordKey;

    @Column(name = "office_type", nullable = false)
    private String officeType;

    @Column(name = "parent_office_key", nullable = false)
    private String parentOfficeKey;

    @Column(name = "head_office_key", nullable = false)
    private String headOfficeKey;

    @Column(name = "legal_type", nullable = false)
    private String legalType;

    @Column(name = "legal_parent_key", nullable = false)
    private String legalParentKey;

    @Column(name = "group_type")
    private String groupType = "NULL";

    @Column(name = "group_parent_key")
    private String groupParentKey = "NULL";

    @Column(name = "institution_status")
    private String institutionStatus = "NULL";

    @Column(name = "cooperative_group_key")
    private String cooperativeGroupKey = "NULL";

    @Column(name = "iso_lei_code")
    private String isoLeiCode = "NULL";

    @Column(name = "bic8")
    private String bic8 = "NULL";

    @Column(name = "branch_bic")
    private String branchBic = "NULL";

    @Column(name = "bic")
    private String bic = "NULL";

    @Column(name = "chips_uid")
    private String chipsUid = "NULL";

    @Column(name = "national_id")
    private String nationalId = "NULL";

    @Column(name = "connected_bic")
    private String connectedBic = "NULL";

    @Column(name = "institution_name", nullable = false)
    private String institutionName;

    @Column(name = "branch_information")
    private String branchInformation = "NULL";

    @Column(name = "pob_number")
    private String pobNumber = "NULL";

    @Column(name = "street_address1")
    private String streetAddress1 = "NULL";

    @Column(name = "street_address2")
    private String streetAddress2 = "NULL";

    @Column(name = "street_address3")
    private String streetAddress3 = "NULL";

    @Column(name = "street_address4")
    private String streetAddress4 = "NULL";

    @Column(name = "city")
    private String city = "NULL";

    @Column(name = "cps")
    private String cps = "NULL";

    @Column(name = "zip_code")
    private String zipCode = "NULL";

    @Column(name = "country_name", nullable = false)
    private String countryName;

    @Column(name = "iso_country_code", nullable = false)
    private String isoCountryCode;

    @Column(name = "timezone")
    private String timezone = "NULL";

    @Column(name = "subtype_indicator")
    private String subtypeIndicator = "NULL";

    @Column(name = "network_connectivity")
    private String networkConnectivity = "NULL";

    @Column(name = "branch_qualifiers")
    private String branchQualifiers = "NULL";

    @Column(name = "service_codes")
    private String serviceCodes = "NULL";

    @Column(name = "ssi_group_key")
    private String ssiGroupKey = "NULL";

    @Column(name = "iban_key")
    private String ibanKey = "NULL";

    @Column(name = "field_a")
    private String fieldA = "NULL";

    @Column(name = "field_b")
    private String fieldB = "NULL";

    @Column(name = "deletedAt")
    private Timestamp deletedAt;

    @Column(name = "createdAt", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updatedAt", nullable = false)
    private Timestamp updatedAt;

    
}
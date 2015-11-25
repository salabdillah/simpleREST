package com.example.model;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by irsan on 20/10/15.
 */
@Entity
@Table(name = "long_codes", indexes = {
        @Index(name = "ix_long_codes_key", columnList = "long_code_key", unique = true),
        @Index(name = "ix_long_codes_name", columnList = "name", unique = false),
        @Index(name = "ix_long_codes_msisdn", columnList = "msisdn", unique = false)
})
@NamedQueries({
        @NamedQuery(name = "jeru.longCode.findByMsisdn",
                query = "FROM LongCode WHERE msisdn = :msisdn"),
        @NamedQuery(name = "jeru.longCode.findByKey",
                query = "SELECT longCode FROM LongCode longCode " +
                        "WHERE longCode.key = :key " +
                        "AND longCode.status = 'active'")
})

public class LongCode extends EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "long_code_key", nullable = false, length = 64)
    private String key;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "msisdn", length = 20, nullable = false)
    private String msisdn;

    private long expiryTime;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    public LongCode() {
        super();
        expiryTime = 86400000;
    }

    public LongCode(String username) {
        super(username);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public long getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(long expired) {
        this.expiryTime = expired;
    }
}

package com.example.model;

import javax.persistence.*;

/**
 * Created by irsan on 6/11/15.
 */
@Entity
@Table(name = "sms_sessions")
@NamedQueries({
        @NamedQuery(name = "jeru.SMSSession.countNonExpiredByMsisdnLongcode",
                query = "SELECT COUNT(session) FROM SMSSession session " +
                        "WHERE session.msisdn = :msisdn " +
                        "AND session.longCode = :longCode " +
                        "AND session.status = 'active' " +
                        "AND session.createdAt BETWEEN :startDate AND :endDate"),
        @NamedQuery(name = "jeru.SMSSession.findByDateRange",
                query = "SELECT smsSession FROM SMSSession smsSession " +
                        "WHERE smsSession.status NOT IN ('inactive') " +
                        "AND smsSession.createdAt BETWEEN :startDate AND :endDate " +
                        "ORDER BY smsSession.id")
})
public class SMSSession extends EntityBase {

    public final static String STATUS_DUPLICATE = "duplicate";
    public final static String STATUS_FAILED = "failed";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "msisdn", length = 20, nullable = false)
    private String msisdn;

    @ManyToOne
    @JoinColumn(name = "long_code_id", nullable = false)
    private LongCode longCode;

    public SMSSession() {
        super();
    }

    public SMSSession(String username) {
        super(username);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public LongCode getLongCode() {
        return longCode;
    }

    public void setLongCode(LongCode longCode) {
        this.longCode = longCode;
    }
}
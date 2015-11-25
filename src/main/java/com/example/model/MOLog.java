package com.example.model;

import javax.persistence.*;

/**
 * Created by irsan on 20/10/15.
 */
@Entity
@Table(name = "mo_logs", indexes = {
        @Index(name = "ix_mo_logs_msisdn", columnList = "msisdn"),
})
@NamedQueries({
        @NamedQuery(name = "jeru.moLog.findRecordByLongCodeMsisdn",
                query = "SELECT moLog FROM MOLog moLog " +
                        "WHERE moLog.msisdn = :msisdn " +
                        "AND moLog.longCode = :longCode"),
        @NamedQuery(name = "jeru.moLog.findByMTLogs",
                query = "SELECT moLog FROM MOLog  moLog " +
                        "WHERE moLog.mtLog IN (:mtLogs) " +
                        "AND moLog.status NOT IN ('inactive') " +
                        "ORDER BY moLog.mtLog.id, moLog.id")
})
public class MOLog extends EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "mo_id")
    private int moId;

    @Column(name = "orga", length = 20, nullable = false)
    private String orga;

    @Column(name = "msisdn", length = 50, nullable = false)
    private String msisdn;

    @Column(name = "message_id", length = 20)
    private int messageId;

    @Column(name = "message", columnDefinition = "text")
    private String message;

    @OneToOne
    @JoinColumn(name = "mt_log_id", nullable = true)
    private MTLog mtLog;

    @ManyToOne
    @JoinColumn(name = "long_code_id", nullable = true)
    private LongCode longCode;

    public MOLog() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMoId() {
        return moId;
    }

    public void setMoId(int moId) {
        this.moId = moId;
    }

    public String getOrga() {
        return orga;
    }

    public void setOrga(String orga) {
        this.orga = orga;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MTLog getMtLog() {
        return mtLog;
    }

    public void setMtLog(MTLog mtLog) {
        this.mtLog = mtLog;
    }

    public LongCode getLongCode() {
        return longCode;
    }

    public void setLongCode(LongCode longCode) {
        this.longCode = longCode;
    }
}

package com.example.model;

import javax.persistence.*;

/**
 * Created by irsan on 20/10/15.
 */
@Entity
@Table(name = "mt_logs", indexes = {
        @Index(name = "ix_mt_logs_msisdn", columnList = "msisdn"),
        @Index(name = "ix_mt_logs_status_id", columnList = "status_id"),
        @Index(name = "ix_mt_logs_mt_log_id", columnList = "mt_log_id")
})
@NamedQueries({
		@NamedQuery(name = "jeru.mtLog.logService",
				query = "SELECT mtLog FROM MTLog mtLog WHERE mtLog.tpoa = :services"),
        @NamedQuery(name = "jeru.mtLog.logPhoneNumber",
                query = "SELECT mtLog FROM MTLog mtLog WHERE mtLog.msisdn = :msisdn"),
        @NamedQuery(name = "jeru.mtLog.logSameDate",
                query = "SELECT mtLog FROM MTLog mtLog WHERE mtLog.createdAt = :date"),
        @NamedQuery(name = "jeru.mtLog.findLatestByMsisdnLongCode",
                query = "SELECT mtLog FROM MTLog mtLog " +
                        "WHERE mtLog.msisdn = :msisdn AND mtLog.tpoa = :tpoa " +
                        "AND mtLog.status = 'active' AND mtLog.statusId = '501' " +
                        "ORDER BY mtLog.createdAt DESC"),
        @NamedQuery(name = "jeru.MTLog.findBySMSSessions",
                query = "SELECT mtLog FROM MTLog mtLog " +
                        "WHERE mtLog.smsSession IN (:smsSessions) " +
                        "ORDER BY mtLog.smsSession.id, mtLog.createdAt")
})
public class MTLog extends EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "msisdn", length = 50, nullable = false)
    private String msisdn;

    @Column(name = "tpoa", length = 20, nullable = false)
    private String tpoa;

    @Column(name = "message", columnDefinition = "text")
    private String message;

    @Column(name = "status_id", length = 5, nullable = false)
    private String statusId;

    @Column(name = "mt_log_id", length = 20)
    private int mtLogId;

    @ManyToOne
    @JoinColumn(name = "mt_template_id", nullable = false)
    private MTTemplate mtTemplate;

    @ManyToOne
    @JoinColumn(name = "sms_session_id", nullable = false)
    private SMSSession smsSession;

    public MTLog() {
        super();
        statusId = "0";
    }

    public MTLog(String username) {
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

    public String getTpoa() {
        return tpoa;
    }

    public void setTpoa(String tpoa) {
        this.tpoa = tpoa;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public int getMtLogId() {
        return mtLogId;
    }

    public void setMtLogId(int mtLogId) {
        this.mtLogId = mtLogId;
    }

    public MTTemplate getMtTemplate() {
        return mtTemplate;
    }

    public void setMtTemplate(MTTemplate mtTemplate) {
        this.mtTemplate = mtTemplate;
    }

    public SMSSession getSmsSession() {
        return smsSession;
    }

    public void setSmsSession(SMSSession smsSession) {
        this.smsSession = smsSession;
    }
}

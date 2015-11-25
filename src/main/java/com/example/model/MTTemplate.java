package com.example.model;

import javax.persistence.*;

/**
 * Created by irsan on 20/10/15.
 */
@Entity
@Table(name = "mt_templates", indexes = {
        @Index(name = "ix_mt_templates_main", columnList = "main")
})
@NamedQueries({
        @NamedQuery(name = "jeru.mtTemplate.firstQuestion",
                query = "SELECT mtTemplate FROM MTTemplate mtTemplate " +
                        "WHERE mtTemplate.status = 'active' AND mtTemplate.main = true " +
                        "AND mtTemplate.longCode = :longCode"),
})
public class MTTemplate extends EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "message", nullable = false, length = 255)
    private String message;

    @Column(name = "main", nullable = false)
    private boolean main;

    @Column(name = "expiry_time", nullable = false)
    private long expiryTime;

    @ManyToOne
    @JoinColumn(name = "long_code_id", nullable = false)
    private LongCode longCode;

    @OneToOne
    @JoinColumn(name = "reply", nullable = true)
    private MTTemplate reply;

    public MTTemplate() {
        super();
        expiryTime = 42900000;
    }

    public MTTemplate(String username) {
        super(username);
        expiryTime = 42900000;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }

    public LongCode getLongCode() {
        return longCode;
    }

    public void setLongCode(LongCode longCode) {
        this.longCode = longCode;
    }

    public MTTemplate getReply() {
        return reply;
    }

    public void setReply(MTTemplate reply) {
        this.reply = reply;
    }

    public long getExpiryTime() {
        return expiryTime;
    }
}

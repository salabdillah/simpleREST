package com.example.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by irsan on 28/9/15.
 */
@Entity
@Table(name ="services", indexes = {
        @Index(columnList = "name"),
        @Index(columnList = "permlink"),
        @Index(columnList = "service_key"),
        @Index(columnList = "created_at"), @Index(columnList = "updated_at"),
        @Index(columnList = "creator"), @Index(columnList = "updater")
})
public class Service extends EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "permlink", nullable = false, length = 200)
    private String permlink;

    @Column(name = "service_key", length = 64)
    private String key;

    @Column(name = "theme", length = 100)
    private String theme;

    /**
     * default constructor
     */
    public Service() {
        super();
        init();
    }

    /**
     * construct using username
     *
     * @param username
     */
    public Service(String username) {
        super(username);
        init();
    }

    private void init() {
        theme = "default";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermlink() {
        return permlink;
    }

    public void setPermlink(String permlink) {
        this.permlink = permlink;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Transient
    public Map<String, String> getSimpleInfo() {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("permlink", permlink);
        return map;
    }
}

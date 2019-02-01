package com.chinatelecom.model;

import java.util.Date;

public class WorkOrder {
    private Long id;

    private String title;

    private Long groupid;

    private String affectScope;

    private String serviceType;

    private String contacts;

    private String tel;

    private String firstSystem;

    private Date happenTime;

    private String appearance;

    private String priority;

    private String influence;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    public String getAffectScope() {
        return affectScope;
    }

    public void setAffectScope(String affectScope) {
        this.affectScope = affectScope == null ? null : affectScope.trim();
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getFirstSystem() {
        return firstSystem;
    }

    public void setFirstSystem(String firstSystem) {
        this.firstSystem = firstSystem == null ? null : firstSystem.trim();
    }

    public Date getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(Date happenTime) {
        this.happenTime = happenTime;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance == null ? null : appearance.trim();
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority == null ? null : priority.trim();
    }

    public String getInfluence() {
        return influence;
    }

    public void setInfluence(String influence) {
        this.influence = influence == null ? null : influence.trim();
    }
}
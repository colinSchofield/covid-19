package com.idk.covid19.model.db;

public class DecoratedUser extends User {
    private String regionList;
    private String contact;

    public DecoratedUser(User user, String regionList, String contact) {
        setId(user.getId());
        setName(user.getName());
        setAge(user.getAge());
        setGender(user.getGender());
        setRegions(user.getRegions());
        setEmail(user.getEmail());
        setSms(user.getSms());
        this.regionList = regionList;
        this.contact = contact;
    }

    public String getRegionList() {
        return regionList;
    }

    public void setRegionList(String regionList) {
        this.regionList = regionList;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}

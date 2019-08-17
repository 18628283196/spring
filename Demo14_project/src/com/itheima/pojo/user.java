package com.itheima.pojo;

public class user {
    /**
     * eid INT PRIMARY KEY AUTO_INCREMENT,
     ename VARCHAR(20),
     sex VARCHAR(6),
     tel VARCHAR(20),
     email VARCHAR(50),
     address VARCHAR(200),
     did INT   #外键
     dname VARCHAR(30)
     */
    private int eid;
    private String ename;
    private String sex;
    private String tel;
    private String email;
    private String address;
    private int did;
    private String dname;
    private String photo;

    @Override
    public String toString() {
        return "user{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", did=" + did +
                ", dname='" + dname + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public user(int eid, String ename, String sex, String tel, String email, String address, int did, String dname, String photo) {

        this.eid = eid;
        this.ename = ename;
        this.sex = sex;
        this.tel = tel;
        this.email = email;
        this.address = address;
        this.did = did;
        this.dname = dname;
        this.photo = photo;
    }

    public user() {

    }
}

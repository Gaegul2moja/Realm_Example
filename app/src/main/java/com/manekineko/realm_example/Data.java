package com.manekineko.realm_example;

import io.realm.RealmObject;

public class Data extends RealmObject{
    private String id;
    private String pwd;

    public void setId(String id) {
        this.id = id;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }
}

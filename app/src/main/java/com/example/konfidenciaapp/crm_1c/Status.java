package com.example.konfidenciaapp.crm_1c;


import java.io.Serializable;

public class Status implements Serializable{

    private String success;

    public Status() {
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "Status{" +
                "success='" + success + '\'' +
                '}';
    }
}

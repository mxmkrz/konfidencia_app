package com.example.konfidenciaapp.crm_1c;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Client implements Serializable {

    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("Parameters")
    @Expose
    private Parameters parameters;
    @SerializedName("Errors")
    @Expose
    private Errors errors;

    public Client() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public Errors getErrors() {
        return errors;
    }

    public void setErrors(Errors errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "Client{" +
                "Status=" + status +
                ", Parameters=" + parameters +
                ", Errors=" + errors +
                '}';
    }
}

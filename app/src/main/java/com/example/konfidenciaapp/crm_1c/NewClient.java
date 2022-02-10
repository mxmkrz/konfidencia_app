package com.example.konfidenciaapp.crm_1c;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class NewClient implements Serializable {
    @SerializedName("Parameters")
    @Expose
    private ParametersForPost parameters;
    @SerializedName("Errors")
    @Expose
    private Errors errors;

    public NewClient() {
    }

    public ParametersForPost getParameters() {
        return parameters;
    }

    public void setParameters(ParametersForPost parameters) {
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
        return "NewClient{" +
                "parameters=" + parameters +
                ", errors=" + errors +
                '}';
    }
}

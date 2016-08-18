package com.plusmental.model;

import com.google.gson.annotations.SerializedName;
import java.sql.Timestamp;

public class LoginObject {

    @SerializedName("success") private boolean success;
    @SerializedName("message") private String message;
    @SerializedName("name") private String name;
    @SerializedName("email") private String email;
    @SerializedName("id") private String id;
    @SerializedName("token") private String token;

    public String getToken() {
	return token;
    }

    public void setToken(String token) {
	this.token = token;
    }


    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }


    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }


    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }


    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }


    public boolean getSuccess() {
	return success;
    }

    public void setSuccess(boolean success) {
	this.success = success;
    }
}

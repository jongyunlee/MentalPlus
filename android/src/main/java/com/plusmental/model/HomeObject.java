package com.plusmental.model;

import com.google.gson.annotations.SerializedName;
import java.sql.Timestamp;

public class HomeObject {

    @SerializedName("success") private boolean success;
    @SerializedName("message") private String message;
    @SerializedName("profile") private Profile profile;
    @SerializedName("hearts_count") private int heartsCount;
    @SerializedName("level") private int level;
    @SerializedName("total_xp") private int totalXp;
    @SerializedName("current_xp") private int currentXp;

    public int getCurrentXp() {
	return currentXp;
    }

    public void setCurrentXp(int currentXp) {
	this.currentXp = currentXp;
    }


    public int getTotalXp() {
	return totalXp;
    }

    public void setTotalXp(int totalXp) {
	this.totalXp = totalXp;
    }


    public int getLevel() {
	return level;
    }

    public void setLevel(int level) {
	this.level = level;
    }


    public int getHeartsCount() {
	return heartsCount;
    }

    public void setHeartsCount(int heartsCount) {
	this.heartsCount = heartsCount;
    }


    public Profile getProfile() {
	return profile;
    }

    public void setProfile(Profile profile) {
	this.profile = profile;
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

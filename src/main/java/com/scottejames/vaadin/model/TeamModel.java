package com.scottejames.vaadin.model;

import java.util.List;

public class TeamModel extends Model{

    public String toString(){
        return "MODEL for Team Name:" + teamName;
    }
    private String teamName = null;
    private String hikeClass = null;
    private String status = null;
    private String section = null;
    private String district = null;
    private String county = null;
    private String prefStart = null;
    private List<ScoutModel> scoutTeam = null;
    private String activeMobile = null;
    private String backupMobile = null;
    private List<SupportModel> supportTeam = null;
    private String emergencyContactName = null;
    private String emergencyContactMobile = null;

    public String getEmergencyContactLandline() {
        return emergencyContactLandline;
    }

    public void setEmergencyContactLandline(String emergencyContactLandline) {
        this.emergencyContactLandline = emergencyContactLandline;
    }

    private String emergencyContactLandline = null;

    public String getEmergencyContactEmail() {
        return emergencyContactEmail;
    }

    public void setEmergencyContactEmail(String emergencyContactEmail) {
        this.emergencyContactEmail = emergencyContactEmail;
    }

    private String emergencyContactEmail = null;


    public TeamModel(String teamName, String hikeClass, String status) {
        this.teamName = teamName;
        this.hikeClass = hikeClass;
        this.status = status;
    }

    public TeamModel(String teamName, String hikeClass, String status, String section, String district, String county, String prefStart, List<ScoutModel> scoutTeam, String activeMobile, String backupMobile, List<SupportModel> supportTeam, String emergencyContactName, String emergencyContactMobile, String emergencyContactLandline) {
        this.teamName = teamName;
        this.hikeClass = hikeClass;
        this.status = status;
        this.section = section;
        this.district = district;
        this.county = county;
        this.prefStart = prefStart;
        this.scoutTeam = scoutTeam;
        this.activeMobile = activeMobile;
        this.backupMobile = backupMobile;
        this.supportTeam = supportTeam;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactMobile = emergencyContactMobile;
        this.emergencyContactLandline = emergencyContactLandline;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPrefStart() {
        return prefStart;
    }

    public void setPrefStart(String prefStart) {
        this.prefStart = prefStart;
    }

    public List<ScoutModel> getScoutTeam() {
        return scoutTeam;
    }

    public void setScoutTeam(List<ScoutModel> scoutTeam) {
        this.scoutTeam = scoutTeam;
    }

    public String getActiveMobile() {
        return activeMobile;
    }

    public void setActiveMobile(String activeMobile) {
        this.activeMobile = activeMobile;
    }

    public String getBackupMobile() {
        return backupMobile;
    }

    public void setBackupMobile(String backupMobile) {
        this.backupMobile = backupMobile;
    }

    public List<SupportModel> getSupportTeam() {
        return supportTeam;
    }

    public void setSupportTeam(List<SupportModel> supportTeam) {
        this.supportTeam = supportTeam;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactMobile() {
        return emergencyContactMobile;
    }

    public void setEmergencyContactMobile(String emergencyContactMobile) {
        this.emergencyContactMobile = emergencyContactMobile;
    }
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getHikeClass() {
        return hikeClass;
    }

    public void setHikeClass(String hikeClass) {
        this.hikeClass = hikeClass;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

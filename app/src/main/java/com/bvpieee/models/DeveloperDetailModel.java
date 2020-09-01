package com.bvpieee.models;

public class DeveloperDetailModel {

    private String DevelopeName;
    private String DeveloperDetails;
    private int DeveloperPhoto;
    private String DeveloperLinkedin;
    private String DeveloperEmail;


    public DeveloperDetailModel() {
    }


    public DeveloperDetailModel(String developeName, String developerDetails, int developerPhoto, String developerLinkedin, String developerEmail) {
        DevelopeName = developeName;
        DeveloperDetails = developerDetails;
        DeveloperPhoto = developerPhoto;
        DeveloperLinkedin = developerLinkedin;
        DeveloperEmail = developerEmail;
    }

    public String getDevelopeName() {
        return DevelopeName;
    }

    public int getDeveloperPhoto() {
        return DeveloperPhoto;
    }

    public String getDeveloperDetails() {
        return DeveloperDetails;
    }

    public void setDeveloperPhoto(int developerPhoto) {
        DeveloperPhoto = developerPhoto;
    }

    public void setDeveloperDetails(String developerDetails) {
        DeveloperDetails = developerDetails;
    }

    public void setDevelopeName(String developeName) {
        DevelopeName = developeName;
    }

    public void setDeveloperEmail(String developerEmail) {
        DeveloperEmail = developerEmail;
    }

    public String getDeveloperEmail() {
        return DeveloperEmail;
    }

    public String getDeveloperLinkedin() {
        return DeveloperLinkedin;
    }

    public void setDeveloperLinkedin(String developerLinkedin) {
        DeveloperLinkedin = developerLinkedin;
    }
}

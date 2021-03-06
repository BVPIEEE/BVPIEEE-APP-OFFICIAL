package com.bvpieee.models;

public class TeamFragModelClass {


    private String Name;
    private String Post;
    private int Photo;
    private String MemberDetails;
    private String LinkedIn;
    private String BranchYear;

    public TeamFragModelClass() {
    }


    public TeamFragModelClass(String name, String post, int photo, String memberDetails, String linkedIn, String branchYear) {
        Name = name;
        Post = post;
        Photo = photo;
        MemberDetails = memberDetails;
        LinkedIn = linkedIn;
        BranchYear = branchYear;
    }


    public void setLinkedIn(String linkedIn) {
        LinkedIn = linkedIn;
    }

    public String getLinkedIn() {
        return LinkedIn;
    }

    public String getName() {
        return Name;
    }

    public String getPost() {
        return Post;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPost(String post) {
        Post = post;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }

    public void setMemberDetails(String memberDetails) {
        MemberDetails = memberDetails;
    }

    public String getMemberDetails() {
        return MemberDetails;
    }

    public void setBranchYear(String branchYear) {
        BranchYear = branchYear;
    }

    public String getBranchYear() {
        return BranchYear;
    }
}
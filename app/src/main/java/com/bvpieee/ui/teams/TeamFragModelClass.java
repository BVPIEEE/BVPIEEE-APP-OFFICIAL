package com.bvpieee.ui.teams;

import android.widget.ScrollView;

public class TeamFragModelClass {

    private String Name;
    private String Post;
    private int Photo;
    private String MemberDetails;

    public TeamFragModelClass(){
    }



    public TeamFragModelClass(String name, String post, int photo, String memberDetails){
            Name=name;
            Post=post;
            Photo=photo;
            MemberDetails=memberDetails;
    }


    public String getName() {
        return Name;
    }

    public String  getPost() {
        return Post;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPost(String  post) {
        Post = post;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }

    public void setMemberDetails(String memberDetails) { MemberDetails = memberDetails; }

    public String getMemberDetails() { return MemberDetails; }
}

package com.bvpieee.ui.teams;

import com.bvpieee.Chapter;

public class ChapterTeamFragModel  {

    private String ChapterName;
    private String ChapterFullForm;
    private  int ChapPhoto;


    public ChapterTeamFragModel(){
    }



    public ChapterTeamFragModel(String chapname, String chapterfullform, int chapterphoto){
        ChapterName=chapname;
        ChapterFullForm=chapterfullform;
        ChapPhoto=chapterphoto;
    }

    public int getChapPhoto() {
        return ChapPhoto;
    }

    public String getChapterName() {
        return ChapterName;
    }

    public void setChapterFullForm(String chapterFullForm) { ChapterFullForm = chapterFullForm; }

    public String getChapterFullForm() { return ChapterFullForm; }

    public void setChapterName(String chapterName) {
        ChapterName = chapterName;
    }

    public void setChapPhoto(int chapPhoto) {
        ChapPhoto = chapPhoto;
    }
}

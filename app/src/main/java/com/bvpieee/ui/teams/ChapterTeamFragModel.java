package com.bvpieee.ui.teams;

import com.bvpieee.Chapter;

public class ChapterTeamFragModel  {

    private String ChapterName;
    private  int ChapPhoto;

    public ChapterTeamFragModel(){
    }

    public ChapterTeamFragModel(String chapname, int chapterphoto){
        ChapterName=chapname;
        ChapPhoto=chapterphoto;
    }

    public int getChapPhoto() {
        return ChapPhoto;
    }

    public String getChapterName() {
        return ChapterName;
    }

    public void setChapterName(String chapterName) {
        ChapterName = chapterName;
    }

    public void setChapPhoto(int chapPhoto) {
        ChapPhoto = chapPhoto;
    }
}

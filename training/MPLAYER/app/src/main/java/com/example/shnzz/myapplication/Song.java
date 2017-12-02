package com.example.shnzz.myapplication;

/**
 * Created by SHNZZ on 12/11/2017.
 */

public class Song {
    private String Title;
    private int File;

    public void setTitle(String title) {
        Title = title;
    }

    public void setFile(int file) {
        File = file;
    }

    public String getTitle() {

        return Title;
    }

    public int getFile() {
        return File;
    }

    public Song(String title, int file) {

        Title = title;
        File = file;
    }
}

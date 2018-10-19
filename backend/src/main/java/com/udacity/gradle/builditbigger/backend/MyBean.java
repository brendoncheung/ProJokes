package com.udacity.gradle.builditbigger.backend;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public String getJoke() {
        return myData;
    }

    public void setJoke(String data) {
        myData = data;
    }
}
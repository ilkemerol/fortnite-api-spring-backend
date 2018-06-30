package com.fortnite.api.model;

public class UserPojo
{
    private String uid;

    private String username;

    private String[] platforms;

    public String getUid ()
    {
        return uid;
    }

    public void setUid (String uid)
    {
        this.uid = uid;
    }

    public String getUsername ()
    {
        return username;
    }

    public void setUsername (String username)
    {
        this.username = username;
    }

    public String[] getPlatforms ()
    {
        return platforms;
    }

    public void setPlatforms (String[] platforms)
    {
        this.platforms = platforms;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [uid = "+uid+", username = "+username+", platforms = "+platforms+"]";
    }
}
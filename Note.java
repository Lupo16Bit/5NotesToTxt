package com.company;

import java.sql.Timestamp;

public class Note extends SuperNote
{
    private int id;
    private String topic;
    private String txt;
    private final Timestamp timestamp;
    private Boolean needsSplit = true;

    public Note(String in_topic,String in_txt)
    {
        this.id = this.id_count_SUPER;
        SuperNote.id_count_SUPER++;

        this.topic = in_topic;
        this.txt = in_txt;
        this.timestamp = new Timestamp(System.currentTimeMillis());

        if(in_txt.length() < 120)
        {
            this.needsSplit = false;
        }
        else{
            this.needsSplit = true;
        }
    }
    public Note(String in_text)
    {
        this.txt = in_text;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    // GETTER / SETTER

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String in_topic) {
        this.topic = in_topic;
    }

    public String getTxt() {
        return this.txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;

    }

    public Boolean getNeedsSplit() {
        return needsSplit;
    }

    public void setNeedsSplit(Boolean needsSplit) {
        this.needsSplit = needsSplit;
    }
}


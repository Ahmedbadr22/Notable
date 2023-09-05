package com.coder.x.notable.domain.model;


import androidx.annotation.Keep;

import java.io.Serializable;

@Keep
public class Note implements Serializable {
    protected long id;
    protected String title;
    protected String body;
    protected String createUpdateDate;

    public Note(long id, String title, String body, String createUpdateDate) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.createUpdateDate = createUpdateDate;
    }

    public Note(String title, String body, String createUpdateDate) {
        this.title = title;
        this.body = body;
        this.createUpdateDate = createUpdateDate;
    }

    public long getId() {
        return this.id;
    }
    public String getTitle() {
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    public String getCreateUpdateDate() {
        return this.createUpdateDate;
    }


    public void setTitle(String value) {
        this.title = value;
    }

    public void setBody(String value) {
        this.title = value;
    }
}

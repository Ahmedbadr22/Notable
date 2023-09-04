package com.coder.x.notable.domain.model;


public class Note {
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
}

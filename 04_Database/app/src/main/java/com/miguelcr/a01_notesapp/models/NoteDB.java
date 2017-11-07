package com.miguelcr.a01_notesapp.models;

import com.miguelcr.a01_notesapp.app.MyApplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by miguelcampos on 6/11/17.
 */

public class NoteDB extends RealmObject {

    @PrimaryKey
    private long id;
    @Required
    private String title;
    private String description;
    private long idCat;

    public NoteDB() {
        this.id = MyApplication.NoteID.incrementAndGet();
    }

    public NoteDB(String title, String description, long idCat) {
        this.id = MyApplication.NoteID.incrementAndGet();
        this.title = title;
        this.description = description;
        this.idCat = idCat;
    }

    public long getIdCat() {
        return idCat;
    }

    public void setIdCat(long idCat) {
        this.idCat = idCat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

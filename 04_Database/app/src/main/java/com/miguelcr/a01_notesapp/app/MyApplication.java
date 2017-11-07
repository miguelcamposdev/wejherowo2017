package com.miguelcr.a01_notesapp.app;

import android.app.Application;

import com.miguelcr.a01_notesapp.models.CategoryNoteDB;
import com.miguelcr.a01_notesapp.models.NoteDB;

import java.util.concurrent.atomic.AtomicLong;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by miguelcampos on 6/11/17.
 */

public class MyApplication extends Application {
    public static AtomicLong CategoryID = new AtomicLong();
    public static AtomicLong NoteID = new AtomicLong();

    @Override
    public void onCreate() {
        super.onCreate();
        initRealm();

        Realm realm = Realm.getDefaultInstance();
        CategoryID = getIdByTable(realm, CategoryNoteDB.class);
        NoteID = getIdByTable(realm, NoteDB.class);
        realm.close();

    }

    private void initRealm() {
        Realm.init(getApplicationContext());
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    private <T extends RealmObject> AtomicLong getIdByTable(Realm realm, Class<T> anyClass) {
        RealmResults<T> results = realm.where(anyClass).findAll();
        return (results.size() > 0) ? new AtomicLong(results.max("id").intValue()) : new AtomicLong();
    }
}

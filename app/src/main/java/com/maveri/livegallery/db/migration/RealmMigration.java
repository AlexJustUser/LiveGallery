package com.maveri.livegallery.db.migration;

import io.realm.DynamicRealm;
import io.realm.RealmSchema;

public class RealmMigration implements io.realm.RealmMigration  {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();

        if (oldVersion == 0) {
            schema.create("GifRealmModel")
                    .addField("title",String.class);

            oldVersion++;
        }
    }
}
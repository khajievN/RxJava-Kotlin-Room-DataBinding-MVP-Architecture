package com.nizzle94.cleankotlinrxarchitecture.database

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.migration.Migration



/**
 * Created by Khajiev Nizomjon on 26/01/2018.
 */
class Migrations {
    companion object {
        @JvmField
        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE news " + " ADD COLUMN image TEXT NOT NULL DEFAULT ''")
            }
        }
        @JvmField
        val MIGRATION_2_3: Migration = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE news " + " ADD COLUMN description TEXT NOT NULL DEFAULT ''")
            }
        }
    }
}
package com.nathanhtml.mybestyoutube.utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBase (
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

        constructor(context: Context?) : this(
                context,
                "my_best_youtube.db",
                null,
                1
        )

        companion object {
                const val DB_KEY = "id"
                const val DB_NAME = "my_best_youtube"
        }

        override fun onCreate(db: SQLiteDatabase?) {
                db!!.execSQL("CREATE TABLE $DB_NAME (" +
                        "$DB_KEY INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "title Text," +
                        "description Text," +
                        "uri Text," +
                        "category Text);")
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
                db!!.execSQL("DROP TABLE IF EXISTS $DB_NAME;")
                onCreate(db)
        }
}
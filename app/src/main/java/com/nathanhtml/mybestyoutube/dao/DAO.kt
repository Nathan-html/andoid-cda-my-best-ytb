package com.nathanhtml.mybestyoutube.dao

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class DAO (helper: SQLiteOpenHelper) {

    protected lateinit var db: SQLiteDatabase
    protected lateinit var helper: SQLiteOpenHelper

    init {
        this.helper = helper
    }

    fun open(): SQLiteDatabase {
        db = helper.writableDatabase
        return db
    }

    fun close() {
        db.close()
    }
}
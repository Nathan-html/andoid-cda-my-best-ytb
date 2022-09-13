package com.nathanhtml.mybestyoutube.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.util.Log
import com.nathanhtml.mybestyoutube.model.Video
import com.nathanhtml.mybestyoutube.utils.DataBase

class VideoDAO : DAO {

    constructor(context: Context) : super(DataBase(context))

    /**
     * Find one video with id
     */
    fun find (id: Long): Video? {
        var video : Video? = null
        open()
        val cursor : Cursor = db.rawQuery("select * from ${DataBase.DB_NAME} where ${DataBase.DB_KEY}  =?;", arrayOf(id.toString()))
        if(cursor.moveToFirst()) {
            video = Video(
                // title
                cursor.getString(1),
                // description
                cursor.getString(2),
                // uri
                cursor.getString(3),
                // category
                cursor.getString(4)
            )
        }
        close()
        return video
    }

    /**
     * Find all videos
     */
    fun findAll() : ArrayList<Video> {
        var videos : ArrayList<Video> = ArrayList()
        open()
        val cursor : Cursor = db.rawQuery("select * from ${DataBase.DB_NAME}", null)
        if(cursor.moveToFirst()) {
            while (!cursor.isAfterLast) {
                var video = Video(
                    // title
                    cursor.getString(1),
                    // description
                    cursor.getString(2),
                    // uri
                    cursor.getString(3),
                    // category
                    cursor.getString(4)
                )
                video.id = cursor.getLong(0)
                videos.add(video)
                cursor.moveToNext()
            }
        }
        close()
        Log.d("test", "on add video")
        Log.d("test", videos.toString())
        return videos
    }

    /**
     * Create one video
     */
    fun add (video: Video) {
        open()
        val values = ContentValues()
        values.put("title", video.title)
        values.put("description", video.description)
        values.put("uri", video.uri)
        values.put("category", video.category)
        val id = db.insert(
            DataBase.DB_NAME,
            null,
            values
        )
        video.id = id
        close()
    }

    /**
     * Update one video
     */
    fun update (video: Video) {
        open()
        val values = ContentValues()
        values.put("title", video.title)
        values.put("description", video.description)
        values.put("uri", video.uri)
        values.put("category", video.category)
        db.update(
            DataBase.DB_NAME,
            values,
            "${DataBase.DB_KEY} = ?",
            arrayOf(video.id.toString())
        )
        close()
    }
}

package com.nathanhtml.mybestyoutube.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nathanhtml.mybestyoutube.R
import com.nathanhtml.mybestyoutube.dao.DAO
import com.nathanhtml.mybestyoutube.dao.VideoDAO
import com.nathanhtml.mybestyoutube.model.Video

class VideosAdapter (
    private val context: Context?
): RecyclerView.Adapter<VideosAdapter.VideosAdapterHolder>() {

    companion object {
        const val TAG = "Nathan-html"
    }

    private val items : List<Video> = VideoDAO(context!!).findAll()

    /**
     * Initialize view elements
     */
    class VideosAdapterHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val videoTitle : TextView = view!!.findViewById(R.id.video_title)
        val videoDescription : TextView = view!!.findViewById(R.id.video_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideosAdapterHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.videos, parent, false)
        return VideosAdapterHolder(adapterLayout)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VideosAdapterHolder, position: Int) {
        Log.d("test", "onBindViewHolder ")
        val current : Video = items[position]
        holder.itemView.rootView
        holder.videoTitle.text = current.title
        holder.videoDescription.text = current.description
    }
}
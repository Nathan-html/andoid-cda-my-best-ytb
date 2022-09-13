package com.nathanhtml.mybestyoutube.model

import java.io.Serializable

class Video (
    title: String,
    description: String,
    uri: String,
    category: String
) : Serializable {
    var id: Long = 0
    var title: String = title
    var description: String = description
    var uri: String = uri
    var category: String = category
}
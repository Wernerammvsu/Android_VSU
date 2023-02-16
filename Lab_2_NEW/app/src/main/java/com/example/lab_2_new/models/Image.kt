package com.example.lab_2_new.models

class Image {
    var docs: ArrayList<DocImage>? = null
    var total = 0
    var limit = 0
    var page = 0
    var pages = 0

    override fun toString(): String {
        return docs!![0].previewUrl.toString() + " , высота: " + docs!![0].height
    }
}
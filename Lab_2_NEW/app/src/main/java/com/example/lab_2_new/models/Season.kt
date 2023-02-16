package com.example.lab_2_new.models

class Season {
    var docs: ArrayList<DocSeason>? = null
    var total = 0
    var limit = 0
    var page = 0
    var pages = 0

    override fun toString(): String {
        return java.lang.String.valueOf(docs!![0].episodes!![0].name)
            .toString() + " , всего: " + total
    }
}
package com.example.lab_2_new.models

class Review {
    var docs: ArrayList<DocReview>? = null
    var total = 0
    var limit = 0
    var page = 0
    var pages = 0

    override fun toString(): String {
        return java.lang.String.valueOf(docs!![0].review).toString() + " , всего отзывов: " + total
    }
}
package com.example.lab_2_new.models

import android.media.Rating
import android.provider.MediaStore.Images


class Movie {
    var id = 0
    var externalId: ExternalId? = null
    var type: String? = null
    var name: String? = null
    var alternativeName: String? = null
    var description: String? = null
    var slogan: String? = null
    var year = 0
    var poster: Poster? = null
    var backdrop: Backdrop? = null
    var rating: Rating? = null
    var votes: Votes? = null
    var videos: Videos? = null
    var budget: Budget? = null
    var fees: Fees? = null
    var distributors: Distributors? = null
    var premiere: Premiere? = null
    var images: Images? = null
    var status: String? = null
    var movieLength = 0
    var productionCompanies: ArrayList<ProductionCompany>? = null
    var spokenLanguages: ArrayList<SpokenLanguage>? = null
    var facts: ArrayList<Fact>? = null
    var genres: ArrayList<Genre>? = null
    var countries: ArrayList<Country>? = null
    var seasonsInfo: ArrayList<Any>? = null
    var persons: ArrayList<Person>? = null
    var lists: ArrayList<Any>? = null


    override fun toString(): String {
        return "$name $year"
    }
}
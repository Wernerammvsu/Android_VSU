package com.example.lab_2_new.models

class Person {
    var id = 0
    var name: String? = null
    var enName: String? = null
    var photo: String? = null
    var enProfession: String? = null
    var description: String? = null

    override fun toString(): String {
        return name + " " + enName + " " + description
    }
}
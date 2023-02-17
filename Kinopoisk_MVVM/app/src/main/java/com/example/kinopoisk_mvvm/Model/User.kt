package com.example.kinopoisk_mvvm.Model

data class User (val name: String, val login: String, val password: String) {


    override fun equals(other: Any?): Boolean {
        if (other == null || other.javaClass != this.javaClass){
            return false
        }
        val otherUser: User = other as User
        if (otherUser.login == this.login){
            return true
        }

        return false
    }
}
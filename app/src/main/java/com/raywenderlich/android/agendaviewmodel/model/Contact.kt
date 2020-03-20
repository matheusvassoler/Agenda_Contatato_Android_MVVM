package com.raywenderlich.android.agendaviewmodel.model

class Contact {
    private var name: String = ""
    private var phone: String = ""
    private var email: String = ""

    fun setName(name: String) {
        this.name = name
    }

    fun setPhone(phone: String) {
        this.phone = phone
    }

    fun setEmail(email: String) {
        this.email = email
    }
}
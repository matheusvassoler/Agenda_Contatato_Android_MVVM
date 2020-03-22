package com.raywenderlich.android.agendaviewmodel.model

class Contact {
    private var id: Int = 0
    private var name: String = ""
    private var phone: String = ""
    private var email: String = ""

    fun setId(id: Int) {
        this.id = id
    }

    fun setName(name: String) {
        this.name = name
    }

    fun setPhone(phone: String) {
        this.phone = phone
    }

    fun setEmail(email: String) {
        this.email = email
    }

    fun getId(): Int {
        return id
    }

    fun getName(): String {
        return name
    }

    fun getPhone(): String {
        return phone
    }

    fun getEmail(): String {
        return email
    }
}
package com.raywenderlich.android.agendaviewmodel.repository

import com.raywenderlich.android.agendaviewmodel.model.Contact
import java.net.ConnectException

class ContactRepository {

    companion object {
        var contactList: MutableList<Contact> = ArrayList<Contact>()
    }

    fun addContact(contact: Contact) {
        contactList.add(contact)
    }

    fun getContactList(): MutableList<Contact> {
        return ArrayList<Contact>(contactList)
    }

}
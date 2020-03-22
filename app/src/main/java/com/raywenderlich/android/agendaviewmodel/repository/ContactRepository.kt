package com.raywenderlich.android.agendaviewmodel.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.raywenderlich.android.agendaviewmodel.model.Contact
import java.net.ConnectException

class ContactRepository {

    companion object {
        var contactList: MutableList<Contact> = ArrayList<Contact>()
        var idIncrement: Int = 1
    }

    val data = MutableLiveData<Contact>()

    fun addContact(contact: Contact) {
        contact.setId(idIncrement)
        contactList.add(contact)
        idIncrement++
    }

    fun getContactList(): MutableList<Contact> {
        return ArrayList<Contact>(contactList)
    }

    fun searchContactById(id: Int): Contact? {
        for (contact in contactList) {
            if(contact.getId() == id) {
                return contact
            }
        }
        return null
    }

    fun editContact(contact: Contact) {
        var contactFound = searchContactById(contact.getId())

        if(contactFound != null) {
            var contactPosition = contactList.indexOf(contactFound)
            contactList.set(contactPosition, contact)
        }
    }
}
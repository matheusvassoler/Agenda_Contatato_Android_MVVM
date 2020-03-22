package com.raywenderlich.android.agendaviewmodel.contactForm

import androidx.lifecycle.ViewModel
import com.raywenderlich.android.agendaviewmodel.model.Contact
import com.raywenderlich.android.agendaviewmodel.repository.ContactRepository

class ContactFormViewModel: ViewModel() {

    private var name: String      = ""
    private var phone: String     = ""
    private var email: String     = ""
    private var contactRepository = ContactRepository()
    private var contact           = Contact()

    fun saveContact() {
        setContact()
        contactRepository.addContact(contact)
    }

    private fun setContact() {
        contact.setName(name)
        contact.setPhone(phone)
        contact.setEmail(email)
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
}
package com.raywenderlich.android.agendaviewmodel.contactForm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raywenderlich.android.agendaviewmodel.model.Contact
import com.raywenderlich.android.agendaviewmodel.repository.ContactRepository

class ContactFormViewModel: ViewModel() {

    private var name: String      = ""
    private var phone: String     = ""
    private var email: String     = ""
    private var contactRepository = ContactRepository()
    private var contact           = Contact()
    var contactExist: MutableLiveData<Contact> = MutableLiveData()

    fun saveContact(id: Int) {
        setContact()
        if(id > 0) {
            contact.setId(id)
            contactRepository.editContact(contact)
        } else {
            contactRepository.addContact(contact)
        }

    }

    fun searchContactById(id: Int) {
        contactExist.value = contactRepository.searchContactById(id)
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
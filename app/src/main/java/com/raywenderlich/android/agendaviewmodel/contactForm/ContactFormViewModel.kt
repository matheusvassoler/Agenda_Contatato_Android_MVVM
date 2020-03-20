package com.raywenderlich.android.agendaviewmodel.contactForm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raywenderlich.android.agendaviewmodel.model.Contact
import com.raywenderlich.android.agendaviewmodel.repository.ContactRepository

class ContactFormViewModel: ViewModel() {

    private var name: MutableLiveData<String>  = MutableLiveData()
    private var phone: MutableLiveData<String> = MutableLiveData()
    private var email: MutableLiveData<String> = MutableLiveData()
    private var contactRepository              = ContactRepository()
    private var contact                        = Contact()

    fun saveContact() {
        setContact()
        contactRepository.addContact(contact)
    }

    private fun setContact() {
        contact.setName(name.value!!)
        contact.setPhone(phone.value!!)
        contact.setEmail(email.value!!)
    }

    fun setName(name: String) {
        this.name.value = name
    }

    fun setPhone(phone: String) {
        this.phone.value = phone
    }

    fun setEmail(email: String) {
        this.email.value = email
    }
}
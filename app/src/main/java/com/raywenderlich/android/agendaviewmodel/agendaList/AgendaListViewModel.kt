package com.raywenderlich.android.agendaviewmodel.agendaList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raywenderlich.android.agendaviewmodel.model.Contact
import com.raywenderlich.android.agendaviewmodel.repository.ContactRepository

class AgendaListViewModel: ViewModel() {
    var contactList: MutableLiveData<List<Contact>> = MutableLiveData()
    var contactRepository:ContactRepository         = ContactRepository()

    fun getContacts() {
        contactList.value = contactRepository.getContactList()
    }
}
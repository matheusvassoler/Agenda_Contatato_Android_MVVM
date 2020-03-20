package com.raywenderlich.android.agendaviewmodel.agendaList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raywenderlich.android.agendaviewmodel.model.Contact

class AgendaListViewModel: ViewModel() {
    var contactList: MutableLiveData<List<Contact>> = MutableLiveData()
}
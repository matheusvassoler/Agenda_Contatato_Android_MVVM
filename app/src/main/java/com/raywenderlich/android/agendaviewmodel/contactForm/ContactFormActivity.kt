package com.raywenderlich.android.agendaviewmodel.contactForm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.raywenderlich.android.agendaviewmodel.R
import com.raywenderlich.android.agendaviewmodel.agendaList.AgendaListActivity
import kotlinx.android.synthetic.main.activity_contact_form.*

class ContactFormActivity : AppCompatActivity() {

    private lateinit var name: String
    private lateinit var phone: String
    private lateinit var email: String
    private lateinit var viewModel: ContactFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_form)

        viewModel = ViewModelProviders.of(this).get(ContactFormViewModel::class.java)

        activity_contact_form_btnAddContact.setOnClickListener {
            onClickAddContact()
        }
    }

    fun onClickAddContact() {
        getDataFromEditText()
        setDataToViewModel()
        viewModel.saveContact()
        finish()
    }

    fun getDataFromEditText() {
        name  = activity_contact_form_editName.text.toString()
        phone = activity_contact_form_editPhone.text.toString()
        email = activity_contact_form_editEmail.text.toString()
    }

    fun setDataToViewModel() {
        viewModel.setName(name)
        viewModel.setPhone(phone)
        viewModel.setEmail(email)
    }
}

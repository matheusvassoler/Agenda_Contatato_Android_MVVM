package com.raywenderlich.android.agendaviewmodel.contactForm

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.text.set
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.raywenderlich.android.agendaviewmodel.R
import com.raywenderlich.android.agendaviewmodel.agendaList.AgendaListActivity
import com.raywenderlich.android.agendaviewmodel.databinding.ActivityContactFormBinding
import com.raywenderlich.android.agendaviewmodel.model.Contact
import kotlinx.android.synthetic.main.activity_contact_form.*

class ContactFormActivity : AppCompatActivity() {

    private lateinit var name: String
    private lateinit var phone: String
    private lateinit var email: String
    private lateinit var viewModel: ContactFormViewModel
    private lateinit var binding: ActivityContactFormBinding

    private val userId by lazy {
        intent.getIntExtra("id", 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_form)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_contact_form)

        viewModel = ViewModelProviders.of(this).get(ContactFormViewModel::class.java)
        fillFields()
        viewModel.searchContactById(userId)

        activity_contact_form_btnAddContact.setOnClickListener {
            onClickAddContact()
        }
    }

    private fun fillFields() {
        viewModel.contactExist.observe(this, Observer {
            if (it != null) {
                binding.item = it
            }
        })
    }

    fun onClickAddContact() {
        getDataFromEditText()
        setDataToViewModel()
        viewModel.saveContact(userId)
        setResult(Activity.RESULT_OK)
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

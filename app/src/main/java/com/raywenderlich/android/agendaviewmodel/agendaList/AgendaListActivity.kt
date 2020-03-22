package com.raywenderlich.android.agendaviewmodel.agendaList

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.android.agendaviewmodel.R
import com.raywenderlich.android.agendaviewmodel.contactForm.ContactFormActivity
import com.raywenderlich.android.agendaviewmodel.model.Contact
import com.raywenderlich.android.agendaviewmodel.repository.ContactRepository
import kotlinx.android.synthetic.main.activity_agenda_list.*

class AgendaListActivity : AppCompatActivity() {
    private lateinit var viewModel: AgendaListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agenda_list)

        viewModel = ViewModelProviders.of(this).get(AgendaListViewModel::class.java)

        val observer = Observer<List<Contact>> {
            agenda_list.apply {
                layoutManager = LinearLayoutManager(this@AgendaListActivity, RecyclerView.VERTICAL, false)
                setHasFixedSize(true)
                adapter = AgendaListAdapter(it) {
                    goToNextActivity(it.getId())
                }
            }
        }

        viewModel.contactList.observe(this, observer)

        activity_agenda_list_fabAddContact.setOnClickListener {
            goToNextActivity()
        }

        viewModel.getContacts()
    }

    fun goToNextActivity() {
        startActivityForResult(Intent(this, ContactFormActivity::class.java),1)
    }

    fun goToNextActivity(id: Int) {
        intent = Intent(this, ContactFormActivity::class.java)
        intent.putExtra("id", id)
        startActivityForResult(intent,1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 1 && resultCode == Activity.RESULT_OK) {
            viewModel.getContacts()
        }
    }
}

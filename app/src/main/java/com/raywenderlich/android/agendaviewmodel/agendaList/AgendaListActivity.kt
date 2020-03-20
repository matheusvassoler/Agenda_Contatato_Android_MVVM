package com.raywenderlich.android.agendaviewmodel.agendaList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raywenderlich.android.agendaviewmodel.R
import com.raywenderlich.android.agendaviewmodel.contactForm.ContactFormActivity
import kotlinx.android.synthetic.main.activity_agenda_list.*

class AgendaListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agenda_list)

        activity_agenda_list_fabAddContact.setOnClickListener {
            onClickAddContact()
        }
    }

    fun onClickAddContact() {
        startActivity(Intent(this, ContactFormActivity::class.java))
    }
}

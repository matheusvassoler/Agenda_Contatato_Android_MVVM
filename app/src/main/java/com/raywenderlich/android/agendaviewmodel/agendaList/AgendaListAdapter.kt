package com.raywenderlich.android.agendaviewmodel.agendaList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.android.agendaviewmodel.R
import com.raywenderlich.android.agendaviewmodel.databinding.ContactListBinding
import com.raywenderlich.android.agendaviewmodel.model.Contact
import kotlinx.android.synthetic.main.contact_list.view.*

class AgendaListAdapter(var contacts: List<Contact>, val onItemClickListener: ((contact: Contact) -> Unit)): RecyclerView.Adapter<AgendaListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AgendaListAdapter.ViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        val binding = ContactListBinding.inflate(inflater)
        return ViewHolder(binding, onItemClickListener)
    }

    override fun getItemCount(): Int {
        return contacts.count()
    }

    override fun onBindViewHolder(holder: AgendaListAdapter.ViewHolder, position: Int) {
        var contact = contacts[position]
        holder.bindView(contact)
    }

    class ViewHolder(val view: ContactListBinding, val onItemClickListener: ((contact: Contact) -> Unit)): RecyclerView.ViewHolder(view.root) {
        fun bindView(contact: Contact) {
            view.item = contact
            view.executePendingBindings()

            itemView.setOnClickListener {
                onItemClickListener(contact)
            }
        }
    }
}
package com.raywenderlich.android.agendaviewmodel.agendaList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.android.agendaviewmodel.R
import com.raywenderlich.android.agendaviewmodel.model.Contact
import kotlinx.android.synthetic.main.contact_list.view.*

class AgendaListAdapter(var contacts: List<Contact>): RecyclerView.Adapter<AgendaListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AgendaListAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.contact_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contacts.count()
    }

    override fun onBindViewHolder(holder: AgendaListAdapter.ViewHolder, position: Int) {
        var contact = contacts[position]
        holder.bindView(contact)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var name = itemView.textView

        fun bindView(contact: Contact) {
            name.text = contact.getName()
        }
    }
}
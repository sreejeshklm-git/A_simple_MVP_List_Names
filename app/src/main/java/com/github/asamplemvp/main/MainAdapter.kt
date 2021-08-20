package com.github.asamplemvp.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.github.asamplemvp.R
import com.github.asamplemvp.model.Employee
import java.util.*


class MainAdapter(
    private val context: Context, private val list: MutableList<Employee>
) : RecyclerView.Adapter<MainAdapter.ListViewHolder>() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var employee = list[position]
        holder.name!!.setText(employee.name.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(
                Locale.getDefault()
            ) else it.toString()
        })
        holder.email!!.setText(employee.email)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.employee_list, parent, false)
        return MainAdapter.ListViewHolder(itemView)
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name = itemView.findViewById<TextView>(R.id.name)
        val email = itemView.findViewById<TextView>(R.id.email)

    }


}
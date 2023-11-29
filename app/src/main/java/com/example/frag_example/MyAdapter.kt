package com.example.frag_example

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MyAdapter (private val context: Activity, private val arrayList: ArrayList<User>) : ArrayAdapter<User> (context,R.layout.item,arrayList)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.item,null)

        val name:TextView = view.findViewById(R.id.itemname)
        val char:TextView = view.findViewById(R.id.itemchar)

        name.text = arrayList[position].name
        char.text = arrayList[position].name.get(0).toString()

        return view
    }
}
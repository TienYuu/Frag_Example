package com.example.frag_example

import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment


class BlankFragment : Fragment() {
    private lateinit var adapter: MyAdapter
    private lateinit var listview: ListView
    private lateinit var userArray : ArrayList<User>

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.option_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }
    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        activity?.menuInflater?.inflate(R.menu.menu_exam, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==R.id.add) {
            val NewAdd = AddUserFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, NewAdd)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return super.onOptionsItemSelected(item)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        val name = mutableListOf("Chris","Meg","Peter","Stewy","Brian","Louise","Jotaro","Yoma")
        val ids = mutableListOf("01","02","03", "04","05","06","07","08")
        val phone = mutableListOf("020214646631","00114446631","00124663631","00146144631","00120426631","0002446631","00124663541","0012146445")
        val email = mutableListOf("chris@gmail.com","chris1@gmail.com","chris2@gmail.com"
            ,"chris3@gmail.com","chris4@gmail.com","chris5@gmail.com"
            ,"chris6@gmail.com","chris7@gmail.com")
        val bundle = this.arguments
        if (bundle != null) {
            val name1 = bundle.getString("key1")
            val phone1 = bundle.getString("key2")
            val id1 = bundle.getString("key3")
            val email1 = bundle.getString("key4")
            name.add(name1!!)
            ids.add(id1!!)
            phone.add(phone1!!)
            email.add(email1!!)
        }
        userArray = ArrayList()
        for (i in name.indices) {
            val user1 = User(name[i],ids[i],phone[i],email[i])
            userArray.add(user1)
        }

        var listview : ListView = view.findViewById(R.id.listview)
        super.onViewCreated(view, savedInstanceState)
        adapter = activity?.let { MyAdapter(it,userArray) }!!
        listview.adapter = adapter
        registerForContextMenu(listview)
        listview.isClickable = true
        listview.setOnItemClickListener { _, _, position, _ ->
            // Get the data associated with selected item
            val name = name[position]
            val phone = phone[position]
            val ids = ids[position]
            val email = email[position]
            val newFragment = ProfileFragment()
            val bundle = Bundle()
            bundle.putString("key1", name)
            bundle.putString("key2", phone)
            bundle.putString("key3", ids)
            bundle.putString("key4", email)
            newFragment.arguments = bundle
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, newFragment)
            transaction.addToBackStack(newFragment.toString())
            transaction.commit()
        }


    }

}
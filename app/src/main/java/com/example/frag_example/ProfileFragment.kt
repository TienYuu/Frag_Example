package com.example.frag_example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = this.arguments
        if (bundle != null) {
            val name = bundle.getString("key1")
            val phone = bundle.getString("key2")
            val id = bundle.getString("key3")
            val email = bundle.getString("key4")

            var userchar:TextView = view.findViewById(R.id.userchar)
            var username:TextView = view.findViewById(R.id.username)
            var userphone:TextView = view.findViewById(R.id.userphone)
            var userid:TextView = view.findViewById(R.id.userid)
            var useremail:TextView = view.findViewById(R.id.useremail)
            var backBtn: ImageButton = view.findViewById(R.id.backBtn)

            userchar.text = name?.get(0).toString()
            username.text = name
            userphone.text = phone
            userid.text = id
            useremail.text =email

            backBtn.setOnClickListener {
              requireFragmentManager().popBackStack()
            }
            // Now you can use these values in your fragment
        }


    }

}
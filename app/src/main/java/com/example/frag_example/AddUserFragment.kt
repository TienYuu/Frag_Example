package com.example.frag_example

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment


class AddUserFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val editText1: EditText = view.findViewById(R.id.editText1)
        val editText2: EditText = view.findViewById(R.id.editText2)
        val editText3: EditText = view.findViewById(R.id.editText3)
        val editText4: EditText = view.findViewById(R.id.editText4)
        val button: Button = view.findViewById(R.id.button)
        button.isEnabled = false
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // No need to do anything here
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // No need to do anything here
            }

            override fun afterTextChanged(s: Editable) {
                button.isEnabled = editText1.text.trim().isNotEmpty() &&
                        editText2.text.trim().isNotEmpty() &&
                        editText3.text.trim().isNotEmpty() &&
                        editText4.text.trim().isNotEmpty()
            }
        }
        editText1.addTextChangedListener(textWatcher)
        editText2.addTextChangedListener(textWatcher)
        editText3.addTextChangedListener(textWatcher)
        editText4.addTextChangedListener(textWatcher)

        button.setOnClickListener {
            var name = editText1.text.toString()
            var phone = editText2.text.toString()
            var ids = editText3.text.toString()
            var email = editText4.text.toString()

            val udpFrag = BlankFragment()

            val addag = Bundle()
            addag.putString("key1", name)
            addag.putString("key2", phone)
            addag.putString("key3", ids)
            addag.putString("key4", email)
            udpFrag.arguments = addag
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, udpFrag)
            transaction.addToBackStack(null)
            transaction.commit()

        }

        super.onViewCreated(view, savedInstanceState)
    }
}
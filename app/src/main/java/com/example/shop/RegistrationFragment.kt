package com.example.shop

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.fragment_registration.*

class RegistrationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        button_register.setOnClickListener {
            if (!materialEditText.text.isNullOrEmpty()) {
                if (!materialPassET.text.isNullOrEmpty() && materialPassET.text!!.length >= 8) {
                    MaterialAlertDialogBuilder(button_register.context)
                        .setTitle("Success")
                        .setMessage("Are you register")

                        .setPositiveButton("OK") { dialog, which ->

                            User.instance.login = materialEditText.text.toString()
                            User.instance.password = materialPassET.text.toString()
                            User.instance.isRegister = true

                            findNavController().popBackStack()

                        }
                        .show()
                } else materialPass.helperText = "Пароль должен содержать не менее 8 символов"
            } else materialTextField.helperText = "Имя не должно быть пустым"
        }
    }
}

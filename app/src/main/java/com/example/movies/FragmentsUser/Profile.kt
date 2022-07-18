package com.example.movies.FragmentsUser

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.movies.Login.LoginActivity
import com.example.movies.Register.RegisterActivity
import com.example.movies.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth

class Profile : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.getRoot()

//        binding.locationChange.setOnClickListener{
//            Toast.makeText()(this, "Soon", Toast.LENGTH_SHORT).show()
//        }
//
//        binding.changelanguage.setOnClickListener {
//            Toast.makeText(this, "Soon", Toast.LENGTH_SHORT).show()
//        }
//
//        binding.notificationProfile.setOnClickListener {
//            Toast.makeText(this, "Soon", Toast.LENGTH_SHORT).show()
//
//
//        }
//
//        binding.support.setOnClickListener {
//             Toast.makeText(this, "pleas contact us", Toast.LENGTH_SHORT).show()
//
//        }
//
        binding.gotoLogin.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity( Intent(requireContext(), LoginActivity::class.java))
        }

    }

}
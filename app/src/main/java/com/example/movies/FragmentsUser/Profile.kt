package com.example.movies.FragmentsUser

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.example.movies.Login.LoginActivity
import com.example.movies.R
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
//دي هبدايه ع قد مفهمت
//        binding.apply {
//            when (id) {
//                R.id.sign_out -> {
//                   FirebaseAuth.getInstance().signOut()
//                   startActivity( Intent(requireContext(), LoginActivity::class.java))
//                }
//                R.id.prof_tv_location -> {
//                    Toast.makeText()(this, "Soon", Toast.LENGTH_SHORT).show()
//                }
//                R.id.prof_tv_phone -> {
//                    Toast.makeText()(this, "Phone Number", Toast.LENGTH_SHORT).show()
//                }
//                R.id.prof_tv_support -> {
//                    Toast.makeText()(this, "01117561394", Toast.LENGTH_SHORT).show()
//                }
//                R.id.prof_tv_notification ->{
//                    Toast.makeText(this,"soon",Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
        binding.signOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity( Intent(requireContext(), LoginActivity::class.java))
        }
//        binding.profTvLocation.setOnClickListener{
//            Toast.makeText()(this, "Soon", Toast.LENGTH_SHORT).show()
//        }
//
//
//        binding.profTvNotification.setOnClickListener {
//            Toast.makeText(this, "Soon", Toast.LENGTH_SHORT).show()
//
//
//        }
//
//        binding.profTvSupport.setOnClickListener {
//             Toast.makeText(this, "pleas contact us", Toast.LENGTH_SHORT).show()
//
//        }


    }


}
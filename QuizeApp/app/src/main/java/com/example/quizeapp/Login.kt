package com.example.quizeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizeapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.button.setOnClickListener {
            Firebase.auth.createUserWithEmailAndPassword(binding.email.text.toString(),
            binding.pass.text.toString())
                .addOnCompleteListener {
                    if (it.isSuccessful){
                       startActivity(Intent(this, QuizActivity::class.java))
                    }
                    else{
                        Toast.makeText(this, " User  Not Created !!", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}
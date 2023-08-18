package com.example.quizeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed
import com.example.quizeapp.databinding.ActivityLoginBinding
import com.example.quizeapp.databinding.ActivityMainBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)




//            if (Firebase.auth.currentUser != null){
//                startActivity(Intent(this,QuizActivity::class.java))
//            }
//            else{
//                val intent = Intent(this, Login::class.java)
//                intent.putExtra("MODE", "SIGNUP")
//                startActivity(intent)
//            }
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }, 3000)

        }
    }

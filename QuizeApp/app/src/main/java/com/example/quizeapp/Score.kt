package com.example.quizeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizeapp.databinding.ActivityScoreBinding

class Score : AppCompatActivity() {

    private lateinit var binding: ActivityScoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.score.setText("Congrats.... Your Score is : ${intent.getIntExtra("score",0)}")


    }
}
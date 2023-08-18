package com.example.quizeapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizeapp.databinding.ActivityQuizBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    private var counter : Int = 0
    private var score =0

    private lateinit var list : ArrayList<QuestionModel>
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
  list= ArrayList<QuestionModel>()

        Firebase.firestore.collection("Quiz")
            .get().addOnSuccessListener {
                doc->
                list.clear()
                for (i in doc.documents){

                    var questionModel =i.toObject(QuestionModel::class.java)
                        list.add(questionModel!!)
                }
                binding.ques.setText(list.get(0).Question)
                binding.Option1.setText(list.get(0).Option1)
                binding.Option2.setText(list.get(0).Option2)
                binding.Option3.setText(list.get(0).Option3)
                binding.Option4.setText(list.get(0).Option4)
            }
//        list.add(QuestionModel("Who is aman raj yadav", "fuck boy ", " Engineer", "Hacker", " Doctor"))
//        list.add(QuestionModel("Who is aman raj yadav", "Engineer boy ", " Engineer", "Hacker", " Army"))
//        list.add(QuestionModel("Who is aman raj yadav", "Engineer boy ", " Engineer", "Hacker", " Doctor"))
//        list.add(QuestionModel("Who is aman raj yadav", "fuck boy ", " Engineer", "boy", " Doctor"))

        
        binding.Option1.setOnClickListener { 
            nextData(binding.Option1.text.toString())
        }
        binding.Option2.setOnClickListener {
            nextData(binding.Option2.text.toString())
        }
        binding.Option3.setOnClickListener {
            nextData(binding.Option3.text.toString())
        }
        binding.Option4.setOnClickListener {
            nextData(binding.Option4.text.toString())
        }
    }


    private fun nextData(i: String) {


       if(counter<list.size){
           if (list.get(counter).ans.equals(i)){
               score++
           }
       }

        counter++
        if (counter>=list.size){
           val intent = Intent(this,Score::class.java)
            intent.putExtra("score", score)
            startActivity(intent)
            finish()
        }
        else{
            binding.ques.setText(list.get(counter).Question)
            binding.Option1.setText(list.get(counter).Option1)
            binding.Option2.setText(list.get(counter).Option2)
            binding.Option3.setText(list.get(counter).Option3)
            binding.Option4.setText(list.get(counter).Option4)

        }


    }
}
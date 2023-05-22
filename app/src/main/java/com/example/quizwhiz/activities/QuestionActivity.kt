package com.example.quizwhiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizwhiz.adapters.OptionAdapter
import com.example.quizwhiz.databinding.ActivityQuestionBinding
import com.example.quizwhiz.models.Question
import com.example.quizwhiz.models.Quiz
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson

class QuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestionBinding
    var quiz : MutableList<Quiz>? = null
    var questions: MutableMap<String, Question>? = null
    var index = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpFireStore()
        setUpEventListener()
    }

    private fun setUpEventListener() {
        binding.btnPrevious.setOnClickListener {
            index--
            bindViews()
        }
        binding.btnNext.setOnClickListener {
            index++
            bindViews()
        }
        binding.btnSubmit.setOnClickListener {
            Log.d("Final Submit", questions.toString())
            val intent = Intent(this, ResultActivity::class.java)
            val json = Gson().toJson(quiz!![0])
            intent.putExtra("QUIZ", json)
            startActivity(intent)
            finish()
        }
    }

    private fun setUpFireStore() {
        val firestore = FirebaseFirestore.getInstance()
        var date = intent.getStringExtra("DATE")
        if(date != null) {
            firestore.collection("QuizWhiz").whereEqualTo("title", date).get()
                .addOnSuccessListener {
                    if(it != null && !it.isEmpty) {
                        quiz = it.toObjects(Quiz::class.java)
                        questions = quiz!![0].questions
                        bindViews()
                    }
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun bindViews() {
        binding.btnNext.visibility = View.GONE
        binding.btnPrevious.visibility = View.GONE
        binding.btnSubmit.visibility = View.GONE
        if(index == 1){
            binding.btnNext.visibility = View.VISIBLE
        }
        else if(index == questions!!.size) {
            binding.btnSubmit.visibility = View.VISIBLE
            binding.btnPrevious.visibility = View.VISIBLE
        }
        else {
            binding.btnPrevious.visibility = View.VISIBLE
            binding.btnNext.visibility = View.VISIBLE
        }

        val question = questions!!["question$index"]

        binding.tvDescription.text = question!!.description
        question?.let {
            binding.tvDescription.text = it.description
            val optionAdapter = OptionAdapter(this, it)
            binding.rvOptionList.layoutManager = LinearLayoutManager(this)
            binding.rvOptionList.adapter = optionAdapter
            binding.rvOptionList.setHasFixedSize(true)
        }
    }
}
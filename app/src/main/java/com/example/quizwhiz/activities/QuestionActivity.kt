package com.example.quizwhiz.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizwhiz.adapters.OptionAdapter
import com.example.quizwhiz.databinding.ActivityQuestionBinding
import com.example.quizwhiz.models.Question

class QuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindViews()
    }

    private fun bindViews() {
        val question = Question(
            "What is my name?",
            "Sajal",
            "Ujjwal",
            "Rajesh",
            "Neeru",
            "Sajal"
        )
        binding.tvDescription.text = question.description
        val optionAdapter = OptionAdapter(this, question)
        binding.rvOptionList.layoutManager = LinearLayoutManager(this)
        binding.rvOptionList.adapter = optionAdapter
        binding.rvOptionList.setHasFixedSize(true)
    }
}
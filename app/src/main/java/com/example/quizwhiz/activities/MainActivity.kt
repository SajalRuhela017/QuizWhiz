package com.example.quizwhiz.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quizwhiz.R
import com.example.quizwhiz.adapters.QuizAdapter
import com.example.quizwhiz.databinding.ActivityMainBinding
import com.example.quizwhiz.models.Quiz

class MainActivity : AppCompatActivity() {
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding
    lateinit var adapter: QuizAdapter
    private var quizList = mutableListOf<Quiz>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        populateDummyData()
        setUpViews()
    }

    private fun populateDummyData() {
        quizList.add(Quiz("20-05-2023", "20-05-2023"))
        quizList.add(Quiz("21-05-2023", "21-05-2023"))
        quizList.add(Quiz("22-05-2023", "22-05-2023"))
        quizList.add(Quiz("23-05-2023", "23-05-2023"))
        quizList.add(Quiz("24-05-2023", "24-05-2023"))
        quizList.add(Quiz("25-05-2023", "25-05-2023"))
        quizList.add(Quiz("26-05-2023", "26-05-2023"))
        quizList.add(Quiz("27-05-2023", "27-05-2023"))
        quizList.add(Quiz("28-05-2023", "28-05-2023"))
        quizList.add(Quiz("29-05-2023", "29-05-2023"))
        quizList.add(Quiz("30-05-2023", "30-05-2023"))
    }

    private fun setUpViews() {
        setUpDrawerLayout()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        adapter = QuizAdapter(this, quizList)
        binding.rvMainActivity.layoutManager = GridLayoutManager(this, 2)
        binding.rvMainActivity.adapter = adapter
    }

    private fun setUpDrawerLayout() {
        setSupportActionBar(binding.appBar)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, binding.mainDrawer,
            R.string.app_name,
            R.string.app_name
        )
        actionBarDrawerToggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
package com.example.kabaddikounter

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.map
import com.example.kabaddikounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Delegate provided by androidx.activity.viewModels
    val viewModel: ScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Binding
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // Team A's one-point plus button
        binding.plusOneButtonA.setOnClickListener {
            viewModel.incrementScore(true)
            binding.scoreViewA.text = viewModel.scoreA.toString()
        }

        // Team A's two-point plus button
        binding.plusTwoButtonA.setOnClickListener {
            viewModel.doubleIncrementScore(true)
            binding.scoreViewA.text = viewModel.scoreA.toString()
        }

        // Update Team A's score
        val scoreA_Observer = Observer<Int> { newValue -> binding.scoreViewA.text = newValue.toString() }
        viewModel.scoreA.observe(this, scoreA_Observer)

        // Team B's one-point plus button
        binding.plusOneButtonB.setOnClickListener {
            viewModel.incrementScore(false)
            binding.scoreViewB.text = viewModel.scoreB.toString()
        }

        // Team B's two-point plus button
        binding.plusTwoButtonB.setOnClickListener {
            viewModel.doubleIncrementScore(false)
            binding.scoreViewB.text = viewModel.scoreB.toString()
        }

        // Update Team B's score
        val scoreB_Observer = Observer<Int> { newValue -> binding.scoreViewB.text = newValue.toString() }
        viewModel.scoreB.observe(this, scoreB_Observer)

        // Result
        val resultA = viewModel.scoreA.map { teamAScore ->
            val teamBScore = viewModel.scoreB.value ?: 0
            when {
                (teamAScore > 10) && (teamAScore > teamBScore) -> "Team A Won"
                else -> ""
            }
        }

        val resultB = viewModel.scoreB.map { teamBScore ->
            val teamAScore = viewModel.scoreA.value ?: 0
            when {
                (teamBScore > 10) && (teamBScore > teamAScore) -> "Team B Won"
                else -> ""
            }
        }

        // View result
        val resultA_Observer = Observer<String> { resultValue -> binding.resultAView.text = resultValue }
        resultA.observe(this, resultA_Observer)

        val resultB_Observer = Observer<String> { resultValue -> binding.resultBView.text = resultValue }
        resultB.observe(this, resultB_Observer)

        // Reset
        binding.resetButton.setOnClickListener {
            viewModel.resetScore()
        }

    }
}
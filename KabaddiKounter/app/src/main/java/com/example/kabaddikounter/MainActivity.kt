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
        val result = viewModel.scoreA.map { teamAScore ->
            val teamBScore = viewModel.scoreB.value ?: 0

            if ( (teamAScore > teamBScore) && (teamAScore > 10) ) {
                "Team A Won"
            } else if ( (teamBScore > teamAScore) && (teamBScore > 10) ){
                "Team B Won"
            } else ""
        }

        // View result
        val result_Observer = Observer<String> { resultValue -> binding.resultView.text = resultValue }
        result.observe(this, result_Observer)

        // Reset
        binding.resetButton.setOnClickListener {
            viewModel.resetScore()
        }

    }
}
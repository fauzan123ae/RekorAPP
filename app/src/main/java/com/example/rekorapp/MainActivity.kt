package com.example.rekorapp


import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var skorA: TextView
    private lateinit var skorB: TextView

    private val viewModel: ScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        skorA = findViewById(R.id.skorA)
        skorB = findViewById(R.id.skorB)

        val buttonPlus1A: Button = findViewById(R.id.tambah1a)
        val buttonPlus2A: Button = findViewById(R.id.tambah2a)
        val buttonPlus1B: Button = findViewById(R.id.tambah1b)
        val buttonPlus2B: Button = findViewById(R.id.tambah2b)
        val buttonReset: Button = findViewById(R.id.btnreset)

        updateScores()

        buttonPlus1A.setOnClickListener { updateScoreA(1) }
        buttonPlus2A.setOnClickListener { updateScoreA(2) }
        buttonPlus1B.setOnClickListener { updateScoreB(1) }
        buttonPlus2B.setOnClickListener { updateScoreB(2) }
        buttonReset.setOnClickListener { resetScores() }
    }

    private fun updateScoreA(points: Int) {
        viewModel.incrementSkorA(points)
        updateScores()
    }

    private fun updateScoreB(points: Int) {
        viewModel.incrementSkorB(points)
        updateScores()
    }

    private fun resetScores() {
        viewModel.resetSkor()
        updateScores()
    }

    private fun updateScores() {
        skorA.text = viewModel.scoreA.toString()
        skorB.text = viewModel.scoreB.toString()
    }
}
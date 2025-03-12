package com.example.rekorapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer

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

        viewModel.scoreA.observe(this, Observer { skorA.text = it.toString() })
        viewModel.scoreB.observe(this, Observer { skorB.text = it.toString() })


        viewModel.winner.observe(this, Observer { winner ->
            winner?.let { showWinnerDialog(it) }
        })

        buttonPlus1A.setOnClickListener { viewModel.incrementSkorA(1) }
        buttonPlus2A.setOnClickListener { viewModel.incrementSkorA(2) }
        buttonPlus1B.setOnClickListener { viewModel.incrementSkorB(1) }
        buttonPlus2B.setOnClickListener { viewModel.incrementSkorB(2) }
        buttonReset.setOnClickListener { viewModel.resetSkor() }
    }

    private fun showWinnerDialog(winner: String) {
        AlertDialog.Builder(this)
            .setTitle("Permainan Selesai!")
            .setMessage(winner)
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .setCancelable(false)
            .show()
    }
}

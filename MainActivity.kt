package com.example.multiactivityapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var gofact: Button
    lateinit var check: Button
    lateinit var gocal: Button
    lateinit var textView: TextView
    lateinit var edits: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gofact = findViewById(R.id.nav1)
        gocal = findViewById(R.id.nav2)
        check = findViewById(R.id.checkButton)
        textView = findViewById(R.id.result)
        edits = findViewById(R.id.edit)

        val factIntent = Intent(this, Factorial::class.java)
        val calIntent = Intent(this, Cal::class.java)

        gofact.setOnClickListener {
            startActivity(factIntent)
        }

        gocal.setOnClickListener {
            startActivity(calIntent)
        }

        check.setOnClickListener {
            val x = edits.text.toString().toInt()
            textView.text = isEven(x)
            edits.setText("")
        }
    }
}

fun isEven(a: Int): String {
    return if (a % 2 == 0) {
        "Number $a is Even."
    } else {
        "Number $a is Odd."
    }
}

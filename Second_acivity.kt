package com.example.multiactivityapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Factorial : AppCompatActivity() {

    lateinit var gofact : Button
    lateinit var check : Button
    lateinit var gocal : Button
    lateinit var textView: TextView
    lateinit var edits: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.factorial)
        gofact = findViewById(R.id.nav1)
        gocal = findViewById(R.id.nav2)
        check = findViewById(R.id.checkButton)
        textView = findViewById(R.id.result)
        edits = findViewById(R.id.edit)

        var factIntent = Intent(this, MainActivity :: class.java)
        var calIntent = Intent(this, Cal :: class.java)

        gofact.setOnClickListener {
            startActivity(factIntent)
        }

        gocal.setOnClickListener {
            startActivity(calIntent)
        }

        check.setOnClickListener {
            var x = edits.text.toString().toInt()
            textView.setText("Factorial of ${x} is ${fact(x)}.")
            edits.setText("")
        }

    }

    fun fact(a:Int):Int{
        if(a==1){
            return 1
        }
        return a * fact(a-1)
    }
}

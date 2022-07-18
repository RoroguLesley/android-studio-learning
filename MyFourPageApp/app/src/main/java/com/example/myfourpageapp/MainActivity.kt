package com.example.myfourpageapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            //..........calc btn
        val calcbutn = findViewById<Button>(R.id.bTncalc)

        calcbutn.setOnClickListener {
            Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Calc::class.java)
            startActivity(intent)}

            //..............toolkit btn
            val toolkitbutn = findViewById<Button>(R.id.bTntoolkit)

            toolkitbutn.setOnClickListener {
                Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Toolkit::class.java)
                startActivity(intent)
            }
            //..........website
        var buttonGoToWeb:Button ?= null
        buttonGoToWeb = findViewById(R.id.bTnweb)
        buttonGoToWeb!!.setOnClickListener {
            var goToWebIntent = Intent(applicationContext,WebActivity::class.java)
            startActivity(goToWebIntent)
        }

        }
    }


package com.example.secondmorningfirefoxapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //instantiate the ui elements
    var buttonRegister:Button ?=null
    var buttonLogin:Button ?=null
    var myphoto:Button ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //reference the elements using their respective ID's
        buttonRegister = findViewById(R.id.mBtnRegister)
        buttonLogin = findViewById(R.id.mBtnLogin)
        myphoto= findViewById(R.id.Myphoto)
        // set listeners to the elements
        buttonRegister!!.setOnClickListener {
            Toast.makeText(applicationContext,"Login button clicked", Toast.LENGTH_LONG).show()
        }
        buttonLogin!!.setOnClickListener {
            Toast.makeText(applicationContext,"Register button clicked", Toast.LENGTH_LONG).show()
        }
        myphoto!!.setOnClickListener {
            Toast.makeText(applicationContext,"Image photo clicked", Toast.LENGTH_LONG).show()
        }
    }
}
package com.example.morningfirebasedatabaseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    var editTextName: EditText? = null
    var editTextEmail: EditText? = null
    var editTextIdnumber: EditText? = null
    var buttonsave: Button? = null
    var buttonview: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.EdtName)
        editTextEmail = findViewById(R.id.EdtEmail)
        editTextIdnumber = findViewById(R.id.EdtIDNo)
        buttonsave = findViewById(R.id.mBtnSave)
        buttonview = findViewById(R.id.mBtnView)

            buttonsave!!.setOnClickListener {
                val userName = editTextName!!.text.toString().trim()
                val userEmail = editTextEmail!!.text.toString().trim()
                val userIdNumber = editTextIdnumber!!.text.toString().trim()
                val id = System.currentTimeMillis().toString()

                //check if the user has submitted empty fields

                if (userName.isEmpty()){
                    editTextName!!.setError("Please fill thi field")
                    editTextName!!.requestFocus()
                }else if (userEmail.isEmpty()){
                    editTextEmail!!.setError("Please fill thi field")
                    editTextEmail!!.requestFocus()
                }else if (userIdNumber.isEmpty()){
                    editTextIdnumber!!.setError("Please fill thi field")
                    editTextIdnumber!!.requestFocus()
                }else{
                    //proceed to save data
                    //start by creating the user object
                    val userData = User(userName,userEmail,userIdNumber,id)
                    //create a reference to the database to store data
                    val reference = FirebaseDatabase.getInstance().getReference().
                                    child("Users/$id")
                    //start saving data
                    reference.setValue(userData).addOnCompleteListener {
                        task->
                        if (task.isSuccessful){
                            Toast.makeText(applicationContext, "Data saved successfully", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(applicationContext, "Data saving failed", Toast.LENGTH_SHORT).show()
                        }

                    }
                }


            }
            buttonview!!.setOnClickListener {
                val gotoUsers = Intent(applicationContext,UsersActivity::class.java)
                startActivity(gotoUsers)
            }
    }

}
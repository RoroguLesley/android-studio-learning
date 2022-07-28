package com.example.mymorningsqliteapp

import android.content.Context
import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    var editTextName: EditText? = null
    var editTextEmail: EditText? = null
    var editTextIDNumber: EditText? = null
    var buttonsave: Button? = null
    var buttonview: Button? = null
    var buttondelete: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.mEdtName)
        editTextEmail = findViewById(R.id.mEdtEmail)
        editTextIDNumber = findViewById(R.id.mBtnEdtNumber)
        buttonsave = findViewById(R.id.mBtnSave)
        buttonview = findViewById(R.id.mBtnView)
        buttondelete = findViewById(R.id.mBtnDelete)

        //Create a database
        var db = openOrCreateDatabase("votersDB", Context.MODE_PRIVATE, null)
        //create a table called users inside the votersDB
        db.execSQL("CREATE TABLE IF NOT EXISTS users(jina VARCHAR,arafa VARCHAR, kitambulisho VARCHAR)")
        //set a click listener to butto save to implement the saving
        buttonsave!!.setOnClickListener {
            //Recieve the data from the user
            var userName = editTextName!!.text.toString()
            var userEmail = editTextName!!.text.toString()
            var userIDNumber = editTextName!!.text.toString()
            //check if the user is submitting empty fields
            if (userName.isEmpty() || userEmail.isEmpty() || userIDNumber.isEmpty()) {
                messages("EMPTY FIELDS!!","Please fill all inputs")
            }else{
                //proceed to save data
                db.execSQL("INSERT INTO users VALUES('"+userName+"','"+userEmail+"','"+userIDNumber+"')")
                messages("SUCCESS!!","Data saved successfully!!")
                clear()
            }
        }

        buttonview!!.setOnClickListener {
            //use cursor to select all the data from the database
            var cursor = db.rawQuery("SELECT * FROM users",null)
            //check if there is no record in the db
            if (cursor.count == 0 ){
                messages("NO DATA!!","Sorry he db is empty!!")
            }else{
                //use a string buffer to append all records for display
                var buffer = StringBuffer()
                while (cursor.moveToNext()){
                    buffer.append(cursor.getString(0)+"\n")//column 0 is for Name
                    buffer.append(cursor.getString(1)+"\n")//column 1 is for Email
                    buffer.append(cursor.getString(2)+"\n\n")//column 2 is for ID No
                }
                messages("DB RECORDS",buffer.toString())
            }
        }

        buttondelete!!.setOnClickListener {
            //receive the ID number from the user
            var idnumber = editTextIDNumber!!.text.toString().trim()
            //check if the user s submitting empty fields
            if (idnumber.isEmpty()){
                messages("EMPTY FIELD!!","Please enter ID no!!")
            }else{
                //use cursor to select user with provided ID
                var cursor = db.rawQuery("SELECT * FROM users WHERE kitambulisho = '"+idnumber+"'",null)
                //check if there's a user with the provided ID
                if (cursor.count == 0){
                    messages("NO RECORD!!","Record deleted successfully")
                    clear()
                }
            }
        }
    }


    fun messages(kichwa: String, ujumbe: String) {
        var alertDialog = AlertDialog.Builder(applicationContext)
        alertDialog.setTitle(kichwa)
        alertDialog.setTitle(ujumbe)
        alertDialog.create().show()
    }

    fun clear() {
        editTextEmail!!.setText("")
        editTextEmail!!.setText("")
        editTextIDNumber!!.setText("")
    }
}
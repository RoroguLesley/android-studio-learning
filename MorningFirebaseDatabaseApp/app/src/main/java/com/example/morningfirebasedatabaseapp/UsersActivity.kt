package com.example.morningfirebasedatabaseapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

class UsersActivity : AppCompatActivity() {
    var listusers:ListView ?=null
    var adapter:CustomAdapter ?=null
    var users:ArrayList<User> ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        listusers = findViewById(R.id.mListUsers)
        users = ArrayList()
        adapter = CustomAdapter(this,users!!)
        //connect to the user table/child to fetch data
        val reference = FirebaseDatabase.getInstance().getReference().child("Users")
        //start fetching the data
        reference.addValueEventListener(object : ValueEventListener{
            //override the data changed
            override fun onDataChange(snapshot: DataSnapshot) {
                users!!.clear()
                //Use for loop to add the users on the arraylist
                for (snap in snapshot.children){
                    var user = snap.getValue(User::class.java)
                    users!!.add(user!!)
                }
                adapter!!.notifyDataSetChanged()
            }
            //override the cancelled method
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, "Please contact the admin"
                    , Toast.LENGTH_SHORT).show()
            }
        })
        listusers!!.adapter = adapter!!
        //set an item click listener to the listview
        listusers!!.setOnItemClickListener { adapterView, view, i, l ->
            val userID =users!!.get(i).id
            val deletionreference = FirebaseDatabase.getInstance().getReference().
                                    child("Users/$userID")
            //set on alert when someone clicks on an item
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("ALERT!!")
            alertDialog.setMessage("Select an option you want to perform")
            alertDialog.setNegativeButton("Update", DialogInterface.OnClickListener { dialogInterface, i ->
                //dismiss the alert
                alertDialog

            })
            alertDialog.setPositiveButton("Delete",DialogInterface.OnClickListener { dialogInterface, i ->
                deletionreference.removeValue()
                Toast.makeText(applicationContext, "Deleted successfuly", Toast.LENGTH_SHORT).show()
            })
            alertDialog.create().show()
        }
    }
}
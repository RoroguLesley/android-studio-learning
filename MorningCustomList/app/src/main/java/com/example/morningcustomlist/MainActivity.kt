package com.example.morningcustomlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    var mList:ListView ?=null
    var users:ArrayList<User> ?=null
    var adapter:CustomAdapter ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mList =findViewById(R.id.mListview)
        users = ArrayList()
        adapter = CustomAdapter(this,users!!)
        //....................start creating users
        var user1 = User(R.mipmap.imgone,"Lesley","0724235454")
        var user2 = User(R.mipmap.imgtwo,"Rorogu","0724257345")
        var user3 = User(R.mipmap.imgthree,"Shean","0724256767")
        var user4 = User(R.mipmap.imgfour,"Paul","0724245423")
        var user5 = User(R.mipmap.imgtwo,"Peter","0724235423")
        var user6 = User(R.mipmap.imgone,"John","0723545423")
        var user7 = User(R.mipmap.imgthree,"Drake","0724235423")

        //.................add the created users to the arraylist users
        users!!.add(user1)
        users!!.add(user2)
        users!!.add(user3)
        users!!.add(user4)
        users!!.add(user5)
        users!!.add(user6)
        users!!.add(user7)

        //........assign our custom adapter to the list view
        mList!!.adapter = adapter!!
    }
}
package com.example.myfourpageapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Calc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)

        //...............

            var myAnswer: TextView? = null
            var myFnum: EditText? = null
            var mySnum: EditText? = null
            var buttonAdd: Button? = null
            var buttonSubtract: Button? = null
            var buttonDivide: Button? = null
            var buttonMultiply: Button? = null

                myAnswer = findViewById(R.id.mTvanswer)
                myFnum = findViewById(R.id.mEdtFnum)
                mySnum = findViewById(R.id.mEdtSnum)
                buttonAdd = findViewById(R.id.mBtnadd)
                buttonSubtract = findViewById(R.id.mBtnsubtract)
                buttonDivide = findViewById(R.id.mBtndivide)
                buttonMultiply = findViewById(R.id.mBtnmultiply)
                //set onclick listeners for button
                buttonAdd!!.setOnClickListener {
                    //receive the two numbers
                    var firstnumber = myFnum!!.text.toString().trim()
                    var secondnumber = mySnum!!.text.toString().trim()
                    //Check if the user is submitting empty fields
                    if (firstnumber.isEmpty()) {
                        //set an error to the firstnumber edit text
                        myFnum!!.setError("Please fill this input")
                        myFnum!!.requestFocus()
                    } else if (secondnumber.isEmpty()) {
                        //set an error to the firstnumber edit text
                        mySnum!!.setError("Please fill this input")
                        mySnum!!.requestFocus()
                    } else {
                        // proceed to calculate the two numbers
                        var answer = firstnumber.toDouble() + secondnumber.toDouble()
                        //dispay the result on text view myAnswer
                        myAnswer!!.text = answer.toString()
                    }
                }
                buttonSubtract!!.setOnClickListener {
                    //receive the two numbers
                    var firstnumber = myFnum!!.text.toString().trim()
                    var secondnumber = mySnum!!.text.toString().trim()
                    //Check if the user is submitting empty fields
                    if (firstnumber.isEmpty()) {
                        //set an error to the firstnumber edit text
                        myFnum!!.setError("Please fill this input")
                        myFnum!!.requestFocus()
                    } else if (secondnumber.isEmpty()) {
                        //set an error to the firstnumber edit text
                        mySnum!!.setError("Please fill this input")
                        mySnum!!.requestFocus()
                    } else {
                        // proceed to calculate the two numbers
                        var answer = firstnumber.toDouble() - secondnumber.toDouble()
                        //dispay the result on text view myAnswer
                        myAnswer!!.text = answer.toString()
                    }
                }
                    buttonDivide!!.setOnClickListener {
                        //receive the two numbers
                        var firstnumber = myFnum!!.text.toString().trim()
                        var secondnumber = mySnum!!.text.toString().trim()
                        //Check if the user is submitting empty fields
                        if (firstnumber.isEmpty()) {
                            //set an error to the firstnumber edit text
                            myFnum!!.setError("Please fill this input")
                            myFnum!!.requestFocus()
                        } else if (secondnumber.isEmpty()) {
                            //set an error to the firstnumber edit text
                            mySnum!!.setError("Please fill this input")
                            mySnum!!.requestFocus()
                        } else {
                            // proceed to calculate the two numbers
                            var answer = firstnumber.toDouble() / secondnumber.toDouble()
                            //dispay the result on text view myAnswer
                            myAnswer!!.text = answer.toString()
                        }
                    }
                        buttonMultiply!!.setOnClickListener {
                            //receive the two numbers
                            var firstnumber = myFnum!!.text.toString().trim()
                            var secondnumber = mySnum!!.text.toString().trim()
                            //Check if the user is submitting empty fields
                            if (firstnumber.isEmpty()) {
                                //set an error to the firstnumber edit text
                                myFnum!!.setError("Please fill this input")
                                myFnum!!.requestFocus()
                            } else if (secondnumber.isEmpty()) {
                                //set an error to the firstnumber edit text
                                mySnum!!.setError("Please fill this input")
                                mySnum!!.requestFocus()
                            } else {
                                // proceed to calculate the two numbers
                                var answer = firstnumber.toDouble() * secondnumber.toDouble()
                                //display the result on text view myAnswer
                                myAnswer!!.text = answer.toString()
                            }
                        }
                    }
                }




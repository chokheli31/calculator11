package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var ResultTextView: TextView



    private var operand: Double = 0.0
    private var operation: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ResultTextView = findViewById(R.id.ResultTextView)


    }

    fun numberclick(clickedView: View) {

        if (clickedView is TextView) {
            val number: String = clickedView.text.toString()
            val ResultText: String = ResultTextView.text.toString()

            ResultTextView.text = ResultText + number
        }


    }

    fun operationClick(view: View) {
        if (view is TextView) {

            val result: String = ResultTextView.text.toString()

            if (result.isNotEmpty()) {
                this.operand = result.toDouble()
            }
            ResultTextView.text = ""

            this.operation = view.text.toString()
        }
    }

    fun equalsClick(view: View) {
        val secOperandtext: String = ResultTextView.text.toString()
        var secOperand: Double = 0.0

        if (secOperandtext.isNotEmpty()) {
            secOperand = secOperandtext.toDouble()
        }

        when (this.operation) {
            "+" -> ResultTextView.text = (operand + secOperand).toString()
            "-" -> ResultTextView.text = (operand - secOperand).toString()
            "*" -> ResultTextView.text = (operand * secOperand).toString()
            "/" -> ResultTextView.text = (operand / secOperand).toString()
            "n^" -> ResultTextView.text = (Math.pow(operand,secOperand)).toString()
            "CLEAR"-> ResultTextView.text =""
        }
    }



                }











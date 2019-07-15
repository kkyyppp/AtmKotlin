package com.csl.atmkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewAndSetListener()
    }

    private fun findViewAndSetListener() {
        help.setOnClickListener{
            AlertDialog.Builder(this@MainActivity)
                .setMessage("秘密")
                .setPositiveButton("OK"){dialog, which ->
                    Toast.makeText(this@MainActivity, "我也不知道",Toast.LENGTH_SHORT).show()
                }.show()
        }

        bmi.setOnClickListener{
            val bmi = weight.text.toString().toFloat() / height.text.toString().toFloat() / height.text.toString().toFloat()*100*100
            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            intent.putExtra("bmi", bmi)
            startActivity(intent)
        }
    }
}

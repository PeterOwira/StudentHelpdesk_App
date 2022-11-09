package com.example.strathmore_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.regex.Matcher


class RegistrationActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)


        findViewById<TextView>(R.id.text_loginlink).setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
            findViewById<Button>(R.id.button_register).setOnClickListener {
                startActivity(Intent(this, LoginActivity::class.java))
            }


    }
}
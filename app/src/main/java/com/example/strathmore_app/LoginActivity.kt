package com.example.strathmore_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<TextView>(R.id.text_registrationlink).setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))

        }
        findViewById<Button>(R.id.button_login).setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java) )
        }
    }
}
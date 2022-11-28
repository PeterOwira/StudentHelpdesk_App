package com.example.strathmore_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.strathmore_app.models.User
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        findViewById<TextView>(R.id.text_registrationlink).setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))

        }
        findViewById<Button>(R.id.button_login).setOnClickListener{


           val loginchecked= userlogin()


            if (loginchecked) {
                startActivity(Intent(this, MainActivity::class.java))
            }

        }
    }

    private fun userlogin(): Boolean {


        val loginemail = findViewById<EditText>(R.id.editloginTextemail).text.toString()
        val loginpassword = findViewById<EditText>(R.id.editloginTextpassword).text.toString()


        if (TextUtils.isEmpty(loginemail)){
            Toast.makeText(this,"Email Address is empty", Toast.LENGTH_SHORT).show()
            return false
        }
        if (TextUtils.isEmpty(loginpassword)){
            Toast.makeText(this,"Password is empty", Toast.LENGTH_SHORT).show()
            return false
        }


    auth.signInWithEmailAndPassword(loginemail,loginpassword)
        .addOnCompleteListener { task ->
        if (task.isSuccessful) {

            Toast.makeText(this, "Successfull Login", Toast.LENGTH_SHORT).show()


        } else {
            Toast.makeText(this, "Error" + task.exception, Toast.LENGTH_SHORT).show()

        }

    }

return true
    }
}
package com.example.strathmore_app

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.strathmore_app.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegistrationActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        findViewById<TextView>(R.id.text_loginlink).setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
            findViewById<Button>(R.id.button_register).setOnClickListener {
                val checked = createUser()


                if (checked){

                    startActivity(Intent(this, LoginActivity::class.java))
                }


            }


    }

    private fun createUser(): Boolean {

        val firstname = findViewById<EditText>(R.id.editTextfirstName).text.toString()
        val middlename = findViewById<EditText>(R.id.editTextmiddleName).text.toString()
        val lastname = findViewById<EditText>(R.id.editTextlastName).text.toString()
        val email = findViewById<EditText>(R.id.editTextemail).text.toString()
        val password = findViewById<EditText>(R.id.editTextpassword).text.toString()
        val repeatpassword = findViewById<EditText>(R.id.editTextrepeatpassword).text.toString()



      if (TextUtils.isEmpty(firstname)){
          Toast.makeText(this,"Firstname is empty", Toast.LENGTH_SHORT).show()

          return false
      }
        if (TextUtils.isEmpty(middlename)){
            Toast.makeText(this,"Middlename is empty", Toast.LENGTH_SHORT).show()
            return false
        }
        if (TextUtils.isEmpty(lastname)){
            Toast.makeText(this,"Lastname is empty", Toast.LENGTH_SHORT).show()
        return false
        }
        if (TextUtils.isEmpty(email)){
            Toast.makeText(this,"Email is empty", Toast.LENGTH_SHORT).show()
        return false
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this,"Password is empty", Toast.LENGTH_SHORT).show()
        return false
        }
        if (TextUtils.isEmpty(repeatpassword)){
            Toast.makeText(this,"Repeat Password is empty", Toast.LENGTH_SHORT).show()
        return false
        }
        if (password.length < 6 || repeatpassword.length <6){
            Toast.makeText(this,"Password or Repeat Password is less than 6 characters", Toast.LENGTH_SHORT).show()
        return false
        }

        if (password != repeatpassword){
            Toast.makeText(this,"Password and Repeat Password do not match", Toast.LENGTH_SHORT).show()
            return false
        }

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {



                   val  user = User(firstname, middlename, lastname, email, password)
                     val userid = task.result.user?.uid

                    if (userid != null) {
                        database.reference.child("Users").child(userid).setValue(user)
                    }



                    Toast.makeText(this, "Registration Successfull", Toast.LENGTH_SHORT).show()


                } else {
                    Toast.makeText(this, "Error" + task.exception, Toast.LENGTH_SHORT).show()

                }

            }

        return true
    }
}
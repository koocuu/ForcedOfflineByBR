package com.example.forcedofflinebybr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        button.setOnClickListener {
            if (name.text.toString() == "cu" && pwd.text.toString() == "123" ){
                Intent(this,MainActivity::class.java).apply {
                    startActivity(this)
                }
            }else{
                Toast.makeText(this,"invalid",Toast.LENGTH_SHORT).show()

            }
        }

    }
}
package io.piestack.android2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginText = findViewById<View>(R.id.edEmail) as EditText
        val loginPassword = findViewById<View>(R.id.edPassword) as EditText
        val button: Button = findViewById<View>(R.id.loginButton) as Button
        button.setOnClickListener { view ->
            var myIntent: Intent? = null
            if (loginText.text.toString() == "admin" &&
                loginPassword.text.toString() == "admin"
            ) {
                println("Entering")
                myIntent = Intent(view.context, MainActivity::class.java)
            }
            startActivity(myIntent)
        }
    }
}
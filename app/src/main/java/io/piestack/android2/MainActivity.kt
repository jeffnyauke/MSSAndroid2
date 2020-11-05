package io.piestack.android2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Spinner Planets */
        val spinnerPlanets = findViewById<View>(R.id.spinner_planets) as Spinner
        val adapterPlanets = ArrayAdapter.createFromResource(
            this,
            R.array.planets_array, android.R.layout.simple_spinner_item
        )
        adapterPlanets.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerPlanets.adapter = adapterPlanets

        /* Spinner Countries */
        val spinner = findViewById<View>(R.id.spinner_countries) as Spinner
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.countries_array, android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        /* Button */
        val button1: Button = findViewById<View>(R.id.button1) as Button
        button1.setOnClickListener {
            val txtView = findViewById<View>(R.id.textView) as TextView
            txtView.textSize = 25f
        }

        val login: Button = findViewById<View>(R.id.loginButton) as Button
        login.setOnClickListener {
            val myIntent = Intent(this@MainActivity, LoginActivity::class.java)
            this@MainActivity.startActivity(myIntent)
        }

        /* Popup Menu */
        val button2 = findViewById<View>(R.id.button2) as Button
        button2.setOnClickListener {
            val popup = PopupMenu(this@MainActivity, button1)
            popup.menuInflater
                .inflate(R.menu.menu_file, popup.menu)
            popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener {
                Toast.makeText(
                    this@MainActivity,
                    "You Clicked : " + it.title,
                    Toast.LENGTH_SHORT
                ).show()
                true
            })
            popup.show()
        }
    }
}
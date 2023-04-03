package com.estefaniasalamanca.formacion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.estefaniasalamanca.formacion.FirstApp.FirstAppActivity
import com.estefaniasalamanca.formacion.imcApp.ImcCalculatorActivity
import com.estefaniasalamanca.formacion.superheroapp.SuperHeroListActivity
import com.estefaniasalamanca.formacion.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        btnSaludApp.setOnClickListener { navigateToSaludApp() }
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        btnIMCApp.setOnClickListener { navigateToIMCApp() }
        val btnToDoApp = findViewById<Button>(R.id.btnToDoApp)
        btnToDoApp.setOnClickListener { navigateToToDoApp() }
        val btnSuperHeroApp = findViewById<Button>(R.id.btnSuperHeroApp)
        btnSuperHeroApp.setOnClickListener { navigateToSuperHeroApp() }

    }

    private fun navigateToToDoApp() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)

    }

    private fun navigateToSaludApp(){
         val intent = Intent(this, FirstAppActivity::class.java)
         startActivity(intent)
     }
    private fun navigateToIMCApp(){
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)

    }
    private fun navigateToSuperHeroApp(){
        val intent = Intent(this, SuperHeroListActivity::class.java)
        startActivity(intent)

    }

}
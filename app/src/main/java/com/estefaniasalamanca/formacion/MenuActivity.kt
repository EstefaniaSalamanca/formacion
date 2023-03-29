package com.estefaniasalamanca.formacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.estefaniasalamanca.formacion.FirstApp.FirstAppActivity
import android.content.Intent
import com.estefaniasalamanca.formacion.IMCApp.ImcCalculatorActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        btnSaludApp.setOnClickListener { navigateToSaludApp() }
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        btnIMCApp.setOnClickListener { navigateToIMCApp() }
    }
     private fun navigateToSaludApp(){
         val intent = Intent(this, FirstAppActivity::class.java)
         startActivity(intent)
     }
    private fun navigateToIMCApp(){
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)

    }

}
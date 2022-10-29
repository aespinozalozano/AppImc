package com.ademirespinoza.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Variables del App IMC//

        val txtNumero1 = findViewById<EditText>(R.id.txtPeso)
        val txtNumero2 = findViewById<EditText>(R.id.txtAltura)
        val botonCalcular = findViewById<Button>(R.id.btnCalcular)
        val botonBorrarDatos = findViewById<Button>(R.id.btnBorrar)
        val botonResultado = findViewById<TextView>(R.id.txtResultadoImc)


        var resultado:Long? = null
        botonCalcular.setOnClickListener {
            if (txtNumero1.text.isNotEmpty() && txtNumero2.text.isNotEmpty()){
                var alturaFinal =
                    txtNumero2.text.toString().toLong() * txtNumero2.text.toString().toLong()
                resultado = txtNumero1.text.toString().toLong() / alturaFinal
                botonResultado.text = resultado.toString()
            }
            else {
                Toast.makeText(this,"Los 2 campos son obligatorios", Toast.LENGTH_SHORT).show()
            }

            botonBorrarDatos.setOnClickListener {
                txtNumero1.text.clear()
                txtNumero2.text.clear()
                botonResultado.text = ""
            }
        }
    }
}
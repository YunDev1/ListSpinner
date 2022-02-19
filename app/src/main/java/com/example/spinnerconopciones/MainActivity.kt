package com.example.spinnerconopciones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.spinnerconopciones.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inflamos la vista
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)// esta linea es compatible con material design y con elementos de la librería de android
        val services = resources.getStringArray(R.array.servicios)
        val adapter = ArrayAdapter(
            this,R.layout.list_item, services
        )
        with(binding.autoCompleteTextView2){
            setAdapter(adapter)
            //escuchamos el item pulsado
            onItemClickListener = this@MainActivity
        }
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val item = parent?.getItemAtPosition(position).toString()
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show()//sustituimos el texto a escribir por "item", si ponemos  position.toString() en lugar de item nos muestra la posicion del elemento seleccionado
        when (item){
            "servicio1"-> Toast.makeText(this, "ok", Toast.LENGTH_LONG).show()
            "servicio2"-> Toast.makeText(this, "sisi", Toast.LENGTH_SHORT).show()
            "servicio3"-> Toast.makeText(this, "nono", Toast.LENGTH_SHORT).show()
            "servicio4"-> Toast.makeText(this, "a ver si nos aclaramos", Toast.LENGTH_SHORT).show()
        }
    }
}
package com.example.androidtimepickerdialoginkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class AnotherActivity : AppCompatActivity() {

    var array = arrayOf("Melbourne", "Vienna", "Vancouver", "Toronto", "Calgary", "Adelaide", "Perth", "Auckland", "Helsinki", "Hamburg", "Munich", "New York", "Sydney", "Paris", "Cape Town", "Barcelona", "London", "Bangkok")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)


        val adapter = ArrayAdapter(this,R.layout.vista, array)

        val listView: ListView = findViewById(R.id.lista)
        listView.setAdapter(adapter)
    }
}
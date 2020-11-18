package com.example.androidtimepickerdialoginkotlin

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val languages = resources.getStringArray(R.array.Languages)


        // access the spinner
        val spinner = findViewById<Spinner>(R.id.spinner1)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, languages)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
      Toast.makeText(this@MainActivity, languages[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }








        val mTimePicker: TimePickerDialog
        val mcurrentTime = Calendar.getInstance()
        val hour = mcurrentTime.get(Calendar.HOUR_OF_DAY)
        val minute = mcurrentTime.get(Calendar.MINUTE)

        mTimePicker = TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener {
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                selectedTime.setText(String.format("%d : %d", hourOfDay, minute))
            }
        }, hour, minute, false)

        selectTime.setOnClickListener({ v -> mTimePicker.show()})








    val mcurrentTime2 = Calendar.getInstance()
    val year = mcurrentTime2.get(Calendar.YEAR)
    val month = mcurrentTime2.get(Calendar.MONTH)
    val day = mcurrentTime2.get(Calendar.DAY_OF_MONTH)

    val datePicker = DatePickerDialog(this, R.style.MyDatePickerStyle, object : DatePickerDialog.OnDateSetListener {
        override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
            selectedDate.setText(String.format("%d / %d / %d", dayOfMonth, month + 1, year))
        }
    }, year, month, day);

    selectDate.setOnClickListener({ v ->
        datePicker.show()
    })



}



    fun showAlertDialog(view: View): Unit {

        val builder: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)

        builder.setTitle("Title")
        builder.setMessage("Message")
        builder.setIcon(R.mipmap.ic_launcher)

        builder.setPositiveButton("ok", DialogInterface.OnClickListener { dialog, id ->
            dialog.dismiss()
        })
        builder.setNegativeButton("cancel", { dialog, id ->
            dialog.dismiss()
        })

        builder.setNeutralButton("Can't Say", { dialog, i ->
            dialog.dismiss()
        })

        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()

    }




    fun prueba(view: View) {
           val intent = Intent(this, AnotherActivity::class.java)
            // start your next activity
            startActivity(intent)


    }

}
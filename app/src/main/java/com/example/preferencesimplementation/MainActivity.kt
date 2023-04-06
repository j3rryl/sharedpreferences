package com.example.preferencesimplementation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nameET:EditText = findViewById(R.id.name)
        var ageET:EditText = findViewById(R.id.age)
        var btnSave:Button = findViewById(R.id.save)
        var btnLoad:Button=findViewById(R.id.load)
        var checkAge: CheckBox=findViewById(R.id.checkBox)

        var sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        var editor =sharedPref.edit()

        btnSave.setOnClickListener {
            var name = nameET.text.toString()
            var age = ageET.text.toString().toInt()
            var isAdult=checkAge.isChecked

            editor.putString("name",name)
            editor.putInt("age",age)
            editor.putBoolean("isAdult",isAdult)
            editor.apply()

            nameET.setText("")
            ageET.setText("")

        }

        btnLoad.setOnClickListener {
            var name = sharedPref.getString("name",null)
            var age = sharedPref.getInt("age",0)
            var isAdult=sharedPref.getBoolean("isAdult",false)


            nameET.setText(name)
            ageET.setText(age.toString())
            checkAge.isChecked=isAdult

        }
    }
}
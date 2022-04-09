package com.example.assignmentn5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var runDistance: EditText
    private lateinit var swimDistance: EditText
    private lateinit var calories: EditText
    private lateinit var info1: TextView
    private lateinit var info2: TextView
    private lateinit var info3: TextView
    private lateinit var save: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runDistance = findViewById(R.id.run)
        swimDistance = findViewById(R.id.swim)
        calories = findViewById(R.id.calories)
        info1 = findViewById(R.id.results)
        info2 = findViewById(R.id.results2)
        info3 = findViewById(R.id.results3)
        save = findViewById(R.id.save)

        save.setOnClickListener {
            if (checkInputs()) {
                Toast.makeText(this, "Fill fields", Toast.LENGTH_SHORT).show()
            } else {
                    val runDist=App.instance.db.userDao().avgOfRunDis()?.toString()
                    val totalRun=App.instance.db.userDao().totalOfRunDis()?.toString()
                    info1.append("$runDist $totalRun")
                    val swimDist = App.instance.db.userDao().avgOfSwimDis()?.toString()
                    info2.append("$swimDist")
                    val cal = App.instance.db.userDao().avgOfcals()?.toString()
                    info3.append("$cal")
                    clear()
                    insert(view = View(this))
                }
            }


    }

    private fun insert(view: View) {
        App.instance.db.userDao().delAll()
        App.instance.db.userDao().insert(User(0,runDistance.text.toString().toInt(),
            swimDistance.text.toString().toInt(),calories.text.toString().toDouble()))
        App.instance.db.userDao().getAll()?.forEach{User-> Log.d("dataset",User.toString())
        }
    }

    fun checkInputs():Boolean{
        return runDistance.text.toString().isEmpty()||
                swimDistance.text.toString().isEmpty()||
                calories.text.toString().isEmpty()
    }
    fun clear(){
        runDistance.setText("")
        swimDistance.setText("")
        calories.setText("")
    }

}
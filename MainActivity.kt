
package com.example.hospitaltriage

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        val title = TextView(this)
        title.text = "Hospital Obstetric Triage Dashboard"
        title.textSize = 22f

        val addBtn = Button(this)
        addBtn.text = "Add Patient"

        val listBtn = Button(this)
        listBtn.text = "View Patients"

        val statsBtn = Button(this)
        statsBtn.text = "Statistics"

        addBtn.setOnClickListener {
            startActivity(Intent(this, PatientFormActivity::class.java))
        }

        listBtn.setOnClickListener {
            startActivity(Intent(this, PatientListActivity::class.java))
        }

        statsBtn.setOnClickListener {
            startActivity(Intent(this, StatsActivity::class.java))
        }

        layout.addView(title)
        layout.addView(addBtn)
        layout.addView(listBtn)
        layout.addView(statsBtn)

        setContentView(layout)
    }
}

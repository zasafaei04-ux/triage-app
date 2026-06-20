
package com.example.hospitaltriage

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class PatientFormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        val name = EditText(this); name.hint = "Name"
        val age = EditText(this); age.hint = "Age"
        val sbp = EditText(this); sbp.hint = "SBP"
        val dbp = EditText(this); dbp.hint = "DBP"
        val hr = EditText(this); hr.hint = "HR"
        val rr = EditText(this); rr.hint = "RR"
        val spo2 = EditText(this); spo2.hint = "SpO2"
        val temp = EditText(this); temp.hint = "Temp"
        val vas = EditText(this); vas.hint = "VAS"

        val bleeding = CheckBox(this); bleeding.text = "Bleeding"
        val labor = CheckBox(this); labor.text = "Labor"
        val fetal = CheckBox(this); fetal.text = "Fetal distress"

        val btn = Button(this)
        btn.text = "Save Patient"

        val result = TextView(this)

        btn.setOnClickListener {

            val p = Patient(
                name = name.text.toString(),
                age = age.text.toString().toIntOrNull() ?: 0,
                gestationalAge = 0,
                sbp = sbp.text.toString().toIntOrNull() ?: 0,
                dbp = dbp.text.toString().toIntOrNull() ?: 0,
                hr = hr.text.toString().toIntOrNull() ?: 0,
                rr = rr.text.toString().toIntOrNull() ?: 0,
                spo2 = spo2.text.toString().toDoubleOrNull() ?: 0.0,
                temp = temp.text.toString().toDoubleOrNull() ?: 37.0,
                vas = vas.text.toString().toIntOrNull() ?: 0,
                bleeding = bleeding.isChecked,
                labor = labor.isChecked,
                fetalDistress = fetal.isChecked,
                triageLevel = 0
            )

            val level = TriageEngine.calculate(p)

            result.text = "Triage Level: $level"
        }

        layout.addView(name)
        layout.addView(age)
        layout.addView(sbp)
        layout.addView(dbp)
        layout.addView(hr)
        layout.addView(rr)
        layout.addView(spo2)
        layout.addView(temp)
        layout.addView(vas)
        layout.addView(bleeding)
        layout.addView(labor)
        layout.addView(fetal)
        layout.addView(btn)
        layout.addView(result)

        setContentView(layout)
    }
}

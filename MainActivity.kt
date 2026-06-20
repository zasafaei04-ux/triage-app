
package com.example.triage

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        val sbp = EditText(this); sbp.hint = "SBP"
        val hr = EditText(this); hr.hint = "HR"
        val rr = EditText(this); rr.hint = "RR"

        val btn = Button(this)
        btn.text = "Calculate Triage"

        val out = TextView(this)

        btn.setOnClickListener {
            var score = 0

            val s = sbp.text.toString().toIntOrNull() ?: 0
            val h = hr.text.toString().toIntOrNull() ?: 0
            val r = rr.text.toString().toIntOrNull() ?: 0

            if (s > 160 || s < 70) score += 3
            if (h > 130 || h < 40) score += 3
            if (r > 30 || r < 10) score += 3

            val level = when {
                score >= 6 -> 1
                score >= 4 -> 2
                score >= 2 -> 3
                else -> 5
            }

            out.text = "Score: $score | Level: $level"
        }

        layout.addView(sbp)
        layout.addView(hr)
        layout.addView(rr)
        layout.addView(btn)
        layout.addView(out)

        setContentView(layout)
    }
}

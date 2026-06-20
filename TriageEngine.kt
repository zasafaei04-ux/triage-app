
package com.example.hospitaltriage

class TriageEngine {

    companion object {

        fun calculate(p: Patient): Int {

            var score = 0

            if (p.sbp > 160 || p.sbp < 70) score += 3
            if (p.hr > 130 || p.hr < 40) score += 3
            if (p.rr > 30 || p.rr < 10) score += 3
            if (p.spo2 < 95) score += 3
            if (p.temp > 39) score += 2
            if (p.vas >= 7) score += 3
            if (p.bleeding) score += 3
            if (p.labor) score += 2
            if (p.fetalDistress) score += 3

            return when {
                score >= 10 -> 1
                score >= 7 -> 2
                score >= 4 -> 3
                score >= 2 -> 4
                else -> 5
            }
        }
    }
}

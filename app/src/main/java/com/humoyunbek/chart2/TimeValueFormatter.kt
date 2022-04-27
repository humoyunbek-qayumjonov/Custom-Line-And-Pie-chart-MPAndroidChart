package com.humoyunbek.chart2

import com.github.mikephil.charting.formatter.ValueFormatter
import java.time.LocalTime
import java.time.format.DateTimeFormatter


class TimeValueFormatter:ValueFormatter() {
    override fun getFormattedValue(value: Float): String {
        var format = ""
        when(value.toInt()){
            0->format = "Jan"
            2->format ="Feb"
            4->format ="Mar"
            6->format ="Apr"
            8->format ="May"
            10->format ="Jun"
            12->format ="Jul"
            14->format ="Aug"
            16->format ="Sep"
            18->format ="Oct"
            20->format ="Nov"
            22->format ="Dec"
        }
        return format
//        val localTime = LocalTime.of(value.toInt(),0)
//        val format = DateTimeFormatter.ofPattern("H:mm").format(localTime)
//        return format
    }
}
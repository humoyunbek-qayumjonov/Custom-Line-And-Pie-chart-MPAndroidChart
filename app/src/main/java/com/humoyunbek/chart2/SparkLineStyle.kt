package com.humoyunbek.chart2

import android.content.Context
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import javax.inject.Inject

class SparkLineStyle @Inject constructor(private val context:Context)  {
    fun styleChart(lineChart:LineChart) = lineChart.apply{
        axisRight.isEnabled = false
        axisLeft.apply {
            isEnabled = false
            axisMinimum = 0f
            axisMaximum = 100f
        }

        xAxis.apply {
            axisMinimum = 0f
            axisMaximum = 1000f
            isGranularityEnabled = true
            setDrawGridLines(true)
            position = XAxis.XAxisPosition.BOTTOM
        }
        setTouchEnabled(true)
        isDragEnabled = true
        setScaleEnabled(false)
        setPinchZoom(false)
        description = null
        legend.isEnabled = false
    }
}
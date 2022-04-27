package com.humoyunbek.chart2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import com.humoyunbek.chart2.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var lineList:ArrayList<Entry>
    lateinit var lineList2:ArrayList<Entry>
    lateinit var lineDataSet:LineDataSet
    lateinit var lineDataSet2:LineDataSet
    lateinit var lineData:LineData
    @Inject
    lateinit var chartStyle: SparkLineStyle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lineList = ArrayList()
        lineList.add(Entry(0f,100f))
        lineList.add(Entry(2f,300f))
        lineList.add(Entry(4f,200f))
        lineList.add(Entry(6f,600f))
        lineList.add(Entry(8f,500f))
        lineList.add(Entry(10f,510f))
        lineList.add(Entry(12f,600f))
        lineList.add(Entry(14f,600f))
        lineList.add(Entry(16f,600f))
        lineList.add(Entry(18f,600f))
        lineList.add(Entry(20f,600f))
        lineList.add(Entry(22f,600f))

        lineList2 = ArrayList()
        lineList2.add(Entry(0f,100f))
        lineList2.add(Entry(2f,300f))
        lineList2.add(Entry(4f,200f))
        lineList2.add(Entry(6f,600f))
        lineList2.add(Entry(8f,500f))
        lineList2.add(Entry(10f,510f))
        lineList2.add(Entry(12f,600f))
        lineList2.add(Entry(14f,600f))
        lineList2.add(Entry(16f,600f))
        lineList2.add(Entry(18f,600f))
        lineList2.add(Entry(20f,600f))
        lineList2.add(Entry(22f,600f))

        lineDataSet = LineDataSet(lineList,"Count")
        lineDataSet2 = LineDataSet(lineList2,"Count")
        lineData = LineData(lineDataSet,lineDataSet2)
        binding.lineChart.data = lineData
        binding.lineChart.invalidate()

        binding.lineChart.apply {
            axisRight.isEnabled = false
            axisLeft.apply {
                isEnabled = false
//                axisMinimum = 0f
//                axisMaximum = 100f
            }

            xAxis.apply {
                axisMinimum = 0f
                axisMaximum = 22f
                isGranularityEnabled = true
                setDrawGridLines(false)
                setDrawAxisLine(false)
                granularity = 2f
                position = XAxis.XAxisPosition.BOTTOM
                valueFormatter = TimeValueFormatter()
            }
            setTouchEnabled(true)
            isDragEnabled = true
            setScaleEnabled(false)
            setPinchZoom(false)
            description = null
            legend.isEnabled = false
        }
        lineDataSet2.apply {
            color = ContextCompat.getColor(this@MainActivity, R.color.line_color2)
            setDrawValues(false)
            lineWidth = 3f
            isHighlightEnabled = true
            setDrawHighlightIndicators(false)
            setDrawCircles(false)
            mode = LineDataSet.Mode.CUBIC_BEZIER
        }
        lineDataSet.apply {
            color = ContextCompat.getColor(this@MainActivity, R.color.line_color)
            setDrawValues(false)
            lineWidth = 3f
            isHighlightEnabled = true
            setDrawHighlightIndicators(false)
            setDrawCircles(false)
            mode = LineDataSet.Mode.CUBIC_BEZIER
            setDrawFilled(true)
            fillDrawable = ContextCompat.getDrawable(this@MainActivity,R.drawable.bg_spark_line)
        }


    }
}
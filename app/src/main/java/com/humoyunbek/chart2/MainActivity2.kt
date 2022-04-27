package com.humoyunbek.chart2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.humoyunbek.chart2.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setupPieChart()
        loadPieChart()

    }

    private fun setupPieChart(){
        binding.pieChart.isDrawHoleEnabled = true
        binding.pieChart.setUsePercentValues(true)
        binding.pieChart.setEntryLabelTextSize(12f)
        binding.pieChart.setEntryLabelColor(Color.BLACK)
        binding.pieChart.centerText = "Spending by Category"
        binding.pieChart.setCenterTextSize(24f)
        binding.pieChart.description.isEnabled = false
        val l = binding.pieChart.legend
        l.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
        l.orientation = Legend.LegendOrientation.VERTICAL
        l.setDrawInside(false)
        l.isEnabled = true
    }

    private fun loadPieChart(){
        var entries = ArrayList<PieEntry>()
        entries.add(PieEntry(0.2f,"Food & Dinning"))
        entries.add(PieEntry(0.15f,"Medical"))
        entries.add(PieEntry(0.1f,"Entertainment"))
        entries.add(PieEntry(0.25f,"Electracity and Gas"))
        entries.add(PieEntry(0.3f,"Housing"))

        var colors = ArrayList<Int>()
        for(color in ColorTemplate.MATERIAL_COLORS){
            colors.add(color)
        }
        for (color in ColorTemplate.VORDIPLOM_COLORS){
            colors.add(color)
        }

        var dataset = PieDataSet(entries,"Expense Category")
        dataset.colors = colors

        var data = PieData(dataset)
        data.setDrawValues(true)
        data.setValueFormatter(PercentFormatter(binding.pieChart))
        data.setValueTextSize(12f)
        data.setValueTextColor(Color.BLACK)

        binding.pieChart.data = data
        binding.pieChart.invalidate()
        binding.pieChart.animateY(1400,Easing.EaseInOutQuad)
    }
}
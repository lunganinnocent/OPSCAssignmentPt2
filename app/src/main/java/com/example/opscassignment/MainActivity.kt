package com.example.opscassignment

import android.os.Bundle
import android.annotation.SuppressLint
import androidx.activity.enableEdgeToEdge
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var container: FrameLayout
    private lateinit var pieChart: PieChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ///Initialize the PieChart after setContentView
        pieChart = findViewById(R.id.pieChart)

        // Configure the PieChart
        setupPieChart()

        // Load data into the PieChart
        loadPieChartData()

        tabLayout = findViewById(R.id.tabLayout)
        container = findViewById(R.id.tabContainer)

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_dashboard))
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_budget_goal))
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_show_analysis))

        showDashboard()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) { //indexes
                    0 -> showDashboard() // executes this function if tab clicked is on position zero
                    1 -> showAdd()
                    2 -> showanalysis()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // TODO("Not yet implemented")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // TODO("Not yet implemented")
            }
        })//listens to every click and executes listed operations*/
        }

        private fun setupPieChart() {
            // Configure the pie chart's settings
            /*pieChart.isDrawHoleEnabled = true // Make a hole in the center
            pieChart.setUsePercentValues(true) // Use percentage, not raw values
            pieChart.description.isEnabled = false // Remove description label
            pieChart.setExtraOffsets(5f, 10f, 5f, 5f) // Offsets for the chart
            pieChart.dragDecelerationFrictionCoef = 0.95f // Slow down rotation


            pieChart.setHoleColor(android.R.color.transparent) // Make the hole transparent
            pieChart.transparentCircleRadius = 61f // Radius of the transparent circle
            pieChart.holeRadius = 58f // Radius of the hole in the center

            pieChart.isRotationEnabled = true // Enable rotation of the chart
            pieChart.isHighlightPerTapEnabled = true // Enable highlighting slices on tap
            pieChart.rotationAngle = 0f // Start at 0 degrees
            pieChart.animateY(1400) // Animate the chart on first display

            // Add a legend to the chart
            val l = pieChart.legend
            l.verticalAlignment = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.BOTTOM
            l.horizontalAlignment = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.CENTER
            l.orientation = com.github.mikephil.charting.components.Legend.LegendOrientation.HORIZONTAL
            l.setDrawInside(false)
            l.xEntrySpace = 7f
            l.yEntrySpace = 0f
            l.yOffset = 0f*/
        }

        private fun loadPieChartData() {
            // Create the data for the pie chart
            /*val entries = ArrayList<PieEntry>()
            entries.add(PieEntry(34f, "Android"))
            entries.add(PieEntry(23f, "iOS"))
            entries.add(PieEntry(14f, "Windows"))
            entries.add(PieEntry(35f, "Other"))

            // Create a PieDataSet from the entries
            val dataSet = PieDataSet(entries, "Operating Systems")
            dataSet.setDrawIcons(false)
            dataSet.sliceSpace = 3f // Space between slices

            // Add colors to the dataset
            val colors = ArrayList<Int>()
            for (c in ColorTemplate.VORDIPLOM_COLORS) colors.add(c)
            for (c in ColorTemplate.JOYFUL_COLORS) colors.add(c)
            for (c in ColorTemplate.COLORFUL_COLORS) colors.add(c)
            for (c in ColorTemplate.LIBERTY_COLORS) colors.add(c)
            for (c in ColorTemplate.PASTEL_COLORS) colors.add(c)
            colors.add(ColorTemplate.getHoloBlue())
            dataSet.colors = colors

            // Create a PieData object from the PieDataSet
            val data = PieData(dataSet)
            data.setValueFormatter(com.github.mikephil.charting.formatter.PercentFormatter(pieChart)) // Format values as percentages
            data.setValueTextSize(11f)
            data.setValueTextColor(android.R.color.white)

            // Set the data to the PieChart
            pieChart.data = data
            pieChart.highlightValues(null)
            pieChart.invalidate() // Refresh the chart*/
        }

        private fun showDashboard() {
             var view = layoutInflater.inflate(R.layout.activity_main, null)
             container.removeAllViews() //removes all previously existing views
             container.addView(view)
        }

        private fun showAdd() {
            var view = layoutInflater.inflate(R.layout.activity_budget_goal, null)
            container.removeAllViews() //removes all previously existing views
            container.addView(view)
        }

        private fun showanalysis() {
            var view = layoutInflater.inflate(R.layout.activity_history, null)
            container.removeAllViews() //removes all previously existing views
            container.addView(view)
        }
    }


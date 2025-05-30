package com.example.uts10122038hamidabdulaziz.ui.walkthrough

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.uts10122038hamidabdulaziz.ui.main.MainActivity
import com.example.uts10122038hamidabdulaziz.R

class WalkthroughActivity : AppCompatActivity() {

    private lateinit var walkthroughAdapter: WalkthroughAdapter
    private lateinit var indicatorLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walkthrough)

        // Hilangkan action bar
        supportActionBar?.hide()

        // Set up walkthrough items
        val walkthroughItems = listOf(
            WalkthroughItem(
                R.drawable.walkthrough_1,
                getString(R.string.walkthrough_title_1),
                getString(R.string.walkthrough_description_1)
            ),
            WalkthroughItem(
                R.drawable.walkthrough_2,
                getString(R.string.walkthrough_title_2),
                getString(R.string.walkthrough_description_2)
            ),
            WalkthroughItem(
                R.drawable.walkthrough_3,
                getString(R.string.walkthrough_title_3),
                getString(R.string.walkthrough_description_3)
            )
        )

        // Inisialisasi adapter
        walkthroughAdapter = WalkthroughAdapter(walkthroughItems)

        // Set up ViewPager
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = walkthroughAdapter

        // Set up indicators
        indicatorLayout = findViewById(R.id.indicatorLayout)
        setUpIndicators()
        setCurrentIndicator(0)

        // Listener untuk ViewPager
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)

                // Ubah text button jika halaman terakhir
                val btnNext = findViewById<Button>(R.id.btnNext)
                if (position == walkthroughItems.size - 1) {
                    btnNext.text = getString(R.string.get_started)
                } else {
                    btnNext.text = getString(R.string.next)
                }
            }
        })

        // Set up button click listeners
        findViewById<Button>(R.id.btnNext).setOnClickListener {
            if (viewPager.currentItem + 1 < walkthroughAdapter.itemCount) {
                viewPager.currentItem += 1
            } else {
                navigateToMainActivity()
            }
        }

        findViewById<Button>(R.id.btnSkip).setOnClickListener {
            navigateToMainActivity()
        }
    }

    private fun navigateToMainActivity() {
        // Untuk sementara, kita akan membuat placeholder MainActivity
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun setUpIndicators() {
        val indicators = arrayOfNulls<ImageView>(walkthroughAdapter.itemCount)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(8, 0, 8, 0)

        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.indicator_inactive
                )
            )
            indicators[i]?.layoutParams = layoutParams
            indicatorLayout.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(position: Int) {
        val childCount = indicatorLayout.childCount
        for (i in 0 until childCount) {
            val imageView = indicatorLayout.getChildAt(i) as ImageView
            if (i == position) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }
}
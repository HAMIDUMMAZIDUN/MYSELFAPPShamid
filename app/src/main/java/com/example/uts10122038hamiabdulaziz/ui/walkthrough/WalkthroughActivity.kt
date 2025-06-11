package com.example.uts10122038hamidabdulaziz.ui.walkthrough

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.uts10122038hamidabdulaziz.ui.main.MainActivity
import com.example.uts10122038hamidabdulaziz.R
import com.example.uts10122038hamidabdulaziz.databinding.ActivityWalkthroughBinding // Import View Binding

class WalkthroughActivity : AppCompatActivity() {

    private lateinit var walkthroughAdapter: WalkthroughAdapter
    // LinearLayout untuk indicator diakses melalui binding
    private lateinit var binding: ActivityWalkthroughBinding // Deklarasi View Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWalkthroughBinding.inflate(layoutInflater) // Inisialisasi View Binding
        setContentView(binding.root)

        // Hilangkan action bar
        supportActionBar?.hide()

        // Set up walkthrough items
        // PENTING: WalkthroughItem sekarang hanya menerima title dan description
        //          sesuai dengan modifikasi adapter sebelumnya.
        val walkthroughItems = listOf(
            WalkthroughItem(
                // R.drawable.walkthrough_1, // DIHILANGKAN: Tidak ada lagi parameter gambar
                getString(R.string.walkthrough_title_1),
                getString(R.string.walkthrough_description_1)
            ),
            WalkthroughItem(
                // R.drawable.walkthrough_2, // DIHILANGKAN
                getString(R.string.walkthrough_title_2),
                getString(R.string.walkthrough_description_2)
            ),
            WalkthroughItem(
                // R.drawable.walkthrough_3, // DIHILANGKAN
                getString(R.string.walkthrough_title_3),
                getString(R.string.walkthrough_description_3)
            )
        )

        // Inisialisasi adapter
        walkthroughAdapter = WalkthroughAdapter(walkthroughItems)

        // Set up ViewPager menggunakan binding
        binding.viewPager.adapter = walkthroughAdapter

        // Set up indicators
        setUpIndicators()
        setCurrentIndicator(0)

        // Listener untuk ViewPager
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)

                // Ubah teks button jika halaman terakhir menggunakan binding
                if (position == walkthroughItems.size - 1) {
                    binding.btnNext.text = getString(R.string.get_started)
                } else {
                    binding.btnNext.text = getString(R.string.next)
                }
            }
        })

        // Set up button click listeners menggunakan binding
        binding.btnNext.setOnClickListener {
            if (binding.viewPager.currentItem + 1 < walkthroughAdapter.itemCount) {
                binding.viewPager.currentItem += 1
            } else {
                navigateToMainActivity()
            }
        }

        binding.btnSkip.setOnClickListener {
            navigateToMainActivity()
        }
    }

    private fun navigateToMainActivity() {
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
                    R.drawable.indicator_inactive // Pastikan drawable ini bernuansa hijau jika diinginkan
                )
            )
            indicators[i]?.layoutParams = layoutParams
            binding.indicatorLayout.addView(indicators[i]) // Menggunakan binding
        }
    }

    private fun setCurrentIndicator(position: Int) {
        val childCount = binding.indicatorLayout.childCount
        for (i in 0 until childCount) {
            val imageView = binding.indicatorLayout.getChildAt(i) as ImageView
            if (i == position) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active // Pastikan drawable ini bernuansa hijau
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive // Pastikan drawable ini bernuansa hijau atau netral
                    )
                )
            }
        }
    }
}
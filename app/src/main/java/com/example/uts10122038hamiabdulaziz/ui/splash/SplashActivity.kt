package com.example.uts10122038hamidabdulaziz.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.uts10122038hamidabdulaziz.R
import com.example.uts10122038hamidabdulaziz.ui.walkthrough.WalkthroughActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Langsung set layout
        setContentView(R.layout.activity_splash)

        // Inisialisasi animasi
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)

        // Terapkan animasi pada elemen UI
        findViewById<TextView>(R.id.appName)?.startAnimation(fadeIn)
        findViewById<TextView>(R.id.identityName)?.startAnimation(fadeIn)
        findViewById<TextView>(R.id.versionText)?.startAnimation(fadeIn)

        // Navigasi ke activity berikutnya setelah delay
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, WalkthroughActivity::class.java)
            startActivity(intent)
            finish()
        }, 2500) // 2.5 detik delay
    }
}
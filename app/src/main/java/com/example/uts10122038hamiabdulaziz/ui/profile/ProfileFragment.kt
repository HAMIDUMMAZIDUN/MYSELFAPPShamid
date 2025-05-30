package com.example.uts10122038hamidabdulaziz.ui.profile

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.uts10122038hamidabdulaziz.R
import com.example.uts10122038hamidabdulaziz.data.dummy.DummyData
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import de.hdodenhof.circleimageview.CircleImageView


class ProfileFragment : Fragment() {

    private lateinit var imgProfile: CircleImageView
    private lateinit var tvName: TextView
    private lateinit var tvDescription: TextView
    private lateinit var tvAddress: TextView
    private lateinit var btnPhone: Button
    private lateinit var btnEmail: Button
    private lateinit var btnInstagram: Button
    private lateinit var btnOpenMap: Button
    private lateinit var btnAbout: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize views
        imgProfile = view.findViewById(R.id.imgProfile)
        tvName = view.findViewById(R.id.tvName)
        tvDescription = view.findViewById(R.id.tvDescription)
        tvAddress = view.findViewById(R.id.tvAddress)
        btnPhone = view.findViewById(R.id.btnPhone)
        btnEmail = view.findViewById(R.id.btnEmail)
        btnInstagram = view.findViewById(R.id.btnInstagram)
        btnOpenMap = view.findViewById(R.id.btnOpenMap)
        btnAbout = view.findViewById(R.id.btnAbout)

        // Set up profile data
        setupProfileData()

        // Set up map
        setupMap()


        // Set up button click listeners
        setupButtonListeners()
    }

    private fun setupProfileData() {
        val profileInfo = DummyData.getProfileInfo()

        imgProfile.setImageResource(profileInfo.photo)
        tvName.text = profileInfo.name
        tvDescription.text = profileInfo.description
        tvAddress.text = profileInfo.address
    }

    private fun setupButtonListeners() {
        val profileInfo = DummyData.getProfileInfo()

        // Phone call button
        btnPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${profileInfo.phone}")
            }
            startActivity(intent)
        }

        // Email button
        btnEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${profileInfo.email}")
                putExtra(Intent.EXTRA_SUBJECT, "Hello from Myself Apps")
            }
            startActivity(intent)
        }

        // Instagram button
        btnInstagram.setOnClickListener {
            try {
                // Try to open in Instagram app first
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("http://instagram.com/_u/${profileInfo.instagram}")
                    setPackage("com.instagram.android")
                }
                startActivity(intent)
            } catch (e: Exception) {
                // If Instagram app is not installed, open in browser
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("https://instagram.com/${profileInfo.instagram}")
                }
                startActivity(intent)
            }
        }

        // Open Map button
        btnOpenMap.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:${profileInfo.latitude},${profileInfo.longitude}?q=${profileInfo.latitude},${profileInfo.longitude}(${profileInfo.name})")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")

            if (mapIntent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(mapIntent)
            } else {
                // If Google Maps is not installed
                val browserIntent = Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.com/maps/search/?api=1&query=${profileInfo.latitude},${profileInfo.longitude}"))
                startActivity(browserIntent)
            }
        }

        // About button
        btnAbout.setOnClickListener {
            showAboutDialog()
        }
    }

    private fun showAboutDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_about)

        // Set dialog width to 90% of screen width
        val width = (resources.displayMetrics.widthPixels * 0.90).toInt()
        dialog.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)

        // Initialize views in dialog
        val tvVersion = dialog.findViewById<TextView>(R.id.tvVersion)
        val tvAppInfo = dialog.findViewById<TextView>(R.id.tvAppInfo)
        val btnClose = dialog.findViewById<Button>(R.id.btnClose)

        // Set data
        tvVersion.text = "Version ${DummyData.getAppVersion()}"
        tvAppInfo.text = DummyData.getAppInfo()

        // Set close button click listener
        btnClose.setOnClickListener {
            dialog.dismiss()
        }

        // Show the dialog
        dialog.show()
    }

    private fun setupMap() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync { googleMap ->
            val profileInfo = DummyData.getProfileInfo()
            val location = LatLng(profileInfo.latitude, profileInfo.longitude)

            googleMap.addMarker(
                MarkerOptions()
                    .position(location)
                    .title(profileInfo.name)
                    .snippet(profileInfo.address)
            )
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
        }
    }
}
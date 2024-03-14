package com.example.cinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.cinema.helpers.SharedPreferencesHelper
import org.w3c.dom.Text

class OnBoarding : AppCompatActivity() {
    private val onBoardingDeque: ArrayDeque<Map<String, Int>> = ArrayDeque()
    //Object
    private lateinit var onBoardingImg: ImageView
    private lateinit var onBoardingTitle: TextView
    private lateinit var onBoardingDescription: TextView
    private lateinit var appSharedPreferences: SharedPreferencesHelper
    override fun onCreate(savedInstanceState: Bundle?) {

        val splashScreen = installSplashScreen()


        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding)
        appSharedPreferences = SharedPreferencesHelper(this)


        onBoardingImg = findViewById(R.id.image)
        onBoardingTitle = findViewById(R.id.title)
        onBoardingDescription = findViewById(R.id.description)
        onBoardingDeque.addLast(mapOf(
            "title" to R.string.title_1,
            "description" to R.string.description_1,
            "image" to R.drawable.onboarding_img_1
        ))
        onBoardingDeque.addLast(mapOf(
            "title" to R.string.title_2,
            "description" to  R.string.description_2,
            "image" to R.drawable.onboarding_img_2
        ))
        onBoardingDeque.addLast(mapOf(
            "title" to R.string.title_3,
            "description" to R.string.description_3,
            "image" to R.drawable.onboarding_img_3
        ))
        updateImg()

        //Do
        findViewById<LinearLayout>(R.id.next_btn).setOnClickListener {
            updateImg()
        }
        findViewById<LinearLayout>(R.id.pass_btn).setOnClickListener {
            while (onBoardingDeque.size>1) onBoardingDeque.removeFirst()
            updateImg()
        }
    }

    private fun updateImg() {
        if (onBoardingDeque.isNotEmpty()) {
            val stepContent: Map<String, Int> = onBoardingDeque.first()
            onBoardingDeque.removeFirst()

            onBoardingImg.setImageResource(stepContent["image"]!!)
            onBoardingDescription.text = getString(stepContent["description"]!!)
            onBoardingTitle.text = getString(stepContent["title"]!!)
        }
        else {
            appSharedPreferences.saveData("is_OnBoarding", true)
            finish()
        }
        if (onBoardingDeque.isEmpty()) {
            findViewById<TextView>(R.id.next_btn_text).text = getString(R.string.start_btn_text)
        }

    }
}



package com.example.cinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import org.w3c.dom.Text

class OnBoarding : AppCompatActivity() {
    private val onboardingContent: List<Map<String, Any>> = listOf(
        mapOf(
            "title" to "Добро пожаловать\nв Клуб Синема!",
            "description" to "",
            "image" to R.drawable.onboarding_img_1
        ),
        mapOf(
            "title" to "Смотри премьеры и\n классику в кино",
            "description" to "Узнавай первый о премьерах новых фильмах и пересматривай любимые фильмы в кинозале",
            "image" to R.drawable.onboarding_img_2
        ),
        mapOf(
            "title" to "Все билеты в одном месте",
            "description" to "Покупай и используй билеты в любимых кинотеатрах в одном приложении",
            "image" to R.drawable.onboarding_img_3
        )
    )
    private var step = 0

    //Object
    private lateinit var onBoardingImg: ImageView
    private lateinit var onBoardingTitle: TextView
    private lateinit var onBoardingDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding)

        onBoardingImg = findViewById(R.id.image)
        onBoardingTitle = findViewById(R.id.title)
        onBoardingDescription = findViewById(R.id.description)

        updateImg()

        //Do
        findViewById<LinearLayout>(R.id.next_btn).setOnClickListener {
            step++
            updateImg()
        }
        findViewById<LinearLayout>(R.id.pass_btn).setOnClickListener {
            step = 2
            updateImg()
        }
    }

    private fun updateImg() {
        if (step < 3) {
            onBoardingImg.setImageResource(onboardingContent[step]["image"] as Int)
            onBoardingDescription.text = onboardingContent[step]["description"] as String
            onBoardingTitle.text = onboardingContent[step]["title"] as String

            if (step == 2) {

                findViewById<TextView>(R.id.next_btn_text).text = "Начать"
            }
        }
    }
}

package com.ddd.android.session

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // defStyleAttr에 android:textColor가 정의되어 있을 때
        val defStyleResAttrTextColor = String.format("#%06X", 0xFFFFFF and -16720385)
        // defStyleAttr에서 android:textColor를 못 찾았을 때
        val defStyleResTextColor = String.format("#%06X", 0xFFFFFF and -1)
        val darkGray = String.format("#%06X", 0xFFFFFF and 17170432)

        println("defStyleResAttrTextColor: $defStyleResAttrTextColor")
        println("defStyleResTextColor: $defStyleResTextColor")
        println("darkGray: $darkGray")

        findViewById<DDDProgressBar>(R.id.progressBar).display()
    }
}
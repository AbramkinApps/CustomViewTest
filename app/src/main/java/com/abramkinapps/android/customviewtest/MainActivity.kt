package com.abramkinapps.android.customviewtest

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //  val customView: CustomView = findViewById(R.id.custom_view)

      //  customView.strokeColor = Color.YELLOW
      //  customView.strokeWidth = 50F
    }
}
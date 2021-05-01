package com.CDL.android.warcardgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// All card images are from http://acbl.mybigcommerce.com/52-playing-cards/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_page)
    }
}
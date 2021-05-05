package com.CDL.android.warcardgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

private const val TAG = "HowToPlay"

class HowToPlayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_to_play)
    }

    // Call this to move from the main activity to the game activity
    fun launchMain(view: View) {
        Log.i(TAG, "launching main activity")
        // intent of the how to play activity
        val main_intent = Intent(this, MainActivity::class.java)
        // switch from the main activity to the how to play activity using the intent
        startActivity(main_intent)
    }
}
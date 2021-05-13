package com.CDL.android.warcardgame


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.CDL.android.warcardgame.database.Scoreboard
import java.util.*

// const val TAG = "MainActivity"
// All card images are from http://acbl.mybigcommerce.com/52-playing-cards/
class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

        }

    // Call this to move from the main activity to the game activity
    fun launchGame(view: View) {
        //Log.i(TAG, "launching game activity")
        // intent of the game activity
        val game_intent = Intent(this, GameActivity::class.java)
        // switch from the main activity to the game activity using the intent
        startActivity(game_intent)
    }

    // Call this to move from the main activity to the How to Play activity
    fun launchHowToPlay(view: View) {
        //Log.i(TAG, "launching how to play activity")
        // intent of the how to play activity
        val how_to_intent = Intent(this, HowToPlayActivity::class.java)
        // switch from the main activity to the how to play activity using the intent
        startActivity(how_to_intent)
    }

    fun launchScoreboard(view: View) {
        //Log.i(TAG, "launching scoreboard activity")
        // intent of the scoreboard activity
        val score_intent = Intent(this, Scoreboard::class.java)
        // switch from the main activity to the scoreboard activity using the intent
        startActivity(score_intent)
    }
}


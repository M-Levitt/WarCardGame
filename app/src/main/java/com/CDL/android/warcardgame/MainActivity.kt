package com.CDL.android.warcardgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*

lateinit var card1: ImageView
lateinit var card2: ImageView

lateinit var let_player1: TextView
lateinit var let_player2: TextView

lateinit var wargame: TextView

lateinit var deals: Button

lateinit var random: Random

var player1 = 0
var player2 = 0

var cardsArray = intArrayOf(
        R.drawable.spades
        R.drawable.hearts
        R.drawable.clubs
        R.drawable.diamonds
)


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        card1 = findViewById(R.id.card1)
        card2 = findViewById(R.id.card2)

        player1 = findViewById(R.id.let_player1)
        player2 = findViewById(R.id.let_player2)

        wargame = findViewById(R.id.wargame)
        wargame.visibility = View.INVISIBLE

        deals = findViewById(R.id.deals)
        deals.setOnClickListener {
            wargame.visibility = View.INVISIBLE

            val card1 = random.nextInt(cardsArray.size)
            val card2 = random.nextInt(cardsArray.size)

            setCardImage(card1, card1)
            setCardImage(card2, card2)

            // comparing unique cards
            if(card1 > card2) {
                player1++
                player1.text = "Player 1: $player1"
            } else if (card1 < card2){
                player2++
                player2.text = "Player 2: $player2"
            } else {
                wargame.visibility = View.VISIBLE
        }
        }
    }

    private fun setCardImage(number: Int, image: ImageView) {
        image.setImageResource(cardsArray[number])
    }
}
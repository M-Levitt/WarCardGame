package com.CDL.android.warcardgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var iv_card1: ImageView
    lateinit var iv_card2: ImageView

    lateinit var let_player1: TextView
    lateinit var let_player2: TextView

    lateinit var wargame: TextView

    lateinit var deals: Button

    lateinit var random: Random

    var player1 = 0
    var player2 = 0

    var cardDeck = intArrayOf(
            R.drawable.hearts_10,
            R.drawable.hearts_9,
            R.drawable.hearts_8,
            R.drawable.hearts_7,
            R.drawable.hearts_6,
            R.drawable.hearts_5,
            R.drawable.hearts_4,
            R.drawable.hearts_3,
            R.drawable.hearts_2,
            R.drawable.hearts_ace,
            R.drawable.hearts_jack,
            R.drawable.hearts_queen,
            R.drawable.hearts_king,
            R.drawable.spades_10,
            R.drawable.spades_9,
            R.drawable.spades_8,
            R.drawable.spades_7,
            R.drawable.spades_6,
            R.drawable.spades_5,
            R.drawable.spades_4,
            R.drawable.spades_3,
            R.drawable.spades_2,
            R.drawable.spades_ace,
            R.drawable.spades_jack,
            R.drawable.spades_queen,
            R.drawable.spades_king,
            R.drawable.clubs_10,
            R.drawable.clubs_9,
            R.drawable.clubs_8,
            R.drawable.clubs_7,
            R.drawable.clubs_6,
            R.drawable.clubs_5,
            R.drawable.clubs_4,
            R.drawable.clubs_3,
            R.drawable.clubs_2,
            R.drawable.clubs_ace,
            R.drawable.clubs_jack,
            R.drawable.clubs_queen,
            R.drawable.clubs_king,
            R.drawable.diamonds_10,
            R.drawable.diamonds_9,
            R.drawable.diamonds_8,
            R.drawable.diamonds_7,
            R.drawable.diamonds_6,
            R.drawable.diamonds_5,
            R.drawable.diamonds_4,
            R.drawable.diamonds_3,
            R.drawable.diamonds_2,
            R.drawable.diamonds_ace,
            R.drawable.diamonds_jack,
            R.drawable.diamonds_queen,
            R.drawable.diamonds_king
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iv_card1 = findViewById(R.id.player_card)
        iv_card2 = findViewById(R.id.opponent_card)

        let_player1 = findViewById(R.id.player_deck)
        let_player2 = findViewById(R.id.opponent_deck)

        wargame = findViewById(R.id.)
        wargame.visibility = View.INVISIBLE

        //button for dealing the cards
        deals = findViewById(R.id.deals)
        deals.setOnClickListener {
            wargame.visibility = View.INVISIBLE

            // random cards generated from varying suits
            val card1 = random.nextInt(cardDeck.size)
            val card2 = random.nextInt(cardDeck.size)

            // images compiled for play
            setCardImage(card1, iv_card1)
            setCardImage(card2, iv_card2)

            // comapting card values
            if(card1 > card2) {
                player1++
                let_player1.text = "Player 1: $player1"
            } else if (card1 < card2) {
                player2++
                let_player2.text = "Player 2: $player2"
            } else {
                // war commences from label
                wargame.visibility = View.VISIBLE
            }
        }
    }

    private fun setCardImage(number: Int, image: ImageView) {
        image.setImageResource(cardDeck[number])
    }
}
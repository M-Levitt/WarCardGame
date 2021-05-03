package com.CDL.android.warcardgame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.core.view.isVisible

class GameActivity : AppCompatActivity() {

    var cards = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_page)

        val player_deck: ImageView = findViewById(R.id.player_deck)
        val player_card: ImageView = findViewById(R.id.player_card)
        val opponent_deck: ImageView = findViewById(R.id.opponent_deck)
        val opponent_card: ImageView = findViewById(R.id.opponent_card)

        player_card.isVisible = false
        opponent_card.isVisible = false

        /*
        Naming convention for cards is this:
        First number is the suit of the card and the second and third number represent
        the card's value
        For suit(these don't affect the value of the card, just used for organization):
        1 = clubs
        2 = diamonds
        3 = hearts
        4 = spades
        For number (these do affect the value of the card, the higher the number the more the value)
        02 = 2
        03 = 3
        04 = 4
        05 = 5
        06 = 6
        07 = 7
        08 = 8
        09 = 9
        10 = 10
        11 = J
        12 = Q
        13 = K
        14 = A
        Combine these numbers together into a three digit number to organize all the cards
        For example, 102 is the 2 of clubs
         */
        // cards in terms of integers
        // clubs
        val clubs_2 = 102
        val clubs_3 = 103
        val clubs_4 = 104
        val clubs_5 = 105
        val clubs_6 = 106
        val clubs_7 = 107
        val clubs_8 = 108
        val clubs_9 = 109
        val clubs_10 = 110
        val clubs_jack = 111
        val clubs_queen = 112
        val clubs_king = 113
        val clubs_ace = 114
        // diamonds
        val diamonds_2 = 202
        val diamonds_3 = 203
        val diamonds_4 = 204
        val diamonds_5 = 205
        val diamonds_6 = 206
        val diamonds_7 = 207
        val diamonds_8 = 208
        val diamonds_9 = 209
        val diamonds_10 = 210
        val diamonds_jack = 211
        val diamonds_queen = 212
        val diamonds_king = 213
        val diamonds_ace = 214
        // hearts
        val hearts_2 = 302
        val hearts_3 = 303
        val hearts_4 = 304
        val hearts_5 = 305
        val hearts_6 = 306
        val hearts_7 = 307
        val hearts_8 = 308
        val hearts_9 = 309
        val hearts_10 = 310
        val hearts_jack = 311
        val hearts_queen = 312
        val hearts_king = 313
        val hearts_ace = 314
        // spades
        val spades_2 = 402
        val spades_3 = 403
        val spades_4 = 404
        val spades_5 = 405
        val spades_6 = 406
        val spades_7 = 407
        val spades_8 = 408
        val spades_9 = 409
        val spades_10 = 410
        val spades_jack = 411
        val spades_queen = 412
        val spades_king = 413
        val spades_ace = 414

        // add cards
        // clubs
        cards.add(clubs_2)
        cards.add(clubs_3)
        cards.add(clubs_4)
        cards.add(clubs_5)
        cards.add(clubs_6)
        cards.add(clubs_7)
        cards.add(clubs_8)
        cards.add(clubs_9)
        cards.add(clubs_10)
        cards.add(clubs_jack)
        cards.add(clubs_queen)
        cards.add(clubs_king)
        cards.add(clubs_ace)
        // diamonds
        cards.add(diamonds_2)
        cards.add(diamonds_3)
        cards.add(diamonds_4)
        cards.add(diamonds_5)
        cards.add(diamonds_6)
        cards.add(diamonds_7)
        cards.add(diamonds_8)
        cards.add(diamonds_9)
        cards.add(diamonds_10)
        cards.add(diamonds_jack)
        cards.add(diamonds_queen)
        cards.add(diamonds_king)
        cards.add(diamonds_ace)
        // hearts
        cards.add(hearts_2)
        cards.add(hearts_3)
        cards.add(hearts_4)
        cards.add(hearts_5)
        cards.add(hearts_6)
        cards.add(hearts_7)
        cards.add(hearts_8)
        cards.add(hearts_9)
        cards.add(hearts_10)
        cards.add(hearts_jack)
        cards.add(hearts_queen)
        cards.add(hearts_king)
        cards.add(hearts_ace)
        // spades
        cards.add(spades_2)
        cards.add(spades_3)
        cards.add(spades_4)
        cards.add(spades_5)
        cards.add(spades_6)
        cards.add(spades_7)
        cards.add(spades_8)
        cards.add(spades_9)
        cards.add(spades_10)
        cards.add(spades_jack)
        cards.add(spades_queen)
        cards.add(spades_king)
        cards.add(spades_ace)

        player_deck.setOnClickListener{
            player_card.isVisible = true
            player_card.setImageResource(R.drawable.clubs_2)
        }

    }

    fun showCard(card: Int, cardimage: ImageView) {
        cardimage.setImageResource(R.drawable.clubs_2)
    }
}
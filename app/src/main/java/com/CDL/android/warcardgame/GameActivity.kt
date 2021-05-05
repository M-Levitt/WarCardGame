package com.CDL.android.warcardgame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible

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

class GameActivity : AppCompatActivity() {

    var cards = ArrayList<Int>()
    var cards_for_player = ArrayList<Int>()
    var cards_for_opponent = ArrayList<Int>()
    var half_of_a_full_deck = 0 // this should be 26 after the cards are added
    var player_deck_counter = 0
    var opponent_deck_counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_page)

        val player_deck: ImageView = findViewById(R.id.player_deck)
        val player_card: ImageView = findViewById(R.id.player_card)
        val opponent_deck: ImageView = findViewById(R.id.opponent_deck)
        val opponent_card: ImageView = findViewById(R.id.opponent_card)

        player_card.isVisible = false
        opponent_card.isVisible = false

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

        cards.shuffle()

        half_of_a_full_deck = cards.size / 2
        for (i in 0..(cards.size - 1)) {
            // divide half the 52 cards for the player closer to the bottom
            if (i < half_of_a_full_deck) {
                cards_for_player.add(cards.get(i))
            }
            // divide the other half of the 52 cards for the player closer to the top
            else if (i >= half_of_a_full_deck) {
                cards_for_opponent.add(cards.get(i))
            }
        }

        val cardText: TextView = findViewById(R.id.card_text)
        player_deck.setOnClickListener {
            // cards.shuffle()
            if (player_deck_counter == cards_for_player.size) {
                player_deck_counter = 0
            }
            if (opponent_deck_counter == cards_for_opponent.size) {
                opponent_deck_counter = 0
            }
            var current_player_card = cards_for_player.get(player_deck_counter)
            var current_opponent_card = cards_for_opponent.get(opponent_deck_counter)
            player_deck_counter += 1
            opponent_deck_counter += 1
            player_card.isVisible = true
            opponent_card.isVisible = true
            showCard(current_player_card, player_card)
            showCard(current_opponent_card, opponent_card)
            var battle = cardOutcome(current_player_card, current_opponent_card)
            cardText.setText(battle.toString())
        }

    }

    fun cardOutcome(playerCard: Int, opponentCard: Int): Int {
        val startIndex = 1
        val player_string_card = playerCard.toString()
        val opponent_string_card = opponentCard.toString()

        // exclude the first value (suit value) and include just the final 2 digits
        // or the value of the card
        val player_card_value = player_string_card.substring(startIndex, player_string_card.length)
        val opponent_card_value = opponent_string_card.substring(startIndex, opponent_string_card.length)

        val int_player_card_value = player_card_value.toInt()
        val int_opponent_card_value = opponent_card_value.toInt()

        if (int_player_card_value > int_opponent_card_value) {
            return 1 // indicate player (deck closer to bottom of screen) won the battle
        }
        else if (int_player_card_value < int_opponent_card_value) {
            return -1 // indicate player (deck closer to bottom of screen) lost the battle
        }

        else if (int_player_card_value == int_opponent_card_value) {
            return 0 // start a WAR
        }
        return -10 // indicate something went wrong, this should not be treturned
    }

    fun showCard(card: Int, cardImage: ImageView) {
        // clubs
        if (card == clubs_2) {
            cardImage.setImageResource(R.drawable.clubs_2)
        }
        else if (card == clubs_3) {
            cardImage.setImageResource(R.drawable.clubs_3)
        }
        else if (card == clubs_4) {
            cardImage.setImageResource(R.drawable.clubs_4)
        }
        else if (card == clubs_5) {
            cardImage.setImageResource(R.drawable.clubs_5)
        }
        else if (card == clubs_6) {
            cardImage.setImageResource(R.drawable.clubs_6)
        }
        else if (card == clubs_7) {
            cardImage.setImageResource(R.drawable.clubs_7)
        }
        else if (card == clubs_8) {
            cardImage.setImageResource(R.drawable.clubs_8)
        }
        else if (card == clubs_9) {
            cardImage.setImageResource(R.drawable.clubs_9)
        }
        else if (card == clubs_10) {
            cardImage.setImageResource(R.drawable.clubs_10)
        }
        else if (card == clubs_jack) {
            cardImage.setImageResource(R.drawable.clubs_jack)
        }
        else if (card == clubs_queen) {
            cardImage.setImageResource(R.drawable.clubs_queen)
        }
        else if (card == clubs_king) {
            cardImage.setImageResource(R.drawable.clubs_king)
        }
        else if (card == clubs_ace) {
            cardImage.setImageResource(R.drawable.clubs_ace)
        }
        // diamonds
        else if (card == diamonds_2) {
            cardImage.setImageResource(R.drawable.diamonds_2)
        }
        else if (card == diamonds_3) {
            cardImage.setImageResource(R.drawable.diamonds_3)
        }
        else if (card == diamonds_4) {
            cardImage.setImageResource(R.drawable.diamonds_4)
        }
        else if (card == diamonds_5) {
            cardImage.setImageResource(R.drawable.diamonds_5)
        }
        else if (card == diamonds_6) {
            cardImage.setImageResource(R.drawable.diamonds_6)
        }
        else if (card == diamonds_7) {
            cardImage.setImageResource(R.drawable.diamonds_7)
        }
        else if (card == diamonds_8) {
            cardImage.setImageResource(R.drawable.diamonds_8)
        }
        else if (card == diamonds_9) {
            cardImage.setImageResource(R.drawable.diamonds_9)
        }
        else if (card == diamonds_10) {
            cardImage.setImageResource(R.drawable.diamonds_10)
        }
        else if (card == diamonds_jack) {
            cardImage.setImageResource(R.drawable.diamonds_jack)
        }
        else if (card == diamonds_queen) {
            cardImage.setImageResource(R.drawable.diamonds_queen)
        }
        else if (card == diamonds_king) {
            cardImage.setImageResource(R.drawable.diamonds_king)
        }
        else if (card == diamonds_ace) {
            cardImage.setImageResource(R.drawable.diamonds_ace)
        }
        // hearts
        else if (card == hearts_2) {
            cardImage.setImageResource(R.drawable.hearts_2)
        }
        else if (card == hearts_3) {
            cardImage.setImageResource(R.drawable.hearts_3)
        }
        else if (card == hearts_4) {
            cardImage.setImageResource(R.drawable.hearts_4)
        }
        else if (card == hearts_5) {
            cardImage.setImageResource(R.drawable.hearts_5)
        }
        else if (card == hearts_6) {
            cardImage.setImageResource(R.drawable.hearts_6)
        }
        else if (card == hearts_7) {
            cardImage.setImageResource(R.drawable.hearts_7)
        }
        else if (card == hearts_8) {
            cardImage.setImageResource(R.drawable.hearts_8)
        }
        else if (card == hearts_9) {
            cardImage.setImageResource(R.drawable.hearts_9)
        }
        else if (card == hearts_10) {
            cardImage.setImageResource(R.drawable.hearts_10)
        }
        else if (card == hearts_jack) {
            cardImage.setImageResource(R.drawable.hearts_jack)
        }
        else if (card == hearts_queen) {
            cardImage.setImageResource(R.drawable.hearts_queen)
        }
        else if (card == hearts_king) {
            cardImage.setImageResource(R.drawable.hearts_king)
        }
        else if (card == hearts_ace) {
            cardImage.setImageResource(R.drawable.hearts_ace)
        }
        // spades
        else if (card == spades_2) {
            cardImage.setImageResource(R.drawable.spades_2)
        }
        else if (card == spades_3) {
            cardImage.setImageResource(R.drawable.spades_3)
        }
        else if (card == spades_4) {
            cardImage.setImageResource(R.drawable.spades_4)
        }
        else if (card == spades_5) {
            cardImage.setImageResource(R.drawable.spades_5)
        }
        else if (card == spades_6) {
            cardImage.setImageResource(R.drawable.spades_6)
        }
        else if (card == spades_7) {
            cardImage.setImageResource(R.drawable.spades_7)
        }
        else if (card == spades_8) {
            cardImage.setImageResource(R.drawable.spades_8)
        }
        else if (card == spades_9) {
            cardImage.setImageResource(R.drawable.spades_9)
        }
        else if (card == spades_10) {
            cardImage.setImageResource(R.drawable.spades_10)
        }
        else if (card == spades_jack) {
            cardImage.setImageResource(R.drawable.spades_jack)
        }
        else if (card == spades_queen) {
            cardImage.setImageResource(R.drawable.spades_queen)
        }
        else if (card == spades_king) {
            cardImage.setImageResource(R.drawable.spades_king)
        }
        else if (card == spades_ace) {
            cardImage.setImageResource(R.drawable.spades_ace)
        }
    }
}
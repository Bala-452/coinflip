package com.example.coinflip

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val roll: Button = findViewById(R.id.button)
        roll.setOnClickListener {
                flipdice()
        }
    }

    private fun flipdice() {
        val coin=Coin()
        val coinflip=coin.flip()
        val coinImage:ImageView=findViewById(R.id.imageView)
        val drawableResource=if(coinflip=="H") {
            R.drawable.heads_img
        }
        else {
            R.drawable.tails_img
        }
        coinImage.setImageResource(drawableResource)
        coinImage.contentDescription=coinflip.toString()
    }
}
class Coin() {
    fun flip(): String{
        return listOf("H","T").random()
    }
}

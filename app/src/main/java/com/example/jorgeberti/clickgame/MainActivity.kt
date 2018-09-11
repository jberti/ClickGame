package com.example.jorgeberti.clickgame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    val game = Game()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnStart.setOnClickListener{
            timer(millisInFuture = game.initialTime, countDownInterval = game.step).start()
            it.isEnabled = false
            txtCount.visibility = View.VISIBLE
            btnClick.isEnabled = true
        }

        btnClick.setOnClickListener {
            game.click()
        }
    }

    private fun timer(millisInFuture:Long, countDownInterval:Long): CountDownTimer{
        return object: CountDownTimer(millisInFuture,countDownInterval){
            override fun onFinish() {
                btnClick.isEnabled = false
                btnStart.isEnabled = true
                Toast.makeText(this@MainActivity, "Você clicou ${game.count.toString()} vezes",Toast.LENGTH_SHORT).show()
                game.reset()
                txtCount.visibility = View.INVISIBLE
            }

            override fun onTick(millisUntilFinished: Long) {
                txtCount.text = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished).toString()
            }

        }
    }
}

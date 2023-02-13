package com.example.quiz

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz.databinding.ActivityResultBinding
import kotlin.system.exitProcess

/**
 * Created by Techpass Master.
 * Website - www.techpassmaster.com
 * Youtube - Techpass Master
 */

class ResultActivity : AppCompatActivity() {

    private lateinit var activityResultBinding: ActivityResultBinding

    var totalScore = 0
    var wrong = 0
    var skip = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityResultBinding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(activityResultBinding.root)

        totalScore = intent.extras!!.getInt("верно")
        wrong = intent.extras!!.getInt("неверно")
        skip = intent.extras!!.getInt("пропущено")

        initViews()
    }

    @SuppressLint("SetTextI18n")
    private fun initViews() {
        activityResultBinding.apply {

            tvScore.text = "Счет: $totalScore"
            tvright.text = "Верно: $totalScore"
            tvwrong.text = "Неверно: $wrong"
            tvSkip.text = "Пропущено: $skip"

            if (totalScore >= 6) {
                activityResultBinding.emojiReactionImg.setImageResource(R.drawable.smile_img)
                Toast.makeText(this@ResultActivity, "Вау, Здорово", Toast.LENGTH_SHORT).show()

            } else {
                emojiReactionImg.setImageResource(R.drawable.angry_img)
                Toast.makeText(this@ResultActivity, "Тщательней нужно", Toast.LENGTH_SHORT).show()
            }

            tvPlayAgain.setOnClickListener {
                finish()
            }

            tvExit.setOnClickListener {
                moveTaskToBack(true)
                exitProcess(-1)
            }
        }
    }
}

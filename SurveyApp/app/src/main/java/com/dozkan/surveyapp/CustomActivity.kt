package com.dozkan.surveyapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dozkan.surveyapp.databinding.ActivityCustomBinding

class CustomActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val person = intent.getParcelableExtra("person") as Person?

        with(binding) {
            name.text = person?.nameSurname

            saveButton.setOnClickListener {
                if (!movieAnswer.text.isNullOrEmpty() && !singerAnswer.text.isNullOrEmpty() && !mealAnswer.text.isNullOrEmpty()) {
                    val userInfo =
                        person?.let {
                            PersonInfo(
                                movieAnswer.text.toString(),
                                singerAnswer.text.toString(),
                                mealAnswer.text.toString(),
                                it
                            )
                        }

                    val intent = Intent(this@CustomActivity, ResultActivity::class.java)
                    intent.putExtra("info", userInfo)
                    startActivity(intent)
                }
            }
        }
    }
}
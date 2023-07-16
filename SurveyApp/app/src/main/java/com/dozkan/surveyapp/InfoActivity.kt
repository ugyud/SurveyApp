package com.dozkan.surveyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dozkan.surveyapp.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val nameSurname= intent.getStringExtra("namesurname")

        with(binding) {
            nameSurnameInfo.text = nameSurname.toString()
            enterButton.setOnClickListener {
                if (!email.text.isNullOrEmpty() && !age.text.isNullOrEmpty() && !phoneNum.text.isNullOrEmpty()) {
                    val person = Person(
                        nameSurname.toString(),
                        email.text.toString(),
                        age.text.toString(),
                        phoneNum.text.toString(),
                    )
                    val intent = Intent(this@InfoActivity, CustomActivity::class.java)
                    intent.putExtra("person", person)
                    startActivity(intent)
                }
            }
        }
    }
}
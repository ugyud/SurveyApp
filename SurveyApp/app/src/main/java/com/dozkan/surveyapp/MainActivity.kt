package com.dozkan.surveyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.dozkan.surveyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            loginButton.setOnClickListener {
                val nameSurname = nameSurname.text.toString()
                if (!nameSurname.isNullOrEmpty()) {
                    val intent = Intent(this@MainActivity, InfoActivity::class.java)
                    intent.putExtra("namesurname",nameSurname)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(
                        this@MainActivity,
                        "You have to enter your name.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                System.exit(0)
            }
        })
    }
}

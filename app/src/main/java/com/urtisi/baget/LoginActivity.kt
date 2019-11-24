package com.urtisi.baget

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.urtisi.baget.databinding.LoginActivityBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.login_activity)
        binding.buttonLogin.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

//        startActivity(Intent(this, TestActivity::class.java))
        startActivity(Intent(this, MainActivity::class.java))
    }

}
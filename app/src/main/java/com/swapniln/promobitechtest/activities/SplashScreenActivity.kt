package com.swapniln.promobitechtest.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.swapniln.promobitechtest.R
import java.util.*
import kotlin.concurrent.schedule


class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slash_screen)


        // creating delay for 3 sec using Coroutines
        Timer().schedule(3000){
            val intent = Intent(this@SplashScreenActivity, BookListActivity::class.java)

            startActivity(intent)

            // close this activity
            finish()
        }
    }
}

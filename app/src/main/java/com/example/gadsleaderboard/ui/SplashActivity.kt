package com.example.gadsleaderboard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.gadsleaderboard.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class SplashActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_splash)
		window.statusBarColor = resources.getColor(R.color.colorPrimaryDark)
	}


	override fun onResume() {
		super.onResume()
		lifecycleScope.launchWhenResumed {
			delay(1000)
			MainActivity.startMainActivity(this@SplashActivity)
			finish()
		}
	}

}
package com.example.gadsleaderboard.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.gadsleaderboard.R

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
		navHostFragment.navController
	}

	companion object {
		fun startMainActivity(context: Context?) {
			context?.apply {
				val intent = Intent(this, MainActivity::class.java)
				this.startActivity(intent)
			}
		}
	}
}
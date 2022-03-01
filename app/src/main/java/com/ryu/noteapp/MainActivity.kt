package com.ryu.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ryu.noteapp.ui.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, HomeFragment())
            .setReorderingAllowed(true)
            .addToBackStack("name")
            .commit()
    }
}

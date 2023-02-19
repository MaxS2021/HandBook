package com.example.handbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.handbook.databinding.ActivityContentBinding
import com.example.handbook.databinding.ActivityEditBinding

class ContentActivity : AppCompatActivity() {
    lateinit var bind: ActivityContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityContentBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val item = intent.getSerializableExtra("item") as Plant

        bind.apply {
            imMain.setImageResource(item.imageId)
            twTitle1.text = item.title
            twContent.text = item.dscr
        }

    }
}
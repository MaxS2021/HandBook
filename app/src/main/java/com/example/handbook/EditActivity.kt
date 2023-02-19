package com.example.handbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.handbook.databinding.ActivityEditBinding


// Добавление нового элемента в список

class EditActivity : AppCompatActivity() {
    lateinit var bind: ActivityEditBinding
    private var idxImage: Int = 0
    private var ImageId: Int = R.drawable.pict1
    private val imageIdList = listOf(
        R.drawable.pict1,
        R.drawable.pict2,
        R.drawable.pict3,
        R.drawable.pict4,
        R.drawable.pict5,
        R.drawable.pict6,
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityEditBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.vImage.setImageResource(ImageId)
        initButtobs()

    }
    private fun initButtobs() = with(bind) {
        bNext.setOnClickListener {
            idxImage++
            if (idxImage > imageIdList.size - 1) idxImage = 0
            //Log.d("AppLog","Index $idxImage")
            ImageId = imageIdList[idxImage]
            vImage.setImageResource(ImageId)
        }
        bDone.setOnClickListener{
            val plant = Plant(ImageId, adTitle.text.toString(), adTitle2.text.toString())
            val i = Intent()
            i.putExtra("plant", plant)
            setResult(RESULT_OK, i)
            finish()
        }
    }

    fun onClickDone(view: View) {

    }
}
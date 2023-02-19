package com.example.handbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.handbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), PlantAdapter.Listener {
    lateinit var bind: ActivityMainBinding
    private val adapter = PlantAdapter(this)
    private var editlauncher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        init()
        editlauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                adapter.addPlant(it.data?.getSerializableExtra("plant") as Plant)
            }
        }
    }

    private fun init() {
        bind.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 2)
            rcView.adapter = adapter
            bAdd.setOnClickListener {
                editlauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))
            }
        }
    }

    override fun onClick(plant: Plant) {
        // Слушатель нажатий в RecyclerView | Kotlin + Android Studio https://www.youtube.com/watch?v=13K72xJaAGc
        Log.d("AppLog", "Нажали кнопку ${plant.title}")
        startActivity(Intent(this, ContentActivity::class.java).apply {
            putExtra("item", plant)
        })

    }
}
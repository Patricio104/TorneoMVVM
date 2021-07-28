package com.patricio.graficatorneo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.patricio.graficatorneo.databinding.ActivityMainBinding
import com.patricio.graficatorneo.ui.RegisterTorneo.RegisterTorneoActivity
import com.patricio.graficatorneo.ui.Torneos.TorneosActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var rbSelected: Int=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnCreateTorneo.setOnClickListener{
            val intent = Intent(this, RegisterTorneoActivity::class.java)
            startActivity(intent)
        }

        binding.btnTorneos.setOnClickListener{
            val intent = Intent(this, TorneosActivity::class.java)
            startActivity(intent)
        }

    }
}



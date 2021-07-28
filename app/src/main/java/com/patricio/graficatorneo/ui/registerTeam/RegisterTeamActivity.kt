package com.patricio.graficatorneo.ui.registerTeam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.patricio.graficatorneo.R
import com.patricio.graficatorneo.databinding.ActivityRegisterTeamBinding

class RegisterTeamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterTeamBinding

    private var nombreTorneo : String? = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterTeamBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        intent.extras?.let {bundle ->
            nombreTorneo = bundle.getString("nameTorneo")
            Log.e("TAG", "A2, Nombre torneo: $nombreTorneo")
        }
    }
}
package com.patricio.graficatorneo.ui.RegisterTorneo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.patricio.graficatorneo.R
import com.patricio.graficatorneo.core.Resource
import com.patricio.graficatorneo.data.local.AppDatabase
import com.patricio.graficatorneo.data.local.Torneo.TorneoDataSource
import com.patricio.graficatorneo.data.model.Torneo
import com.patricio.graficatorneo.data.model.TorneoEntity
import com.patricio.graficatorneo.databinding.ActivityRegisterTorneoBinding
import com.patricio.graficatorneo.presentation.TorneoViewModel
import com.patricio.graficatorneo.presentation.TorneoViewModelFactory
import com.patricio.graficatorneo.repository.Torneo.TorneoRepositoryImpl
import com.patricio.graficatorneo.ui.registerTeam.RegisterTeamActivity

class RegisterTorneoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterTorneoBinding

    private var rbSelected: Int=1
    private var flag: Boolean = false
    private var nameTorneo: String =""

    private val viewModel by viewModels<TorneoViewModel> {
        TorneoViewModelFactory(
            TorneoRepositoryImpl(
                TorneoDataSource(AppDatabase.getDatabase(this).torneoDao())))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterTorneoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnAceptar.setOnClickListener{
            nameTorneo = binding.txtNameTorneo.text.toString()

            if (!nameTorneo.isEmpty()){
                val torneo = TorneoEntity(name = nameTorneo, date = "default")

                viewModel.insertTorneo(torneo).observe(this, Observer { result ->
                    when (result){
                        is Resource.Loading -> {
                            Log.e("Live data", "Insertando-.... ")
                        }
                        is Resource.Success -> {
                            val intent = Intent(this, RegisterTeamActivity::class.java)
                            intent.putExtra("nameTorneo", nameTorneo)
                            startActivity(intent)
                            Log.e("Live data", "${result.data}")
                        }
                        is Resource.Failure -> {

                            Log.e("Error", "${result.exception}")
                        }
                    }
                })

            }else{
                binding.txtNameTorneo.setError("Agrega un nombre para el torneo")
            }
        }
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            when (view.getId()) {
                R.id.rdSimpleElimination ->
                    if (checked) {
                        rbSelected=1
                    }

                R.id.rdDoubleElimination ->
                    if (checked) {
                        rbSelected=2
                    }
            }
        }
    }
}
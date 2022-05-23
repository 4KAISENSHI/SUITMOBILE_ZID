package com.samsaak.dhanich4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import com.samsaak.dhanich4.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private val data by lazy {
        intent.getParcelableExtra<Player>("data")
    }

    private lateinit var binding: ActivityMenuBinding
    private lateinit var foe: Parcelable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.run {
            binding.root.showSnackbar("Welcomee, Have a Good Day ${data?.name}")

            if(data?.name != "") {
            txtVsKomputer.text = "${data?.name} vs COM"
            txtVsPemain.text = "${data?.name} vs Pemain 2"
            } else {
                txtVsKomputer.text = "COM"
                txtVsPemain.text = "Multiplayer"
            }

            imgVsKomputer.setOnClickListener { viewCom ->
                foe = Foe(foe = "CPU", player = "${data?.name}")
                val intent = Intent(Intent(this@MenuActivity, MainActivity::class.java)).apply {
                    putExtra("data", foe)
                }
                startActivity(intent)
            }
            imgVsPemain.setOnClickListener { viewPlayer ->
                foe = Foe(foe = "Player 2", player = "${data?.name}")
                val intent = Intent(Intent(this@MenuActivity, MainActivity::class.java)).apply {
                    putExtra("data", foe)
                }
                startActivity(intent)
            }

        }
    }
}
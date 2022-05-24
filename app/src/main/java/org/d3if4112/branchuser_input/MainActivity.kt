package org.d3if4112.branchuser_input


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import org.d3if4112.branchuser_input.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { hitungJarak()
        }
        binding.button2.setOnClickListener { DataReset()
        }
    }

    private fun hitungJarak() {
        val jarak = binding.jarakTempuh.text.toString()
        val hasilJarak = binding.jarakditempuh.text.toString()
        val hasil = binding.jauhdekat.text.toString()
        if (TextUtils.isEmpty(jarak)) {
            Toast.makeText(this, R.string.berat_invalid, Toast.LENGTH_LONG).show()
            return
        }


        val selectedId = binding.radioGroup.checkedRadioButtonId

        when {
            TextUtils.isEmpty(jarak) -> {
                Toast.makeText(this, R.string.jarak_invalid, Toast.LENGTH_LONG).show()
                return
            }
            selectedId == -1 -> {
                Toast.makeText(this, R.string.kendaraan_invalid, Toast.LENGTH_LONG).show()
                return
            }
            selectedId == R.id.jalankakiRadioButton -> {
                if (jarak < 2.toString()) {
                    binding.jarakditempuh.text = jarak
                    binding.jauhdekat.text = "dekat"
                } else{
                    binding.jarakditempuh.text = jarak
                    binding.jauhdekat.text = "jauh"
                }
                return
            }
            selectedId == R.id.mobilRadioButton -> {
                if (jarak < 100.toString()) {
                    binding.jarakditempuh.text = jarak
                    binding.jauhdekat.text = "dekat"
                } else{
                    binding.jarakditempuh.text = jarak
                    binding.jauhdekat.text = "jauh"
                }
                return

            }
        }



    }private fun DataReset() {
        binding.jarakTempuh.text?.clear()
        binding.radioGroup.clearCheck()
    }

//        fun getKategori(jarak: String, jalan_kaki: Boolean): String {
//            val stringRes = if (jalan_kaki) {
//                when {
//                    jarak >= 2 -> R.string.jauh
//                    else -> R.string.dekat
//                }
//            } else {
//                when {
//                    jarak >= 2 -> R.string.jauh
//                    else -> R.string.dekat
//                }
//            }
//            return getString(stringRes)
//        }
//
//        val kategori = getKategori(jarak, jalan_kaki)
//        binding.bmiTextView.text = getString(R.string.bmi_x, jarak)
//        binding.kategoriTextView.text = getString(R.string.kategori_x, kategori)
    }


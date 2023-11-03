package com.example.lamp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.lamp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isClickBtn = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        turnOnFirstLamp()
    }

    private fun turnOnFirstLamp() {
        binding.btnClick.setOnClickListener {
            if (isClickBtn) {
                binding.imageSmall1.setImageResource(R.drawable.lamp_on)
                changeFirstLampToSecondLamp()
                turnOnLargeLamp()
            } else {
                binding.imageSmall1.setImageResource(R.drawable.lamp_off)
                turnOffLargeLamp()
            }
            isClickBtn = !isClickBtn
        }
    }

    private fun turnOnSecondLamp() {
        binding.btnClick.setOnClickListener {
            if (isClickBtn) {
                binding.imageSmall2.setImageResource(R.drawable.lamp_on)
                changeSecondLampToThirdLamp()
                turnOnLargeLamp()
            } else {
                binding.imageSmall2.setImageResource(R.drawable.lamp_off)
                turnOffLargeLamp()
            }
            isClickBtn = !isClickBtn
        }
    }

    private fun turnOnThirdLamp() {
        binding.btnClick.setOnClickListener {
            if (isClickBtn) {
                binding.imageSmall3.setImageResource(R.drawable.lamp_on)
                turnOnLargeLamp()
                turnOffLamps()
            } else {
                binding.imageSmall3.setImageResource(R.drawable.lamp_off)
                turnOffLargeLamp()
            }
            isClickBtn = !isClickBtn
        }
    }

    private fun changeFirstLampToSecondLamp() {
        binding.imageLargeOff.setOnLongClickListener {
            binding.image1.visibility = View.VISIBLE
            binding.imageSmall1.setImageResource(R.drawable.lamp_off)
            brokenLamp()
            callButtonRetryForSecondLamp()
            true
        }
    }

    private fun changeSecondLampToThirdLamp() {
        binding.imageLargeOff.setOnLongClickListener {
            binding.image2.visibility = View.VISIBLE
            binding.imageSmall2.setImageResource(R.drawable.lamp_off)
            brokenLamp()
            callButtonRetryForThirdLamp()
            true
        }
    }

    private fun turnOffLamps() {
        binding.imageLargeOff.setOnLongClickListener {
            binding.image3.visibility = View.VISIBLE
            binding.btnClick.visibility = View.GONE
            binding.txt.visibility = View.VISIBLE
            binding.imageSmall3.setImageResource(R.drawable.lamp_off)
            brokenLamp()
            true
        }
    }

    private fun callButtonRetryForSecondLamp() {
        binding.btnRetry.visibility = View.VISIBLE
        binding.btnRetry.setOnClickListener {
            visibleButtons()
            turnOnSecondLamp()
        }
    }

    private fun callButtonRetryForThirdLamp() {
        binding.btnRetry.visibility = View.VISIBLE
        binding.btnRetry.setOnClickListener {
            visibleButtons()
            turnOnThirdLamp()
        }
    }

    private fun visibleButtons() {
        binding.btnRetry.visibility = View.GONE
        binding.btnClick.visibility = View.VISIBLE
        binding.imageLargeOff.setImageResource(R.drawable.large_lamp_off)
    }

    private fun brokenLamp() {
        binding.imageLargeOff.setImageResource(R.drawable.broken_lamp)
    }

    private fun turnOnLargeLamp() {
        binding.imageLargeOff.setImageResource(R.drawable.large_lamp_on)
        isClickBtn = true
    }

    private fun turnOffLargeLamp() {
        binding.imageLargeOff.setImageResource(R.drawable.large_lamp_off)
        isClickBtn = false
    }
}
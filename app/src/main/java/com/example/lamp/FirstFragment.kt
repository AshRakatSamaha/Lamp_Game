package com.example.lamp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lamp.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private var isClickBtn = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        turnOnFirstLamp()
        initBackSack()
        return binding.root
    }

    private fun turnOnFirstLamp() {
        binding.imageLargeOff.setOnClickListener {
            if (isClickBtn) {
                binding.imageSmall1.setImageResource(R.drawable.small_lamp_turn_on)
                changeFirstLampToSecondLamp()
                turnOnLargeLamp()
            } else {
                binding.imageSmall1.setImageResource(R.drawable.small_lamp_turn_off)
                turnOffLargeLamp()
            }
            isClickBtn = !isClickBtn
        }
    }

    private fun turnOnSecondLamp() {
        binding.imageLargeOff.setOnClickListener {
            if (isClickBtn) {
                binding.imageSmall2.setImageResource(R.drawable.small_lamp_turn_on)
                changeSecondLampToThirdLamp()
                turnOnLargeLamp()
            } else {
                binding.imageSmall2.setImageResource(R.drawable.small_lamp_turn_off)
                turnOffLargeLamp()
            }
            isClickBtn = !isClickBtn
        }
    }

    private fun turnOnThirdLamp() {
        binding.imageLargeOff.setOnClickListener {
            if (isClickBtn) {
                binding.imageSmall3.setImageResource(R.drawable.small_lamp_turn_on)
                turnOnLargeLamp()
                turnOffLamps()
            } else {
                binding.imageSmall3.setImageResource(R.drawable.small_lamp_turn_off)
                turnOffLargeLamp()
            }
            isClickBtn = !isClickBtn
        }
    }

    private fun changeFirstLampToSecondLamp() {
        binding.imageLargeOff.setOnLongClickListener {
            binding.imageSmall1.setImageResource(R.drawable.broken_small_lamp)
            brokenLamp()
            callButtonRetryForSecondLamp()
            true
        }
    }

    private fun changeSecondLampToThirdLamp() {
        binding.imageLargeOff.setOnLongClickListener {
            binding.imageSmall2.setImageResource(R.drawable.broken_small_lamp)
            brokenLamp()
            callButtonRetryForThirdLamp()
            true
        }
    }

    private fun turnOffLamps() {
        binding.imageLargeOff.setOnLongClickListener {
            binding.imageSmall3.setImageResource(R.drawable.broken_small_lamp)
            findNavController().navigate(R.id.action_firstFragment_to_scandFragment)
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
        binding.brokenLamp.visibility=View.GONE
        binding.imageLargeOff.visibility=View.VISIBLE
        binding.imageLargeOff.setImageResource(R.drawable.large_lamp_turn_off)
    }

    private fun brokenLamp() {
        binding.brokenLamp.visibility=View.VISIBLE
        binding.imageLargeOff.visibility=View.GONE
    }

    private fun turnOnLargeLamp() {
        binding.imageLargeOff.setImageResource(R.drawable.large_lamp_turn_on)
        isClickBtn = true
    }

    private fun turnOffLargeLamp() {
        binding.imageLargeOff.setImageResource(R.drawable.large_lamp_turn_off)
        isClickBtn = false
    }
    private fun initBackSack() {
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            onBackPressedCallback
        )
    }
}
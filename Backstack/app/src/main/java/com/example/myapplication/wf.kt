package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.myapplication.databinding.FragmentWfBinding

class wf : Fragment() {
    private lateinit var binding:FragmentWfBinding ;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWfBinding.inflate(inflater, container, false)
        binding.button.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_wf_to_q1f)
        }
        return binding.root

    }


}
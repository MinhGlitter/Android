package com.example.myapplication
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.input.key.Key.Companion.F
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentRfBinding

class rf : Fragment() {
    private lateinit var binding:FragmentRfBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentRfBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         val args by navArgs<rfArgs>()
        val res = args.resQ3
        binding.txtResult.setText("Your final result is: "+res+"/3")
        binding.button.setOnClickListener {

            view.findNavController().navigate(R.id.action_rf_to_wf)
        }
    }

}
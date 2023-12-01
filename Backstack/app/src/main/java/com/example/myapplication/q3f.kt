package com.example.myapplication
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentQ3fBinding

class q3f : Fragment() {
    private lateinit var binding: FragmentQ3fBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQ3fBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args by navArgs<q3fArgs>();
        val x = args.resQ2;
        binding.txtResult.setText("Current result is: "+x+"/2")
        binding.submitButton.setOnClickListener{
            val selectedAnswerId = binding.answerRadioGroup.checkedRadioButtonId

            // Kiểm tra xem đáp án có đúng không và cập nhật biến kết quả
            val   curRes = if (selectedAnswerId == R.id.answerDRadioButton) {
                1 // Nếu đáp án đúng (A)
            } else {
                0 // Nếu đáp án sai
            }

            val y =x+curRes;

            val action =  q3fDirections.actionQ3fToRf(y)
            view.findNavController().navigate(action)
        }
    }
}
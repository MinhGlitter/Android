package com.example.myapplication
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.myapplication.databinding.FragmentQ1fBinding
class q1f : Fragment() {
private lateinit var binding :FragmentQ1fBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentQ1fBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.submitButton.setOnClickListener{
            val selectedAnswerId = binding.answerRadioGroup.checkedRadioButtonId
            // Kiểm tra xem đáp án có đúng không và cập nhật biến kết quả
            val   questionResult = if (selectedAnswerId == R.id.answerARadioButton) {
                1 // Nếu đáp án đúng (A)
            } else {
                0 // Nếu đáp án sai
            }

           val action =  q1fDirections.actionQ1fToQ2f(questionResult)
            view.findNavController().navigate(action)
        }

    }

}
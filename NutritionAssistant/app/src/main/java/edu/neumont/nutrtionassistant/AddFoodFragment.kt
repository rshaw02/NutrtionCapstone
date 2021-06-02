package edu.neumont.nutrtionassistant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.neumont.nutrtionassistant.data.Food
import edu.neumont.nutrtionassistant.databinding.FragmentAddFoodBinding
import edu.neumont.nutrtionassistant.viewmodels.AddFoodViewModel

@AndroidEntryPoint
class AddFoodFragment : Fragment() {

    private val addFoodViewModel: AddFoodViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAddFoodBinding.inflate(inflater, container, false)
//        val root = inflater.inflate(R.layout.fragment_first, container, false)
        binding.saveUserFoodButton.setOnClickListener {
            val name = binding.foodName.text.toString()
            val rawCals = binding.foodCalories.text.toString()
            if (name.isEmpty() && rawCals.isEmpty()) {
                Toast.makeText(
                    context,
                    R.string.name_and_cal_empty,
                    Toast.LENGTH_LONG
                ).show()
            } else if (name.isEmpty()) {
                Toast.makeText(
                    context,
                    R.string.name_empty,
                    Toast.LENGTH_LONG
                ).show()
            } else if (rawCals.isEmpty()) {
                Toast.makeText(
                    context,
                    R.string.cal_empty,
                    Toast.LENGTH_LONG
                ).show()
            } else {
                addFoodViewModel.addFood(Food(name, Integer.parseInt(rawCals)))
                findNavController().navigate(R.id.action_addFoodFragment_to_userFoodsFragment)
            }
        }
        // Inflate the layout for this fragment
        return binding.root
    }

}
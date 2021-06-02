package edu.neumont.nutrtionassistant

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.core.view.forEach
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.textview.MaterialTextView
import dagger.hilt.android.AndroidEntryPoint
import edu.neumont.nutrtionassistant.adapters.AddNutritionFoodListAdapter
import edu.neumont.nutrtionassistant.adapters.FoodListAdapter
import edu.neumont.nutrtionassistant.data.NutritionFood
import edu.neumont.nutrtionassistant.databinding.FragmentAddNutritionFoodBinding
import edu.neumont.nutrtionassistant.databinding.FragmentNutrtionCalendarBinding
import edu.neumont.nutrtionassistant.viewmodels.FoodListViewModel
import edu.neumont.nutrtionassistant.viewmodels.NutritionCalendarViewModel
import java.util.*

@AndroidEntryPoint
class AddNutritionFoodFragment : Fragment() {

    private val nutritionCalendarViewModel: NutritionCalendarViewModel by viewModels()
    private val foodListViewModel: FoodListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAddNutritionFoodBinding.inflate(inflater, container, false)
        val navCtrl = findNavController()
        val foodRecyclerView: RecyclerView = binding.foodOptions
        val adapter = AddNutritionFoodListAdapter()
        foodRecyclerView.adapter = adapter
        foodRecyclerView.layoutManager = LinearLayoutManager(context)
        foodListViewModel.foods.observe(viewLifecycleOwner) { foods ->
            adapter.submitList(foods)
        }
        binding.addNutritionFoodButton.setOnClickListener {
            binding.foodOptions.forEach {
                val clChild = it as ConstraintLayout
                val mcbChild: MaterialCheckBox = clChild[2] as MaterialCheckBox
                if (mcbChild.isChecked) {
                    val date = String.format("%04d-%02d-%02d", nutritionCalendarViewModel.year, nutritionCalendarViewModel.month, nutritionCalendarViewModel.day)
                    val name = (clChild[0] as MaterialTextView).text as String
                    val cals = Integer.parseInt((clChild[1] as MaterialTextView).text as String)
                    Log.println(Log.INFO, "ANFF", "$name, $cals, $date")
                    nutritionCalendarViewModel.addFood(NutritionFood(name, cals, date))
                }
            }
            navCtrl.navigate(R.id.action_addNutritionFoodFragment_to_NutritionCalendarFragment)
        }
        return binding.root
    }

}
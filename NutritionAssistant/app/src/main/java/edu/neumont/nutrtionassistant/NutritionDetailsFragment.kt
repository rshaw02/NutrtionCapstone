package edu.neumont.nutrtionassistant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import edu.neumont.nutrtionassistant.adapters.NutritionDetailsListAdapter
import edu.neumont.nutrtionassistant.databinding.FragmentNutritionDetailsBinding
import edu.neumont.nutrtionassistant.viewmodels.NutritionCalendarViewModel

@AndroidEntryPoint
class NutritionDetailsFragment : Fragment() {

    private val nutritionCalendarViewModel: NutritionCalendarViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentNutritionDetailsBinding.inflate(inflater, container, false)

        val foodRecyclerView: RecyclerView = binding.detailsFoods
        val adapter = NutritionDetailsListAdapter()
        foodRecyclerView.adapter = adapter
        foodRecyclerView.layoutManager = LinearLayoutManager(context)
        nutritionCalendarViewModel.foodByDate.observe(viewLifecycleOwner) { foods ->
            var sum = 0
            for (f in foods) {
                sum += f.calories
            }
            binding.calories = sum
            adapter.submitList(foods)
        }

        return binding.root
    }

}
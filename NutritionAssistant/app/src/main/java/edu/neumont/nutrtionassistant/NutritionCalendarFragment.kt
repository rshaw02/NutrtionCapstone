package edu.neumont.nutrtionassistant

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.neumont.nutrtionassistant.databinding.FragmentNutrtionCalendarBinding
import edu.neumont.nutrtionassistant.viewmodels.NutritionCalendarViewModel
import java.util.*

@AndroidEntryPoint
class NutritionCalendarFragment : Fragment() {

    private val nutritionCalendarViewModel: NutritionCalendarViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentNutrtionCalendarBinding.inflate(inflater, container, false)
//        val root = inflater.inflate(R.layout.fragment_first, container, false)
        // Inflate the layout for this fragment
        val navCtrl = findNavController()
        binding.calendarView.setOnDateChangeListener { _: CalendarView, year: Int, month: Int, day: Int ->
            nutritionCalendarViewModel.date.value = GregorianCalendar(year, month, day)
            nutritionCalendarViewModel.day = day
            nutritionCalendarViewModel.month = month
            nutritionCalendarViewModel.year = year
            Log.println(Log.INFO, "NutritionCalendarFragment", "Calendar: $year $month $day")
        }
        binding.detailsButton.setOnClickListener {
            navCtrl.navigate(R.id.action_NutritionCalendarFragment_to_nutritionDetailsFragment)
        }
        binding.addButton.setOnClickListener {
            navCtrl.navigate(R.id.action_NutritionCalendarFragment_to_addNutritionFoodFragment)
        }
        nutritionCalendarViewModel.foodByDate.observe(viewLifecycleOwner) { foods ->
            var sum = 0
            for (f in foods) {
                sum += f.calories
            }
            binding.calories = sum
        }
        return binding.root
    }

}
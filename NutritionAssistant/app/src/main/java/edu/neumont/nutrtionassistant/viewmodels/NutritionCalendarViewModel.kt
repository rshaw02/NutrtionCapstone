package edu.neumont.nutrtionassistant.viewmodels

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.neumont.nutrtionassistant.data.Food
import edu.neumont.nutrtionassistant.data.NutritionFood
import edu.neumont.nutrtionassistant.data.NutritionFoodRepository
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class NutritionCalendarViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val nutritionFoodRepository: NutritionFoodRepository
) : ViewModel() {

    val date: MutableLiveData<Calendar> = MutableLiveData(Calendar.getInstance())

    var day: Int = savedStateHandle[DAY_ID] ?: date.value?.get(Calendar.DAY_OF_MONTH)!!
        set(value) {
            savedStateHandle.set(DAY_ID, value)
            field = value
        }
    var month: Int = savedStateHandle[MONTH_ID] ?: date.value?.get(Calendar.MONTH)!!
        set(value) {
            savedStateHandle.set(MONTH_ID, value)
            field = value
        }
    var year: Int = savedStateHandle[YEAR_ID] ?: date.value?.get(Calendar.YEAR)!!
        set(value) {
            savedStateHandle.set(YEAR_ID, value)
            field = value
        }

    val foodByDate: LiveData<List<NutritionFood>>
        get() = Transformations.switchMap(date) { date ->
            val all = nutritionFoodRepository.getAll().asLiveData()
            Transformations.switchMap(all) { toFilter: List<NutritionFood> ->
                val filteredFood = MutableLiveData<List<NutritionFood>>()
                val filteredList = toFilter.filter { f ->
                    f.date.equals(
                        String.format(
                            "%04d-%02d-%02d",
                            date.get(Calendar.YEAR),
                            date.get(Calendar.MONTH),
                            date.get(Calendar.DAY_OF_MONTH)
                        )
                    )
                }
                filteredFood.value = filteredList
                filteredFood
            }
        }

    fun addFood(food: NutritionFood) =
        viewModelScope.launch { nutritionFoodRepository.addFood(food) }

    companion object {
        private const val DAY_ID = "day"
        private const val MONTH_ID = "month"
        private const val YEAR_ID = "year"
    }

}
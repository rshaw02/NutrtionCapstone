package edu.neumont.nutrtionassistant.viewmodels

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.neumont.nutrtionassistant.data.Food
import edu.neumont.nutrtionassistant.data.FoodRepository
import javax.inject.Inject

@HiltViewModel
class FoodListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val foodRepository: FoodRepository
) : ViewModel() {

    val foods: LiveData<List<Food>> = foodRepository.getAll().asLiveData()

}
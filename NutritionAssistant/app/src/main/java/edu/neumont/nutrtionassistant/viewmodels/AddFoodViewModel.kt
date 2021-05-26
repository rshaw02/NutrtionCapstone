package edu.neumont.nutrtionassistant.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.neumont.nutrtionassistant.data.Food
import edu.neumont.nutrtionassistant.data.FoodRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddFoodViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val foodRepository: FoodRepository
) : ViewModel() {

    fun addFood(food: Food) = viewModelScope.launch { foodRepository.addFood(food) }

}
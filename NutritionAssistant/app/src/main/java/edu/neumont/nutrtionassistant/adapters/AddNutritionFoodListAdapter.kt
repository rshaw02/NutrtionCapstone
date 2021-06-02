package edu.neumont.nutrtionassistant.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import edu.neumont.nutrtionassistant.data.Food
import edu.neumont.nutrtionassistant.data.NutritionFood
import edu.neumont.nutrtionassistant.databinding.RecyclerItemAddNutritionFoodBinding
import edu.neumont.nutrtionassistant.databinding.RecyclerItemFoodBinding

class AddNutritionFoodListAdapter: ListAdapter<Food, AddNutritionFoodListAdapter.AddNutritionFoodViewHolder>(ADD_NUTRITION_FOODS_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddNutritionFoodViewHolder {
        return AddNutritionFoodViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: AddNutritionFoodViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class AddNutritionFoodViewHolder(
        private val binding: RecyclerItemAddNutritionFoodBinding
    ) : RecyclerView.ViewHolder(binding.root) {
//        init {
//            binding.setClickListener {
//                binding.plant?.let { plant ->
//                    navigateToPlant(plant, it)
//                }
//            }
//        }

//        private fun navigateToPlant(
//            plant: Food,
//            view: View
//        ) {
//            val direction =
//                HomeViewPagerFragmentDirections.actionViewPagerFragmentToPlantDetailFragment(
//                    plant.plantId
//                )
//            view.findNavController().navigate(direction)
//        }

        fun bind(item: Food) {
            binding.apply {
                food = item
                executePendingBindings()
            }
        }

        companion object {
            fun create(parent: ViewGroup): AddNutritionFoodViewHolder {
                val view: RecyclerItemAddNutritionFoodBinding = RecyclerItemAddNutritionFoodBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return AddNutritionFoodViewHolder(view)
            }
        }
    }

    companion object {
        private val ADD_NUTRITION_FOODS_COMPARATOR = object : DiffUtil.ItemCallback<Food>() {
            override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }


}
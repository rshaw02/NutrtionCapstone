package edu.neumont.nutrtionassistant.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import edu.neumont.nutrtionassistant.data.Food
import edu.neumont.nutrtionassistant.data.NutritionFood
import edu.neumont.nutrtionassistant.databinding.RecyclerItemAddNutritionFoodBinding
import edu.neumont.nutrtionassistant.databinding.RecyclerItemFoodNutritionDetailsBinding

class NutritionDetailsListAdapter: ListAdapter<NutritionFood, NutritionDetailsListAdapter.NutritionDetailsFoodViewHolder>(
    NutritionDetailsListAdapter.NUTRITION_DETAILS_FOODS_COMPARATOR
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NutritionDetailsFoodViewHolder {
        return NutritionDetailsFoodViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: NutritionDetailsFoodViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class NutritionDetailsFoodViewHolder(
        private val binding: RecyclerItemFoodNutritionDetailsBinding
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

        fun bind(item: NutritionFood) {
            binding.apply {
                food = item
                executePendingBindings()
            }
        }

        companion object {
            fun create(parent: ViewGroup): NutritionDetailsFoodViewHolder {
                val view: RecyclerItemFoodNutritionDetailsBinding = RecyclerItemFoodNutritionDetailsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return NutritionDetailsFoodViewHolder(view)
            }
        }
    }

    companion object {
        private val NUTRITION_DETAILS_FOODS_COMPARATOR = object : DiffUtil.ItemCallback<NutritionFood>() {
            override fun areItemsTheSame(oldItem: NutritionFood, newItem: NutritionFood): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: NutritionFood, newItem: NutritionFood): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

}
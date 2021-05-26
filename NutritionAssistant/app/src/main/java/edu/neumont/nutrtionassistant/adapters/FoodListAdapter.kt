package edu.neumont.nutrtionassistant.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import edu.neumont.nutrtionassistant.data.Food
import edu.neumont.nutrtionassistant.databinding.RecyclerItemFoodBinding

class FoodListAdapter : ListAdapter<Food, FoodListAdapter.FoodViewHolder>(FOODS_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class FoodViewHolder(
        private val binding: RecyclerItemFoodBinding
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
            fun create(parent: ViewGroup): FoodViewHolder {
                val view: RecyclerItemFoodBinding = RecyclerItemFoodBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return FoodViewHolder(view)
            }
        }
    }

    companion object {
        private val FOODS_COMPARATOR = object : DiffUtil.ItemCallback<Food>() {
            override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

}
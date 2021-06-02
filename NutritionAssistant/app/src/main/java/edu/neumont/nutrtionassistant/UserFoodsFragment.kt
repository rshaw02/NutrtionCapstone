package edu.neumont.nutrtionassistant

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import edu.neumont.nutrtionassistant.adapters.FoodListAdapter
import edu.neumont.nutrtionassistant.databinding.FragmentAddFoodBinding
import edu.neumont.nutrtionassistant.databinding.FragmentUserFoodsBinding
import edu.neumont.nutrtionassistant.viewmodels.FoodListViewModel

@AndroidEntryPoint
class UserFoodsFragment : Fragment() {

    private val foodListViewModel: FoodListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentUserFoodsBinding.inflate(inflater, container, false)

        val navCtrl = findNavController()
        val foodRecyclerView: RecyclerView = binding.scrollView
        val adapter = FoodListAdapter()
        foodRecyclerView.adapter = adapter
        foodRecyclerView.layoutManager = LinearLayoutManager(context)
        foodListViewModel.foods.observe(viewLifecycleOwner) { foods ->
            adapter.submitList(foods)
        }
        binding.addUserFoodButton.setOnClickListener {
            navCtrl.navigate(R.id.action_userFoodsFragment_to_addFoodFragment)
        }

        return binding.root
    }

}
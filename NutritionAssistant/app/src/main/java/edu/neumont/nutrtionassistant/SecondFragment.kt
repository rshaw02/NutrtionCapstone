package edu.neumont.nutrtionassistant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import edu.neumont.nutrtionassistant.adapters.FoodListAdapter
import edu.neumont.nutrtionassistant.databinding.FragmentSecondBinding
import edu.neumont.nutrtionassistant.viewmodels.FoodListViewModel

@AndroidEntryPoint
class SecondFragment : Fragment() {

    private val foodListViewModel: FoodListViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSecondBinding.inflate(inflater, container, false)

        val foodRecyclerView: RecyclerView = binding.scrollView
        val adapter = FoodListAdapter()
        foodRecyclerView.adapter = adapter
        foodRecyclerView.layoutManager = LinearLayoutManager(context)
        foodListViewModel.foods.observe(viewLifecycleOwner) { foods ->
            adapter.submitList(foods)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }


    }

}
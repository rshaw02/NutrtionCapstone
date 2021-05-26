package edu.neumont.nutrtionassistant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.neumont.nutrtionassistant.data.Food
import edu.neumont.nutrtionassistant.databinding.FragmentFirstBinding
import edu.neumont.nutrtionassistant.viewmodels.AddFoodViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private val addFoodViewModel: AddFoodViewModel by viewModels()
    lateinit var testButton: Button
    lateinit var fragmentNav: Button
    lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFirstBinding.inflate(inflater, container, false)
//        val root = inflater.inflate(R.layout.fragment_first, container, false)
        fragmentNav = binding.buttonFirst
        testButton = binding.testButton
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentNav.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        testButton.setOnClickListener { testButtonEvent() }
    }

    fun testButtonEvent() {
        addFoodViewModel.addFood(Food("Food"))
    }
}
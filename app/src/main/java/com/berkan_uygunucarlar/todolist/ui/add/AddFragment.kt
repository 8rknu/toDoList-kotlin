package com.berkan_uygunucarlar.todolist.ui.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.berkan_uygunucarlar.todolist.R
import com.berkan_uygunucarlar.todolist.database.TaskEntry
import com.berkan_uygunucarlar.todolist.databinding.FragmentAddBinding
import com.berkan_uygunucarlar.todolist.viewmodel.TaskViewModel


class AddFragment : Fragment() {

    private val viewModel : TaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentAddBinding.inflate(inflater)

        val myAdapter = ArrayAdapter<String>(
            requireActivity(),
            android.R.layout.simple_spinner_dropdown_item,
            resources.getStringArray(R.array.priorities)
        )

        binding.apply {
            spinner.adapter = myAdapter
            addBtn.setOnClickListener {
                if (TextUtils.isEmpty((taskEditText.text))){
                    Toast.makeText(requireContext(), "Error! Task can not be empty", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                val title = taskEditText.text.toString()
                val priority = spinner.selectedItemPosition

                val taskEntry = TaskEntry(
                    0,
                    title,
                    priority,
                    System.currentTimeMillis()
                )

                viewModel.insert(taskEntry)
                Toast.makeText(requireContext(), "Succesfully Added", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_addFragment_to_taskFragment)

            }
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}
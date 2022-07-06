package com.berkan_uygunucarlar.todolist.ui.update

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.berkan_uygunucarlar.todolist.R
import com.berkan_uygunucarlar.todolist.database.TaskEntry
import com.berkan_uygunucarlar.todolist.databinding.FragmentUpdateBinding
import com.berkan_uygunucarlar.todolist.viewmodel.TaskViewModel

class UpdateFragment : Fragment() {

    private val viewModel : TaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentUpdateBinding.inflate(inflater)
        val args = UpdateFragmentArgs.fromBundle(requireArguments())

        binding.apply {
            updateTaskEditText.setText(args.taskEntry.title)
            updateSpinner.setSelection(args.taskEntry.priority)

            updateBtn.setOnClickListener {

                if (TextUtils.isEmpty(updateTaskEditText.text)){
                    Toast.makeText(requireContext(), "Task is empty!", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                val title = updateTaskEditText.text.toString()
                val priority = updateSpinner.selectedItemPosition

                val taskEntry = TaskEntry(
                    args.taskEntry.id,
                    title,
                    priority,
                    args.taskEntry.timestamp
                )
                viewModel.update(taskEntry)
                Toast.makeText(requireContext(), "Task updated!", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_updateFragment_to_taskFragment)

            }
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}
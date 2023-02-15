package com.example.taskmanager.ui.task

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController

import com.example.taskmanager.R
import com.example.taskmanager.databinding.FragmentTaskBinding
import com.example.taskmanager.ui.home.HomeFragment
import com.example.taskmanager.ui.task.model.Task


class TaskFragment : Fragment() {
private lateinit var binding: FragmentTaskBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
   binding = FragmentTaskBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener{
val task = Task(binding.etDesk.text.toString(),binding.etTitil.text.toString())
            setFragmentResult(HomeFragment.RESULT_REQUEST_KEY, bundleOf(HomeFragment.TASK_KEY to task))
            findNavController().navigateUp()
        }
    }



}
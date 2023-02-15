package com.example.taskmanager.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener

import androidx.navigation.fragment.findNavController
import com.example.taskmanager.R
import com.example.taskmanager.databinding.FragmentHomeBinding
import com.example.taskmanager.ui.home.adapter.TaskAdapter
import com.example.taskmanager.ui.task.model.Task

class HomeFragment : Fragment () {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var  adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TaskAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return _binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this._binding?.btnFub?.setOnClickListener{
            findNavController().navigate(R.id.taskFragment)
        }

        setFragmentResultListener("requestKey"){key,bundle->
            val result = bundle.getSerializable(TASK_KEY) as Task
            adapter.addTask(result)
        }

       _binding?.recyclerView?.adapter = adapter
    }
    companion object{
        const val  RESULT_REQUEST_KEY = "requestKey"
        const val TASK_KEY = "task_key"
    }
}
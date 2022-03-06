package com.ryu.noteapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ryu.noteapp.R
import com.ryu.noteapp.databinding.FragmentHomeBinding
import com.ryu.noteapp.utils.Future
import com.ryu.noteapp.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.articleLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is Future.Proceeding -> {
                    Log.d("Check status", "onViewCreated: It's now proceeding")
                }
                is Future.Success -> {
                    Log.d("hello", "onViewCreated: ${viewModel.articleLiveData.value}")
                }
                is Future.Failure -> {
                    Log.d("Check status", "onViewCreated: failure")
                }

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
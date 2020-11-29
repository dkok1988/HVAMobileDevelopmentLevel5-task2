package com.example.madlevel5task2.ui.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.madlevel5task2.R
import kotlinx.android.synthetic.main.fragment_add.*


class AddFragment : Fragment() {

    private lateinit var viewModel: AddViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initViewModel()
    }

    private fun initViews() {
        fabAdd.setOnClickListener {
            viewModel.addGame(
                etTitle.text.toString(),
                etPlatform.text.toString(),
                etDay.text.toString(),
                etMonth.text.toString(),
                etYear.text.toString()
            )

        }
    }

    private fun initViewModel() {
        viewModel =
            ViewModelProviders.of(this).get(AddViewModel::class.java) // Initialize the ViewModel.

        viewModel.error.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })

        viewModel.success.observe(viewLifecycleOwner, Observer {
            findNavController().popBackStack()
        })
    }
}

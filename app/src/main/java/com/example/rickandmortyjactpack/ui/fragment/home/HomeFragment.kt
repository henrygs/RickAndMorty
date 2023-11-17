package com.example.rickandmortyjactpack.ui.fragment.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.apimanager.SafeResponse
import com.example.rickandmortyjactpack.ui.fragment.BaseFragment
import com.example.rickandmortyjactpack.databinding.FragmentHomeBinding
import com.example.rickandmortyjactpack.ext.persons
import com.example.rickandmortyjactpack.viewModel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel  by viewModel <HomeViewModel>()
    private val adapter by lazy { HomePersonAdapter(requireContext()) }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

    override fun initViewModel() {
        viewModel.getPersons()
    }

    override fun renderViews() {

        val recyclerView = binding.personsRecyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        with(binding) {
                viewModel.liveData.observe(viewLifecycleOwner) {
                    when(it) {
                        is SafeResponse.Success -> {
                            it.data?.let {
                                adapter.addPersons(it.results.persons())
                            }
                        }
                        is SafeResponse.Loading -> {
                            if(!it.isLoading) {
                                progressBar.visibility = View.GONE
                                return@observe
                            }
                            progressBar.visibility = View.VISIBLE
                        }
                        is SafeResponse.Error -> {
                            Toast.makeText(requireContext(), "${it.error}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
    }
}
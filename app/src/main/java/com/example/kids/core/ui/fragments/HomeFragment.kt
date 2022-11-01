package com.example.kids.core.ui.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.kids.R
import com.example.kids.core.adapters.ArticleAdapter
import com.example.kids.databinding.FragmentHomeBinding
import com.example.kids.core.viewmodel.ArticlesViewModel
import com.example.kids.utils.AppConstants
import com.example.kids.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import loaderDialog

@AndroidEntryPoint
class HomeFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener, ArticleAdapter.OnClick {

    private lateinit var binding: FragmentHomeBinding
    private val articlesViewModel: ArticlesViewModel by viewModels()

    lateinit var loaderDialog: Dialog
    private lateinit var navController: NavController
    lateinit var adapter: ArticleAdapter

    private var dataList: ArrayList<com.example.kids.core.model.getarticles.Result> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        loaderDialog = requireContext().loaderDialog()

        binding.swipeRefresh.setOnRefreshListener(this)
        setUpObservers()
        doCallForGetArticles()

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        requireActivity().menuInflater.inflate(R.menu.top_menu, menu)

        var menuItem = menu.findItem(R.id.search)
        var searchView: SearchView = menuItem.actionView as SearchView
        searchView.queryHint = "Type here to search..."

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
//                adapter.filter.filter(newText)
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                // task HERE
                adapter.filter.filter(query)
                return false
            }

        })
    }

    private fun doCallForGetArticles() {
        articlesViewModel.setUrl(AppConstants.API_KEY)
    }

    private fun setUpObservers() {

        articlesViewModel.getArticles.observe(requireActivity(), Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    if (loaderDialog.isShowing)
                        loaderDialog.dismiss()
                    dataList = it.data!!.results
                    setUpRecyclerViewForOrders(dataList)

                }
                Status.ERROR -> {
                    if (loaderDialog.isShowing)
                        loaderDialog.dismiss()
                    Toast.makeText(requireContext(), "Error: " + it.message, Toast.LENGTH_SHORT)
                        .show()
                }
                Status.LOADING -> {
                    if (!loaderDialog.isShowing)
                        loaderDialog.show()
                }
            }
        })
    }

    private fun setUpRecyclerViewForOrders(list: ArrayList<com.example.kids.core.model.getarticles.Result>) {
        binding.orderlist.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter = ArticleAdapter(requireContext(), list, this)
        binding.orderlist.adapter = adapter
    }

    override fun onRefresh() {
        loaderDialog = requireContext().loaderDialog()
        articlesViewModel.setUrl(AppConstants.API_KEY)
        binding.swipeRefresh.isRefreshing = false
    }

    override fun onItemClick(data: com.example.kids.core.model.getarticles.Result) {

        val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(data)
        navController.navigate(action)
//        navController.navigate(R.id.detailsFragment)
//        Toast.makeText(requireContext(), "$pos", Toast.LENGTH_SHORT).show()
    }
}
package com.example.stravaclient.fragments.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stravaclient.R
import com.example.stravaclient.databinding.FragmentListBinding
import com.example.stravaclient.fragments.list.delegates.PostItemDelegate
import com.example.stravaclient.models.LoadingItem
import com.example.stravaclient.models.PostItem
import com.example.stravaclient.utils.PaginationScrollListener
import com.example.stravaclient.utils.autoCleared

class ListFragment : Fragment(R.layout.fragment_list){

    private val binding: FragmentListBinding by viewBinding(FragmentListBinding::bind)

    private var mainAdapter : MainDelegatesListAdapter by autoCleared()
    val viewModel : PostItemViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
    }

    private fun initList() {
        mainAdapter = MainDelegatesListAdapter(object : PostItemDelegate.Callback {
            override fun onLikeClick(item: PostItem) {
                viewModel.onLikeClick(item)
                mainAdapter.update()
            }
        })
        with(binding.list) {
            val orientation = RecyclerView.VERTICAL
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(context, orientation, false)

            addOnScrollListener(
                PaginationScrollListener(
                    layoutManager = layoutManager as LinearLayoutManager,
                    requestNextItems = ::loadMoreItems,
                    visibilityThreshold = 5
                )
            )

            addItemDecoration(DividerItemDecoration(context, orientation))
            setHasFixedSize(true)
        }
        viewModel.inputListData.observe(viewLifecycleOwner, {
            mainAdapter.items = it
        })
    }

    private fun loadMoreItems() {
        val newItems = mainAdapter.items.toMutableList().apply {
            if (lastOrNull() is LoadingItem) {
                removeLastOrNull()
            }
        }
        mainAdapter.items = newItems
    }
}
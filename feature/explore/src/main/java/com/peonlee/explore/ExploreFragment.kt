package com.peonlee.explore

import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.peonlee.core.ui.adapter.decoration.ContentPaddingDecoration
import com.peonlee.core.ui.adapter.product.ProductAdapter
import com.peonlee.core.ui.base.BaseFragment
import com.peonlee.explore.databinding.FragmentExploreBinding
import com.peonlee.model.product.PRODUCTS_TEST_DOUBLE
import com.peonlee.model.util.PaddingValues

class ExploreFragment : BaseFragment<FragmentExploreBinding>() {
    override fun bindingFactory(parent: ViewGroup): FragmentExploreBinding {
        return FragmentExploreBinding.inflate(layoutInflater, parent, false)
    }

    override fun initViews() {
        val adapter = ProductAdapter(
            rootLayoutParams = ConstraintLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        )
        binding.layoutExplore.layoutManager = GridLayoutManager(context, 2)
        binding.layoutExplore.adapter = adapter
        binding.layoutExplore.addItemDecoration(
            ContentPaddingDecoration(
                PaddingValues(top = 12, right = 4, bottom = 12, left = 4)
            )
        )
        adapter.submitList(PRODUCTS_TEST_DOUBLE)
    }

    companion object {
        fun getInstance(): ExploreFragment = ExploreFragment()
    }
}

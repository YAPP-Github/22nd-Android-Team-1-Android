package com.peonlee.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.peonlee.core.ui.adapter.MultiTypeListAdapter
import com.peonlee.core.ui.viewholder.CommonViewHolder
import com.peonlee.home.adapter.viewholder.divider.DividerViewHolder
import com.peonlee.home.adapter.viewholder.title.TitleViewHolder
import com.peonlee.home.databinding.ListItemDividerBinding
import com.peonlee.home.databinding.ListItemTitleBinding
import com.peonlee.model.MainHomeListItem
import com.peonlee.model.MainHomeViewType

class HomeAdapter : MultiTypeListAdapter<MainHomeListItem, MainHomeViewType>() {
    override fun onCreateViewHolder(
        viewType: MainHomeViewType,
        parent: ViewGroup
    ): CommonViewHolder<MainHomeListItem> {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            MainHomeViewType.TITLE -> TitleViewHolder(ListItemTitleBinding.inflate(inflater, parent, false))
            MainHomeViewType.DIVIDER -> DividerViewHolder(ListItemDividerBinding.inflate(inflater, parent, false))
        }
    }
}
package com.peonlee.home.adapter.viewholder.product

import android.view.LayoutInflater
import androidx.core.view.doOnAttach
import androidx.core.view.doOnDetach
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import com.peonlee.core.ui.databinding.PeonleeMediumSelectorBinding
import com.peonlee.core.ui.extensions.getStringWithArgs
import com.peonlee.core.ui.viewholder.CommonViewHolder
import com.peonlee.home.adapter.ProductsByStoreAdapter
import com.peonlee.home.databinding.ListItemEventStoresBinding
import com.peonlee.home.model.product.EventByStoresUiModel
import com.peonlee.model.type.StoreType
import com.peonlee.core.ui.R as UiResource
import com.peonlee.home.R as HomeResource

class EventByStoresViewHolder(
    private val binding: ListItemEventStoresBinding
) : CommonViewHolder<EventByStoresUiModel>(binding) {
    private var productsByStoreAdapter = ProductsByStoreAdapter()
    private var tabLayoutMediator: TabLayoutMediator? = null
    private val onTabSelectedListener = object : OnTabSelectedListener {
        override fun onTabReselected(tab: TabLayout.Tab?) {}
        override fun onTabSelected(tab: TabLayout.Tab?) {
            tab?.let {
                val store = StoreType.values()[it.position]
                it.customView?.setBackgroundResource(getBackgroundByStore(store))
                binding.btnMoreProducts.text = getStringWithArgs(
                    id = HomeResource.string.item_conditional_products_button_text,
                    store.storeName
                )
            }
        }

        override fun onTabUnselected(tab: TabLayout.Tab?) {
            tab?.let {
                it.customView?.setBackgroundResource(
                    UiResource.drawable.bg_white_outline_radius_17dp
                )
            }
        }
    }

    init {
        with(binding) {
            pagerProducts.adapter = productsByStoreAdapter
            tabLayoutMediator = TabLayoutMediator(layoutStoreTab, pagerProducts) { tab, position ->
                val store = StoreType.values()[position]
                val tabItem = PeonleeMediumSelectorBinding.inflate(
                    LayoutInflater.from(itemView.context)
                )
                tabItem.tvMediumSelectorTitle.text = store.storeName
                tabItem.ivMediumSelectorIcon.setImageResource(getIconByStore(store))
                tab.customView = tabItem.root
            }
        }
        itemView.doOnAttach {
            binding.layoutStoreTab.addOnTabSelectedListener(onTabSelectedListener)
            tabLayoutMediator?.attach()
        }

        itemView.doOnDetach {
            binding.layoutStoreTab.removeOnTabSelectedListener(onTabSelectedListener)
            tabLayoutMediator?.detach()
        }
    }

    override fun onBindView(item: EventByStoresUiModel) {
        productsByStoreAdapter.submitList(item.stores)
    }

    companion object {
        private fun getBackgroundByStore(storeType: StoreType): Int = when (storeType) {
            StoreType.CU -> UiResource.drawable.bg_store_outline_cu_radius_17dp
            StoreType.GS25 -> UiResource.drawable.bg_store_outline_gs25_radius_17dp
            StoreType.SEVEN -> UiResource.drawable.bg_store_outline_seveneleven_radius_17dp
        }

        private fun getIconByStore(storeType: StoreType): Int = when (storeType) {
            StoreType.CU -> UiResource.drawable.ic_store_cu
            StoreType.GS25 -> UiResource.drawable.ic_store_gs25
            StoreType.SEVEN -> UiResource.drawable.ic_store_seveneleven
        }
    }
}

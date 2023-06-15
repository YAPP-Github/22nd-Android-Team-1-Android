package com.peonlee.core.ui.designsystem.chip

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.peonlee.core.ui.R
import com.peonlee.core.ui.base.BaseCustomView
import com.peonlee.core.ui.databinding.PeonleeSmallChipBinding

class SmallChip(
    context: Context,
    attributeSet: AttributeSet
) : BaseCustomView<PeonleeSmallChipBinding>(
    context = context,
    attributeSet = attributeSet,
    styleable = R.styleable.SmallChip
) {

    init {
        applyAttributes(attributeSet)
    }

    override fun bindingFactory(): PeonleeSmallChipBinding {
        return PeonleeSmallChipBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )
    }

    override fun applyAttributes(attributeSet: AttributeSet) {
        customTypeArray.apply {
            val chipTitleText = getString(R.styleable.SmallChip_android_text)
            applyTextAttributes(chipTitleText)
            recycle()
        }
    }

    override fun applyTextAttributes(
        titleText: String?,
        titleTextColor: Int
    ) {
        binding.tvSmallChipTitle.text = titleText
    }

    override fun applyBackgroundAttributes(background: Int) { }
}
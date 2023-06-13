package com.peonlee.core.ui.designsystem.button

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.peonlee.core.ui.R
import com.peonlee.core.ui.databinding.PeonleeLargeButtonBinding
import com.peonlee.core.ui.extensions.gone
import com.peonlee.core.ui.extensions.visible

class LargeButton constructor(
    context: Context,
    attributeSet: AttributeSet
) : ConstraintLayout(context, attributeSet) {

    private val binding: PeonleeLargeButtonBinding =
        PeonleeLargeButtonBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )

    init {
        applyAttributes(attributeSet)
    }

    private fun applyAttributes(attributeSet: AttributeSet) {
        val largeButtonTypedArray = context.obtainStyledAttributes(attributeSet, R.styleable.LargeButton)

        largeButtonTypedArray.apply {
            val titleText = largeButtonTypedArray.getString(R.styleable.LargeButton_android_text)
            val titleTextColor = largeButtonTypedArray.getColor(
                R.styleable.LargeButton_android_textColor,
                resources.getColor(
                    R.color.bg80,
                    context.theme
                )
            )

            val largeButtonBackground = largeButtonTypedArray.getResourceId(
                R.styleable.LargeButton_android_background,
                R.drawable.background_radius_10dp
            )

            val isShowingChevron = largeButtonTypedArray.getBoolean(
                R.styleable.LargeButton_showChevron,
                false
            )

            applyTextAttributes(
                titleText,
                titleTextColor
            )
            applyBackgroundAttributes(largeButtonBackground)
            applyImageAttributes(isShowingChevron)

            recycle()
        }
    }

    private fun applyTextAttributes(
        text: String?,
        textColor: Int
    ) {
        binding.tvTitle.apply {
            this.text = text
            this.setTextColor(textColor)
        }
    }

    private fun applyBackgroundAttributes(largeButtonBackground: Int) {
        binding.layoutLargeBtnBackground.apply {
            setBackgroundResource(largeButtonBackground)
            backgroundTintList = ColorStateList.valueOf(R.styleable.LargeButton_android_backgroundTint)
        }
    }

    private fun applyImageAttributes(isShowingChevron: Boolean) {
        if (isShowingChevron) binding.ivChevronRight.visible() else binding.ivChevronRight.gone()
    }
}
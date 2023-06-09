package com.peonlee.home.adapter.viewholder.review

import androidx.core.view.isGone
import com.peonlee.common.util.TimeUtil
import com.peonlee.core.ui.designsystem.chip.MediumChip
import com.peonlee.core.ui.extensions.getString
import com.peonlee.core.ui.extensions.getStringWithArgs
import com.peonlee.core.ui.viewholder.CommonViewHolder
import com.peonlee.home.databinding.ListItemRecentReviewBinding
import com.peonlee.home.model.review.RecentReviewUiModel
import com.peonlee.core.ui.R as UiResource
import com.peonlee.home.R as homeResource

/**
 * 최근 리뷰 View Holder
 */
class RecentReviewViewHolder(
    private val binding: ListItemRecentReviewBinding
) : CommonViewHolder<RecentReviewUiModel>(binding) {
    override fun onBindView(item: RecentReviewUiModel) =
        with(binding) {
            // 상품 이름
            tvProductName.text = item.product.name
            // 리뷰
            item.comment?.let { tvComment.text = it }
            // 리뷰 작성자 & 작성 날짜
            tvUserNameAndDate.text = getStringWithArgs(
                homeResource.string.item_recent_review_user_and_date,
                item.userName,
                TimeUtil.getDuration(
                    itemView.context,
                    item.updateDate
                )
            )
            // 추천/비추천 chip
            if (item.recommended != null) {
                if (item.recommended) {
                    setRecommendedChip(binding.chipRecommended)
                } else {
                    setNoneRecommendedChip(binding.chipRecommended)
                }
            } else {
                // 평가(추천/비추천)이 null 인 경우에는 Chip 제거
                binding.chipRecommended.isGone = true
            }
        }
}

// 추천 chip
private fun RecentReviewViewHolder.setRecommendedChip(
    chip: MediumChip
) {
    chip.text = getString(homeResource.string.item_recent_review_recommended)
}

// 비추천 chip
private fun RecentReviewViewHolder.setNoneRecommendedChip(
    chip: MediumChip
) {
    chip.apply {
        text = getString(homeResource.string.item_recent_review_none_recommended)
        setBackgroundTint(UiResource.color.system_r40)
        setIcon(UiResource.drawable.ic_thumbs_down)
        setIconTint(UiResource.color.system_r100)
        setTextColor(UiResource.color.system_r100)
    }
}

package com.peonlee.home.model.title

import com.peonlee.model.MainHomeListItem
import com.peonlee.model.MainHomeViewType

/**
 * 각 리스트 를 구별 하는 제목 UI Model
 */
data class TitleUiModel(
    override val id: Long,
    override val viewType: Enum<MainHomeViewType> = MainHomeViewType.TITLE,
    val title: String
) : MainHomeListItem

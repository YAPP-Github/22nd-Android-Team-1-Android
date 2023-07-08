package com.peonlee.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Content(
    val brandName: String,
    val imageUrl: String,
    val isPbProduct: Boolean,
    val isPromotion: Boolean,
    val price: Int,
    val productCategoryType: String,
    val productId: Int,
    val productName: String
)

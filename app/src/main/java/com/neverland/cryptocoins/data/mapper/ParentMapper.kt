package com.neverland.cryptocoins.data.mapper

import com.neverland.cryptocoins.data.model.ParentResponse
import com.neverland.cryptocoins.domain.model.Parent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ParentMapper @Inject constructor() {

    fun mapToDomainModel(response: ParentResponse?): Parent = Parent(
        id = response?.id.orEmpty(),
        name = response?.name.orEmpty(),
        symbol = response?.symbol.orEmpty()
    )
}
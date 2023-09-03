package com.neverland.cryptocoins.data.mapper

import com.neverland.cryptocoins.data.model.TagResponse
import com.neverland.cryptocoins.domain.model.Tag
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TagMapper @Inject constructor() {

    fun mapToDomainModelList(response: List<TagResponse>?): List<Tag> =
        response?.map { mapToDomainModel(it) } ?: emptyList()

    private fun mapToDomainModel(response: TagResponse?): Tag = Tag(
        id = response?.id.orEmpty(),
        name = response?.name.orEmpty(),
        coinCounter = response?.coinCounter ?: -1,
        icoCounter = response?.icoCounter ?: -1
    )
}

package com.neverland.cryptocoins.data.mapper

import com.neverland.cryptocoins.data.model.LinksResponse
import com.neverland.cryptocoins.domain.model.Links
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LinksMapper @Inject constructor() {

    fun mapToDomainModel(response: LinksResponse?): Links = Links(
        explorer = response?.explorer.orEmpty(),
        facebook = response?.facebook.orEmpty(),
        reddit = response?.reddit.orEmpty(),
        sourceCode = response?.sourceCode.orEmpty(),
        website = response?.website.orEmpty(),
        youtube = response?.youtube.orEmpty()
    )
}
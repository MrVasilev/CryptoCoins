package com.neverland.cryptocoins.data.mapper

import com.neverland.cryptocoins.data.model.WhitePaperResponse
import com.neverland.cryptocoins.domain.model.WhitePaper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WhitePaperMapper @Inject constructor() {

    fun mapToDomainModel(response: WhitePaperResponse?): WhitePaper = WhitePaper(
        link = response?.link.orEmpty(),
        thumbnail = response?.thumbnail.orEmpty()
    )
}
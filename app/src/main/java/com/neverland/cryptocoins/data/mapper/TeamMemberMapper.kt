package com.neverland.cryptocoins.data.mapper

import com.neverland.cryptocoins.data.model.TeamMemberResponse
import com.neverland.cryptocoins.domain.model.TeamMember
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamMemberMapper @Inject constructor() {

    fun mapToDomainModelList(response: List<TeamMemberResponse>?): List<TeamMember> =
        response?.map { mapToDomainModel(it) } ?: emptyList()

    private fun mapToDomainModel(response: TeamMemberResponse?): TeamMember = TeamMember(
        id = response?.id.orEmpty(),
        name = response?.name.orEmpty(),
        position = response?.position.orEmpty()
    )
}
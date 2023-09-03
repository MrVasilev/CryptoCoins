package com.neverland.cryptocoins.data.mapper

import com.neverland.cryptocoins.data.model.CoinDetailsResponse
import com.neverland.cryptocoins.domain.model.CoinDetails
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CoinDetailsMapper @Inject constructor(
    private val linksMapper: LinksMapper,
    private val parentMapper: ParentMapper,
    private val tagMapper: TagMapper,
    private val teamMemberMapper: TeamMemberMapper,
    private val whitePaperMapper: WhitePaperMapper
) {

    fun mapToDomainModel(response: CoinDetailsResponse?): CoinDetails = CoinDetails(
        id = response?.id.orEmpty(),
        name = response?.name.orEmpty(),
        symbol = response?.symbol.orEmpty(),
        rank = response?.rank ?: -1,
        isNew = response?.isNew ?: false,
        isActive = response?.isActive ?: false,
        type = response?.type.orEmpty(),
        contract = response?.contract.orEmpty(),
        description = response?.description.orEmpty(),
        logo = response?.logo.orEmpty(),
        message = response?.message.orEmpty(),
        parent = parentMapper.mapToDomainModel(response?.parent),
        developmentStatus = response?.developmentStatus.orEmpty(),
        hardwareWallet = response?.hardwareWallet ?: false,
        hashAlgorithm = response?.hashAlgorithm.orEmpty(),
        links = linksMapper.mapToDomainModel(response?.links),
        isOpenSource = response?.isOpenSource ?: false,
        orgStructure = response?.orgStructure.orEmpty(),
        platform = response?.platform.orEmpty(),
        proofType = response?.proofType.orEmpty(),
        tags = tagMapper.mapToDomainModelList(response?.tags),
        team = teamMemberMapper.mapToDomainModelList(response?.team),
        whitePaper = whitePaperMapper.mapToDomainModel(response?.whitePaper),
        startedAt = response?.startedAt.orEmpty(),
        firstDataAt = response?.firstDataAt.orEmpty(),
        lastDataAt = response?.lastDataAt.orEmpty()
    )
}
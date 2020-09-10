package com.example.gadsleaderboard.repo

import com.example.gadsleaderboard.network.retrofit.NetworkServiceGenerator

object LeaderBoardRepo {
	private val learnerService = NetworkServiceGenerator.getLearnerServiceService()

	suspend fun getLearningLeaders() = learnerService.fetchLearningLeaders()
	suspend fun getSkillIQLeaders() = learnerService.fetchSkillIQLeaders()

	suspend fun submitAPP(firstName: String, lastName: String, emailAddress: String, ProjectGitHubLink: String)=
		learnerService.submitAPP(firstName, lastName, emailAddress, ProjectGitHubLink)
}
package com.example.gadsleaderboard.network.retrofit

import com.example.gadsleaderboard.model.LearnerResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.ArrayList

interface LearnerService {

	@GET(ApiConstants.LEARNING_LEADERS)
suspend fun fetchLearningLeaders(): ArrayList<LearnerResponse>

	@GET(ApiConstants.SKILL_IQ_LEADERS)
	suspend	fun fetchSkillIQLeaders():  ArrayList<LearnerResponse>

	@POST(ApiConstants.FULL_Form_ID)
	@FormUrlEncoded
	 suspend fun submitAPP(
			@Field("entry.1877115667") firstName: String,
			@Field("entry.2006916086") lastName: String,
			@Field("entry.1824927963") emailAddress: String,
			@Field("entry.284483984") ProjectGitHubLink: String
	             ) : Unit
}

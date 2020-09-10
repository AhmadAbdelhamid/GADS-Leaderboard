package com.example.gadsleaderboard.network.retrofit

object ApiConstants {
	const val BASE_URL = " https://gadsapi.herokuapp.com"
	const val LEARNING_LEADERS = "/api/hours"
	const val SKILL_IQ_LEADERS = "/api/skilliq"
	const val SUBMIT_URL = "https://docs.google.com/forms/d/e/"
	const val Form_ID = "1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse"
	const val FULL_Form_ID = "$SUBMIT_URL$Form_ID"

	fun getBaseUrl(): String = BASE_URL
	fun getSubmitUrl(): String = SUBMIT_URL

	fun getLearningLeaders(): String = "$BASE_URL$LEARNING_LEADERS"
	fun getSkillIQLeaders(): String = "$BASE_URL$SKILL_IQ_LEADERS"
	fun getFullSubmitUrl(): String = "$SUBMIT_URL$Form_ID"

}

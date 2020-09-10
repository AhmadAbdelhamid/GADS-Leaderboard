package com.example.gadsleaderboard.viewmodels

import androidx.lifecycle.*
import com.example.gadsleaderboard.network.googleutil.Resource
import com.example.gadsleaderboard.repo.LeaderBoardRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LearnersViewModel : ViewModel() {

	private val repo = LeaderBoardRepo


	fun getLiveLearningLeaders() = liveData(Dispatchers.IO) {
		emit(Resource.loading(data = null))
		try {
			emit(Resource.success(data = repo.getLearningLeaders()))
		} catch (exception: Exception) {
			emit(Resource.error(data = null, msg = exception.message ?: "Error Occurred!"))
		}
	}

	fun getSkillIQLeaders() = liveData(Dispatchers.IO) {
		emit(Resource.loading(data = null))
		try {
			emit(Resource.success(data = repo.getSkillIQLeaders()))
		} catch (exception: Exception) {
			emit(Resource.error(data = null, msg = exception.message ?: "Error Occurred!"))
		}

	}

	fun submitAPP(firstName: String, lastName: String, emailAddress: String, ProjectGitHubLink: String) =
			liveData(Dispatchers.IO) {
				emit(Resource.loading(data = null))
				try {
					emit(Resource.success(data = repo.submitAPP(firstName, lastName, emailAddress, ProjectGitHubLink)))
				} catch (exception: Exception) {
					emit(Resource.error(data = null, msg = exception.message ?: "Error Occurred!"))
				}
	}


}
package com.example.gadsleaderboard.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.gadsleaderboard.R
import com.example.gadsleaderboard.databinding.FragmentLearningLeadersBinding
import com.example.gadsleaderboard.network.googleutil.Resource
import com.example.gadsleaderboard.ui.adapters.LearnersAdapter
import com.example.gadsleaderboard.ui.adapters.ViewHolderType
import com.example.gadsleaderboard.viewmodels.LearnersViewModel

class LearningLeadersFragment : Fragment() {

	private val mLearnersViewModel: LearnersViewModel by activityViewModels()

	private lateinit var binding: FragmentLearningLeadersBinding
	private lateinit var learnerAdapter: LearnersAdapter
	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
	                          savedInstanceState: Bundle?): View? {

		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_learning_leaders, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		initView()
		mLearnersViewModel.getLiveLearningLeaders().observe(viewLifecycleOwner) { result ->
			when (result.status) {
				Resource.Status.SUCCESS -> {
					val data = result.data
					data?.let { learnerAdapter.update(it) }
				}

				Resource.Status.ERROR -> {
					println("LearningLeadersFragment, ${result.message}")
				}

				Resource.Status.LOADING -> {

				}
			}
		}
	}

	private fun initView() = with(binding) {
		learnersViewModel = this@LearningLeadersFragment.mLearnersViewModel
		learnerAdapter = LearnersAdapter(ViewHolderType.LearnerType)
		rvTopLearners.apply {
			adapter = learnerAdapter
			setHasFixedSize(true)
		}
	}
}
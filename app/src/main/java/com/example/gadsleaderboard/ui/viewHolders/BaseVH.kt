package com.example.gadsleaderboard.ui.viewHolders

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gadsleaderboard.databinding.ItemLearnLeadersBinding
import com.example.gadsleaderboard.model.LearnerResponse

abstract class BaseVH(val binding: ItemLearnLeadersBinding) : RecyclerView.ViewHolder(binding.root) {
	abstract fun bind(currentLearner: LearnerResponse)
}

class LearnLeadersVH(binding: ItemLearnLeadersBinding) : BaseVH(binding) {
	private val TAG = this.javaClass.simpleName
	override fun bind(currentLearner: LearnerResponse) {
		itemView.run {
			binding.tvLearnerName.text = currentLearner.name
			binding.tvLearnerInfo.text = "${currentLearner.hours} Learning hours, ${currentLearner.country}"
			Glide.with(context)
					.load(currentLearner.badgeUrl)
					.into(binding.ivBadge)
//			setOnClickListener { context.startActivity(Intent()) }
		}.also { Log.d(TAG, currentLearner.toString()) }

	}
}

class SkillLeadersVH(binding: ItemLearnLeadersBinding) : BaseVH(binding) {
	private val TAG = this.javaClass.simpleName
	override fun bind(currentLearner: LearnerResponse) {
		itemView.run {
			binding.tvLearnerName.text = currentLearner.name
			binding.tvLearnerInfo.text = "${currentLearner.score} Skill IQ Score, ${currentLearner.country}"
			Glide.with(context)
					.load(currentLearner.badgeUrl)
					.into(binding.ivBadge)
//			setOnClickListener { context.startActivity(Intent()) }
		}.also { Log.d(TAG, currentLearner.toString()) }

	}
}
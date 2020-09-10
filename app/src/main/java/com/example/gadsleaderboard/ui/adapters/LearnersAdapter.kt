package com.example.gadsleaderboard.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gadsleaderboard.R
import com.example.gadsleaderboard.databinding.ItemLearnLeadersBinding
import com.example.gadsleaderboard.model.LearnerResponse
import com.example.gadsleaderboard.ui.viewHolders.BaseVH
import com.example.gadsleaderboard.ui.viewHolders.LearnLeadersVH
import com.example.gadsleaderboard.ui.viewHolders.SkillLeadersVH
import java.util.*

class LearnersAdapter(private val vh: ViewHolderType) : RecyclerView.Adapter<BaseVH>() {
	private lateinit var binding: ItemLearnLeadersBinding
	private var learners: ArrayList<LearnerResponse> = arrayListOf()

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseVH {

		val inflater = LayoutInflater.from(parent.context)
		binding = DataBindingUtil.inflate(inflater, R.layout.item_learn_leaders, parent, false)

		return when (vh) {
			is ViewHolderType.LearnerType ->  LearnLeadersVH(binding)
			is ViewHolderType.SkillIQType ->  SkillLeadersVH(binding)
		}
	}

	override fun onBindViewHolder(holder: BaseVH, position: Int) {
		holder.bind(learners[position])
	}

	override fun getItemCount() = learners.count()

	fun update(items: ArrayList<LearnerResponse>) {
		this.learners = items
		notifyDataSetChanged()
	}

}
sealed class ViewHolderType {
	object LearnerType : ViewHolderType()
	object SkillIQType : ViewHolderType()
}


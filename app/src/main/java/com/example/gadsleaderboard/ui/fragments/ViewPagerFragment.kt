package com.example.gadsleaderboard.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.gadsleaderboard.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_view_pager.*

private const val NUMBER_OF_TABS = 2
class ViewPagerFragment : Fragment() {

	private lateinit var pagerAdapter: PagerAdapter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		requireActivity().window.statusBarColor = resources.getColor(R.color.colorPrimaryDark)
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
	                          savedInstanceState: Bundle?): View? {
		return inflater.inflate(R.layout.fragment_view_pager, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		toolbar.title = "LEADER BOARD"

		btn_Submit.setOnClickListener {
			findNavController().navigate(ViewPagerFragmentDirections.toSubmitFragment())
		}
		pagerAdapter = PagerAdapter(this, NUMBER_OF_TABS)
		view_pager.adapter = pagerAdapter
		TabLayoutMediator(tabs, view_pager) { tab, position ->
			tab.text = titles[position]
		}.attach()
	}

	companion object {
		val titles = listOf("Learning Leaders", "Skill IQ Leaders")
	}
}

class PagerAdapter(fragment: Fragment, private var tabsNum: Int) : FragmentStateAdapter(fragment) {
	override fun getItemCount() = tabsNum

	override fun createFragment(position: Int) = when (position) {
		0 -> LearningLeadersFragment()
		else -> SkillIQLeadersFragment()
	}
}
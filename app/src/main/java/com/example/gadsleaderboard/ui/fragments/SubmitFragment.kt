package com.example.gadsleaderboard.ui.fragments


import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.gadsleaderboard.R
import com.example.gadsleaderboard.network.googleutil.Resource
import com.example.gadsleaderboard.viewmodels.LearnersViewModel
import kotlinx.android.synthetic.main.layout_alert_dialog.view.*
import kotlinx.android.synthetic.main.layout_submit.*
import kotlinx.android.synthetic.main.layout_submit_toolbar.*


class SubmitFragment : Fragment() {

	private val mLearnersViewModel: LearnersViewModel by activityViewModels()
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
	                          savedInstanceState: Bundle?): View? {
		return inflater.inflate(R.layout.fragment_submit, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		toolbar.setNavigationOnClickListener {
			findNavController().navigateUp()
		}

		btn_Submit.setOnClickListener {
			val fistName = et_fistName.text.toString()
			val lastName = et_lastName.text.toString()
			val email = et_email.text.toString()
			val projectGitHubLink = et_link.text.toString()
			if (fistName.isBlank() || lastName.isBlank() || email.isBlank() || projectGitHubLink.isBlank()) {
				Toast.makeText(context, "check inputs ", Toast.LENGTH_SHORT).show()
				return@setOnClickListener
			} else {


				showConfirmDialog(
						fistName,
						lastName,
						email,
						projectGitHubLink)


			}
		}
	}


	private fun showConfirmDialog(fistName: String, lastName: String, email: String, projectGitHubLink: String) {

		val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
		val inflater = this.layoutInflater
		val dialogView= inflater.inflate(R.layout.layout_alert_dialog, null)
		dialogBuilder.setView(dialogView)
		val alertDialog= dialogBuilder.create()

		dialogView.iv_cancelSubmit.setOnClickListener {
			alertDialog.dismiss()
		}
		dialogView.btn_confirmSubmit.setOnClickListener {
			submitAPP(
					fistName,
					lastName,
					email,
					projectGitHubLink)
			alertDialog.dismiss()
		}
		alertDialog.show()
	}

	private fun submitAPP(fistName: String, lastName: String, email: String, projectGitHubLink: String) {
		mLearnersViewModel.submitAPP(
				fistName,
				lastName,
				email,
				projectGitHubLink).observe(viewLifecycleOwner) {
			when (it.status) {
				Resource.Status.LOADING -> {
				}

				Resource.Status.SUCCESS -> {
					findNavController().navigate(SubmitFragmentDirections.toSubmissionStateDialog(it.status))
				}

				Resource.Status.ERROR -> {
					findNavController().navigate(SubmitFragmentDirections.toSubmissionStateDialog(it.status))
				}
			}
		}

	}
}

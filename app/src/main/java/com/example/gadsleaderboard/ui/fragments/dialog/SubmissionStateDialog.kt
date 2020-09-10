package com.example.gadsleaderboard.ui.fragments.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import com.example.gadsleaderboard.R
import com.example.gadsleaderboard.network.googleutil.Resource


private const val ARG_PARAM1 = "param1"

class SubmissionStateDialog : DialogFragment() {

	private var param1: String? = null

	private val args by navArgs<SubmissionStateDialogArgs>()
	private val submissionState by lazy {
		args.submissionState
	}

	override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
		arguments?.let {
			param1 = it.getString(ARG_PARAM1)
		}
		return super.onCreateDialog(savedInstanceState)
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
	                          savedInstanceState: Bundle?): View? {
		return when (submissionState) {
			Resource.Status.SUCCESS -> inflater.inflate(R.layout.fragment_success_dialog, container, false)
			else                    -> inflater.inflate(R.layout.fragment_failed_dialog, container, false)
		}

	}

	override fun onResume() {
		super.onResume()
		dialog?.window?.apply {
			setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
			setGravity(Gravity.CENTER)
		}
	}

	companion object {
		@JvmStatic
		fun newInstance(param1: String) =
				SubmissionStateDialog().apply {
					arguments = Bundle().apply {
						putString(ARG_PARAM1, param1)
					}
				}
	}
}
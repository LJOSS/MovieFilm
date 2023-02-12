package com.example.movie_project.utils

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.common.BaseViewModel
import com.example.movie_project.R

abstract class BaseFragment<VM : BaseViewModel>(@LayoutRes val layout: Int) : Fragment(layout) {

    protected abstract val viewModel: VM

    //Simple implementation
    //it will be better to override errorView and progressView on Fragments, and manage show/hide here
    private val progressDialog: ProgressDialog by lazy {
        ProgressDialog(requireActivity()).also {
            it.setMessage(requireContext().getString(R.string.load_data))
        }
    }

    private val alertDialog: AlertDialog.Builder by lazy {
        AlertDialog.Builder(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.showProgress.observe(viewLifecycleOwner) {
            if (it) {
                progressDialog.show()
            } else {
                progressDialog.hide()
            }
        }
        viewModel.showError.observe(viewLifecycleOwner) {
            it?.let {
                alertDialog
                    .setTitle(requireContext().getString(R.string.error_dialog_title))
                    .setMessage("${it.stackTrace ?: it}")
                    .setCancelable(true)
                    .create().show()
            }
        }
    }

    protected val errorView: View? = null

    protected val progressView: View? = null

}
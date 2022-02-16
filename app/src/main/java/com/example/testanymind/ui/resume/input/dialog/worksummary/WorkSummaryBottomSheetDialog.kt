package com.example.testanymind.ui.resume.input.dialog.worksummary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testanymind.databinding.ViewResumeWorkSummaryDialogBinding
import com.example.testanymind.ui.resume.input.adapter.worksummary.ResumeWorkSummaryItem
import com.example.testanymind.ui.resume.input.dialog.ActionClick
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class WorkSummaryBottomSheetDialog : BottomSheetDialogFragment() {

    private lateinit var binding: ViewResumeWorkSummaryDialogBinding
    private var onAddButtonClick: ((item: ResumeWorkSummaryItem, actionClick: ActionClick) -> Unit)? =
        null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ViewResumeWorkSummaryDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() {
        binding.buttonAddWorkSummary.setOnClickListener {
            val item = ResumeWorkSummaryItem(
                id = hashCode(),
                companyName = binding.editTextCompany.text.toString().trim(),
                duration = binding.editTextDuration.text.toString().trim()
            )
            onAddButtonClick?.invoke(item, ActionClick.ADD)
        }
    }

    fun setListeners(onAdd: (item: ResumeWorkSummaryItem, actionClick: ActionClick) -> Unit) {
        onAddButtonClick = onAdd
    }

    override fun dismiss() {
        super.dismiss()
    }

    companion object {
        fun newInstance(): WorkSummaryBottomSheetDialog {
            return WorkSummaryBottomSheetDialog()
        }
    }
}
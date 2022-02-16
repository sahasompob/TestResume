package com.example.testanymind.ui.resume.input.dialog.educationdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testanymind.databinding.ViewResumeEducationDetailsDialogBinding
import com.example.testanymind.ui.resume.input.adapter.educationdetails.ResumeEducationDetailItem
import com.example.testanymind.ui.resume.input.dialog.ActionClick
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class EducationDetailBottomSheetDialog : BottomSheetDialogFragment() {

    private lateinit var binding: ViewResumeEducationDetailsDialogBinding
    private var onAddButtonClick: ((item: ResumeEducationDetailItem, actionClick: ActionClick) -> Unit)? =
        null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ViewResumeEducationDetailsDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() {
        binding.buttonAddEducationDetails.setOnClickListener {
            val item = ResumeEducationDetailItem(
                id = hashCode(),
                className = binding.editTextClass.text.toString().trim(),
                passingYear = binding.editTextPassingYear.text.toString().trim(),
                percentageGPA = binding.editTextPercentageGpa.text.toString().trim()
            )
            onAddButtonClick?.invoke(item, ActionClick.ADD)
        }
    }

    fun setListeners(onAdd: (item: ResumeEducationDetailItem, actionClick: ActionClick) -> Unit) {
        onAddButtonClick = onAdd
    }

    override fun dismiss() {
        super.dismiss()
    }

    companion object {
        fun newInstance(): EducationDetailBottomSheetDialog {
            return EducationDetailBottomSheetDialog()
        }
    }
}
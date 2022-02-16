package com.example.testanymind.ui.resume.input.dialog.projectdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testanymind.databinding.ViewResumeProjectDetailsDialogBinding
import com.example.testanymind.ui.resume.input.adapter.projectdetails.ResumeProjectDetailItem
import com.example.testanymind.ui.resume.input.dialog.ActionClick
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ProjectDetailBottomSheetDialog : BottomSheetDialogFragment() {

    private lateinit var binding: ViewResumeProjectDetailsDialogBinding
    private var onAddButtonClick: ((item: ResumeProjectDetailItem, actionClick: ActionClick) -> Unit)? =
        null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ViewResumeProjectDetailsDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() {
        binding.buttonAddProjectDetails.setOnClickListener {
            val item = ResumeProjectDetailItem(
                id = hashCode().toString(),
                projectName = binding.editTextProjectName.text.toString().trim(),
                teamSize = binding.editTextTeamSize.text.toString().trim(),
                projectSummary = binding.editTextProjectSummary.text.toString().trim(),
                technologyUsed = binding.editTextTechnologyUsed.text.toString().trim(),
                role = binding.editTextRole.text.toString().trim()
            )
            onAddButtonClick?.invoke(item, ActionClick.ADD)
        }
    }

    fun setListeners(onAdd: (item: ResumeProjectDetailItem, actionClick: ActionClick) -> Unit) {
        onAddButtonClick = onAdd
    }

    override fun dismiss() {
        super.dismiss()
    }

    companion object {
        fun newInstance(): ProjectDetailBottomSheetDialog {
            return ProjectDetailBottomSheetDialog()
        }
    }
}
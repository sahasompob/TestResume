package com.example.testanymind.ui.resume.input.dialog.skill

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testanymind.databinding.ViewResumeSkillDialogBinding
import com.example.testanymind.ui.resume.input.adapter.skill.ResumeSkillItem
import com.example.testanymind.ui.resume.input.dialog.ActionClick
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SkillBottomSheetDialog : BottomSheetDialogFragment() {

    private lateinit var binding: ViewResumeSkillDialogBinding
    private var onAddButtonClick: ((item: ResumeSkillItem, actionClick: ActionClick) -> Unit)? =
        null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ViewResumeSkillDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() {
        binding.buttonAddSkill.setOnClickListener {
            val item = ResumeSkillItem(
                id = hashCode(),
                skill = binding.editTextSkill.text.toString().trim()
            )
            onAddButtonClick?.invoke(item, ActionClick.ADD)
        }
    }

    fun setListeners(onAdd: (item: ResumeSkillItem, actionClick: ActionClick) -> Unit) {
        onAddButtonClick = onAdd
    }

    override fun dismiss() {
        super.dismiss()
    }

    companion object {
        fun newInstance(): SkillBottomSheetDialog {
            return SkillBottomSheetDialog()
        }
    }
}
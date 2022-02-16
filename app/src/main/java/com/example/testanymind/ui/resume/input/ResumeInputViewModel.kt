package com.example.testanymind.ui.resume.input

import androidx.lifecycle.MutableLiveData
import com.example.testanymind.ui.base.BaseViewModel
import com.example.testanymind.ui.resume.input.adapter.educationdetails.ResumeEducationDetailItem
import com.example.testanymind.ui.resume.input.adapter.projectdetails.ResumeProjectDetailItem
import com.example.testanymind.ui.resume.input.adapter.skill.ResumeSkillItem
import com.example.testanymind.ui.resume.input.adapter.worksummary.ResumeWorkSummaryItem
import com.example.testanymind.ui.resume.input.dialog.ActionClick

class ResumeInputViewModel : BaseViewModel() {

    val resumeWorkSummaryList: MutableLiveData<List<ResumeWorkSummaryItem>> = MutableLiveData(emptyList())
    val resumeSkillList: MutableLiveData<List<ResumeSkillItem>> = MutableLiveData(emptyList())
    val resumeEducationDetailList: MutableLiveData<List<ResumeEducationDetailItem>> = MutableLiveData(emptyList())
    val resumeProjectDetailList: MutableLiveData<List<ResumeProjectDetailItem>> = MutableLiveData(emptyList())

    fun setUp() {}

    fun handleWorkSummaryClick(workSummaryItem: ResumeWorkSummaryItem, actionClick: ActionClick) {
        when (actionClick) {
            ActionClick.ADD -> addWorkSummary(workSummaryItem)
            ActionClick.EDIT -> removeWorkSummary(workSummaryItem)
            ActionClick.DELETE -> {}
        }
    }

    private fun addWorkSummary(workSummaryItem: ResumeWorkSummaryItem) {
        resumeWorkSummaryList.value?.let { oldList ->
            val newList = oldList.toMutableList()
            newList.add(workSummaryItem)
            resumeWorkSummaryList.value = newList
        }
    }

    private fun removeWorkSummary(workSummaryItem: ResumeWorkSummaryItem) {
        resumeWorkSummaryList.value?.let { oldList ->
            val newList = oldList.toMutableList()
            newList.remove(workSummaryItem)
            resumeWorkSummaryList.value = newList
        }
    }

    fun handleSkillClick(skillItem: ResumeSkillItem, actionClick: ActionClick) {
        when (actionClick) {
            ActionClick.ADD -> addSkill(skillItem)
            ActionClick.EDIT -> removeSkill(skillItem)
            ActionClick.DELETE -> {}
        }
    }

    private fun addSkill(skillItem: ResumeSkillItem) {
        resumeSkillList.value?.let { oldList ->
            val newList = oldList.toMutableList()
            newList.add(skillItem)
            resumeSkillList.value = newList
        }
    }

    private fun removeSkill(skillItem: ResumeSkillItem) {
        resumeSkillList.value?.let { oldList ->
            val newList = oldList.toMutableList()
            newList.remove(skillItem)
            resumeSkillList.value = newList
        }
    }

    fun handleEducationDetailClick(educationDetailItem: ResumeEducationDetailItem, actionClick: ActionClick) {
        when (actionClick) {
            ActionClick.ADD -> addEducationDetail(educationDetailItem)
            ActionClick.EDIT -> removeEducationDetail(educationDetailItem)
            ActionClick.DELETE -> {}
        }
    }

    private fun addEducationDetail(educationDetailItem: ResumeEducationDetailItem) {
        resumeEducationDetailList.value?.let { oldList ->
            val newList = oldList.toMutableList()
            newList.add(educationDetailItem)
            resumeEducationDetailList.value = newList
        }
    }

    private fun removeEducationDetail(educationDetailItem: ResumeEducationDetailItem) {
        resumeEducationDetailList.value?.let { oldList ->
            val newList = oldList.toMutableList()
            newList.remove(educationDetailItem)
            resumeEducationDetailList.value = newList
        }
    }

    fun handleProjectDetailClick(projectDetailItem: ResumeProjectDetailItem, actionClick: ActionClick) {
        when (actionClick) {
            ActionClick.ADD -> addProjectDetail(projectDetailItem)
            ActionClick.EDIT -> removeProjectDetail(projectDetailItem)
            ActionClick.DELETE -> {}
        }
    }

    private fun addProjectDetail(projectDetailItem: ResumeProjectDetailItem) {
        resumeProjectDetailList.value?.let { oldList ->
            val newList = oldList.toMutableList()
            newList.add(projectDetailItem)
            resumeProjectDetailList.value = newList
        }
    }

    private fun removeProjectDetail(projectDetailItem: ResumeProjectDetailItem) {
        resumeProjectDetailList.value?.let { oldList ->
            val newList = oldList.toMutableList()
            newList.remove(projectDetailItem)
            resumeProjectDetailList.value = newList
        }
    }
}
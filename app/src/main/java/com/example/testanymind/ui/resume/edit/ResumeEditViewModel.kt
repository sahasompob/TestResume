package com.example.testanymind.ui.resume.edit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.testanymind.data.model.resume.SaveResume
import com.example.testanymind.ui.base.BaseViewModel
import com.example.testanymind.ui.resume.input.adapter.educationdetails.ResumeEducationDetailItem
import com.example.testanymind.ui.resume.input.adapter.projectdetails.ResumeProjectDetailItem
import com.example.testanymind.ui.resume.input.adapter.skill.ResumeSkillItem
import com.example.testanymind.ui.resume.input.adapter.worksummary.ResumeWorkSummaryItem
import com.example.testanymind.ui.resume.input.dialog.ActionClick
import com.example.testanymind.usecase.GetResumeByIdUseCase
import com.example.testanymind.usecase.UpdateResumeUseCase
import com.example.testanymind.utill.SingleLiveEvent
import kotlinx.coroutines.launch

class ResumeEditViewModel(
    private val getResumeByIdUseCase: GetResumeByIdUseCase,
    private val updateResumeUseCase: UpdateResumeUseCase
) : BaseViewModel() {

    val resumeId = MutableLiveData(0)
    val picture = MutableLiveData<String>()
    val mobileNumber = MutableLiveData("")
    val residenceAddress = MutableLiveData("")
    val email = MutableLiveData("")
    val careerObjective = MutableLiveData("")
    val totalYear = MutableLiveData("")

    val resumeWorkSummaryList: MutableLiveData<List<ResumeWorkSummaryItem>> =
        MutableLiveData(emptyList())
    val resumeSkillList: MutableLiveData<List<ResumeSkillItem>> = MutableLiveData(emptyList())
    val resumeEducationDetailList: MutableLiveData<List<ResumeEducationDetailItem>> =
        MutableLiveData(emptyList())
    val resumeProjectDetailList: MutableLiveData<List<ResumeProjectDetailItem>> =
        MutableLiveData(emptyList())
    val updateResumeSuccess = SingleLiveEvent<Unit>()

    fun setUp(resumeId: String) {
        viewModelScope.launch {
            getResumeByIdUseCase.execute(GetResumeByIdUseCase.Input(resumeId))
                .onSuccess(::onGetResumeByIdSuccess)
        }
    }

    private fun onGetResumeByIdSuccess(resume: SaveResume) {
        resumeId.value = resume.resume.id
        picture.value = resume.resume.picture
        mobileNumber.value = resume.resume.mobileNumber
        residenceAddress.value = resume.resume.residenceAddress
        email.value = resume.resume.email
        careerObjective.value = resume.resume.careerObjective
        totalYear.value = resume.resume.totalYear
        resumeSkillList.value = getSkillList(resume.skillList)
        resumeWorkSummaryList.value = getWorkSummaryList(resume.workSummaryList)
        resumeEducationDetailList.value = getResumeEducationDetailList(resume.educationDetailList)
        resumeProjectDetailList.value = getProjectDetailList(resume.projectDetailList)
    }

    private fun getWorkSummaryList(workSummaryList: List<SaveResume.WorkSummary>): List<ResumeWorkSummaryItem> {
        return workSummaryList.map {
            ResumeWorkSummaryItem(
                id = it.id,
                companyName = it.companyName,
                duration = it.duration
            )
        }
    }

    private fun getSkillList(skillList: List<SaveResume.Skill>): List<ResumeSkillItem> {
        return skillList.map {
            ResumeSkillItem(
                id = it.id,
                skill = it.name,
            )
        }
    }

    private fun getResumeEducationDetailList(educationDetailList: List<SaveResume.EducationDetail>): List<ResumeEducationDetailItem> {
        return educationDetailList.map {
            ResumeEducationDetailItem(
                id = it.id,
                percentageGPA = it.percentageGPA,
                passingYear = it.passingYear,
                className = it.className
            )
        }
    }

    private fun getProjectDetailList(projectDetailList: List<SaveResume.ProjectDetail>): List<ResumeProjectDetailItem> {
        return projectDetailList.map {
            ResumeProjectDetailItem(
                id = it.id,
                projectName = it.projectName,
                projectSummary = it.projectSummary,
                teamSize = it.teamSize,
                technologyUsed = it.technologyUsed,
                role = it.role
            )
        }
    }

    fun setPicture(imageString: String) {
        picture.value = imageString
    }

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

    fun handleEducationDetailClick(
        educationDetailItem: ResumeEducationDetailItem,
        actionClick: ActionClick
    ) {
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

    fun handleProjectDetailClick(
        projectDetailItem: ResumeProjectDetailItem,
        actionClick: ActionClick
    ) {
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

    fun updateResume() {
        viewModelScope.launch {
            val resume = SaveResume(
                resume = SaveResume.Resume(
                    id = resumeId.value ?: 0,
                    residenceAddress = residenceAddress.value.orEmpty(),
                    picture = picture.value.orEmpty(),
                    mobileNumber = mobileNumber.value.orEmpty(),
                    careerObjective = careerObjective.value.orEmpty(),
                    totalYear = totalYear.value.orEmpty(),
                    email = email.value.orEmpty()
                ),
                skillList = getSkills(),
                workSummaryList = getWorkSummary(),
                educationDetailList = getEducationDetail(),
                projectDetailList = getProjectDetail(),
            )

            updateResumeUseCase.execute(UpdateResumeUseCase.Input(resume))
                .onSuccess {
                    updateResumeSuccess.value = Unit
                }
        }
    }

    private fun getSkills(): List<SaveResume.Skill> {
        return resumeSkillList.value?.map {
            SaveResume.Skill(
                id = it.id,
                name = it.skill
            )
        } ?: emptyList()
    }

    private fun getWorkSummary(): List<SaveResume.WorkSummary> {
        return resumeWorkSummaryList.value?.map {
            SaveResume.WorkSummary(
                id = it.id,
                companyName = it.companyName,
                duration = it.duration,
            )
        } ?: emptyList()
    }

    private fun getProjectDetail(): List<SaveResume.ProjectDetail> {
        return resumeProjectDetailList.value?.map {
            SaveResume.ProjectDetail(
                id = it.id,
                projectName = it.projectName,
                teamSize = it.teamSize,
                projectSummary = it.projectSummary,
                technologyUsed = it.technologyUsed,
                role = it.role
            )
        } ?: emptyList()
    }

    private fun getEducationDetail(): List<SaveResume.EducationDetail> {
        return resumeEducationDetailList.value?.map {
            SaveResume.EducationDetail(
                id = it.id,
                className = it.className,
                passingYear = it.passingYear,
                percentageGPA = it.percentageGPA
            )
        } ?: emptyList()
    }
}
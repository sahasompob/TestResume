package com.example.testanymind.ui.resume.input

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.testanymind.data.model.resume.SaveResume
import com.example.testanymind.ui.base.BaseViewModel
import com.example.testanymind.ui.resume.input.adapter.educationdetails.ResumeEducationDetailItem
import com.example.testanymind.ui.resume.input.adapter.projectdetails.ResumeProjectDetailItem
import com.example.testanymind.ui.resume.input.adapter.skill.ResumeSkillItem
import com.example.testanymind.ui.resume.input.adapter.worksummary.ResumeWorkSummaryItem
import com.example.testanymind.ui.resume.input.dialog.ActionClick
import com.example.testanymind.usecase.SaveResumeUseCase
import com.example.testanymind.utill.SingleLiveEvent
import com.example.testanymind.utill.ValidationUtils
import kotlinx.coroutines.launch

class ResumeInputViewModel(
    private val saveResumeUseCase: SaveResumeUseCase
) : BaseViewModel() {

    val picture = MutableLiveData("")
    val mobileNumber = MutableLiveData("")
    val mobileNumberError = MutableLiveData("")
    val residenceAddress = MutableLiveData("")
    val residenceAddressError = MutableLiveData("")
    val email = MutableLiveData("")
    val emailError = MutableLiveData("")
    val careerObjective = MutableLiveData("")
    val careerObjectiveError = MutableLiveData("")
    val totalYear = MutableLiveData("")
    val totalYearError = MutableLiveData("")

    val resumeWorkSummaryList: MutableLiveData<List<ResumeWorkSummaryItem>> = MutableLiveData(emptyList())
    val resumeSkillList: MutableLiveData<List<ResumeSkillItem>> = MutableLiveData(emptyList())
    val resumeEducationDetailList: MutableLiveData<List<ResumeEducationDetailItem>> = MutableLiveData(emptyList())
    val resumeProjectDetailList: MutableLiveData<List<ResumeProjectDetailItem>> = MutableLiveData(emptyList())

    val saveResumeSuccess = SingleLiveEvent<Unit>()

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

    fun saveResume() {
        viewModelScope.launch {
            val saveResume = SaveResume(
                resume = SaveResume.Resume(
                    id = hashCode(),
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

            if (formIsValid().not()) return@launch

            saveResumeUseCase.execute(SaveResumeUseCase.Input(saveResume))
                .onSuccess {
                    saveResumeSuccess.value = Unit
                }
        }
    }

    private fun formIsValid(): Boolean {
        mobileNumberError.value =
            ValidationUtils.validationString(mobileNumber.value.orEmpty(), MOBILE_ERROR)
        residenceAddressError.value =
            ValidationUtils.validationString(residenceAddress.value.orEmpty(), RESIDENCE_ERROR)
        emailError.value =
            ValidationUtils.validationString(email.value.orEmpty(), EMAIL_ERROR)
        careerObjectiveError.value =
            ValidationUtils.validationString(careerObjective.value.orEmpty(), CAREER_OBJ)
        totalYearError.value =
            ValidationUtils.validationString(totalYear.value.orEmpty(), TOTAL_YEAR)

        return mobileNumberError.value?.isEmpty() == true &&
                residenceAddressError.value?.isEmpty() == true &&
                emailError.value?.isEmpty() == true &&
                careerObjectiveError.value?.isEmpty() == true &&
                totalYearError.value?.isEmpty() == true
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

    companion object {
        private const val MOBILE_ERROR = "mobile error"
        private const val RESIDENCE_ERROR = "residence error"
        private const val EMAIL_ERROR = "email error"
        private const val TOTAL_YEAR = "total year error"
        private const val CAREER_OBJ = "careerObjective error"
    }
}
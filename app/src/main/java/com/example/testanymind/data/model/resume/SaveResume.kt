package com.example.testanymind.data.model.resume

import com.example.testanymind.data.model.local.*
import com.google.gson.Gson

data class SaveResume(
    val resume: Resume,
    val skillList: List<Skill>,
    val workSummaryList: List<WorkSummary>,
    val educationDetailList: List<EducationDetail>,
    val projectDetailList: List<ProjectDetail>,
) {
    data class Resume(
        val id: Int,
        val picture: String,
        val mobileNumber: String,
        val email: String,
        val residenceAddress: String,
        val careerObjective: String,
        val totalYear: String,
    )

    data class Skill(
        val id: Int,
        val name: String
    )

    data class WorkSummary(
        val id: Int,
        val companyName: String,
        val duration: String
    )

    data class EducationDetail(
        val id: Int,
        val className: String,
        val passingYear: String,
        val percentageGPA: String
    )

    data class ProjectDetail(
        val id: Int,
        val projectName: String,
        val teamSize: String,
        val projectSummary: String,
        val technologyUsed: String,
        val role: String
    )

    fun toResumeEntity(): ResumeEntity {
        return ResumeEntity(
            id = resume.id,
            residence = resume.residenceAddress,
            picture = resume.picture,
            mobile = resume.mobileNumber,
            career = resume.careerObjective,
            totalYear = resume.totalYear,
            email = resume.email,
            skill = convertSkillToString(),
            workSummary = convertWorkSummaryToString(),
            projectDetail = convertProjectDetailToString(),
            educationDetail = convertEducationDetailToString()
        )
    }


    private fun convertSkillToString(): String {
        val gson = Gson()
        return gson.toJson(skillList)
    }

    private fun convertWorkSummaryToString(): String {
        val gson = Gson()
        return gson.toJson(workSummaryList)
    }

    private fun convertEducationDetailToString(): String {
        val gson = Gson()
        return gson.toJson(educationDetailList)
    }

    private fun convertProjectDetailToString(): String {
        val gson = Gson()
        return gson.toJson(projectDetailList)
    }

    private fun test (){
        val aa = listOf(1,3,3,3,5)
        aa.count { it == 3 }
    }
}
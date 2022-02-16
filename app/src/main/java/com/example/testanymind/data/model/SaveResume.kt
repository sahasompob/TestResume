package com.example.testanymind.data.model

import com.example.testanymind.data.model.local.*

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
            email = resume.email
        )
    }

    fun toEducationDetailEntity(): List<EducationDetailEntity> {
        return educationDetailList.map {
            EducationDetailEntity(
                id = it.id,
                className = it.className,
                passingYear = it.passingYear,
                percentGPA = it.percentageGPA,
                resumeId = resume.id
            )
        }
    }

    fun toProjectDetailEntity(): List<ProjectDetailEntity> {
        return projectDetailList.map {
            ProjectDetailEntity(
                id = it.id,
                projectName = it.projectName,
                teamSize = it.teamSize,
                projectSummary = it.projectSummary,
                technologyUsed = it.technologyUsed,
                role = it.role,
                resumeId = resume.id
            )
        }
    }

    fun toWorkSummaryEntity(): List<WorkSummaryEntity> {
        return workSummaryList.map {
            WorkSummaryEntity(
                id = it.id,
                companyName = it.companyName,
                duration = it.duration,
                resumeId = resume.id
            )
        }
    }

    fun toSkillEntity(): List<SkillEntity> {
        return skillList.map {
            SkillEntity(
                id = it.id,
                skillName = it.name,
                resumeId = resume.id
            )
        }
    }
}
package com.example.testanymind.data.model.mapper

import com.example.testanymind.base.Mapper
import com.example.testanymind.data.model.SaveResume
import com.example.testanymind.data.model.local.ResumeEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class ResumeListMapper : Mapper<List<ResumeEntity>, List<SaveResume>> {

    override fun map(input: List<ResumeEntity>): List<SaveResume> {
        return with(input) {
            this.map {
                SaveResume(
                    resume = SaveResume.Resume(
                        id = it.id,
                        residenceAddress = it.residence,
                        picture = it.picture,
                        mobileNumber = it.mobile,
                        careerObjective = it.career,
                        totalYear = it.totalYear,
                        email = it.email
                    ),
                    skillList = convertStringToSkillObject(it.skill),
                    workSummaryList = convertStringToWorkSummaryObject(it.workSummary),
                    projectDetailList = convertStringToProjectDetailObject(it.projectDetail),
                    educationDetailList = convertStringToEducationDetailObject(it.educationDetail)
                )
            }
        }
    }

    private fun convertStringToSkillObject(value: String): List<SaveResume.Skill> {
        val listType: Type = object : TypeToken<List<SaveResume.Skill>>() {}.type
        return Gson().fromJson(value, listType) ?: emptyList()
    }

    private fun convertStringToWorkSummaryObject(value: String): List<SaveResume.WorkSummary> {
        val listType: Type = object : TypeToken<List<SaveResume.WorkSummary>>() {}.type
        return Gson().fromJson(value, listType) ?: emptyList()
    }

    private fun convertStringToEducationDetailObject(value: String): List<SaveResume.EducationDetail> {
        val listType: Type = object : TypeToken<List<SaveResume.EducationDetail>>() {}.type
        return Gson().fromJson(value, listType) ?: emptyList()
    }

    private fun convertStringToProjectDetailObject(value: String): List<SaveResume.ProjectDetail> {
        val listType: Type = object : TypeToken<List<SaveResume.ProjectDetail>>() {}.type
        return Gson().fromJson(value, listType) ?: emptyList()
    }
}

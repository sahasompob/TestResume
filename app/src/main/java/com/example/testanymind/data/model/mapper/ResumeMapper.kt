package com.example.testanymind.data.model.mapper

import com.example.testanymind.base.Mapper
import com.example.testanymind.data.model.resume.SaveResume
import com.example.testanymind.data.model.local.ResumeEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class ResumeMapper : Mapper<ResumeEntity, SaveResume> {

    override fun map(input: ResumeEntity): SaveResume {
        return with(input) {
            SaveResume(
                resume = SaveResume.Resume(
                    id = id,
                    residenceAddress = residence,
                    picture = picture,
                    mobileNumber = mobile,
                    careerObjective = career,
                    totalYear = totalYear,
                    email = email
                ),
                skillList = convertStringToSkillObject(skill),
                workSummaryList = convertStringToWorkSummaryObject(workSummary),
                projectDetailList = convertStringToProjectDetailObject(projectDetail),
                educationDetailList = convertStringToEducationDetailObject(educationDetail)
            )
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

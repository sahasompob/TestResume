package com.example.testanymind.ui.resume.input.adapter.projectdetails

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testanymind.databinding.ItemResumeEducationDetailBinding
import com.example.testanymind.databinding.ItemResumeProjectDetailBinding
import com.example.testanymind.databinding.ItemResumeSkillBinding
import com.example.testanymind.databinding.ItemResumeWorkSummaryBinding
import com.example.testanymind.ui.resume.input.adapter.educationdetails.ResumeEducationDetailItem
import com.example.testanymind.ui.resume.input.adapter.educationdetails.ResumeEducationDetailViewHolder
import com.example.testanymind.ui.resume.input.adapter.skill.ResumeSkillItem
import com.example.testanymind.ui.resume.input.adapter.skill.ResumeSkillViewHolder
import com.example.testanymind.ui.resume.input.adapter.worksummary.ResumeWorkSummaryItem
import com.example.testanymind.ui.resume.input.adapter.worksummary.ResumeWorkSummaryViewHolder

class ResumeProjectDetailAdapter() : RecyclerView.Adapter<ResumeProjectDetailViewHolder>() {

    private var projectDetailList: List<ResumeProjectDetailItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResumeProjectDetailViewHolder {
        val binding =
            ItemResumeProjectDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ResumeProjectDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResumeProjectDetailViewHolder, position: Int) {
        holder.bind(item = projectDetailList[position])
    }

    override fun getItemCount(): Int {
        return projectDetailList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<ResumeProjectDetailItem>) {
        this.projectDetailList = items
        notifyDataSetChanged()
    }
}
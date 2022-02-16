package com.example.testanymind.ui.resume.input.adapter.projectdetails

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.testanymind.databinding.ItemResumeProjectDetailBinding

class ResumeProjectDetailViewHolder(val binding: ItemResumeProjectDetailBinding) :
    RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(item: ResumeProjectDetailItem) = with(binding) {
        textViewProjectName.text = "- Project Name : ${item.projectName}"
        textViewProjectSummary.text = "Summary : ${item.projectSummary}"
        textViewRole.text = "Role  : ${item.role}"
        textViewTeamSize.text = "Team Size : ${item.teamSize}"
        textViewTechnologyUsed.text = "Technology Used  : ${item.technologyUsed}"
    }
}
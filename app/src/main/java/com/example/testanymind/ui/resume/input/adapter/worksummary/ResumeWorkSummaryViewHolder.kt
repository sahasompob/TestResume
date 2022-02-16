package com.example.testanymind.ui.resume.input.adapter.worksummary

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.testanymind.databinding.ItemWorkSummaryBinding

class ResumeWorkSummaryViewHolder(val binding: ItemWorkSummaryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(item: ResumeWorkSummaryItem) = with(binding) {
        textViewCompanyName.text = "- Company : ${item.companyName}"
        textViewDuration.text = "Duration : ${item.duration}"
    }

}
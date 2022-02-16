package com.example.testanymind.ui.resume.input.adapter.educationdetails

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.testanymind.databinding.ItemResumeEducationDetailBinding

class ResumeEducationDetailViewHolder(val binding: ItemResumeEducationDetailBinding) :
    RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(item: ResumeEducationDetailItem) = with(binding) {
        textViewClass.text = "- Class : ${item.className}"
        textViewPassingYear.text = "Passing Year : ${item.passingYear}"
        textViewPercentageGpa.text = "GPA =  : ${item.percentageGPA}"
    }

}
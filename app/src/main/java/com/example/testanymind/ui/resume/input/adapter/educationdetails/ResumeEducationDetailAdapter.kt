package com.example.testanymind.ui.resume.input.adapter.educationdetails

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testanymind.databinding.ItemResumeEducationDetailBinding

class ResumeEducationDetailAdapter() : RecyclerView.Adapter<ResumeEducationDetailViewHolder>() {

    private var educationDetailList: List<ResumeEducationDetailItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResumeEducationDetailViewHolder {
        val binding =
            ItemResumeEducationDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ResumeEducationDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResumeEducationDetailViewHolder, position: Int) {
        holder.bind(item = educationDetailList[position])
    }

    override fun getItemCount(): Int {
        return educationDetailList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<ResumeEducationDetailItem>) {
        this.educationDetailList = items
        notifyDataSetChanged()
    }
}
package com.example.testanymind.ui.resume.input.adapter.worksummary

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testanymind.databinding.ItemResumeWorkSummaryBinding

class ResumeWorkSummaryAdapter() : RecyclerView.Adapter<ResumeWorkSummaryViewHolder>() {

    private var workSummaryList: List<ResumeWorkSummaryItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResumeWorkSummaryViewHolder {
        val binding =
            ItemResumeWorkSummaryBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ResumeWorkSummaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResumeWorkSummaryViewHolder, position: Int) {
        holder.bind(item = workSummaryList[position])
    }

    override fun getItemCount(): Int {
        return workSummaryList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<ResumeWorkSummaryItem>) {
        this.workSummaryList = items
        notifyDataSetChanged()
    }
}
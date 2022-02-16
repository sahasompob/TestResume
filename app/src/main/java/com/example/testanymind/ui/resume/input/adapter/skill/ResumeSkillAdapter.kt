package com.example.testanymind.ui.resume.input.adapter.skill

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testanymind.databinding.ItemResumeSkillBinding

class ResumeSkillAdapter() : RecyclerView.Adapter<ResumeSkillViewHolder>() {

    private var skillList: List<ResumeSkillItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResumeSkillViewHolder {
        val binding =
            ItemResumeSkillBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ResumeSkillViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResumeSkillViewHolder, position: Int) {
        holder.bind(item = skillList[position])
    }

    override fun getItemCount(): Int {
        return skillList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<ResumeSkillItem>) {
        this.skillList = items
        notifyDataSetChanged()
    }
}
package com.example.testanymind.ui.resume.input.adapter.skill

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.testanymind.databinding.ItemResumeSkillBinding

class ResumeSkillViewHolder(val binding: ItemResumeSkillBinding) :
    RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(item: ResumeSkillItem) = with(binding) {
        textViewSkill.text = "- Skill : ${item.skill}"
    }

}
package com.example.testanymind.ui.resume.list.adapter

import android.annotation.SuppressLint
import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.testanymind.databinding.ItemResumeListBinding
import com.example.testanymind.utill.MediaUtils

class ResumeListViewHolder(
    val binding: ItemResumeListBinding,
    private val onClickListener: (position: Int) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(item: ResumeListItem) = with(binding) {
        imageViewAvatar.load(MediaUtils.stringToBitmap(item.picture))
        textViewName.text = item.email
        textViewMobile.text = "Tel : ${item.mobileNumber}"
        textViewEdit.setOnClickListener {
            onClickListener.invoke(adapterPosition)
        }
    }

}
package com.example.testanymind.ui.resume.list.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testanymind.databinding.ItemResumeListBinding

class ResumeListAdapter() : RecyclerView.Adapter<ResumeListViewHolder>() {

    private var resumeList: List<ResumeListItem> = emptyList()
    private var onClickListener: ((id: String) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResumeListViewHolder {
        val binding =
            ItemResumeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ResumeListViewHolder(binding, this::onClickViewHolder)
    }

    override fun onBindViewHolder(holder: ResumeListViewHolder, position: Int) {
        holder.bind(item = resumeList[position])
    }

    override fun getItemCount(): Int {
        return resumeList.size
    }

    private fun onClickViewHolder(position: Int) {
        (resumeList[position] as? ResumeListItem)?.let {
            onClickListener?.invoke(it.id.toString())
        }
    }

    fun setOnClickListener(listener: ((String) -> Unit)?) {
        this.onClickListener = listener
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<ResumeListItem>) {
        this.resumeList = items
        notifyDataSetChanged()
    }
}
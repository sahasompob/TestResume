package com.example.testanymind.ui.resume.input

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.testanymind.ui.base.BaseViewModel
import com.example.testanymind.ui.resume.input.adapter.worksummary.ResumeWorkSummaryItem

class ResumeInputViewModel : BaseViewModel() {

    val resumeWorkSummaryList = MutableLiveData<List<ResumeWorkSummaryItem>>()

    fun setUp() {
        resumeWorkSummaryList.value = listOf(
            ResumeWorkSummaryItem(
                companyName = "AAA",
                duration = "2017-2020"
            ),
            ResumeWorkSummaryItem(
                companyName = "BBB",
                duration = "2020-2012"
            )
        )
    }

    fun addWorkSummary() {
        resumeWorkSummaryList.value?.let { oldList ->
            val newList = oldList.toMutableList()
            newList.add(
                ResumeWorkSummaryItem(
                    companyName = "C",
                    duration = "1111-22"
                )
            )
            resumeWorkSummaryList.value = newList
        }

        Log.d("AAA", "${resumeWorkSummaryList.value?.size}")
    }
}
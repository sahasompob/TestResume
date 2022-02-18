package com.example.testanymind.ui.resume.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.testanymind.ui.base.BaseViewModel
import com.example.testanymind.ui.resume.list.adapter.ResumeListItem
import com.example.testanymind.usecase.GetAllResumeUseCase
import kotlinx.coroutines.launch

class ResumeListViewModel(
    private val getAllResumeUseCase: GetAllResumeUseCase
) : BaseViewModel() {

    val resumeList : MutableLiveData<List<ResumeListItem>> = MutableLiveData(emptyList())

    fun setUp() {
        viewModelScope.launch {
            getAllResumeUseCase.execute(Unit)
                .onSuccess {
                    resumeList.value = it.map {
                        ResumeListItem(
                          id = it.resume.id,
                          picture = it.resume.picture,
                          email = it.resume.email,
                          mobileNumber = it.resume.mobileNumber
                        )
                    }
                }
        }
    }
}
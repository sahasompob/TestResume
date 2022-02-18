package com.example.testanymind.resume

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.testanymind.base.test.TestCoroutineRule
import com.example.testanymind.data.model.resume.SaveResume
import com.example.testanymind.ui.resume.list.ResumeListViewModel
import com.example.testanymind.usecase.GetAllResumeUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ResumeListViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    lateinit var viewModel: ResumeListViewModel

    private val getAllResumeUseCase: GetAllResumeUseCase = mockk()

    @Before
    fun setUp() {
        viewModel = ResumeListViewModel(
            getAllResumeUseCase = getAllResumeUseCase
        )
    }

    @Test
    fun `should get resume list success`() {
        testCoroutineRule.runBlockingTest {
            coEvery {
                getAllResumeUseCase.execute(Unit)
            } returns Result.success(mockResumeList())

            viewModel.setUp()

            Assert.assertTrue(viewModel.resumeList.value?.size == 2)
        }
    }

    private fun mockResumeList(): List<SaveResume> {
        return listOf(
            SaveResume(
                resume = SaveResume.Resume(
                    id = hashCode(),
                    residenceAddress = "residenceAddress1",
                    picture = "picture1",
                    mobileNumber = "0847788787",
                    careerObjective = "careerObjective1",
                    totalYear = "totalYear1",
                    email = "test@gmail.com"
                ),
                workSummaryList = emptyList(),
                skillList = emptyList(),
                educationDetailList = emptyList(),
                projectDetailList = emptyList()
            ),
            SaveResume(
                resume = SaveResume.Resume(
                    id = hashCode(),
                    residenceAddress = "residenceAddress2",
                    picture = "picture2",
                    mobileNumber = "0847788787",
                    careerObjective = "careerObjective2",
                    totalYear = "totalYear2",
                    email = "test@gmail.com"
                ),
                workSummaryList = emptyList(),
                skillList = emptyList(),
                educationDetailList = emptyList(),
                projectDetailList = emptyList()
            )
        )
    }
}

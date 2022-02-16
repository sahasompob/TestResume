package com.example.testanymind.ui.resume.input

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testanymind.R
import com.example.testanymind.databinding.FragmentResumeInputBinding
import com.example.testanymind.ui.base.BaseFragment
import com.example.testanymind.ui.resume.input.adapter.worksummary.ResumeWorkSummaryAdapter
import com.example.testanymind.ui.resume.input.adapter.worksummary.ResumeWorkSummaryItem

class ResumeInputFragment : BaseFragment<ResumeInputViewModel, FragmentResumeInputBinding>() {

    private val resumeWorkSummaryAdapter: ResumeWorkSummaryAdapter by lazy {
        ResumeWorkSummaryAdapter()
    }

    override val viewModel by viewModels<ResumeInputViewModel>()

    override fun getLayoutId(): Int = R.layout.fragment_resume_input

    override fun initView() {
        initRecyclerView()
        initAction()
    }

    override fun initViewModel() {
        binding.viewModel = viewModel

        viewModel.setUp()
        viewModel.resumeWorkSummaryList.observe(viewLifecycleOwner, ::setWorkSummaryAdapter)
    }

    private fun initAction() {
        binding.relativeLayoutProfileImage.setOnClickListener {
            openGallery()
        }

        binding.buttonWorkSummary.setOnClickListener {
            viewModel.addWorkSummary()
        }
    }

    private fun initRecyclerView() {
        setupWorkSummaryAdapter(resumeWorkSummaryAdapter)
    }

    private fun setupWorkSummaryAdapter(adapter: ResumeWorkSummaryAdapter) = with(binding) {
        recyclerViewWorkSummary.itemAnimator = null
        recyclerViewWorkSummary.adapter = adapter
        recyclerViewWorkSummary.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    private fun setWorkSummaryAdapter(workSummaryList: List<ResumeWorkSummaryItem>) {
        Log.d("AAA","${workSummaryList.size}")
        resumeWorkSummaryAdapter.setItems(workSummaryList)
    }

    private fun openGallery() {
        val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        startActivityForResult(gallery, PICK_IMAGE)
    }

    private fun observeFormErrors() {

    }

    private fun renderImageURI(imageUri: Uri?) {
        binding.imageViewAvatar.setImageURI(imageUri)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            renderImageURI(data?.data)
        }
    }

    companion object {
        fun newInstance() = ResumeInputFragment()

        const val PICK_IMAGE = 100
    }
}
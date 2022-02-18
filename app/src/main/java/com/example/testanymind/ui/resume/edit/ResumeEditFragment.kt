package com.example.testanymind.ui.resume.edit

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.*
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.testanymind.R
import com.example.testanymind.databinding.FragmentResumeEditBinding
import com.example.testanymind.ui.base.BaseFragment
import com.example.testanymind.ui.resume.input.ResumeInputFragment
import com.example.testanymind.ui.resume.input.adapter.educationdetails.ResumeEducationDetailAdapter
import com.example.testanymind.ui.resume.input.adapter.educationdetails.ResumeEducationDetailItem
import com.example.testanymind.ui.resume.input.adapter.projectdetails.ResumeProjectDetailAdapter
import com.example.testanymind.ui.resume.input.adapter.projectdetails.ResumeProjectDetailItem
import com.example.testanymind.ui.resume.input.adapter.skill.ResumeSkillAdapter
import com.example.testanymind.ui.resume.input.adapter.skill.ResumeSkillItem
import com.example.testanymind.ui.resume.input.adapter.worksummary.ResumeWorkSummaryAdapter
import com.example.testanymind.ui.resume.input.adapter.worksummary.ResumeWorkSummaryItem
import com.example.testanymind.ui.resume.input.dialog.educationdetail.EducationDetailBottomSheetDialog
import com.example.testanymind.ui.resume.input.dialog.projectdetail.ProjectDetailBottomSheetDialog
import com.example.testanymind.ui.resume.input.dialog.skill.SkillBottomSheetDialog
import com.example.testanymind.ui.resume.input.dialog.worksummary.WorkSummaryBottomSheetDialog
import com.example.testanymind.utill.MediaUtils
import org.koin.android.viewmodel.ext.android.viewModel
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


class ResumeEditFragment : BaseFragment<ResumeEditViewModel, FragmentResumeEditBinding>() {

    private val args by navArgs<ResumeEditFragmentArgs>()

    private val resumeWorkSummaryAdapter: ResumeWorkSummaryAdapter by lazy {
        ResumeWorkSummaryAdapter()
    }

    private val resumeSkillAdapter: ResumeSkillAdapter by lazy {
        ResumeSkillAdapter()
    }

    private val resumeEducationDetailAdapter: ResumeEducationDetailAdapter by lazy {
        ResumeEducationDetailAdapter()
    }

    private val resumeProjectDetailAdapter: ResumeProjectDetailAdapter by lazy {
        ResumeProjectDetailAdapter()
    }

    override val viewModel : ResumeEditViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.fragment_resume_edit

    override fun initView() {
        initRecyclerView()
        initAction()
    }

    override fun initViewModel() {
        binding.viewModel = viewModel

        viewModel.setUp(args.resumeId)
        viewModel.resumeWorkSummaryList.observe(viewLifecycleOwner, ::setWorkSummaryAdapter)
        viewModel.resumeSkillList.observe(viewLifecycleOwner, ::setSkillAdapter)
        viewModel.resumeEducationDetailList.observe(viewLifecycleOwner, ::setEducationDetailAdapter)
        viewModel.resumeProjectDetailList.observe(viewLifecycleOwner, ::setProjectDetailAdapter)

        viewModel.picture.observe(viewLifecycleOwner,{
            renderImageBitmap(MediaUtils.stringToBitmap(it))
        })

        viewModel.updateResumeSuccess.observe(viewLifecycleOwner, {
            navigateBack()
        })
    }

    private fun initAction() {
        binding.relativeLayoutProfileImage.setOnClickListener {
            openGallery()
        }

        binding.buttonAddWorkSummary.setOnClickListener {
            openWorkSummaryDialog()
        }

        binding.buttonAddSkill.setOnClickListener {
            openSkillsDialog()
        }

        binding.buttonAddEducationDetails.setOnClickListener {
            openEducationDetailsDialog()
        }

        binding.buttonAddProjectDetails.setOnClickListener {
            openProjectDetailsDialog()
        }

        binding.buttonUpdateResume.setOnClickListener {
            viewModel.updateResume()
        }
    }

    private fun navigateBack() {
        findNavController().popBackStack()
    }

    private fun initRecyclerView() {
        setupWorkSummaryAdapter(resumeWorkSummaryAdapter)
        setupEducationDetailAdapter(resumeEducationDetailAdapter)
        setupSkillAdapter(resumeSkillAdapter)
        setupProjectDetailAdapter(resumeProjectDetailAdapter)
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

    private fun setupSkillAdapter(adapter: ResumeSkillAdapter) = with(binding) {
        recyclerViewSkill.itemAnimator = null
        recyclerViewSkill.adapter = adapter
        recyclerViewSkill.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    private fun setupEducationDetailAdapter(adapter: ResumeEducationDetailAdapter) = with(binding) {
        recyclerViewEducationDetails.itemAnimator = null
        recyclerViewEducationDetails.adapter = adapter
        recyclerViewEducationDetails.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    private fun setupProjectDetailAdapter(adapter: ResumeProjectDetailAdapter) = with(binding) {
        recyclerViewProjectDetails.itemAnimator = null
        recyclerViewProjectDetails.adapter = adapter
        recyclerViewProjectDetails.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    private fun setWorkSummaryAdapter(workSummaryList: List<ResumeWorkSummaryItem>) {
        resumeWorkSummaryAdapter.setItems(workSummaryList)
    }

    private fun setSkillAdapter(workSummaryList: List<ResumeSkillItem>) {
        resumeSkillAdapter.setItems(workSummaryList)
    }

    private fun setEducationDetailAdapter(workSummaryList: List<ResumeEducationDetailItem>) {
        resumeEducationDetailAdapter.setItems(workSummaryList)
    }

    private fun setProjectDetailAdapter(workSummaryList: List<ResumeProjectDetailItem>) {
        resumeProjectDetailAdapter.setItems(workSummaryList)
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, PICK_IMAGE)
    }

    private fun openWorkSummaryDialog() {
        val workSummaryDialog: WorkSummaryBottomSheetDialog =
            WorkSummaryBottomSheetDialog.newInstance()
        workSummaryDialog.show(requireFragmentManager(), "Bottom Sheet Dialog Fragment")
        workSummaryDialog.setListeners { item , action ->
            viewModel.handleWorkSummaryClick(item, action)
            workSummaryDialog.dismiss()
        }
    }

    private fun openSkillsDialog() {
        val skillBottomSheetDialog: SkillBottomSheetDialog =
            SkillBottomSheetDialog.newInstance()
        skillBottomSheetDialog.show(requireFragmentManager(), "Bottom Sheet Dialog Fragment")
        skillBottomSheetDialog.setListeners { item , action ->
            viewModel.handleSkillClick(item, action)
            skillBottomSheetDialog.dismiss()
        }
    }

    private fun openEducationDetailsDialog() {
        val educationDetailBottomSheetDialog: EducationDetailBottomSheetDialog =
            EducationDetailBottomSheetDialog.newInstance()
        educationDetailBottomSheetDialog.show(requireFragmentManager(), "Bottom Sheet Dialog Fragment")
        educationDetailBottomSheetDialog.setListeners { item , action ->
            viewModel.handleEducationDetailClick(item, action)
            educationDetailBottomSheetDialog.dismiss()
        }
    }

    private fun openProjectDetailsDialog() {
        val projectDetailBottomSheetDialog: ProjectDetailBottomSheetDialog =
            ProjectDetailBottomSheetDialog.newInstance()
        projectDetailBottomSheetDialog.show(requireFragmentManager(), "Bottom Sheet Dialog Fragment")
        projectDetailBottomSheetDialog.setListeners { item , action ->
            viewModel.handleProjectDetailClick(item, action)
            projectDetailBottomSheetDialog.dismiss()
        }
    }


    private fun renderImageBitmap(bitmap: Bitmap) {
        binding.imageViewAvatar.load(bitmap)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode != ResumeInputFragment.GALLERY || resultCode != RESULT_OK) {
            return
        }

        val imageUri = data?.data ?: return
        val bitmap = MediaUtils.loadFromGallery(this.requireContext(), imageUri)
        renderImageBitmap(bitmap)
    }

    companion object {
        const val PICK_IMAGE = 1012
    }
}
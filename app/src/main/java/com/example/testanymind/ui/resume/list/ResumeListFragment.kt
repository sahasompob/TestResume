package com.example.testanymind.ui.resume.list

import android.util.Log
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testanymind.R
import com.example.testanymind.databinding.FragmentResumeListBinding
import com.example.testanymind.ui.base.BaseFragment
import com.example.testanymind.ui.resume.list.adapter.ResumeListAdapter
import com.example.testanymind.ui.resume.list.adapter.ResumeListItem
import org.koin.android.viewmodel.ext.android.viewModel

class ResumeListFragment : BaseFragment<ResumeListViewModel, FragmentResumeListBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_resume_list

    private val resumeListAdapter: ResumeListAdapter by lazy {
        ResumeListAdapter()
    }

    override fun initView() {
        initRecyclerView()

        binding.buttonAddResume.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_list_resume_fragment_to_input_resume_fragment)
        }
    }

    override fun initViewModel() {
        viewModel.setUp()

        viewModel.resumeList.observe(viewLifecycleOwner, ::setResumeListAdapter)
    }

    override val viewModel: ResumeListViewModel by viewModel()

    private fun initRecyclerView() {
        (setupResumeListAdapter(resumeListAdapter))
    }

    private fun setupResumeListAdapter(adapter: ResumeListAdapter) = with(binding) {
        recyclerViewResumeList.itemAnimator = null
        recyclerViewResumeList.adapter = adapter
        recyclerViewResumeList.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    private fun setResumeListAdapter(items: List<ResumeListItem>) {
        resumeListAdapter.setItems(items)
        resumeListAdapter.setOnClickListener(this::onEditClick)
    }

    private fun onEditClick(id: String) {
        navigateToEditResumeScreen(id)
    }

    private fun navigateToEditResumeScreen(resumeId: String) {
        val bundle = bundleOf("resumeId" to resumeId)
        findNavController().navigate(
            R.id.action_list_resume_fragment_to_edit_resume_fragment,
            bundle
        )
    }
}
package com.example.testanymind.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VM : BaseViewModel, DB : ViewDataBinding> : Fragment() {
    protected abstract val viewModel: VM
    protected lateinit var binding: DB

    @LayoutRes
    protected abstract fun getLayoutId(): Int
    protected abstract fun initView()
    protected abstract fun initViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
        }

        initView()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
    }
}

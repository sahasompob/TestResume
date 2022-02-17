package com.example.testanymind

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testanymind.ui.resume.input.ResumeInputFragment
import com.example.testanymind.ui.resume.list.ResumeListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}
package com.kylecorry.andromeda_template.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kylecorry.andromeda.fragments.BoundFragment
import com.kylecorry.andromeda_template.databinding.FragmentMainBinding

class MainFragment : BoundFragment<FragmentMainBinding>() {
    override fun generateBinding(
        layoutInflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainBinding {
        return FragmentMainBinding.inflate(layoutInflater, container, false)
    }
}
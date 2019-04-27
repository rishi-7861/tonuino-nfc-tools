package com.example.myapplication

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.util.Log
import java.lang.RuntimeException

class EditPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        Log.i("EditPagerAdapter", "position = $position")
        return when (position) {
            0 ->
                EditSimple()
            1 ->
                EditExtended()
            2 ->
                EditExtended()
            else ->
                throw RuntimeException("Only supports 2 items")
        }
    }

    override fun getCount(): Int {
        return 3
    }
}
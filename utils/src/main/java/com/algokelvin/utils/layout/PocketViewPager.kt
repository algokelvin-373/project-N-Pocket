package com.algokelvin.utils.layout

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent

class PocketAppsViewPager(context: Context, attributeSet: AttributeSet) : androidx.viewpager.widget.ViewPager(context, attributeSet) {
    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(ev: MotionEvent?): Boolean = false

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean = false
}
package com.ddd.android.session

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import com.google.android.material.internal.ThemeEnforcement
import com.google.android.material.slider.RangeSlider

@SuppressLint("RestrictedApi")
class DDDSlider @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr : Int = R.attr.sliderStyle
) : RangeSlider(context, attrs, defStyleAttr) {

    init {
        val a = ThemeEnforcement.obtainStyledAttributes(context, attrs, R.styleable.Slider, defStyleAttr, 0)


        a.recycle()
    }





}
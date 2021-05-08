package com.ddd.android.session

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import com.google.android.material.button.MaterialButton
import com.google.android.material.internal.ThemeEnforcement

@SuppressLint("RestrictedApi", "ResourceType")
class DDDButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = R.attr.materialButtonStyle
) : MaterialButton(context, attrs, defStyleAttr) {

    companion object {
        private val DEF_STYLE_RES = com.google.android.material.R.style.Widget_MaterialComponents_Button
    }

    init {
        // enforce material style
        val a = ThemeEnforcement.obtainStyledAttributes(context, attrs, R.styleable.DDDButton, defStyleAttr, DEF_STYLE_RES)

        val textColor = a.getColor(R.styleable.DDDButton_android_textColor, android.R.color.darker_gray)
        a.recycle()
    }

}
package com.ddd.android.session

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.ColorInt
import androidx.annotation.Px
import androidx.core.view.setPadding
import androidx.core.view.updateLayoutParams

class DDDProgressBar : FrameLayout {

    @ColorInt var progressBackgroundColor = Color.WHITE
        set(value) {
            field = value
            updateProgressBar()
        }
    @ColorInt var progressForegroundColor = Color.GREEN
        set(value) {
            field = value
            updateProgressBar()
        }
    @Px var radius = 12.dp()
        set(value) {
            field = value
            updateProgressBar()
        }
    @Px var borderSize = 2.dp()
        set(value) {
            field = value
            updateProgressBar()
        }
    @ColorInt var borderColor = Color.BLACK
        set(value) {
            field = value
            updateProgressBar()
        }
    @Px var progressBarWidth = 200.dp()
        set(value){
            field = value
            updateProgressBar()
        }
    @Px var progressBarHeight = 72.dp()
        set(value){
            field = value
            updateProgressBar()
        }
    var progress = 0.3f
        set(value){
            field = value
            updateProgressBar()
        }
    private val progressView = View(context)

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : this(context, attrs, defStyleAttr, 0)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)
    {
        val a = context.obtainStyledAttributes(attrs, R.styleable.DDDProgressBar)
        progress = a.getFloat(R.styleable.DDDProgressBar_progress, this.progress)
        progressBarWidth = a.getDimension(R.styleable.DDDProgressBar_android_layout_width, this.progressBarWidth)
        progressBarHeight = a.getDimension(R.styleable.DDDProgressBar_android_layout_height, this.progressBarHeight)
        progressForegroundColor = a.getColor(R.styleable.DDDProgressBar_progressBarForeground, this.progressForegroundColor)
        progressBackgroundColor = a.getColor(R.styleable.DDDProgressBar_progressBarBackground, this.progressBackgroundColor)
        borderSize = a.getDimension(R.styleable.DDDProgressBar_strokeWidth, this.borderSize)
        borderColor = a.getColor(R.styleable.DDDProgressBar_strokeColor, this.borderColor)
        radius = a.getDimension(R.styleable.DDDProgressBar_android_radius, this.radius)
        a.recycle()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

    }

    private fun updateProgressBar(){
        updateSize()
        updateBackground()
        updateProgress()
        updateChildViews()
    }

    private fun updateSize() {
        post {
            updateLayoutParams {
                width = progressBarWidth.toInt()
                height = progressBarHeight.toInt()
            }
        }
    }

    private fun updateBackground() {
        background = GradientDrawable().apply {
            cornerRadius = radius
            setColor(progressBackgroundColor)
            setPadding(borderSize.toInt())
            if (borderSize != 0f) {
                setStroke(borderSize.toInt(), borderColor)
            }
        }
    }

    private fun updateProgress() {
        with(progressView) {
            background = GradientDrawable().apply {
                cornerRadius = radius
                setColor(progressForegroundColor)
            }
        }
    }

    private fun updateChildViews() {
        removeAllViews()
        addProgressView()
        invalidate()
    }

    private fun addProgressView() {
        val progressHeight = (progressBarHeight - borderSize * 2).toInt()
        val progressTotalWidth = progressBarWidth - borderSize * 2
        val progressCurrentWidth = (progressTotalWidth * progress).toInt()
        addView(progressView, progressCurrentWidth, progressHeight)
    }
}


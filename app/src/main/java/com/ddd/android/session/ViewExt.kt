package com.ddd.android.session

import android.content.Context
import android.content.res.Resources
import android.view.View
import android.view.ViewGroup
import android.view.ViewPropertyAnimator
import android.widget.FrameLayout
import androidx.annotation.Dimension
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager

// view.layoutParams.width = 10.dp() same in xml android:layout_width="10dp"
@Dimension fun Float.dp() = (this * Resources.getSystem().displayMetrics.density)
@Dimension fun Double.dp() = (this * Resources.getSystem().displayMetrics.density)
@Dimension fun Int.dp() = (this * Resources.getSystem().displayMetrics.density)
@Dimension fun Long.dp() = (this * Resources.getSystem().displayMetrics.density)

// textview.textSize = 10.sp() same in xml android:textSize="10sp"
fun Float.sp() = (this * Resources.getSystem().displayMetrics.scaledDensity)
fun Double.sp() = (this * Resources.getSystem().displayMetrics.scaledDensity)
fun Int.sp() = (this * Resources.getSystem().displayMetrics.scaledDensity)
fun Long.sp() = (this * Resources.getSystem().displayMetrics.scaledDensity)

/** dp size to px size. */
internal fun Context.dp2Px(@Dimension dp: Int): Int {
    val scale = resources.displayMetrics.density
    return (dp * scale).toInt()
}

/** dp size to px size. */
internal fun Context.dp2Px(@Dimension dp: Float): Int {
    val scale = resources.displayMetrics.density
    return (dp * scale).toInt()
}

/** translates view's x position to destination. */
internal fun View.translateX(duration: Long, destination: Float): ViewPropertyAnimator {
    return this.animate()
        .setDuration(duration)
        .translationX(destination)
        .withLayer()
}

/** translates view's y position to destination. */
internal fun View.translateY(duration: Long, destination: Float): ViewPropertyAnimator {
    return this.animate()
        .setDuration(duration)
        .translationY(destination)
        .withLayer()
}

/** animates view's x and y scale size. */
internal fun View.animateScale(toX: Float, toY: Float, duration: Long): ViewPropertyAnimator {
    return this.animate()
        .scaleX(toX)
        .scaleY(toY)
        .setDuration(duration)
        .withLayer()
}

/** animates view's alpha value. */
internal fun View.animateFade(alpha: Float, duration: Long): ViewPropertyAnimator {
    return this.animate()
        .alpha(alpha)
        .setDuration(duration)
        .withLayer()
}

/** begins delayed transition. */
internal fun ViewGroup.beginDelayedTransition(duration: Long) {
    TransitionManager.beginDelayedTransition(this, ChangeBounds().setDuration(duration))
}
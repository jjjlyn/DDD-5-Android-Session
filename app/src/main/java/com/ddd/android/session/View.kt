package com.ddd.android.session

import android.content.Context
import android.content.res.Resources
import androidx.annotation.Dimension

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
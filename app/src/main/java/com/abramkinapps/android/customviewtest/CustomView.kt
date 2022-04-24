package com.abramkinapps.android.customviewtest

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defaultAttrs: Int = 0
) : SurfaceView(context, attrs, defaultAttrs) {

    private val path: Path = Path()
    private val surfaceHolder: SurfaceHolder = holder.apply { setFormat(PixelFormat.TRANSPARENT) }
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply { style = Paint.Style.STROKE }

    private var strokeColor = Color.BLACK
        set(value) {
            paint.color = value
            field = value
        }

    private var strokeWidth = 10F
        set(value) {
            paint.strokeWidth = value
            field = value
        }

    init {

        setZOrderOnTop(true)

        context.theme.obtainStyledAttributes(attrs, R.styleable.CustomView, 0, 0).apply {

            strokeColor = getColor(R.styleable.CustomView_stroke_color, Color.GREEN)
            strokeWidth = getDimension(R.styleable.CustomView_stroke_width, 10F)

            recycle()
        }

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        when (event?.action) {
            MotionEvent.ACTION_DOWN -> { path.moveTo(event.x, event.y) }
            MotionEvent.ACTION_MOVE -> { path.lineTo(event.x, event.y) }
            MotionEvent.ACTION_UP   -> { path.lineTo(event.x, event.y) }
        }

        surfaceHolder.unlockCanvasAndPost(surfaceHolder.lockCanvas().also { it.drawPath(path, paint)})

        return true
    }

}
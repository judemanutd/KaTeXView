package com.judemanutd.katexview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.webkit.WebSettings
import android.webkit.WebView
import com.x5.template.Chunk
import com.x5.template.Theme
import com.x5.template.providers.AndroidTemplates
import androidx.core.content.ContextCompat

@SuppressLint("SetJavaScriptEnabled")
class KatexView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    WebView(context, attrs, defStyleAttr) {

    private val TAG_FORMULA: String = "formula"
    private val TAG_TEXT_COLOR: String = "textColor"

    private var mText: String? = null
    //TODO: pick theme set text color
    private var mTextColor: Int = android.R.color.black

    init {
        settings.allowFileAccess = true
        settings.javaScriptEnabled = true
        settings.cacheMode = WebSettings.LOAD_NO_CACHE
        settings.displayZoomControls = false
        settings.builtInZoomControls = false
        settings.setSupportZoom(false)
        settings.useWideViewPort = false

        setBackgroundColor(Color.TRANSPARENT);

        val mTypeArray = context.obtainStyledAttributes(attrs, R.styleable.KatexView, 0, 0)

        try {
            setTextColor(
                mTypeArray.getColor(
                    R.styleable.KatexView_textColor,
                    ContextCompat.getColor(getContext(), android.R.color.black)
                )
            )

            val text: String? = mTypeArray.getString(R.styleable.KatexView_text)
            if (text != null)
                setText(text)
        } finally {
            mTypeArray.recycle()
        }

    }

    fun setText(text: String) {
        mText = text
        loadData()
    }

    fun setTextColor(color: Int) {
        this.mTextColor = color
        loadData()
    }

    fun getText(): String? {
        return mText
    }

    private fun loadData() {
        if (mText != null) {
            val chunk: Chunk = getChunk()
            chunk.set(TAG_FORMULA, mText)
            chunk.set(TAG_TEXT_COLOR, getHexColor(mTextColor))
            this.loadDataWithBaseURL(null, chunk.toString(), "text/html", "utf-8", "about:blank")
        }

    }

    private fun getChunk(): Chunk {
        val loader = AndroidTemplates(context)
        return Theme(loader).makeChunk("katex")
    }

    private fun getHexColor(intColor: Int): String {
        //Android and javascript color format differ javascript support Hex color,
        // so the android color which user sets is converted to hexcolor to replicate the same in javascript.
        return String.format("#%06X", 0xFFFFFF and intColor)
    }

}
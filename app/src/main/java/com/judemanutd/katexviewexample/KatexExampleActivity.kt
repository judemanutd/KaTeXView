package com.judemanutd.katexviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_katex_example.*

class KatexExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_katex_example)

        val text = "$$ c = \\pm\\sqrt{a^2 + b^2} $$"

        katex_text.setText(text)
    }
}

package com.example.mytestingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvText: TextView

    private var names = ArrayList<String>()

    private var isChanged = false

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvText = findViewById(R.id.tv_text)

        val btnSetValue: Button = findViewById(R.id.btn_set_value)
        btnSetValue.setOnClickListener(this)

        names.add("Narendra Wicaksono")
        names.add("Kevin")
        names.add("Yoza")
    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btn_set_value) {
            Log.d(TAG, "names: ${names}")
            Log.d(TAG, "isChange: ${isChanged}")
            if (!isChanged) {
                val name = StringBuilder()
                for (i in 0 until names.size) {
                    name.append(names[i]).append("\n")
                }
                isChanged = true
                tvText.text = name.toString()
            } else {
                isChanged = false
                tvText.text = getString(R.string.hello_world)
            }
        }
    }
}
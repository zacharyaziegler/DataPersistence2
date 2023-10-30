package edu.farmingdale.alrajab.bcs421.database

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import edu.farmingdale.alrajab.bcs421.R

class SharedPrefActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)

        val sharedPreference =  getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()

        val etFirst = findViewById<EditText>(R.id.et_first)
        val etLast = findViewById<EditText>(R.id.et_last)
        val btnSave = findViewById<Button>(R.id.btn_save)
        val btnRead = findViewById<Button>(R.id.btn_read)
        val tvFirst = findViewById<TextView>(R.id.tv_output_first)
        val tvLast = findViewById<TextView>(R.id.tv_output_last)

        btnSave.setOnClickListener{
            editor.putString("first", etFirst.text.toString())
            editor.putString("last", etLast.text.toString())
            editor.commit()
        }

        btnRead.setOnClickListener{
            val first = sharedPreference.getString("first", "")
            val last = sharedPreference.getString("last", "")
            tvFirst.text = "Output First: $first"
            tvLast.text = "Output Last: $last"
        }


    }
}
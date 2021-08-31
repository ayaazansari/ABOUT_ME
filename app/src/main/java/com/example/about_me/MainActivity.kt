package com.example.about_me

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.*
import com.example.about_me.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val myName  :MyName = MyName("Ayaaz Ansari")

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this,R.layout.activity_main)

        binding.myName= myName

//        val clickButton :Button = findViewById(R.id.done_button)
//        clickButton.setOnClickListener {
//            addNickName(it)
//        }

        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
    }
    private fun addNickName(view:View)
    {

        binding.myName.nickname  = binding.nicknameEdit.text.toString()
        binding.nicknameEdit.visibility = View.GONE
        binding.doneButton.visibility = View.GONE
        binding.nicknameText.visibility = View.VISIBLE
//        val editText:EditText = findViewById(R.id.nickname_edit)
//        val nickNameTextView: TextView = findViewById(R.id.nickname_text)
//
//        nickNameTextView.text = editText.text
//        editText.visibility = View.GONE
//        nickNameTextView.visibility = View.VISIBLE
        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
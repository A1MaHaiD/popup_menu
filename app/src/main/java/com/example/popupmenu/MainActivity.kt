package com.example.popupmenu

import android.graphics.Color
import android.graphics.Color.red
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import com.example.popupmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val popupMenu2 = PopupMenu(this, binding.button)
        popupMenu2.inflate(R.menu.popup_menu)
        popupMenu2.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.red -> {
                    binding.textView.background = ColorDrawable(Color.RED)
                    binding.textView.text = "Вы выбрали красный цвет"
                }
                R.id.yellow -> {
                    binding.textView.background = ColorDrawable(Color.YELLOW)
                    binding.textView.text = "Вы выбрали жёлтый цвет"
                }
                R.id.green -> {
                    binding.textView.background = ColorDrawable(Color.GREEN)
                    binding.textView.text = "Вы выбрали зелёный цвет"
                }
            }
            false
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            popupMenu2.setForceShowIcon(true)
        }

           binding.button.setOnClickListener {
            popupMenu2.show()
        }


        val view = binding.root
        setContentView(view)
    }
}
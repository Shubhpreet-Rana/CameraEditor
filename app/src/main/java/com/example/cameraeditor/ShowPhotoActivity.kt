@file:Suppress("DEPRECATION")

package com.example.cameraeditor

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity
import com.dsphotoeditor.sdk.utils.DsPhotoEditorConstants
import com.example.cameraeditor.databinding.ActivityShowPhotoBinding

class ShowPhotoActivity : AppCompatActivity() {

    private var _binding: ActivityShowPhotoBinding? = null
    private val binding get() = _binding!!
    private var path: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityShowPhotoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        path = intent.getStringExtra("path").toString()

        binding.editImage.setImageURI(Uri.parse(path))


        binding.editButton.setOnClickListener {

            intent = Intent(this, EditorActivity::class.java)
                .putExtra("path", path)

            startActivity(intent)
        }

    }

}
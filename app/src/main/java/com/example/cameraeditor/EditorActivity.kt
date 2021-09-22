@file:Suppress("DEPRECATION")

package com.example.cameraeditor

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity
import com.dsphotoeditor.sdk.utils.DsPhotoEditorConstants
import com.example.cameraeditor.databinding.ActivityEditorBinding
import java.io.File

class EditorActivity : AppCompatActivity() {

    private var _binding : ActivityEditorBinding ?= null
    private val binding get() = _binding!!

    private var path : String = ""
    private lateinit var imageUri : Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityEditorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        path = intent.getStringExtra("path").toString()
        var imgFile : File = File(path)

        if (imgFile.exists()){
            var bitmap : Bitmap = BitmapFactory.decodeFile(imgFile.absolutePath)
            binding.imageView.setImageBitmap(bitmap)
        }

        imageUri = Uri.fromFile(File(path))
        editTrial()
    }

    public fun editTrial(){
        intent = Intent(this, DsPhotoEditorActivity::class.java).setData(Uri.parse(path))
            .putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_OUTPUT_DIRECTORY, "DCIM")

        startActivityForResult(intent,200)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    if (resultCode == RESULT_OK)
        when (requestCode){
            200 -> {
                var outputUri: Uri? = data?.data
                binding.imageView.setImageURI(outputUri)
            }
        }
    }
}
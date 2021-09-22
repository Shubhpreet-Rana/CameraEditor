package com.example.cameraeditor

import android.Manifest

object Constants {

    const val TAG = "Camerax"
    const val FILE_NAME_FORMAT = "yy-MM-dd-hh-mm-ss-SSS"
    const val REQUEST_CODE_PERMISSION = 123
    val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE)
}
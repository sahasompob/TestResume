package com.example.testanymind.utill

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.net.Uri
import android.util.Base64
import android.view.View
import java.io.ByteArrayOutputStream

object MediaUtils {

    fun loadFromGallery(context: Context, imageUri: Uri): Bitmap {
        return context.contentResolver.openInputStream(imageUri).use {
            BitmapFactory.decodeStream(it)
        }
    }

    fun stringToBitmap(imageString: String): Bitmap {
        val imageBytes = Base64.decode(imageString, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
    }

    fun uriToString(context: Context, imageUri: Uri): String {
        val input = context.contentResolver.openInputStream(imageUri)
        val image = BitmapFactory.decodeStream(input, null, null)

        val byteArrayOutputStream = ByteArrayOutputStream()
        image?.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)
        val imageBytes = byteArrayOutputStream.toByteArray()

        return Base64.encodeToString(imageBytes, Base64.DEFAULT)
    }

    fun getBitmap(view: View): Bitmap {
        val width = view.measuredWidth
        val height = view.measuredHeight

        if (width == 0 || height == 0) {
            throw IllegalStateException("Width or height cannot be 0")
        }

        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        canvas.drawColor(Color.WHITE)

        view.draw(canvas)

        return Bitmap.createBitmap(bitmap, 0, 0, width, height)
    }
}
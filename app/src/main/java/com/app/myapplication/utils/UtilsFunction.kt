package com.app.myapplication.utils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import com.app.myapplication.R
import com.app.myapplication.databinding.DialogWrongAccountBinding

object UtilsFunction {
    fun showDialogError(context: Context) : Dialog {
        val dialog = Dialog(context, R.style.Theme_Dialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        val dialogWrongAccountBinding = DialogWrongAccountBinding.inflate(LayoutInflater.from(context))
        dialog.setContentView(dialogWrongAccountBinding.root)
        dialogWrongAccountBinding.btnOk.setOnClickListener {
            dialog.dismiss()
        }
        return dialog
    }
}
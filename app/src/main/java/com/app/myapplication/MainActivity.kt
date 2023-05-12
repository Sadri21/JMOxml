package com.app.myapplication

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.app.myapplication.databinding.ActivityMainBinding
import com.app.myapplication.realm.User
import com.app.myapplication.utils.UserViewModel
import com.app.myapplication.utils.UtilsFunction.showDialogError

class MainActivity : AppCompatActivity() {

    lateinit var viewBinding : ActivityMainBinding
    var email = ""
    var password = ""
    var isEmailValid = false
    var viewModel = UserViewModel()
    var listUser = listOf<User>()
    lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(viewBinding.root)
        supportActionBar!!.hide()
        dialog = showDialogError(this)
        viewBinding.etEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                email = s.toString()
                isEmailValid = isEmailValid(email)
                if (!isEmailValid) {
                    viewBinding.tilEmail.error = "Email tidak valid"
                } else {
                    viewBinding.tilEmail.error = null
                }
                checkButtonState(isEmailValid, password, email)
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        viewBinding.etPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                password = s.toString()
                checkButtonState(isEmailValid, password, email)
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
        viewModel.addUserToRealm()
        viewModel.getUser()
        viewModel.user.observe(this) {
            listUser = it
        }
        viewBinding.btnLogin.setOnClickListener {
            if (listUser.any { it.userName == email && it.password == password }) {
                val intent = Intent(this, DashboardActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
            } else {
                dialog.show()
            }
        }
    }

    fun checkButtonState(isValid: Boolean, password: String, email: String) {
        if (isValid && password != "" && email != "") {
            viewBinding.btnLogin.isEnabled = true
            viewBinding.btnLogin.setBackgroundColor(ContextCompat.getColor(this, R.color.md_green_600))
        } else {
            viewBinding.btnLogin.isEnabled = false
            viewBinding.btnLogin.setBackgroundColor(ContextCompat.getColor(this, R.color.md_grey_500))
        }
    }

    fun isEmailValid(email: String): Boolean {
        val emailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$")
        return emailRegex.matches(email)
    }



}


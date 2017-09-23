package com.awtia.fartsy.sign_in

import android.text.InputType
import com.awtia.fartsy.R
import org.jetbrains.anko.*

/**
 * Created by csaba.dobai on 18-09-17.
 */

class SignInView : AnkoComponent<SignInActivity> {

    private lateinit var ankoContext: AnkoContext<SignInActivity>

    override fun createView(ui: AnkoContext<SignInActivity>) = with(ui) {
        verticalLayout {
            lparams(width = matchParent, height = matchParent)

            val username = editText {
                id = R.id.usernameEditText
                hintResource = R.string.sign_in_username
                textSize = 24f
                singleLine = true
            }.lparams(width = matchParent, height = wrapContent)


            val password = editText {
                id = R.id.passwordEditText
                inputType = InputType.TYPE_CLASS_TEXT
                hintResource = R.string.sign_in_password
                textSize = 24f
                singleLine = true
            }.lparams(width = matchParent, height = wrapContent)


            button {
                id = R.id.signInButton
                textResource = R.string.sign_in_button

                onClick {
                    handleOnSignInButtonPressed(ui = ui, username = username.text.toString(), password = password.text.toString())
                }
            }.lparams(width = matchParent, height = wrapContent)

            textView {
                text = "Hello world"
            }.lparams(width = matchParent, height = wrapContent)
        }
    }

    private fun handleOnSignInButtonPressed(ui: AnkoContext<SignInActivity>, username: String, password: String) {
        if (username.isBlank() || password.isBlank()) {
            with(ui) {
                alert(title = R.string.sign_in_alert_invalid_user_title, message = R.string.sign_in_alert_invalid_user_message) {
                    positiveButton(R.string.dialog_button_close) {}
                }.show()
            }
        } else {
            ui.owner.authorizeUser(username, password)
        }
    }

    fun showAccessDeniedAlertDialog() {
        with(ankoContext) {
            alert(title = R.string.sigIn_alert_access_denied_title,
                    message = R.string.sigIn_alert_access_denied_msg) {

                positiveButton(R.string.dialog_button_close) {}
            }.show()
        }
    }
}
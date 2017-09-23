package com.awtia.fartsy.sign_in

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.awtia.fartsy.sign_in.bl.ISignInBL
import com.awtia.fartsy.sign_in.bl.SignInBL
import com.awtia.fartsy.sign_in.model.AuthCredentials
import org.jetbrains.anko.activityUiThread
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast

class SignInActivity : AppCompatActivity() {
    private val signInBL: ISignInBL = SignInBL()
    private lateinit var view: SignInView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = SignInView()
        view.setContentView(this)

//        startActivity(intentFor<SignInActivity>())
//        finish()
    }

    fun authorizeUser(username: String, password: String) {
        doAsync {
            val authorized = signInBL.checkUserCredentials(AuthCredentials(username = username, password = password))

            activityUiThread {
                if (authorized) {
                    toast("Hello!")
                } else {
                    view.showAccessDeniedAlertDialog()
                }
            }
        }
    }
}

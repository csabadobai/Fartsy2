package com.awtia.fartsy.sign_in.bl

import com.awtia.fartsy.sign_in.model.AuthCredentials

/**
 * Created by csaba.dobai on 19-09-17.
 */
class SignInBL : ISignInBL {
    override fun checkUserCredentials(credentials: AuthCredentials): Boolean {
        return ("csaba".equals(credentials.username) && ("qwerty".equals(credentials.password)))
    }
}
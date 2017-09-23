package com.awtia.fartsy.sign_in.bl

import com.awtia.fartsy.sign_in.model.AuthCredentials

/**
 * Created by csaba.dobai on 19-09-17.
 */
interface ISignInBL {
    fun checkUserCredentials(credentials: AuthCredentials): Boolean
}
package ru.toxyxd.adguardhome.data.controller

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ConnectionController @Inject constructor() {
    private var session = ""

    fun getSession() = session


    /**
     * Set session
     *
     * @param session Base64 encoded session (username:password)
     */
    fun setSession(session: String) {
        this.session = session
    }


    /**
     * Set session
     *
     * @param username
     * @param password
     */
    fun setSession(username: String, password: String) {
        val data = "$username:$password"
        this.session =
            android.util.Base64.encodeToString(data.toByteArray(), android.util.Base64.DEFAULT)
    }

    fun clearSession() {
        this.session = ""
    }

    fun hasSession() = session.isNotEmpty()
}
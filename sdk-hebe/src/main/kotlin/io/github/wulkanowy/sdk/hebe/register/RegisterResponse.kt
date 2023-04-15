package io.github.wulkanowy.sdk.hebe.register

import kotlinx.serialization.SerialName

data class RegisterResponse(

    @SerialName("LoginId")
    val loginId: Int,

    @SerialName("RestURL")
    val restUrl: String,

    @SerialName("UserLogin")
    val userLogin: String,

    @SerialName("UserName")
    val userName: String,
)

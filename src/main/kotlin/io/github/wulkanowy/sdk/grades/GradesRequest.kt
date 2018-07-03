package io.github.wulkanowy.sdk.grades

import com.google.gson.annotations.SerializedName
import io.github.wulkanowy.sdk.base.BaseRequest

data class GradesRequest(

    @SerializedName("IdOddzial")
    val classId: Int,

    @SerializedName("IdOkresKlasyfikacyjny")
    val classificationPeriodId: Int,

    @SerializedName("IdUczen")
    val studentId: Int
) : BaseRequest()

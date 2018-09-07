package io.github.wulkanowy.api.repository

import io.github.wulkanowy.api.register.Semester
import io.github.wulkanowy.api.service.StudentAndParentService
import io.reactivex.Observable
import io.reactivex.Single

class StudentAndParentStartRepository(
        private val symbol: String,
        private val schoolId: String,
        private val studentId: String,
        private val api: StudentAndParentService
) {

    fun getSemesters(): Single<List<Semester>> {
        return api.getUserInfo(studentId).flatMapObservable { Observable.fromIterable(it.diaries.reversed()) }.flatMapSingle { diary ->
            api.getDiaryInfo(diary.id, "/$symbol/$schoolId/Oceny.mvc/Wszystkie").map { res ->
                res.semesters.map {
                    Semester(diary.id, diary.name, it.semesterId, it.semesterNumber,"selected" == it.current && "selected" == diary.current)
                }
            }
        }.toList().map { it.flatten() }
    }
}

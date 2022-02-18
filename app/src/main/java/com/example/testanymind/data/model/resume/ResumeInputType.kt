package com.example.testanymind.data.model.resume

data class ResumeInputType(
    val items: Map<InputType, String>
){
    enum class InputType(
        val errorString: String
    ) {
        PICTURE(
            "picture error"
        ),
        MOBILE_NUMBER(
            "mobile error"
        ),
        RESIDENCE_ADDRESS(
            "residence address error"
        ),
        EMAIL(
            "email error"
        ),
        CAREER_OBJ(
            "careerObjective error"
        ),
        TOTAL_YEAR(
            "total year error"
        )
    }
}
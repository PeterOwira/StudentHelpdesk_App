package com.example.strathmore_app.models

import android.widget.EditText
import java.util.*


data class User(val firstname: String, val middle_name: String?, val lastname: String?, val email: String?, val password: String?) {

}


data class AcademicLeave(val startdate: String, val enddate: String, val academicoptins: String?) {

}

data class ExamRemark(val unitcode: String, val unitname: String, val lecturer: String?,val reason: String?,val amountpaid: String?,val receipt: String?) {

}


data class SpecialExam(val unitcode: String, val unitname: String, val session: String?,val specialexamoptions: String?) {

}

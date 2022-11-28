package com.example.strathmore_app.ui

import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.strathmore_app.R
import com.example.strathmore_app.models.AcademicLeave
import com.google.firebase.database.FirebaseDatabase
import java.time.LocalDate
import java.time.format.DateTimeFormatter


/**
 * A simple [Fragment] subclass.
 * Use the [AcademicLeaveFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AcademicLeaveFragment : Fragment() {
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = FirebaseDatabase.getInstance()


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(com.example.strathmore_app.R.layout.fragment_academic_leave, container, false)
        // Inflate the layout for this fragment

        return root
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view?.findViewById<Button>(com.example.strathmore_app.R.id.button_academic_leave_cancel)?.setOnClickListener{

            Toast.makeText(activity,"Cancelled", Toast.LENGTH_SHORT).show()
        }

        view?.findViewById<Button>(com.example.strathmore_app.R.id.button_academic_leave_submit)?.setOnClickListener {

           val myacademiccheck=saveacademicleave()


            if(myacademiccheck){
                Toast.makeText(activity,"Successfully Submitted", Toast.LENGTH_SHORT).show()

                findNavController().navigate(com.example.strathmore_app.R.id.action_nav_academic_leave_to_nav_home)


            }
        }

        }



    @RequiresApi(Build.VERSION_CODES.O)
    private fun saveacademicleave(): Boolean {

     var dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
//        val textFromEditText = "23-08-2013"
//        val myDate = LocalDate.parse(textFromEditText, dateFormatter)
//        val myText = myDate.format(dateFormatter)
//        println("Formatted again: $myText")

               val startdatestring= view?.findViewById<EditText>(R.id.edit_academic_start_date)?.text.toString()
        val startdate = LocalDate.parse(startdatestring, dateFormatter)
        val mystartdate = startdate.format(dateFormatter)

        var enddatestring =view?.findViewById<EditText>(R.id.edit_academic_enddate)?.text.toString()
        val enddate = LocalDate.parse(enddatestring, dateFormatter)
        val myenddate = enddate.format(dateFormatter)





        val academicradiogroup = view?.findViewById<RadioGroup>(R.id.academic_radiogroup)
        val academicoptions = when (academicradiogroup?.checkedRadioButtonId) {
            R.id.radioButton_work_onstraints -> "Work Constraints"
            R.id.radioButton_finacial_problems -> "Financial Problems"
            R.id.radioButton_medical_grounds -> "Medical Grounds"
            else -> "Other"
        }


        if (startdate == null){
          Toast.makeText(activity,"Start Date is empty", Toast.LENGTH_SHORT).show()

   return false
        }


        if (enddate == null){
            Toast.makeText(activity,"End Date is empty", Toast.LENGTH_SHORT).show()

            return false
        }


        if (TextUtils.isEmpty(academicoptions)){
            Toast.makeText(activity,"Not Selected any academic leave options", Toast.LENGTH_SHORT).show()

            return false
        }

         val myacademicleave = AcademicLeave(mystartdate,myenddate,academicoptions)

        database.reference.child("AcademicLeave").setValue(myacademicleave)



             return true



    }



}
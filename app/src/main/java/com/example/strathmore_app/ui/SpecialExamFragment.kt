package com.example.strathmore_app.ui

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.strathmore_app.R
import com.example.strathmore_app.models.AcademicLeave
import com.example.strathmore_app.models.SpecialExam
import com.google.firebase.database.FirebaseDatabase


/**
 * A simple [Fragment] subclass.
 * Use the [SpecialExamFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpecialExamFragment : Fragment() {

    private lateinit var database: FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {

        database = FirebaseDatabase.getInstance()
        super.onCreate(savedInstanceState)
        arguments?.let {



        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_special_exam, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view?.findViewById<Button>(com.example.strathmore_app.R.id.button_special_exam_cancel)?.setOnClickListener{

            Toast.makeText(activity,"Cancelled", Toast.LENGTH_SHORT).show()
        }

        view?.findViewById<Button>(com.example.strathmore_app.R.id.button_special_exam_submit)?.setOnClickListener {

            val myspecialexamcheck = savespecialexam()


            if(myspecialexamcheck){
                Toast.makeText(activity,"Successfully Submitted", Toast.LENGTH_SHORT).show()

                findNavController().navigate(com.example.strathmore_app.R.id.action_nav_special_exam_to_nav_home)


            }
        }

    }

    private fun savespecialexam() :Boolean {

        val unitcode= view?.findViewById<EditText>(R.id.edit_special_exam_unitcode)?.text.toString()
        val unitname= view?.findViewById<EditText>(R.id.edit_special_exam_unitcode)?.text.toString()
        val session= view?.findViewById<EditText>(R.id.edit_special_exam_unitcode)?.text.toString()



        val specialexamradiogroup = view?.findViewById<RadioGroup>(R.id.radiogroup_special_exam_form)
        val specialexamoptions = when (specialexamradiogroup?.checkedRadioButtonId) {
            R.id.radioButton_special_exam_fees_arrears -> "Fees Arrears"
            R.id.radioButton_special_exam_illness -> "Illness"

            else -> "Other"
        }


        if (TextUtils.isEmpty(unitcode)){
            Toast.makeText(activity,"Unit Code is empty", Toast.LENGTH_SHORT).show()

            return false
        }

        if (TextUtils.isEmpty(unitname)){
            Toast.makeText(activity,"Unit Name is empty", Toast.LENGTH_SHORT).show()

            return false
        }

        if (TextUtils.isEmpty(session)){
            Toast.makeText(activity,"Session is empty", Toast.LENGTH_SHORT).show()

            return false
        }

        if (specialexamoptions == null){
            Toast.makeText(activity,"Kindly select a reason", Toast.LENGTH_SHORT).show()

            return false
        }

        val myspecialexam = SpecialExam(unitcode,unitname,session,specialexamoptions)
        database.reference.child("SpecialExam").setValue(myspecialexam)


        return true

    }


}
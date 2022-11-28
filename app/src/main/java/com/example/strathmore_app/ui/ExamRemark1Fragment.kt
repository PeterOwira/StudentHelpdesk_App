package com.example.strathmore_app.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.strathmore_app.R
import com.example.strathmore_app.models.AcademicLeave
import com.example.strathmore_app.models.ExamRemark
import com.google.firebase.database.FirebaseDatabase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ExamRemark1Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExamRemark1Fragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_exam_remark1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view?.findViewById<Button>(com.example.strathmore_app.R.id.button_exam_remark_submit)
            ?.setOnClickListener {

                val myacademiccheck = saveexamremark()


                if (myacademiccheck) {
                    Toast.makeText(activity, "Successfully Submitted", Toast.LENGTH_SHORT).show()

                    findNavController().navigate(com.example.strathmore_app.R.id.action_nav_exam_remark1_to_nav_home)


                }


            }

        view?.findViewById<Button>(com.example.strathmore_app.R.id.button_special_exam_cancel)
            ?.setOnClickListener {

                Toast.makeText(activity, "Cancelled", Toast.LENGTH_SHORT).show()
            }


    }

    private fun saveexamremark(): Boolean {



       val unitcode= view?.findViewById<EditText>(R.id.edit_exam_remark_unitcode)?.text.toString()
        val unitname= view?.findViewById<EditText>(R.id.editText_exam_remark_unit_name)?.text.toString()
        val lecturer= view?.findViewById<EditText>(R.id.editText_exam_remark_lecturer)?.text.toString()
        val reason= view?.findViewById<EditText>(R.id.exam_remark_reason_text)?.text.toString()
        val amountpaid= view?.findViewById<EditText>(R.id.edit_exam_remark_amountpaid)?.text.toString()
        val receipt= view?.findViewById<EditText>(R.id.editText_exam_remark_receiptnumber)?.text.toString()


        if (unitcode == null){
            Toast.makeText(activity,"Unit Code is empty", Toast.LENGTH_SHORT).show()

            return false
        }

        if (unitname == null){
            Toast.makeText(activity,"Unit Name is empty", Toast.LENGTH_SHORT).show()

            return false
        }

        if (lecturer == null){
            Toast.makeText(activity,"Amount Paid is empty", Toast.LENGTH_SHORT).show()

            return false
        }

        if (amountpaid == null){
            Toast.makeText(activity,"Amount Paid is empty", Toast.LENGTH_SHORT).show()

            return false
        }
        if (receipt == null){
            Toast.makeText(activity,"Receipt is empty", Toast.LENGTH_SHORT).show()

            return false
        }

        val myexamremark = ExamRemark(unitcode,unitname,lecturer,reason,amountpaid,receipt)

        database.reference.child("ExamRemark").setValue(myexamremark)

        return true

    }
}
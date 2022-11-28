package com.example.strathmore_app.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.replace
import androidx.navigation.fragment.findNavController
import com.example.strathmore_app.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_textview1 = "textview1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Studentdashboard.newInstance] factory method to
 * create an instance of this fragment.
 */
class Studentdashboard : Fragment() {
    // TODO: Rename and change types of parameters
    private var textview1: String? = "Select a service from the options provided below."
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            textview1 = it.getString(ARG_textview1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment



                return inflater.inflate(R.layout.fragment_studentdashboard, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        view?.findViewById<Button>(com.example.strathmore_app.R.id.button_academic_leave_form)?.setOnClickListener {

            findNavController().navigate(com.example.strathmore_app.R.id.action_nav_home_to_nav_academic_leave)

        }


        view?.findViewById<Button>(com.example.strathmore_app.R.id.button_special_exam_form)?.setOnClickListener {

            findNavController().navigate(com.example.strathmore_app.R.id.action_nav_home_to_nav_special_exam)

        }

        view?.findViewById<Button>(com.example.strathmore_app.R.id.button_exam_remark_form)?.setOnClickListener {

            findNavController().navigate(com.example.strathmore_app.R.id.action_nav_home_to_nav_exam_remark1)

        }



    }
}
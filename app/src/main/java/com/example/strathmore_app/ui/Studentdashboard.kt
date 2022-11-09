package com.example.strathmore_app.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param textview1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Studentdashboard.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(textview1: String, param2: String) =
            Studentdashboard().apply {
                arguments = Bundle().apply {
                    putString(ARG_textview1, textview1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
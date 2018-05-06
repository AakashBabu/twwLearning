package com.example.root.thoughtworkslearning.pattern.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.root.thoughtworkslearning.R
import com.example.root.thoughtworkslearning.TempValue
import com.example.root.thoughtworkslearning.pattern.adapter.PlaceListAdapter
import kotlinx.android.synthetic.main.fragment_tab_one.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TabOneFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



//    var arrayLit = arrayOf("Bangalore","Chennai","Calicut")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_one, container, false)
    }

    override fun onResume() {
        super.onResume()
        list_item.adapter = PlaceListAdapter(activity,TempValue.arrayLit)
    }




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TabOneFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
                TabOneFragment().apply {
                    arguments = Bundle().apply {
//                        putString(ARG_PARAM1, param1)
//                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}

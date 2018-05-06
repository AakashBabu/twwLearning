package com.example.root.thoughtworkslearning.pattern.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.root.thoughtworkslearning.R
import com.example.root.thoughtworkslearning.TempValue

class PlaceListAdapter(var context: Context, var array: Array<String>): BaseAdapter() {
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.row_basic,null)
        (view.findViewById(R.id.title) as TextView).setText(array[p0])
        var check = view.findViewById(R.id.checkbox) as CheckBox
        check.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {


            }

        })
        return view
    }

    override fun getItem(p0: Int): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemId(p0: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        return array.size
    }
}
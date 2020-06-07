package com.ubis.pizzastore_20200607.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.ubis.pizzastore_20200607.R
import com.ubis.pizzastore_20200607.data.story
import kotlinx.android.synthetic.main.activity_main.view.*

class StoreAdapter(context: Context, resId: Int, list: List<story>) : ArrayAdapter<story>(context, resId, list) {

    val mContext = context
    val mList = list
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        tempRow?.let {

        }.let{
            tempRow = inf.inflate(R.layout.activity_story_list_item, null)
        }
        val row = tempRow!!

        //자리에 맞는 데이터 불러오기
        //val data = mList.get(position)

        return row
    }
}
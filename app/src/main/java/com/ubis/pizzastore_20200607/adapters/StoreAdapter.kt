package com.ubis.pizzastore_20200607.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
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


        // 아이디 찾아서 데이터 옯기기
        val logoImg = row.findViewById<ImageView>(R.id.logoImg)
        val storeName = row.findViewById<TextView>(R.id.StoreNameTxt)


        // 뷰에뿌려질 데이터를 들고있을 변수 생성
        // 액티비티가 전달해줄 mList에서 꺼내보자
        //val data = mList.get(position)
        val data = mList[position]

        // data 안에 있는 가게이름을storenametxt에 글자로 설정
        storeName.text = data.name
        // data안에 있는 로고url을 logoImg 웹에서 다운받아 뿌려준다
        Glide.with(mContext).load("${data.urlAddress}").into(logoImg)

        return row
    }
}
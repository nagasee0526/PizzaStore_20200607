package com.ubis.pizzastore_20200607

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.ubis.pizzastore_20200607.adapters.StoreAdapter
import com.ubis.pizzastore_20200607.data.story
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Attributes

class MainActivity : baseActivity() {

    val pizzaStores = ArrayList<story>()
    // Oncreate가 실행된이후에 내용을 채워야함
    // 변수는 멤버변수로 만들어두면 차후에 편리하다
    lateinit var nStoreAdapter:StoreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setValurs()
        setEvents()
    }

    override fun setValurs() {
        addStroes()
        nStoreAdapter = StoreAdapter(mContext, R.layout.activity_story_list_item, pizzaStores)
        pizzaStoryListView.adapter = nStoreAdapter
    }

    override fun setEvents() {
        pizzaStoryListView.setOnItemLongClickListener { parent, view, position, id ->

            // 어느줄이 눌렸는가 position 을 이용하여
            val clickedStore = pizzaStores[position]

            // 가게 상세 화면으로 넘기기
            val myIntent = Intent(mContext, StoreViewInfo::class.java)
            // 클릭한 가게를 상세조회화면으로 전달
            myIntent.putExtra("StoreData", clickedStore)
            startActivity(myIntent)

            return@setOnItemLongClickListener true
        }
    }

    fun addStroes(){
        pizzaStores.add(story(urlAddress =  "https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FnkQca%2FbtqwVT4rrZo%2FymhFqW9uRbzrmZTxUU1QC1%2Fimg.jpg",name = "피자헛",Phonenum = "1588-5588"))
        pizzaStores.add(story(urlAddress =  "http://mblogthumb2.phinf.naver.net/20160530_65/ppanppane_1464617766007O9b5u_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%284%29.png?type=w800",name = "파파존스",Phonenum = "1577-8080"))
        pizzaStores.add(story(urlAddress =  "https://post-phinf.pstatic.net/MjAxODEyMDVfMzYg/MDAxNTQzOTYxOTA4NjM3.8gsStnhxz7eEc9zpt5nmSRZmI-Pzpl4NJvHYU-Dlgmcg.7Vpgk0lopJ5GoTav3CUDqmXi2-_67S5AXD0AGbbR6J4g.JPEG/IMG_1641.jpg?type=w1200",name = "미스터피자",Phonenum = "1577-0077"))
        pizzaStores.add(story(urlAddress =  "https://pbs.twimg.com/profile_images/1098371010548555776/trCrCTDN_400x400.png",name = "도미노피자",Phonenum = "1577-3082"))
    }
}

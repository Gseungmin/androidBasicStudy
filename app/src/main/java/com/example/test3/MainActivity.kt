package com.example.test3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<ContentModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bookMarkBtn = findViewById<TextView>(R.id.bookMarkBtn)
        bookMarkBtn.setOnClickListener {

            val intent = Intent(this, BookMarkActivity::class.java)
            startActivity(intent)
        }

        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/lTMiXudtCvb4",
                "https://mp-seoul-image-production-s3.mangoplate.com/360523/449685_1600723642809_14753?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "Cocktail"
            )
        )

        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/lTMiXudtCvb4",
                "https://mp-seoul-image-production-s3.mangoplate.com/360523/449685_1600723642809_14753?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "Cocktail"
            )
        )

        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/lTMiXudtCvb4",
                "https://mp-seoul-image-production-s3.mangoplate.com/360523/449685_1600723642809_14753?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "Cocktail"
            )
        )

        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/lTMiXudtCvb4",
                "https://mp-seoul-image-production-s3.mangoplate.com/360523/449685_1600723642809_14753?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "Cocktail"
            )
        )

        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/lTMiXudtCvb4",
                "https://mp-seoul-image-production-s3.mangoplate.com/360523/449685_1600723642809_14753?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "Cocktail"
            )
        )

        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/lTMiXudtCvb4",
                "https://mp-seoul-image-production-s3.mangoplate.com/360523/449685_1600723642809_14753?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "Cocktail"
            )
        )

        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/lTMiXudtCvb4",
                "https://mp-seoul-image-production-s3.mangoplate.com/360523/449685_1600723642809_14753?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "Cocktail"
            )
        )

        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/lTMiXudtCvb4",
                "https://mp-seoul-image-production-s3.mangoplate.com/360523/449685_1600723642809_14753?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "Cocktail"
            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(items, baseContext)
        recyclerView.adapter = rvAdapter

        //클릭 이벤트 코드 재정의
        rvAdapter.itemClick = object: RVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {

                val intent = Intent(baseContext, ViewActivity::class.java)
                //url을 넘기기 위해 intent를 통해 ViewActivity로 데이터 전송
                intent.putExtra("url", items[position].url)
                intent.putExtra("title", items[position].title)
                intent.putExtra("titleImageUrl", items[position].titleImageUrl)
                startActivity(intent)
            }
        }

//        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
    }
}
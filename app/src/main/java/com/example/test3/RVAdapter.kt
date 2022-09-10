package com.example.test3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

//데이터를 받아서 하나하나 처리
class RVAdapter(val List : MutableList<ContentModel>, val context : Context)
    : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return ViewHolder(v)
    }

    //웹뷰 적용
    interface ItemClick
    {
        fun onClick(view : View, position: Int)
    }
    var itemClick : ItemClick? = null

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {

        //이렇게 클릭 이벤트를 만들어야 해서 귀찮은 단점 존재
        if(itemClick != null) {
            holder?.itemView.setOnClickListener {
                v-> itemClick!!.onClick(v, position)
            }
        }

        holder.bindItems(List[position])
    }

    override fun getItemCount(): Int {
        return List.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(item : ContentModel) {
            val rv_image = itemView.findViewById<ImageView>(R.id.rvImage)
            val rv_text = itemView.findViewById<TextView>(R.id.rvText)

            rv_text.text = item.title

            //웹에서 가져온 이미지 넣기 위해 Glide 사용
            //Gradle 추가
            Glide.with(context).load(item.titleImageUrl).into(rv_image)
        }
    }
}
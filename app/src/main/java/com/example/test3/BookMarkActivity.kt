package com.example.test3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class BookMarkActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val contentModels = mutableListOf<ContentModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_mark)

        auth = Firebase.auth

        val database = Firebase.database
        val myBookMarkRef = database.getReference("bookmark_ref")

        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(contentModels, this)
        recyclerView.adapter = rvAdapter

        recyclerView.layoutManager = GridLayoutManager(this, 2)

        myBookMarkRef.child(auth.currentUser?.uid.toString())
            .addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    //dataModel이 ConnentModel
                    for (dataModel in snapshot.children) {
                        contentModels.add(dataModel.getValue(ContentModel::class.java)!!)
                    }
                    rvAdapter.notifyDataSetChanged() //반복문이 끝난 후 view를 보여주어야 하므로 동기화 필요
                }
                override fun onCancelled(error: DatabaseError) {
                    Log.e("BookMark","DBError")
                }
            })

    }
}
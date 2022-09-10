package com.example.test3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ViewActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        auth = Firebase.auth

        val webView = findViewById<WebView>(R.id.webView)
        webView.loadUrl(intent.getStringExtra("url").toString())

        val database = Firebase.database
        val myBookMarkRef = database.getReference("bookmark_ref")

        val url = intent.getStringExtra("url").toString()
        val title = intent.getStringExtra("title").toString()
        val titleImageUrl = intent.getStringExtra("titleImageUrl").toString()

        val saveText = findViewById<TextView>(R.id.saveBtn)
        saveText.setOnClickListener {
            myBookMarkRef.child(auth.currentUser!!.uid).push().setValue(ContentModel(url, titleImageUrl, title))
        }
    }
}
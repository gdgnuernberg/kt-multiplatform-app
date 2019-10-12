package io.github.gdgnbgandroid.mpp.mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        //startActivity(Intent(this, LoginActivity::class.java))

        val meetupListView = findViewById<ListView>(R.id.topic_list_view)
        val meetupTopicListAdapter = MeetupTopicListAdapter(this, Repository.topics.toList())
        meetupListView.adapter = meetupTopicListAdapter

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent = Intent(this, AddTopicActivity::class.java)
            startActivity(intent)
        }
    }
}
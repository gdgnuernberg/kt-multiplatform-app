package io.github.gdgnbgandroid.mpp.mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class AddTopicActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_topic)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val btnAdd = findViewById<Button>(R.id.btn_add)
        val etTitle = findViewById<EditText>(R.id.et_title)
        val etDesc = findViewById<EditText>(R.id.et_description)

        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_back)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        btnAdd.setOnClickListener {
            if (etTitle.text.toString().isBlank()) {
                Toast.makeText(this,"Please enter title..",Toast.LENGTH_SHORT).show()
            }
            if (etDesc.text.toString().isBlank()) {
                Toast.makeText(this,"Please enter description..",Toast.LENGTH_SHORT).show()
            }

            Repository.addTopic(etTitle.text.toString(), etDesc.text.toString())
            finish()
        }

    }
}

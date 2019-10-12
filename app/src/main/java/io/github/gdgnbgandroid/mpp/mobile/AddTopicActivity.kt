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
        val add_button = findViewById<Button>(R.id.add_button)
        val title_edit_text = findViewById<EditText>(R.id.title_edit_text)
        val description_edit_text = findViewById<EditText>(R.id.description_edit_text)

        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_back)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        add_button.setOnClickListener {
            if (title_edit_text.text.toString().isBlank()) {
                Toast.makeText(this,"Please enter title..",Toast.LENGTH_SHORT).show()
            }
            if (description_edit_text.text.toString().isBlank()) {
                Toast.makeText(this,"Please enter description..",Toast.LENGTH_SHORT).show()
            }

            Repository.addTopic(title_edit_text.text.toString(), description_edit_text.text.toString())
            finish()
        }

    }
}

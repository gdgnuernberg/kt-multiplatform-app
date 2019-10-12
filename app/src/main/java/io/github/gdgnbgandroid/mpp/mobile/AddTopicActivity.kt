package io.github.gdgnbgandroid.mpp.mobile

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_topic.*

class AddTopicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_topic)

        setTitle(R.string.title_add_topic)

        addButton.setOnClickListener {
            if (titleEditText.text.toString().isBlank()) {
                Toast.makeText(this,"Please enter title..",Toast.LENGTH_SHORT).show()
            }
            if (descriptionEditText.text.toString().isBlank()) {
                Toast.makeText(this,"Please enter description..",Toast.LENGTH_SHORT).show()
            }

            Repository.addTopic(titleEditText.text.toString(), descriptionEditText.text.toString())
            setResult(Activity.RESULT_OK)
            finish()
        }
    }
}

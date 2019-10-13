package io.github.gdgnbgandroid.mpp.mobile

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        if (sharedPreferences.getString(KEY_USER_IDENTIFICATION, "")?.isBlank() == true) {
            overridePendingTransition(0, 0)
            startActivityForResult(Intent(this, LoginActivity::class.java), REQUEST_CODE_USER)
        } else {
            loadTopics()
        }
    }

    private fun loadTopics() {
        val meetupTopicListAdapter = MeetupTopicListAdapter(this, Repository.topics.toList(), { topic ->
            sharedPreferences.getString(KEY_USER_IDENTIFICATION, "")
                ?.let { userId -> Repository.vote(topic.id, userId) }
            loadTopics()
        })
        topiclistView.adapter = meetupTopicListAdapter

        addTopicButton.setOnClickListener {
            val intent = Intent(this, AddTopicActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_TOPIC)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE_USER && resultCode == RESULT_OK && data != null) {
            sharedPreferences.edit {
                putString(
                    KEY_USER_IDENTIFICATION,
                    data.getStringExtra(LoginActivity.EXTRA_USER_IDENTIFICATION)
                )
            }
            loadTopics()
        } else if (requestCode == REQUEST_CODE_TOPIC && resultCode == RESULT_OK) {
            loadTopics()
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    companion object {
        const val KEY_USER_IDENTIFICATION = "key_user_identification"
        private const val REQUEST_CODE_USER = 591
        private const val REQUEST_CODE_TOPIC = 592
    }
}
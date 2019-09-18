package io.github.gdgnbgandroid.mpp.mobile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MeetupTopicListAdapter(
    context: Context,
    private val meetupTopicList: List<Pair<Int, MeetupTopic>>
) :
    ArrayAdapter<MeetupTopic>(context, 0) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val meetupTopic = meetupTopicList[position].second

        var tempConvertView = convertView

        if (tempConvertView == null) {
            tempConvertView = LayoutInflater.from(context)
                .inflate(R.layout.item_meetup_topic, parent, false);
        }

        val titleTextView = tempConvertView?.findViewById<TextView>(R.id.topic_title_text_view)
        val descriptionTextView =
            tempConvertView?.findViewById<TextView>(R.id.topic_description_text_view)
        val votesTextView =
            tempConvertView?.findViewById<TextView>(R.id.topic_votes_text_view)

        titleTextView?.text = meetupTopic.name
        descriptionTextView?.text = meetupTopic.description
        votesTextView?.text = meetupTopic.voteCount.size.toString()

        return tempConvertView!!
    }

    override fun getCount(): Int {
        return meetupTopicList.size
    }

    fun updateList(meetupTopicList: List<Pair<Int, MeetupTopic>>) {

    }
}
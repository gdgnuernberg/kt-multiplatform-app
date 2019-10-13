package io.github.gdgnbgandroid.mpp.mobile

import android.content.Context
import android.content.SharedPreferences
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.preference.PreferenceManager

class MeetupTopicListAdapter(
    context: Context,
    private val meetupTopicList: List<Pair<Int, MeetupTopic>>,
    private val onCLickAction: (meetupTopic: MeetupTopic) -> Unit,
    private val sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context),
    private val favoriteIcon: Drawable = ContextCompat.getDrawable(
        context, R.drawable.ic_favorite_red
    ) ?: throw IllegalStateException(),
    private val favoriteBorderIcon: Drawable = ContextCompat.getDrawable(
        context, R.drawable.ic_favorite_border_black
    ) ?: throw IllegalStateException()
) : ArrayAdapter<MeetupTopic>(context, 0) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val meetupTopic = meetupTopicList[position].second

        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_meetup_topic, parent, false) ?: return parent

        val titleTextView = view.findViewById<TextView>(R.id.topic_title_text_view)
        val descriptionTextView =
            view.findViewById<TextView>(R.id.topic_description_text_view)
        val votesTextView =
            view.findViewById<TextView>(R.id.topic_votes_text_view)
        val favoriteImageView =
            view.findViewById<ImageView>(R.id.topic_favorite_image_view)

        titleTextView?.text = meetupTopic.name
        descriptionTextView?.text = meetupTopic.description
        votesTextView?.text = meetupTopic.userVotings.size.toString()

        when {
            meetupTopic.userVotings.contains(sharedPreferences.getString(MainActivity.KEY_USER_IDENTIFICATION, "")) ->
                favoriteImageView.setImageDrawable(favoriteIcon)
            else ->
                favoriteImageView.setImageDrawable(favoriteBorderIcon)
        }

        view.setOnClickListener { onCLickAction.invoke(meetupTopic) }

        return view
    }

    override fun getCount(): Int {
        return meetupTopicList.size
    }
}
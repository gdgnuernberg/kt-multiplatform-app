package io.github.gdgnbgandroid.mpp.mobile

expect fun platformName(): String

fun createApplicationScreenMessage(): String {
    return "Kotlin Rocks on ${platformName()}"
}

object Repository {
    private val _votes = mutableMapOf<Int, MeetupTopic>()
    val votes: Map<Int, MeetupTopic>
        get() = _votes

    init {
        (1..9).forEach {
            _votes[it] = MeetupTopic(
                it,
                "name $it",
                "description $it"
            )
        }
    }

    fun vote(meetupTopicId: Int) {
        val meetupTopic = _votes[meetupTopicId]
        meetupTopic?.let {
            _votes[meetupTopicId] = (meetupTopic.copy(voteCount = meetupTopic.voteCount + 1))
        }
    }

    fun unvote(meetupTopicId: Int) {
        val meetupTopic = _votes[meetupTopicId]
        meetupTopic?.let {
            if (meetupTopic.voteCount > 0) {
                _votes[meetupTopicId] = (meetupTopic.copy(voteCount = meetupTopic.voteCount - 1))
            }
        }
    }

    fun addTopic(name: String, description: String?) {
        val id = _votes.size + 1
        _votes[id] = MeetupTopic(id, name, description)
    }
}

data class MeetupTopic(
    val id: Int,
    val name: String,
    val description: String? = null,
    var voteCount: Int = 0
)
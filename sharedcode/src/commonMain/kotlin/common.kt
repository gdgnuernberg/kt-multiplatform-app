package io.github.gdgnbgandroid.mpp.mobile

object Repository {
    private val _topics = mutableMapOf<Int, MeetupTopic>()
    val topics: Map<Int, MeetupTopic>
        get() = _topics.toList().sortedBy { it.second.userVotings.size }.reversed().toMap()

    init {
        (1..9).forEach {
            _topics[it] = MeetupTopic(
                it,
                "name $it",
                "description $it"
            )
        }
    }

    fun vote(meetupTopicId: Int, userId: String) {
        _topics[meetupTopicId]?.userVotings?.apply {
            if (this.contains(userId)) {
                remove(userId)
            } else {
                add(userId)
            }
        }
    }

    fun addTopic(name: String, description: String?) {
        val id = _topics.size + 1
        _topics[id] = MeetupTopic(id, name, description)
    }
}

expect fun String.toHash(): String

data class MeetupTopic(
    val id: Int,
    val name: String,
    val description: String? = null,
    var userVotings: MutableSet<String> = mutableSetOf()
)
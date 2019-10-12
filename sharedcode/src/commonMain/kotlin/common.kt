package io.github.gdgnbgandroid.mpp.mobile

expect fun getUserId(): String

object Repository {
    private val _topics = mutableMapOf<Int, MeetupTopic>()
    val topics: Map<Int, MeetupTopic>
        get() = _topics

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
        _topics[meetupTopicId]?.voteCount?.apply { add(userId) }
    }

    fun unvote(meetupTopicId: Int, userId: String) {
        _topics[meetupTopicId]?.voteCount?.apply { remove(userId) }
    }

    fun addTopic(name: String, description: String?) {
        val id = _topics.size + 1
        _topics[id] = MeetupTopic(id, name, description)
    }
}

//expect class FirebaseRepository {
//    fun authenticate(callback: (success: Boolean) -> Unit)
//    fun vote(meetupTopicId: Int, userId: String)
//    fun unvote(meetupTopicId: Int, userId: String)
//    fun addTopic(name: String, description: String?)
//}

data class MeetupTopic(
    val id: Int,
    val name: String,
    val description: String? = null,
    var voteCount: MutableSet<String> = mutableSetOf()
)
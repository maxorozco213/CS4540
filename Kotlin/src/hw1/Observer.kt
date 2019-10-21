package hw1
//Observer

interface Observer {
    val name: String
    fun subscribe(sub: Subscriber)
    fun unsubscribe(sub: Subscriber)
    fun update(newsletter: String)
}
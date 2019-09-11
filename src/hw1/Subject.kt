package hw1
//Observable

interface Subject {
    fun addSubscriber(sub: Subscriber)
    fun removeSubscriber(sub: Subscriber)
    fun printNewsLetter(newsletter: String)
}
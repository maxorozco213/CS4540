//Observer
package hw1

class Subscriber(private val subName: String, private val publisher: NewsLetterPublisher): Observer {
    override val name = subName

    override fun subscribe(sub: Subscriber) {
        publisher.addSubscriber(sub)
    }

    override fun unsubscribe(sub: Subscriber) {
        publisher.removeSubscriber(sub)
    }

    override fun update(newsletter: String) {
        publisher.printNewsLetter(newsletter)
    }
}
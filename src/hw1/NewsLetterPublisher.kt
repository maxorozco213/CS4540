//Observable
package hw1

object NewsLetterPublisher: Subject {
    private var subscriberList: ArrayList<Subscriber> = arrayListOf()

    override fun addSubscriber(sub: Subscriber) {
        val subName: String = sub.name
        subscriberList.add(sub)
        println("Subscriber named $subName has been added to the list")
    }

    override fun removeSubscriber(sub: Subscriber) {
        val subName: String = sub.name

        if(sub in subscriberList) {
            subscriberList.remove(sub)
            println("$subName was unsubscribed")

        } else {
            println("Subscriber does not exist in the list")
        }
    }

    override fun printNewsLetter(newsletter: String) {
        println(newsletter)
    }
}
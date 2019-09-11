package hw1

fun main(){
    val publisher = NewsLetterPublisher
    val sub1 = Subscriber("Mike", publisher)
    val sub2 = Subscriber("Kevin", publisher)
    val sub3 = Subscriber("Esmerelda", publisher)
    val sub4 = Subscriber("Hector", publisher)
    val sub5 = Subscriber("Letty", publisher)

    sub1.subscribe(sub1)
    sub2.subscribe(sub2)
    sub3.subscribe(sub3)
    sub4.subscribe(sub4)
    sub4.subscribe(sub5)

    for (i in 1..20) {
        publisher.printNewsLetter("Exciting news! We have raised $i million dollars!")

        when (i) {
            3   -> sub1.unsubscribe(sub1)
            10  -> sub2.unsubscribe(sub2)
        }
    }
}
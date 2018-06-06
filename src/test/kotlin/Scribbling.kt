import org.junit.Test
import java.util.function.Consumer

class Scribbling {

    data class Customer(var name: String?, var email: String) {
        constructor(email: String) : this(null, email)
    }

    enum class HttpStatus(val code: Int) {

        NOT_FOUND(404),
        UNAUTHORIZED(401),
        REDIRECT(302)
    }

    fun sendEmail(cc: String = "defaultCC@grail.com", to: Customer?, numOfRetries: Int = 2) {
        System.out.println("Sending email to ${to?.name} on ${to?.email}. CCing $cc")
        System.out.println("Gonna try $numOfRetries times")
    }

    @Test
    fun objectEquality() {
        val customer = Customer(email = "vaibhawj@grail.com")
        customer.name = "Vaibhaw"

        val anotherCustomer = Customer("Vaibhaw", "vaibhawj@grail.com")

        System.out.println(customer == anotherCustomer)
        System.out.println(customer === anotherCustomer)
    }

    @Test
    fun emailing() {
        val customer = Customer("Vaibhaw", "vaibhawj@grail.com")

        sendEmail(to = customer)
        sendEmail(to = customer, numOfRetries = 3)
        sendEmail(to = customer, cc = "mycc@grail.com")
        sendEmail(to = null)
    }

    @Test
    fun mutableList() {
        val list = mutableListOf(10, 12, 9)

        list.removeAt(2)
        list.add(14)

        list.filter { n -> n % 2 == 0 }
                .map { n -> n / 2 }
                .forEach(Consumer { n -> System.out.println(n) })


    }

    @Test
    fun immutableList() {
        val list = listOf(10, 12, 9)

        list.filter { n -> n % 2 == 0 }
                .map { n -> n / 2 }
                .forEach(Consumer { n -> System.out.println(n) })

        // list.remove
    }

    @Test
    fun immutableMap() {
        val switchStateMap = mapOf(
                "OFF" to false,
                "ON" to true
        )

        System.out.println(switchStateMap)
    }

    @Test
    fun hashMap() {
        val switchStateMap = hashMapOf<String, Any>(
                "OFF" to false,
                "ON" to true
        )

        System.out.println(switchStateMap)

        switchStateMap.remove("OFF")
        switchStateMap.remove("ON")

        switchStateMap["Down"] = 0
        switchStateMap["Up"] = 1

        System.out.println(switchStateMap)

    }

    @Test
    fun enum() {
        System.out.println(HttpStatus.NOT_FOUND.code)
    }

}
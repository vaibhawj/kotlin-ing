import org.junit.Assert
import org.junit.Test
import vibe.learning.kotlin.Person

class PersonTest {

    @Test
    fun shouldGreetPerson() {
        val p = Person("Vaibhaw")
        Assert.assertEquals("Hi Vaibhaw", p.greet())
    }

    @Test
    fun shouldGreetNoName() {
        val p = Person()
        Assert.assertEquals("Hi NoName", p.greet())
    }
}



//@Grapes(
//    @Grab(group='org.spockframework', module='spock-core', version='1.0-groovy-2.4')
//)
import spock.lang.Specification

class StackSpec extends Specification {

    def "adding element leads to size increase"() {
        setup: "a new stack instance is created" // optional description
            def stack = new Stack()

        when: // optional description
            stack.push 123

        then: // optional description
            stack.size() == 1
    }
}

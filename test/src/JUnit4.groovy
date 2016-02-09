import groovy.test.GroovyAssert
import org.junit.Test

class JUnit4Tests {

    @Test
    void indexOutOfBoundsAccess() {
        def numbers = [1, 2, 3]

        GroovyAssert.shouldFail {
            numbers.get(3)
        }

        def e = GroovyAssert.shouldFail {
            throw new RuntimeException('foo', new RuntimeException('bar'))
        }
        assert e instanceof RuntimeException
        assert e.cause instanceof RuntimeException
        assert e.message == 'foo'
        assert e.cause.message == 'bar'
    }
}

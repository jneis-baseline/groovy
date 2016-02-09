import groovy.transform.NotYetImplemented

class MyTestCase extends GroovyTestCase {

    void testAssertions() {
        def x = '123'

        assertTrue(1==1)
        assertEquals '1', '1'
        assertNotNull x
        assertNull null
        assertFalse(x == 123)
        assertSame x, x
    }

    void testInvalidIndexAccess() {
        def numbers = [1, 2, 3]
        shouldFail {
            numbers.get(3)
        }
        shouldFail IndexOutOfBoundsException, {
            numbers.get(3)
        }
        def msg = shouldFail IndexOutOfBoundsException, {
            numbers.get(3)
        }
        assertTrue msg.contains('Index: 3, Size: 3')
    }

    @NotYetImplemented
    void testNotYetImplemented() {
        assertEquals 1, 2
    }
}

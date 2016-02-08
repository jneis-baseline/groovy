// multiple assignment
def (int i, String s) = [1, '2']
assert i == 1
assert s == '2'

def a, b, c
(a, b, c) = [1, 2]
assert a == 1
assert b == 2
assert c == null

def (month, _, year) = 'February 8th 2016'.split()
assert month == 'February'
assert year == '2016'

// special for loops
def js = []
for(j in 1..3) { // lists, ranges, strings
    js << j
}
assert js == [1, 2, 3]

js = []
def map = [a:1, b:2, c:3]
for (e in map) { // maps
    js << e.key  // e.value
}
assert js == ['a', 'b', 'c']

// try-catch
try {
    1/0
    assert false
} catch(e) {
    assert e in ArithmeticException
}

// closure coercion to single abstract method type
trait Sam {
    abstract String getName()
    String hello() { "hello ${name}" }
}
def sam = { 'Jen' } as Sam
assert sam.hello() == 'hello Jen'

String saySomething(Sam sam) {
    "ok... ${sam.hello()}"
}
assert saySomething({'Jennifer'} as Sam) == 'ok... hello Jennifer'

// String to enum coercion
enum State { up, down }
def state = 'up' as State
assert state == State.up

// custom coercion
class Actress { String name }
Person.metaClass.asType = { Class target ->
    if (Actress == target) {
        return new Actress(name: name)
    }
}
def actress = new Person(name: 'Jen') as Actress
assert actress.class == Actress

// groovy truth
assert ![]   // lists
assert ![:]  // maps
assert !''   // strings
assert !0    // numbers
assert !null // objects


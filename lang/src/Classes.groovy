class Outer {
    private String str = 'private';

    def doSomething() {
        new Inner().doSomething()
    }

    // inner classes are only visible from enclosing class
    class Inner {
        def doSomething() {
            "${str}"
        }
    }
}

new Outer().doSomething()


// using coercion to delegate

interface Greeter {
    String greet(String name)
}

class DefaultGreeter {        // does not implement interface
    String greet(String name) { // but has a method with same signature
        "Hello, ${name}!"
    }
}

def greeter = new DefaultGreeter()
def coerced = greeter as Greeter
coerced.greet('Jen') // Hello, Jen!

// constructors' positional args (disable named args)
class Name {
    String first
    String last
    Name(first, last) {
        this.first = first
        this.last = last
    }
}
new Name('Jen', 'Lawrence')
['Jen', 'Aniston'] as Name
Name name = ['Jen', 'Connely']

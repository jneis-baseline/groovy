// traits ~ interfaces with default impl + state

interface SomeInterface {}
trait SomeTrait {}
trait AnotherTrait {}

trait Flying implements SomeTrait, AnotherTrait, SomeInterface {
    private String description = 'flying'     // props & private fields allowed
    private String describe() { description } // private methods allowed
    String fly() { "${describe()}" }
}

class Bird implements Flying {}
class Plane {}

new Bird().fly()                  // flying (static impl)
def plane = new Plane()
// plane.fly()                    // MissingMethodException
def flyingPlane = plane as Flying
flyingPlane.fly()                 // flying (dynamic impl)

// method/prop missing
trait Dynamic {
    def methodMissing(String name, args) {
        "Missing ${name}"
    }
    def propertyMissing(String name) {
        "Missing ${name}"
    }
    def hello() {
        "${method()} and ${prop}"
    }
}

class WatchAndLearn implements Dynamic {}

new WatchAndLearn().hello() // Missing method and Missing prop

// inheritance conflicts
trait TraitA { def exec() { 'A' }}
trait TraitB { def exec() { 'B' }}
class ClassC implements TraitA, TraitB {} // resolve to last defined parent
class ClassD implements TraitA, TraitB {
    def exec() { TraitA.super.exec() }    // user conflict resolution
}
assert new ClassC().exec() == 'B'
assert new ClassD().exec() == 'A'

// power
assert (2 ** 3) == 8

// int division
assert (10 / 2).class == BigDecimal
assert 10.intdiv(2).class == Integer

// elvis operator
def val
val != null ? val : 'default' // ternary operator
val ? val : 'default'         // ternary operator, using truth value
val ?: 'default'              // elvis operator

// safe navigation operator (avoids NPE, returns null)
def person
assert person?.name == null

// direct field access operator
class Person {
    String name
    String getName() {
        "Name: $name"
    }
}
person = new Person(name: 'Jennifer')
assert person.name == 'Name: Jennifer'
assert person.@name == 'Jennifer'

// method pointer operator (returns a reference to a method)
def nameIt = person.&getName
assert nameIt() == 'Name: Jennifer'
assert nameIt.class == org.codehaus.groovy.runtime.MethodClosure

// spread operator:
//    - invokes a method on all items of a collection
//    - collects the returning values into a collection
//    - is NPE-safe (returns null)
def people = [
        new Person(name: 'Lawrence'),
        null,
        new Person(name: 'Aniston')
]
assert people*.name == ['Name: Lawrence', null, 'Name: Aniston']

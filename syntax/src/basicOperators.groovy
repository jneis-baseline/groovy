import java.util.regex.Matcher
import java.util.regex.Pattern

// power
2 ** 3

// int division
10 / 2       // BigDecimal
10.intdiv(2) // Integer

// elvis operator
def val
val != null ? val : 'default' // ternary operator
val ? val : 'default'         // ternary operator, using truth value
val ?: 'default'              // elvis operator

// safe navigation operator (avoids NPE, returns null)
def person
person?.name // null

// direct field access operator
class Person {
    String name
    String getName() {
        "Name: $name"
    }
}
person = new Person(name: 'Jennifer')
person.name  // Name: Jennifer
person.@name // Jennifer

// method pointer operator (returns a reference to a method)
def nameIt = person.&getName // MethodClosure
nameIt() // Name: Jennifer

// spread operator:
//    - invokes a method on all items of a collection
//    - collects the returning values into a collection
//    - is NPE-safe (returns null)
def people = [
        new Person(name: 'Lawrence'),
        null,
        new Person(name: 'Aniston')
]
people*.name // ArrayList ['Lawrence', null, 'Aniston']

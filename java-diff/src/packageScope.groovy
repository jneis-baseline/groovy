import groovy.transform.PackageScope

// omitting modifiers does not indicate package-private fields
//    'name' is private, and getter/setter are generated
class Person {
    String name
}

// 'name' here is package-private
class Person2 {
    @PackageScope String name
}

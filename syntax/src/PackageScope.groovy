import groovy.transform.PackageScope

// omitting modifiers does not indicate package-private fields
//    'prop' is private, and getter/setter are generated
class X {
    String prop
}

// 'prop' here is package-private
class Y {
    @PackageScope String prop
}

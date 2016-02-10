def person = new Expando()
person.name = 'Jen'
person.say = { "${it}" }

assert person.name == 'Jen'
assert person.say('hello') == 'hello'
assert person.age == null

person = new DynamicObj()
person.name = 'Jen'
person.say = { "${it}" }

assert person.name == 'Jen'
assert person.say('hello') == 'hello'
assert person.age == null

class DynamicObj {
    private Map props = [:]

    void setProperty(String name, value) {
        props.put(name, value)
    }

    def getProperty(String name) {
        props.get(name)
    }

    def invokeMethod(String name, args) {
        def method = props.get(name)
        if (method instanceof Closure) {
            return method(*args)
        }
        throw new MissingMethodException(name, DynamicObj, args)
    }
}

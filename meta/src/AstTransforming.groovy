import groovy.transform.Immutable
import groovy.transform.PackageScope

// explicitly implementing interface, overriding every method
class Widget1 implements Map {
    private Map map = [:]

    int size() { map.size() }

    boolean isEmpty() { map.isEmpty() }

    boolean containsKey(Object key) { map.containsKey(key) }

    boolean containsValue(Object value) { map.containsValue(value) }

    def get(key) { map.get(key) }

    def put(key, value) { map.put(key, value) }

    def remove(key) { map.remove(key) }

    void putAll(Map m) { map.putAll(m) }

    void clear() { map.clear() }

    Set keySet() { map.keySet() }

    Collection values() { map.values() }

    Set entrySet() { map.entrySet() }
}

// implicitly implementing interface, delegating with AST transformation annotation
class Widget2 {
    @Delegate
    private Map map = [:]
}

assert new Widget1().isEmpty()
assert new Widget2().isEmpty()

@Immutable
class Person {
    @PackageScope String name
}

def person = new Person(name: 'Jen')
try {
    person.name = 'jEN'
    assert false, "'name' prop of type 'Person' shouldn't be mutable"
} catch (e) {
    assert e in ReadOnlyPropertyException
}

@Singleton
class App {}
assert App.getInstance().class == App

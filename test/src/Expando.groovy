// dynamically add methods, constructors or props
String.metaClass.swapCase = { ->
    def sb = new StringBuilder()
    delegate.each {
        sb << (Character.isUpperCase(it as char)
                ? Character.toLowerCase(it as char)
                : Character.toUpperCase(it as char))
    }
    sb.toString()
}

def s = 'heLLo, worLD!'
assert s.swapCase() == 'HEllO, WORld!'

Person.metaClass.static.create << {String first, String last -> new Person(first:first, last:last)}

def p = Person.create('1st', 'lst')
assert p.first == '1st'
assert p.last == 'lst'

// removing changes
GroovySystem.metaClassRegistry.setMetaClass(String, null)
GroovySystem.metaClassRegistry.setMetaClass(Person, null)

try {
    s.swapCase()
    assert false
} catch(e) {
    assert e in MissingMethodException
}

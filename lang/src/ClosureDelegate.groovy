import groovy.transform.Field

def enclosingClass = this
def person = new Person(name: 'Aniston')

@Field def name = 'Lawrence'

def closure = {
    assert this == enclosingClass
    assert owner == enclosingClass
    assert delegate in [owner, person] // owner by default

    assert this.name == 'Lawrence'
    assert owner.name == 'Lawrence'
    assert delegate.name in ['Lawrence', 'Name: Aniston']

    assert name == owner.name // OWNER_FIRST strategy

    def nested = {
        assert this == enclosingClass
        assert delegate == owner // enclosing closure
    }
    nested()
}

closure()
closure.delegate = person
closure()

// delegation strategies:
closure.resolveStrategy = Closure.OWNER_FIRST    // default
closure.resolveStrategy = Closure.DELEGATE_FIRST
closure.resolveStrategy = Closure.OWNER_ONLY
closure.resolveStrategy = Closure.DELEGATE_ONLY
closure.resolveStrategy = Closure.TO_SELF       // for metaprogramming



import groovy.transform.Field

// enclosing object A (class instance)

@Field def name = 'Lawrence'

def closure = { // enclosing object B (closure)
    // this = A
    // owner = A
    // delegate = owner (default)

    this.name     // Lawrence
    owner.name    // Lawrence
    delegate.name // 'Lawrence' first, then 'Name: Aniston'

    name          // = owner.name (OWNER_FIRST strategy)

    def nested = {
        // this = A
        // owner = B
        // delegate = owner
    }
    nested()
}

closure()
closure.delegate = new Person(name: 'Aniston')
closure()

// delegation strategies:
closure.resolveStrategy = Closure.OWNER_FIRST    // default
closure.resolveStrategy = Closure.DELEGATE_FIRST
closure.resolveStrategy = Closure.OWNER_ONLY
closure.resolveStrategy = Closure.DELEGATE_ONLY
closure.resolveStrategy = Closure.TO_SELF       // for metaprogramming



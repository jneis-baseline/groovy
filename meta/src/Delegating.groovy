def closure = {
    append 'one'
    append ' - '
    append 'two'
    toString()
}

def builder = new StringBuilder()

closure.delegate = builder

assert closure().startsWith('Delegating$_run_closure1@')
assert builder.toString() == 'one - two'

closure = {
    append '123'
    delegate.toString()
}
closure.delegate = new StringBuilder()

assert closure() == '123'

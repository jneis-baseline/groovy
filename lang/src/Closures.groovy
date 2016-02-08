// no args, no statement
def closure = { -> }
assert closure.call() == null

def item = 0

// (forced) no args
closure = { -> ++item }
assert closure() == 1

// no args (implicit 'it' for empty params closures)
closure = { it.reverse() }
assert closure('implicit') == 'ticilpmi'

// one untyped arg
closure = { i -> i + 1 }
assert closure(10) == 11

// one typed arg
closure = { String s -> s + s }
assert closure('10') == '1010'

// multiple untyped args
closure = { i, j -> i + j}
assert closure(1, 2) == 3

// multiple typed args
closure = { String s, int i -> s + i}
assert closure('1', 2) == '12'

// multiple statements
closure = { String s ->
    def temp = s.reverse()
    "${s} - ${temp}"
}
assert closure('10') == '10 - 01'

// arg with default value
closure = { s = 'default' -> s.reverse() }
assert closure() == 'tluafed'

// GString closures
def x = 1
def eager = "${x}"
def lazy = "${->x}"
assert eager == '1'
assert lazy == '1'
x = 2
assert eager == '1'
assert lazy == '2'

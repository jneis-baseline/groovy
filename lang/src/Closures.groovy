def closure = { -> }                  // no args, no statement
closure.call()                        // null

def item = 0

closure = { -> ++item }               // (forced) no args
closure()                             // 1

closure = { it.reverse() }            // no args (implicit 'it' for empty params closures)
closure('implicit')                   // ticilpmi

closure = { i -> i + 1 }              // one untyped arg
closure(10)                           // 11

closure = { String s -> s + s }       // one typed arg
closure('10')                         // 1010

closure = { i, j -> i + j}            // multiple untyped args
closure(1, 2)                         // 3

closure = { String s, int i -> s + i} // multiple typed args
closure('1', 2)                       // 12

closure = { String s ->               // multiple statements
    def temp = s.reverse()
    "${s} - ${temp}"
}
closure('10')                         // 10 - 01

closure = { s = 'default' ->          // arg with default value
    s.reverse()
}
closure()                             // tluafed

// GString closures
def x = 1
def eager = "${x}"
def lazy = "${->x}"
eager               // 1
lazy                // 1
x = 2
eager               // 1
lazy                // 2

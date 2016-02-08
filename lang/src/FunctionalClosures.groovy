// currying
def copies = { String s, int n -> s*n }
def bla = copies.curry('bla') // left currying
def twice = copies.rcurry(2)  // right currying

bla(3) // blablabla
twice('bla') // blabla

// composition
def plus2 = { it + 2 }
def times3 = { it * 3 }
def composed = plus2 << times3 // composing
def reversed = plus2 >> times3 // reverse-composing

composed(3)      // 11
plus2(times3(3)) // 11
reversed(3)      // 15
times3(plus2(3)) // 15
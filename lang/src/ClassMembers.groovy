// methods' named args
def doSomething(Map args) {
    "${args.s} ${args.i}"
}
doSomething(s: 'Jen', i: 1) // Jen 1

// default params
def doSomething(String s, int i = 123) {
    "${s} ${i}"
}
doSomething('Jen', 1) // Jen 1
doSomething('Jen')    // Jen 123

// properties metadata
class Some {
    String s
    int i
    private boolean b
    def doSomething() { "${s} ${i} ${b}"}
}
new Some().properties // [class:class Some, i:0, s:null]

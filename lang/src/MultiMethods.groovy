String method(String arg) {
    'String arg'
}

String method(Object arg) {
    'Object arg'
}

// runtime dispatch

Object o = 'Object'

method(o)           // String arg
method(o as Object) // Object arg

String method(long l) {
    'long arg'
}

String method(Integer i) {
    'Integer arg'
}

int i

// autowrap (boxing) over widening
println method(i) // Integer arg

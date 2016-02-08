String method(String arg) {
    'String arg'
}

String method(Object arg) {
    'Object arg'
}

// runtime dispatch

Object o = 'Object'

assert method(o) == 'String arg'
assert method(o as Object) == 'Object arg'

String method(long l) {
    'long arg'
}

String method(Integer i) {
    'Integer arg'
}

int i

// autowrap (boxing) over widening
assert method(i) == 'Integer arg'
assert method(i as long) == 'long arg'

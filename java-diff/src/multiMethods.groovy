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

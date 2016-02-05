String method(String arg) {
    return 'String arg'
}

String method(Object arg) {
    return 'Object arg'
}

// runtime dispatch

Object o = 'Object'

println method(o)
println method((Object) o)

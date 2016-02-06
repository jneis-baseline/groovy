String method(long l) {
    'long arg'
}

String method(Integer i) {
    'Integer arg'
}

int i

// autowrap (boxing) over widening
println method(i) // Integer arg

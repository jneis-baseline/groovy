void method(long l) {
    println 'long arg'
}

void method(Integer i) {
    println 'Integer arg'
}

int i

// autowrap (boxing) over widening
method(i)

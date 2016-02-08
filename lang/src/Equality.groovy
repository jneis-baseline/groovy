class A implements Comparable {
    int i

    int compareTo(Object o) {
        A that = (A) o
        return this.i - that.i
    }
}

class B {
    int i

    boolean equals(o) {
        B that = (B) o
        return this.i == that.i
    }
}

A a1 = new A(i: 1)
A a2 = new A(i: 1)
B a3 = new B(i: 1)
B a4 = new B(i: 1)

assert a1.compareTo(a2) == 0

// equality using compareTo (Comparable)
assert a1 == a1
assert a1 == a2

// equality using equals (not Comparable)
assert a3 == a3
assert a3 == a4

// Comparable vs non-Comparable
assert a1 != a3

// identity
assert a1.is(a1)
assert !a1.is(a2)

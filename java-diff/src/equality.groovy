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

a1.compareTo(a2) // -1

// equality using compareTo (Comparable)
a1 == a1 // true
a1 == a2 // true

// equality using equals (not Comparable)
a3 == a3 // true
a3 == a4 // true

// Comparable vs non-Comparable
a1 == a3 // false

// identity
a1.is(a1) // true
a1.is(a2) // false

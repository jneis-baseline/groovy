class C implements Comparable {
    int i

    int compareTo(Object o) {
        C that = (C) o
        return this.i - that.i
    }
}

class T {
    int i

    boolean equals(o) {
        T that = (T) o
        return this.i == that.i
    }
}

C a1 = new C(i: 1)
C a2 = new C(i: 2)
T a3 = new T(i: 1)
T a4 = new T(i: 2)

println 'a1.compareTo(a2) == ' + a1.compareTo(a2)

// equality when targets are Comparable
println 'a1 == a1 == ' + (a1 == a1)
println 'a1 == a2 == ' + (a1 == a2)

// equality when targets are not Comparable
println 'a3 == a3 == ' + (a3 == a3)
println 'a3 == a4 == ' + (a3 == a4)

println 'a1 == a3 == ' + (a1 == a3)

// identity
println 'a1.is(a1) == ' + a1.is(a1)
println 'a1.is(a2) == ' + a1.is(a2)
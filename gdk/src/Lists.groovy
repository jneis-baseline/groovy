def numbers = [1, 2, 3]
def letters = ['a', 'b', 'cd']

// iteration
numbers.each { println it }
numbers.eachWithIndex{ it, int i -> println "${i}: ${it}" }

// mapping
assert numbers.collect { it * 2 } == [2, 4, 6]
assert numbers.collect { it.multiply(2) } == numbers*.multiply(2)

// finding
assert numbers.find { it > 1 } == 2
assert numbers.findAll { it > 1 } == [2, 3]
assert numbers.every { it < 4 }
assert numbers.any { it > 2 }
assert numbers.max() == 3
assert letters.max { it.size() } == 'cd'
assert letters.count('a') == 1

// reducing
assert numbers.sum() == 6      // plus()
assert letters.sum() == 'abcd' // concat()
assert letters.sum { it == 'a' ? 1 : it == 'b' ? 2 : 0 } == 3
assert numbers.sum(10) == 16

assert numbers.join('-') == '1-2-3'
assert numbers.inject('counting: ') { acc, it -> acc + it } == 'counting: 123'

// checking
assert [].empty
assert ![]
assert numbers.contains(1)

// appending
assert numbers << 4 << 5 == [1, 2, 3, 4, 5]

// set operations
assert 'a' in letters
assert letters.intersect(['a', 'b']) == ['a', 'b']

// sorting
assert [2, 3, 1].sort() == [1, 2, 3]
assert [2, 3, 1].reverse() == [1, 3, 2]

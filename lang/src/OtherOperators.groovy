import java.util.regex.Matcher
import java.util.regex.Pattern

// pattern operator (creates a regex Pattern)
Pattern pattern = ~/.*oo/
Matcher matcher = pattern.matcher('foo')
assert matcher.find()

// find operator (creates a regex Matcher)
matcher = 'foo' =~ /.*OO/
assert !matcher.find()

// spread method args
int sum(int x, int y, int z) { x+y+z }
def nums = [1, 2]
assert sum(*nums, 3) == 6

// spread map elements
def m1 = [b:2, c:3]
assert [a:1, b:10, *:m1] == [a:1, b:2, c:3]
assert [a:1, *:m1, b:10] == [a:1, b:10, c:3]

// ranges
assert 1..3 == [1, 2, 3]
assert 1..<3 == [1, 2]
assert 'a'..'c' == ['a', 'b', 'c']

// spaceship operator (compareTo)
assert (1 <=> 2) < 0
assert (1 <=> 1) == 0
assert (2 <=> 1) > 0
assert (1 <=> 2) == 1.compareTo(2)

// membership operator (contains)
assert 1 in nums
assert !(10 in nums)

// coercion operator (creates a new object, if not the same type)
Integer i = 123
assert !i.is(i as String) // built-in coercion rule

// operator overloading
class Special {
    int i
    Special plus(Special that) {
        new Special(i: this.i + that.i)
    }
}
def s1 = new Special(i: 1)
def s2 = new Special(i: 2)
def s3 = s1 + s2
assert s3.class == Special
assert s3.i == 3

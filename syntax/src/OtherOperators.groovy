import java.util.regex.Matcher
import java.util.regex.Pattern

// pattern operator (creates a regex Pattern)
Pattern pattern = ~/.*oo/
Matcher matcher = pattern.matcher('foo')
matcher.find() // true

// find operator (creates a regex Matcher)
matcher = 'foo' =~ /.*OO/
matcher.find() // false

// spread method args
int sum(int x, int y, int z) { x+y+z }
def nums = [1, 2]
sum(*nums, 3) // 6

// spread map elements
def m1 = [b:2, c:3]
[a:1, b:10, *:m1] // [a:1, b:2, c:3]
[a:1, *:m1, b:10] // [a:1, b:10, c:3]

// ranges
1..3     // [1, 2, 3]
0..<5    // [1, 2]
'a'..'c' // [a, b, c]

// spaceship operator (compareTo)
1 <=> 2 // -1
1 <=> 1 // 0
2 <=> 1 // 1

// membership operator (contains)
1 in nums  // true (nums = [1, 2]
10 in nums // false

// coercion operator (creates a new object, if not the same type)
Integer i = 123
i as String // built-in coercion rule

// operator overloading
class Special {
    int i
    Special plus(Special that) {
        new Special(i: this.i + that.i)
    }
}
def s1 = new Special(i: 1)
def s2 = new Special(i: 2)
s1 + s2 // Special [i = 3]

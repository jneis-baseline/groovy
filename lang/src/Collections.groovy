// lists (or arrays)
def numbers = [1, 2, 3]
assert numbers.class == ArrayList // default

// heterogeneous
[1, 'a', true]

// coerced array
def array = [1, 2, 3] as int[]
assert array.class == int[]

// different list impl through type declaration
LinkedList linked = [1, 2, 3]
assert linked.class == LinkedList

// different list impl through coercion
def set = [1, 2, 2] as Set
assert set.class == LinkedHashSet
assert set == [1, 2] as Set

// append
numbers << 4
assert numbers == [1, 2, 3, 4]

// access
numbers[-1] = 'x'
assert numbers == [1, 2, 3, 'x']

numbers[0,1] = ['a', 'b']
assert numbers == ['a', 'b', 3, 'x']

numbers[2,3] = 'c'
assert numbers == ['a', 'b', 'c', 'c']

numbers[1..3] = ['x', 'y', 'z']
assert numbers == ['a', 'x', 'y', 'z']

numbers[1..3] = 'b'
assert numbers == ['a', 'b']

// multidimensional lists
def multi = [[11, 12], [21, 22]]
multi[0][0] = 99

// maps
def nums = [1: 'one', 2: 'two', 3: 'three']
assert nums.getClass() == LinkedHashMap // default

// accessing
assert nums[0] == null
assert nums[1] == 'one'

// variables as keys
def name = 'Jennifer'

def beauties = [name: 'Lawrence']
assert beauties == ['name': 'Lawrence']
assert beauties['Jennifer'] == null

beauties[(name)] = 'Anniston'
assert beauties['Jennifer'] == 'Anniston'

// maps as objs
def obj = [a: 0, b: true, c: 'two']
assert obj.a == 0

// lists (or arrays)
def numbers = [1, 2, 3]            // ArrayList (default)
def heterogeneous = [1, 'a', true] // ArrayList
def array = [1, 2, 3] as int[]     // class [I (through coersion)
LinkedList linked = [1, 2, 3]      // LinkedList (through type declaration)
def set = [1, 2, 2] as Set         // LinkedHashList ([1, 2])

// append
numbers << 4                       // [1, 2, 3, 4]

// access
numbers[-1] = 'x'                  // [1, 2, 3, x]
numbers[0,1] = ['a', 'b']          // [a, b, 3, x]
numbers[2,3] = 'c'                 // [a, b, c, c]
numbers[1..3] = ['x', 'y', 'z']    // [a, x, y, z]
numbers[1..3] = 'b'                // [a, b]

// multidimensional lists
def multi = [[11, 12], [21, 22]]
multi[0][0] = 99

// maps
def nums = [1: 'one', 2: 'two', 3: 'three'] // LinkedHashMap (default)

// accessing
nums[0] // null
nums[1] // one

// variables as keys
def name = 'Jennifer'

def beauties = [name: 'Lawrence'] // ['name': 'Lawrence']
beauties['Jennifer'] // null

beauties[(name)] = 'Anniston'
beauties['Jennifer'] // 'Anniston'

// maps as objs
def obj = [a: 0, b: true, c: 'two']
obj.a // 0

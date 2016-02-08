// keys are strings by default
def a = 'b'
def map = [a: 1, (a): 2]
assert map['a'] == 1
assert map['b'] == 2
assert map.a == 1
assert map.b == 2

// iteration
map.each { entry -> println "${entry.key}-${entry.value}" }
map.each { key, value -> println "${key}-${value}" }

def people = [
    1: [name:'Lawrence', age: 26],
    2: [name:'Aniston', age: 47],
    3: [name:'Connelly', age: 46],
    4: [name:'Lopez', age: 47]
]

// finding
people.find { it.value.name == 'Lawrence' }
people.findAll { it.value.age > 46 }
assert people.every { it.value.age > 18 }
assert people.any { it.value.age < 50 }

// grouping lists into maps
people.values().groupBy { it.name.charAt(0) }

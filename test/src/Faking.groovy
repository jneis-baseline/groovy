import groovy.mock.interceptor.MockFor
import groovy.mock.interceptor.StubFor

class Translator {
    String translate(String text) {
        'test'
    }
}

// mocking with map coercion
def mock = [translate: {String text -> 'some text'}] as Translator
assert mock.translate('bla') == 'some text'

// mocking SAM types with closure coercion
mock = {String text -> 'another text'} as Translator
assert mock.translate('bla') == 'another text'


class Person {String first, last}
class Family {
    Person father, mother
    def mothersName() {"${mother.first} ${mother.last}"}
}

// mocking with MockFor (strictly ordered expectation, sequence dependent)
mock = new MockFor(Person)
mock.demand.getFirst {'dummy'}
mock.demand.getLast {'name'}
mock.use {
    def mom = new Person(first:'Real', last:'Name')
    def family = new Family(mother:mom)
    assert family.mothersName() == 'dummy name'
}
mock.expect.verify()

// stubing with StubFor (loosely-ordered expectation, sequence independent)
def stub = new StubFor(Person)
stub.demand.with {
    getLast {'name'}
    getFirst {'dummy'}
}
stub.use {
    def dad = new Person(first:'Real', last:'Name')
    def family = new Family(father:dad)
    assert family.father.first == 'dummy'
    assert family.father.last == 'name'
}
stub.expect.verify()

// mocking with ExpandoMetaClass
def person = new Person(first:'1st', last:'lst')
person.metaClass.getFirst {-> 'dummy'}
assert person.first == 'dummy'

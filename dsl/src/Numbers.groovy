import groovy.time.TimeCategory

use(TimeCategory) {
    def today = new Date()
    println today - 3.months
    println 1.minute.from.now
    println 2.hours.ago
    println 1.day.from.today
}

class Distance {
    def number
    String toString() { "${number}m" }
}

@Category(Number)
class NumberCategory {
    Distance getMeters() {
        new Distance(number: this)
    }
}

use(NumberCategory) {
    println 123.meters
}

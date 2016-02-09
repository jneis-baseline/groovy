show = { println it }

squareRoot = { Math.sqrt(it) }

def please(action) {
    [the: { what ->
        [of: { n -> action(what(n)) }]
    }]
}

please(show).the(squareRoot).of(100)

please show the squareRoot of 100

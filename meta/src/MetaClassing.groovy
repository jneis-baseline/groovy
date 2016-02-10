def name = 'jEN'

String.metaClass.changeCase = { ->
    def builder = new StringBuilder()
    delegate.each {
        it = it as char
        it = it.isUpperCase() ? it.toLowerCase() : it.toUpperCase()
        builder << it
    }
    builder.toString()
}

String.metaClass.encoding = 'utf8'

assert name.changeCase() == 'Jen'
assert name.encoding == 'utf8'

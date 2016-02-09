import com.google.common.base.CharMatcher
import com.google.common.base.Splitter

def split(str) {
    [on: { separator ->
        [trimming: { trimChar ->
            Splitter.on(separator).
                    trimResults(CharMatcher.is(trimChar as char)).
                    split(str).
                    iterator().
                    toList()
        }]
    }]
}

split '_a ,_b_ ,c__' on ',' trimming '_'

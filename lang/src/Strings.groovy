def singleQuoted = '\' single-quoted \', \n\"'

def doubleQuoted = " double-quoted \", \n"


// '${}' placeholder may contain any valid expression
//    the last expression returning value is interpolated (possibly, null)

// '$' placeholder can only prefix dotted expressions
//    method calls are invalid

def map = [:]
map.g = "6"

def interpolated = "\${interpolated}  ($map.g${3+2}TR${1}N6${def a=3; def b=2; a+b}) \n"

// multiline
def tripleSingle = '''
triple single-quoted
'''

// slashy strings:
//    - useful for regex
//    - only forward backslashes must be escaped)
//    - multiline
//    - can be interpolated
def slashy = /.* foo ${1}
.* \\ \//

// concatenation mix
singleQuoted + doubleQuoted + interpolated + tripleSingle + slashy

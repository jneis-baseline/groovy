// reading and writing
def file = new File('.', 'Io.groovy')

file.eachLine { line -> println line }
file.eachLine { line, lineNumber -> println "${lineNumber}: ${line}" }

def list = file.collect { it }
byte[] bytes = file.bytes

def txt = new File('.', 'sample.txt')

txt << """Content:
\n
${list.join('\n')}
\n
"""

new File('.', 'sample.file').withOutputStream { stream -> stream.write(bytes) }

// traversing trees
def dir = new File('.')

dir.eachFile { f -> println f.name }
dir.eachFileMatch(~/.*\.groovy/) { f -> println f.name }

new File('..').eachFileRecurse { f -> println f.name }

// external processes
def process = "ls -l".execute()
println "ls -l: ${process.text}"



// normal identifiers (same as Java)

// quoted Identifiers (when following a dot)

def map = [:]

map.'single quoted' = 'spaces allowed'
map."double-quoted" = 'dashes allowed too'
map.'''triple%single#quoted''' = 'special chars also allowed'
map./slashy string/ = 'allowed'

def type = 'interpolated'
map."${type} strings" = 'allowed'
map.'interpolated strings' // allowed
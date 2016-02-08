assert 1.class == Integer
assert 2147483648.class == Long                // Integer.MAX_VALUE + 1
assert 9223372036854775808.class == BigInteger // Long.MAX_VALUE + 1

float f = 1.0
assert f.class == Float

double d = 1E1
assert d.class == Double

def bd = 1.0E1
assert bd.class == BigDecimal

// underscore is permitted in literals (to improve readability)
assert 1234_5678_9012_3456 == 1234567890123456
assert 12_345_678.90 == 12345678.9

// enforcing literal types with suffixes
assert 123I.class == Integer
assert 123L.class == Long
assert 123G.class == BigInteger
assert 123.4F.class == Float
assert 123.4D.class == Double
assert 123.4G.class == BigDecimal

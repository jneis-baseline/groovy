def i = 1                    // Integer
def l = 2147483648           // Long       (Integer.MAX_VALUE + 1)
def bi = 9223372036854775808 // BigInteger (Long.MAX_VALUE + 1)

float f = 1.0  // Float
double d = 1E1 // Double
def bd = 1.0E1 // BigDecimal

// underscore is permitted in literals (to improve readability)
def creditCard = 1234_5678_9012_3456
def money = 12_345_678.90

// enforcing literal types with suffixes
123I   // Integer
123L   // Long
123G   // BigInteger
123.4F // Float
123.4D // Double
123.4G // BigDecimal

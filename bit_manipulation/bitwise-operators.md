# <u>Bit Manipulation.</u>

### AND(&):

Both expressions should be true.
<b>e.g.</b> 0011 & 1111 = 0011

-   When you and with any number, original digits will remain the same.

### OR(|):

If any expression is true, entire expression will be true.
<b>e.g.</b> 0011 | 0101 = 0111

### XOR(^):

Only one should be true.
<b>e.g.</b> 0011 ^ 0101 = 0110

-   Anything xor with 1 we will get the compliment of the original number.
-   Anything xor with 0, it will give us the actual number.
-   If we xor a number with the same number, (now nothing is exclusive), then answer will be zero.

### Complement(~):

Returns the complement of number.
<b>e.g.</b> ~10110 = 01001

### Left Shift Operator.

Shift all the bits to left.
<b>e.g.</b> 1011 = 10110

-   Any number << 1 will double the number.
-   a << b = a $\times 2^b$

### Right Shift Operator.

Shift all the bits to the right. Ignore the most right operators, by how many times you have shifted.
<b>e.g.</b> 1011 = 0101 = 101

-   a >> b = $\frac{a}{2^b}$

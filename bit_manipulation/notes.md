# Bit Manipulation.

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

### COMPLEMENT(~):

Returns the complement of number.
<b>e.g.</b> ~10110 = 01001

# Conversion from decimal to base$_b$.

Keep dividing the decimal by base "b", until the answer is 0, take remainders and write in opposite.

Lets take an example of $(17)_{10}$ and convert it to base <b>2</b>.
Divide it by <b>2</b>, and take the remainders <b>(10001)</b>, now take them in the opposite order (which is similar in this case), <b>(10001)</b>.

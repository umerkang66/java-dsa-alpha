# <u>Negative of Binary Number</u>

A binary number has least significant bit (LSB), and most significant bit (MSB).

-   LSB tells us about that if number is even of odd.
-   MSB tells us about that if number is negative of positive.

### How MSB tells us about positive or negative?

-   If MSB is 1, it means number is NEGATIVE.
-   If MSB is 0, it means number is POSITIVE.
-   Out of integer 32 bits, first bit represent the type of number (positive or negative), and other number will represent the value of number.

### How to convert a binary number into negative?

-   First invert the number (take the complement).
-   Then add 1 to it.
-   We have the negative number.

# <u>Range</u>

How many combination of numbers can be present in one byte (8 bits).

### Formula to find the range.

range = $(-2^{n-1})$ to $(2^{n-1} - 1)$

where $n$ is the number of bits in total bytes.

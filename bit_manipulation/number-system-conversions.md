# <u>Conversion from decimal to base$_b$.</u>

Keep dividing the decimal by base "b", until the answer is 0, take remainders and write in opposite.

Lets take an example of $(17)_{10}$ and convert it to base <b>2</b>.
Divide it by <b>2</b>, and take the remainders $(10001)_2$, now take them in the opposite order (which is similar in this case), $(10001)_2$.

# <u>Conversion of base$_b$ to decimal.</u>

Multiply the current digit from right with "base$^x$" to left, and add them all. $x$ starts from 0, and increases by 1, from right to left side of the number.
<b>e.g.</b>

##### Q1: Convert $(10001)_2$ to decimal.

$= (1\times2^4) + (0\times2^3) + (0\times2^2) + (0\times2^1) + (1\times2^0)$

$= 16 + 0 + 0 + 0 + 1$

$= 17$

$(10001)_2$ in binary is $(17)_{10}$ in decimal.

##### Q2: Convert $(21)_8$ to decimal.

$= (2\times8^1) + (1\times8^0)$
$= 16 + 1$
$= 17$

$(21)_8$ in octal is $(17)_{10}$ in decimal.

### Conversion from non-common number systems to non-common number systems.

First convert that number system to decimal, then convert it to other non-common number system.

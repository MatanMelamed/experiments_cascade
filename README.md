# Problem
Given array of n integers int the range of 0 - (n-1),
where one number is missing and in it's place, there is one duplicate number.
Find missing number

## Solution
In memory, O(n).
Find duplicate number, in O(n)
Xor all numbers 0 - (n-1), xor all array
The missing number is the result of xor both results with duplicate number

### Finding duplicate number:
Start iteration by taking the number from given index to "hand" and put -1 in it's place.
Put the number from "hand" to the matching index, and take the number that was in the new place, into the "hand".
Continue until putting a number in the given index of the iteration,
or until trying to put "hand" in a cell that already contains number equals to "hand".

### Example:
Given array: 1 0 3 3 2

The state of "hand" = h, and the state of array = a

The iteration will start on index 0:<br>
h = 0, a = -1 1 3 3 2<br>
h = -1, a = 0 1 3 3 2<br>
Iteration is over.

Next iteration will start on index 1:<br>
h = 1, a = 0 -1 3 3 2<br>
h = -1, a = 0 1 3 3 2<br>
Iteration is over<br>

Next iteration will start on index 2:<br>
h = 3, a = 0 1 -1 3 2<br>
Iteration is over and 3 will return

### Find missing by XOR:
Given array: a, b, b where indexes are a, b, c:<br>
xor input array = a ^ b ^ b<br>
xor range array = a ^ b ^ c<br>
xor both results with duplicate:<br>
(a ^ b ^ b) ^ (a ^ b ^ c) ^ b =<br>
= (a ^ a) ^ (b ^ b ^ b ^ b) ^ c = c<br>

By Matan Melamed
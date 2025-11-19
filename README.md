# Java Big Integer Arithmetic (Array-Based)

This project is a simple implementation of **big integer arithmetic in Java** using **arrays of digits**, without relying on BigInteger or other built–in high-precision libraries.

It is mainly intended for **learning purposes**, demonstrating how basic arithmetic operations can be implemented manually on very large numbers represented as strings.

---

## Features

Currently implemented operations:

- ✅ Addition of two big integers (`String` input)
- ✅ Subtraction of two big integers (with **negative result** handling)
- ✅ Multiplication of two big integers (schoolbook method, array-based)
- ✅ Division of a big integer by a small integer (`int` divisor)
- ✅ Custom printing function that:
  - Strips leading zeros
  - Prints `0` for a zero result

Implementation details:

- Numbers are read as `String`
- Converted to **reversed int arrays** (each cell = one digit)
- Arithmetic is done using basic digit-by-digit operations with manual carry/borrow handling

---

## Technologies

- Language: Java
- No external libraries
- Standard input/output via Scanner and System.out

---







📘 Big Integer Arithmetic in Java

A full implementation of big integer operations using arrays, without using Java's built-in BigInteger.
Supports:

Addition

Subtraction

Division (by integer)

Multiplication (4 recursive calls – classic method)

Multiplication (3 recursive calls – Karatsuba simplified)

All operations are implemented manually, working on arrays of digits stored in reverse order.

🚀 Features
✔ Big Integer Stored in Arrays

Each digit is stored as an element of an array:

12345  →  [5,4,3,2,1]

✔ Addition (arbitrary length)

Digit-by-digit addition with carry.

✔ Subtraction

Supports negative results (formatted with -).

✔ Division by Integer

Implements long-division on arrays.

✔ Multiplication (Two Methods)
🔹 Method 1: 4 recursive calls

Classic divide-and-conquer approach.

🔹 Method 2: 3 recursive calls (Karatsuba-style)

Efficiency improved by reducing calls from 4 → 3.

🧮 Menu Structure

When you run the program:

1. Addition
2. Subtraction
3. Division
4. Multiplication (4 recursive calls)
5. Multiplication (3 recursive calls)
6. Exit
Enter your choice:


Each option prompts the user for input numbers and prints the result.

🛠 How It Works
🔹 Conversion String → Array

Input numbers are read as strings, then converted into reversed arrays:

static int[] toArray(String s)

🔹 Core Helpers

add() – normal addition

subtract() – normal subtraction using borrow

shift(a, k) – multiply by 10^k

even(a) – pad with a zero to make length even

isZero() – checks if number = 0

trim() – removes leading zeros after operations

These utility functions allow implementation of recursive multiplication.

⭐ Recursive Multiplication (4 Calls)

Implements:

z1 = A0 * B0
z2 = A0 * B1
z3 = A1 * B0
z4 = A1 * B1

Result = z1 + (z2 + z3)*10^k + z4 * 10^(2k)

⭐ Recursive Multiplication (3 Calls — Karatsuba)

Implements:

z0 = A0 * B0
z2 = A1 * B1
z1 = (A0+A1)*(B0+B1)

mid = z1 - z0 - z2

Result = z0 + mid*10^k + z2*10^(2k)


This method is significantly faster for large inputs.

🔧 How to Compile & Run
Compile:
javac BigInteger.java

Run:
java BigInteger

📂 Project File Structure
src/
 ├── BigInteger.java     // Main program + operations
 ├── prefix.java         // (Optional user file)
 ├── PostfixCalculate.java
 └── stack.java

📌 Example Usage
Input:
Enter two numbers:
745
24

Output (4-call):
17880

Output (3-call):
17880

📜 License

This project is open-source.
Free to use for learning, assignments, and GitHub portfolio.

❤️ Author
Mahdi
Big Integer project implemented fully from scratch in Java.

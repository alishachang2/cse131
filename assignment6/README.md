# Assignment 6 - RecursiveMethods

This Java package provides implementations of common recursive algorithms for **Assignment 6**. The methods include calculating exponents, summing arrays, generating a Dragon curve sequence, and computing the maximum path length in a boolean grid.

## Package

`assignment6`

## Dependencies

- [StdDraw](https://introcs.cs.princeton.edu/java/stdlib/StdDraw.java) (imported but not used in current methods)

## Class

### `RecursiveMethods`

Contains static recursive methods for various tasks.

---

### Methods

#### `double exponent(int base, int exp)`

Computes `base` raised to the power `exp` recursively. Handles negative exponents.  

**Example:**

```java
RecursiveMethods.exponent(2, 3);  // returns 8.0
RecursiveMethods.exponent(2, -2); // returns 0.25

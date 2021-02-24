# Tutorial 4

Related to Master Theorem.

## Example 1

Consider the following function:

```cpp
int f1(int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += i;
    }
    return sum;
}
```

Express the running time of ``f1`` as a function of $N$ using Big-O notation. Write a function that has the same functionality as $f1$ but runs in O(1) time.

## Solution 1

Running time is $O(N)$, since there are $N$ steps. This can be proved by induction.

Also, since $0 + 1 + ... + (n - 1) = n * (n + 1) / 2$ we can use the following function to get an $O(1)$ solution.

```cpp
int f1(int n) {
    return n*(n+1)/2;
}
```

<!-- aside 
bignum arithemtic a+b has running time of log(a) + log(b)
-->

## Example 2

Consider the following function:

```cpp
int f5(int n) {
    int sum = 0;
    for (int i = 0; i < n; i = i*2) {
        for (int j = 1; j < i; j++) {
            sum += 1;
        }
    }
    return sum;
}
```

Prove that the running time of ``f5`` is $O(N)$.

## Solution 2

Here $0 + 0 + 1 + 2 + 4 + ... + m$ where $m = 2^k$ and $m < n$. Running time is $2m$ around $2n$. This means that the time complexity is $O(N)$.

<!-- to review above -->

## Example 3

Let $f(n) = 1^2 + 2^2 + 3^2 + ... + n^2$. Prove that $f(n) = O(n^3)$.

## Solution 3

Here $1^2 + 2^2 + 3^2 + ... + n^2 = n*(n+1)*(2n+1)/6$.

* Base: For $n = 1$, $1^2 = (1+2+3)/6$.
* Step: Assuming true for $n - 1$, prove for $n$.

    * $f(n) < 2n + 2n + 3n / 6 = 2n^3$.
    * $f(n) \in \Theta(n^3)$.
    * $f(n) > (n + n + 2n) / 6 = n/3$, therefore $f(n) \in \Omega(n^3)$

* Conclusion: $f(n) \in \Theta(n^3)$

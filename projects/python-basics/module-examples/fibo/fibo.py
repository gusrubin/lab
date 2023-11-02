# Fibonacci numbers module

def fib(n):    # write Fibonacci series up to n
    a, b = 0, 1
    while a < n:
        print(a, end=' ')
        a, b = b, a+b
    print()


def fib2(n):   # return Fibonacci series up to n
    result = []
    a, b = 0, 1
    while a < n:
        result.append(a)
        a, b = b, a+b
    return result


# Make the file usable as a script as well as an importable module,
# because the code that parses the command line only runs if the module
# is executed as the “main” file
if __name__ == "__main__":
    import sys
    fib(int(sys.argv[1]))

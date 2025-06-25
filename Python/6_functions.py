# Function with parameters and arguments
def multiply(a, b):
    product = a * b
    print("Product:", product)

multiply(5, 4)

# Function with return value
def calculate_square(number):
    return number * number

square = calculate_square(6)
print("Square of 6 is:", square)

# Function with *args and **kwargs
def display_information(*args, **kwargs):
    print("Positional arguments:", args)
    print("Keyword arguments:", kwargs)

display_information(10, 20, 30, name="Example", age=25, subject="Math")

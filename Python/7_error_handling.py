# Try-except block
try:
    result = 10 / 0
except ZeroDivisionError as e:
    print("An error occurred:", e)

# Else and finally
try:
    number = int("100")
except ValueError:
    print("Invalid input")
else:
    print("Conversion successful:", number)
finally:
    print("End of try-except block")

# Raise an exception
def check_age(age):
    if age < 0:
        raise ValueError("Age cannot be negative")
    else:
        print("Valid age:", age)

try:
    check_age(-5)
except ValueError as e:
    print("Caught exception:", e)

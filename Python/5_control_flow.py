# If-else statement
score = 75
if score >= 50:
    print("Pass")
else:
    print("Fail")

# For loop
print("List of even numbers between 1 and 10:")
for number in range(1, 11):
    if number % 2 == 0:
        print(number)

# While loop
print("Counting from 1 to 5 using while loop:")
counter = 1
while counter <= 5:
    print(counter)
    counter += 1

# Break and continue
print("Demonstration of break and continue:")
for i in range(1, 10):
    if i == 7:
        print("Breaking the loop at 7")
        break
    if i % 3 == 0:
        print("Skipping multiple of 3")
        continue
    print("Current number:", i)

# Pass statement
print("Pass statement example:")
# 'pass' is used when a statement is required syntactically but no action needs to be taken
# It is often used as a placeholder for future code or inside empty loops/conditionals
for i in range(3):
    if i == 1:
        pass  # No action is taken when i == 1, this block is intentionally left blank
    print("Current value:", i)

# Loop-else
print("Loop-else demonstration:")
# The 'else' block after a for-loop or while-loop runs only if the loop completes normally (no break)
for i in range(5):
    print("Loop value:", i)
    if i == 3:
        print("Breaking the loop early")
        break
else:
    print("Loop completed without break")  # This will not execute if break was used

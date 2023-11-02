import sys
paramValue = sys.argv[1]
print("The value is: ", paramValue)

if int(paramValue) < 0:
    paramValue = 0
    print('Negative changed to zero')
elif int(paramValue) == 0:
    print('Zero')
elif int(paramValue) == 1:
    print('Single')
else:
    print('More')
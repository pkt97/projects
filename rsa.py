m=1
cipher=3
plain=2
a=1
b=1
c=1
d=1
n=1
e=2
d=1
i=0
f=1
phi=1
def prime(a):
  flag=0
  for i in range(2,a):
    if(a%i==0):
      print(a,"is not a prime number")
      exit(0)
      #return 0
  if(flag==0):
    return 1
  return 1
def gcd(a,b):
  if(a%b==0):
    return b
  else:
    return gcd(b,a%b)
a=int(input("Enter first number"))
b=int(input("Enter second number"))
c=prime(a)
d=prime(b)
n=a*b
phi=(a-1)*(b-1)
for e in range(2,phi):
  if(gcd(e,phi)==1):
    print(e)
print("Above is/are the possible value/s of e")
f=int(input("Select any value of e:"))
for i in range(0,phi):
  d=i
  if((d*e)%phi==1):
    break
print("Private key is",d)
m=int(input("Enter any message:"))
cipher=pow(m,d)
cipher=cipher%n
print("Cipher text is",cipher)
plain=pow(cipher,e)
plain=plain%n
print("Plain text is",plain)
    
Output:
Enter first number 5
Enter second number 7
5
7
11
13
17
19
23
Above is/are the possible value/s of e
Select any value of e: 13
Private key is 23
Enter any message: 23
Cipher text is 32
Plain text is 23

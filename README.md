# ISBNConverter

Write an application that can convert a product ID number to a standard ISBN-10 number.
If we take the Da Vinci Code as an example, the product ID is 978140007917 and the ISBN is
1400079179. The first 3 digits of the product ID (978) are a prefix that can be removed. The
remaining digits of the product ID (140007917) are the digits of the ISBN excluding the error
control digit.
Refer to Appendix 1 below for a description of how an ISBN number is constructed.
Your task is to develop an application that can accept a Product ID number and generate the
ISBN-10 number.
You can code this up as a console application that takes in Product ID as input then outputs the
ISBN.

Sample Test Cases
ProductID ISBN
978155192370 155192370x
978140007917 1400079179
978037541457 0375414576
978037428158 0374281580

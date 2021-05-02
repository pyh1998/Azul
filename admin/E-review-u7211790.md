## Code Review

Reviewed by: Yuhui Pang, u7211790

Reviewing code written by: Qinling Zhong, u6616888

Component: isSharedStateWellFormed() method in class Azul (Task 2)

### Comments 

The main purpose of this part of the code is to check whether 
the string of shared state is valid.

This part of the code is clear, good performance, and the required function is well realized.
Qinling divides the process of judgment into four parts: factory part, center part, bag part and discard part.
By cutting the original string to get the substring representing different classes, and then check them in different classes.
In addition, the method of checking whether the string of each region is valid is written in the corresponding class in the form of class method by using static keyword. 
This reflects the idea of object-oriented.

This part of the code follows Java code conventions, the methods and variables are properly named.
For example, isWellFormed() methods in each class, and String factoryStr, String centreStr and so on.
When I see the names, I can see what these methods and variables do clearly.








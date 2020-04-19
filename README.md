# The-Juice-Problem

## [Zinrelo](https://zinrelo.com) Assignment

You decide to throw a party for your best friends.
But your friends are very particular about their fitness, and **each of them has exact calorie intake limits.**  Nothing more and nothing less. And, Since you want to be an excellent host , you plan to make sure they each get their exact limit!
You decide to make a specific fruit juice-mix for each of your friends using the different freshly squeezed fruit juices you have in your cupboard. The completed fruit juice-mix for your friend will have total calorie content value equal to the sum of the calorie contents of the individual fruit juices. 
To make a fruit juice-mix, you decide to use any of the fruit juices that appear in you cupboard shelf. The same fruit juice can appear multiple times and can also be used as many times as it appears. 
Though there are multiple ways to choose these juices to make the fruit juice-mix following the rules given above, you just want to pick one particular combination. So you decide to choose only the set of fruit juices that must appear **IN AN ALPHABETICALLY ORDERED** list of fruit juices which satisfy the calorie constraints. 

### Input:
The inputs for your algorithm appear in the following lines:
- LINE 1 - The first line has the number of friends you have invited for the cocktail party. (Maximum is 200 friends you could invite.)
- LINE 2 - The first variable is an integer, say ‘m’ between 1 and 26 which denotes the number of **unique fruit juices** on the shelf. This variable is separated by a space followed by positive integers from the set {1, 2, 3, 4…….100} describing the calorie content for each fruit juice in an alphabetically sorted list of unique fruit juices. For example, the first value corresponds to calories for Fruit A, the second to Fruit B and so on.
- LINE 3 - contains a sequence of lower case English alphabets which signify the **NAME** of the fruit juice that is actually on the cupboard (you can have multiple bottles of the same juice and in any order)
- LINE 4 - contains a positive integer which specifies the exact calorie intake requirement of your friend.

```
    3 (Number of friends)
    5 21 1 21 3 3 (Fist number denotes # of unique fruit juices then calories of each unique fruit juice on the cupboard)
    accdeeccdeeaab (The actual list of fruit juices in the cupboard)
    2 (Calorie intake requirement for your first friend)
    2 3 4 (Fist number denotes # of unique fruit juices then calories of each unique fruit juice on the cupboard)
    baba (The actual list of fruit juices in the cupboard)
    7 (Calorie intake requirement for your second friend)
    3 5 4 6 (Fist number denotes # of unique fruit juices then calories of each unique fruit juice on the cupboard)
    abcbacbabcc (The actual list of fruit juices in the cupboard)
    15 (Calorie intake requirement for your third friend)
```

### Output:
For each test case, output the sequence of the fruit juices to be used to serve your friend a fruit juice-mix that meets her calorific requirements, or the word **“SORRY, YOU JUST HAVE WATER”** if you are not able to meet her requirements.
```
    SORRY, YOU JUST HAVE WATER (For Friend 1)
    ab (For Friend 2)
    aaa (For Friend 3)
```


### Comments:
For the first friend we have five unique fruit juices {a, b, c, d, e} with each having a calorie total value of {21, 1, 21, 3, 3} respectively. To achieve a total calorie intake of 2, we first sort the entire list of fruit juices (LINE 3 inputs) after which we ascertain that we need 2 bottles of b (with calorie count of 1 per bottle) whereas, we have only one b juice in our cupboard. Hence, we cannot make the cocktail for the first friend and so she will be politely told “SORRY, HAVE WATER”.
For the 2nd friend we have 2 unique bottles {a, b}, with calorie counts of {3, 4} respectively. Her calorific need is 7 which after sorting the bottles on the cupboard {baba} can be met by 1 bottle of “a”, and 1 bottle of “b”.
For the 3rd friend we have 3 unique bottles {a, b, c} with calorie counts of {5, 4, 6} respectively.  Her calorific requirement is 15 which after sorting the bottles on the cupboard {abcbacbabcc} can be met by the bottles “aaa”.


#### Sample Input: 
```
3
5 21 1 21 3 3
accdeeccdeeaab
2
2 3 4
baba
7
3 5 4 6
abcbacbabcc
15
5 21 1 21 3 3
accdeeccdeeaab
4
5 21 1 21 3 3
accdeeccdeeaab
7
2 3 4
baba
0
2 3 4 
babab
12
3 3 4 4 
abbbc
12
```

#### Sample Output:
```
SORRY, YOU JUST HAVE WATER
ab
aaa
bd
bdd
SORRY, YOU JUST HAVE WATER
bbb
bbb
```


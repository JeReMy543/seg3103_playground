# Lab 01

| Outline | Value |
| --- | --- |
| Course | SEG 3103 |
| Date | Summer 2021 |
| Professor | Andrew Forward, aforward@uottawa.ca |
| TA | Zahra Kakavand, zkaka044@uottawa.ca |
| Team | Xinhao Zhang 8761627 |

## Deliverables

* [https://github.com/JeReMy543/seg3103_playground](https://github.com/JeReMy543/seg3103_playground)
* Shared repo above with TA and Professors

### Java


```bash
$ java --version
java 15.0.1 2020-10-20
Java(TM) SE Runtime Environment (build 15.0.1+9-18)
Java HotSpot(TM) 64-Bit Server VM (build 15.0.1+9-18, mixed mode, sharing)
```

First compile the code by the following command.

```bash
javac -encoding UTF-8 --source-path src -d dist src/*.java
```

Then run it

```bash
java -cp ./dist Main
```

Here is an output of the running program

```bash
Newmath (type 'exit' to exit program)
Numerator: 52
Demoninator: 26
52 / 26 = 2
Numerator: exit
```
This is the screenshot of the output

![Running Java in the console](assets/java.png)

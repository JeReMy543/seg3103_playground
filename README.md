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

![Running Java in the console](https://github.com/JeReMy543/seg3103_playground/blob/main/assets/java.PNG)

### JUnit

I am working with JUnit 5 (via Console standalone 1.7.1)

To run JUnit, I need to compile the application (see above), and then compile the test code

```bash
javac -encoding UTF-8 --source-path test -d dist -cp lib/junit-platform-console-standalone-1.7.1.jar test/*.java src/*.java
```

Then I run the tests using

```bash
java -jar lib/junit-platform-console-standalone-1.7.1.jar --class-path dist --scan-class-path
```

Here is the output of the tests

```bash
Thanks for using JUnit! Support its development at https://junit.org/sponsoring

←[36m.←[0m
←[36m+--←[0m ←[36mJUnit Jupiter←[0m ←[32m[OK]←[0m
←[36m| '--←[0m ←[36mNewmathTest←[0m ←[32m[OK]←[0m
←[36m|   +--←[0m ←[34mdiv_ok()←[0m ←[32m[OK]←[0m
←[36m|   '--←[0m ←[34mdiv_by_zero()←[0m ←[32m[OK]←[0m
←[36m'--←[0m ←[36mJUnit Vintage←[0m ←[32m[OK]←[0m

Test run finished after 61 ms
[         3 containers found      ]
[         0 containers skipped    ]
[         3 containers started    ]
[         0 containers aborted    ]
[         3 containers successful ]
[         0 containers failed     ]
[         2 tests found           ]
[         0 tests skipped         ]
[         2 tests started         ]
[         0 tests aborted         ]
[         2 tests successful      ]
[         0 tests failed          ]

```

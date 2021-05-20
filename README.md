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


### Elixir

I am running Elixir 12.0 with Erlang 22

```bash
Erlang/OTP 22 [erts-10.7] [64-bit] [smp:12:12] [ds:12:12:10] [async-threads:1]

Elixir 1.12.0 (compiled with Erlang/OTP 22)
```

To run the Elixir program (in `newmath_ex`), first I compile it

```bash
mix compile
```

Then I run it

```bash
iex -S mix
```

Here is an output of the running program

```elixir
NewmathEx.div(52,26)
{:ok, 2.0}
```

With a screenshot from the terminal
![Running Java in the console](https://github.com/JeReMy543/seg3103_playground/blob/main/assets/elixiroutput.PNG)


### ExUnit

ExUnit is built directly into Elixir (and compiled like above with `mix compile`)

To run the tests

```
mix test
```

Here is the output of the tests

```bash
...

Finished in 0.04 seconds (0.00s async, 0.04s sync)
1 doctest, 2 tests, 0 failures

Randomized with seed 792000
```

With a screenshot from the terminal

![Running ExUnit in the console](https://github.com/JeReMy543/seg3103_playground/blob/main/assets/exunit.PNG)

# Phone Directory (Java)

A university exercise in Java: a phone directory that links each person to a list of phone numbers. It implements the `IAnnuaire` and `IListeNumTel` interfaces given in the course.

## Features

- **Directory (`Annuaire`):** add a person with their numbers, add a number at the start or end of their list, get their first number or all of them, remove a person, list everyone
- People are kept sorted by name in a `TreeMap` (`Personne` implements `Comparable`), so you can also get everyone between two names
- **Phone number list (`ImpListeNumTel`):** add at the start, at the end or at a position, remove, check whether a number is there, count, get the first one, iterate
- **Phone numbers (`NumTel`):** a number with a type: home landline, mobile, fax or unknown
- Two interactive console programs with a menu to try every operation

## Files

| File | What it is |
| --- | --- |
| `IAnnuaire.java`, `IListeNumTel.java` | Interfaces from the course |
| `Annuaire.java` | Directory implementation |
| `ImpListeNumTel.java` | Phone number list implementation |
| `Personne.java`, `NumTel.java` | Person and phone number classes |
| `LectureClavier.java` | Helper to read keyboard input |
| `TestAnnuaire.java` | Console menu for the directory |
| `ListeNumTelTest.java` | Console menu for the number list |

## Run it

You need a JDK (8 or newer).

```bash
git clone https://github.com/hamzakhalem/IANNUAIRE.git
cd IANNUAIRE
javac -encoding ISO-8859-1 *.java
java TestAnnuaire
```

Run `java ListeNumTelTest` to try the number list on its own.

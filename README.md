# LoamStream Hiring Exercise

Thanks for taking the time to do this exercise.  There are several ways to do it, all with different tradeoffs.  We've tried to make it fair - no trick questions or brain teasers - but feedback is welcome.

## Instructions

* Download or clone this repo.  
* Implement `org.broadinstitute.hiring.Planner.Default.findButtonPresses` such that all the unit tests pass.
* Zip up your code and send it to us.

## Details 

Suppose you want to watch a movie at home, via some Netflix-like service displayed on a screen in your living room.  You don't interact with this service using a keyboard and mouse, but rather with a remote control that has (for our purposes) five buttons: up, down, left, right, and select.  The directional buttons move a cursor around on an on-screen virtual keyboard.  The select button "types" the key the cursor is on.  There's a search UI, where you "type" in strings using the on-screen keyboard and search the movie library for films that match.

Your task is to implement the `Planner.Default.findButtonPresses` method to help you type things in.  Given a representation of a keyboard and a string you'd like to type, this method should find the button presses needed to enter in the characters in the string.  For example, suppose you'd want to spell `cat` on a keyboard that looks like this:
```
q w e r t y u i o p
a s d f g h j k l
z x c v b n m
```

Assuming the cursor starts on `q`, one solution is
```java
[down, down, right, right, select,       //c
 up, left, left, select,                 //a
 up, right, right, right, right, select] //t
```

Note that there are many, many paths the cursor could take between any two keys.  (It could meander indefinitely, for example.)  There are also lots of equivalent or symmetrical paths: `right, down` and `down, right`, etc.  We're not looking for the shortest or "best" sequences of button presses, just ones that are valid.

## Notes

* Though it's not required, you'll find it helpful to run the tests with Maven.  Maven can be downloaded here https://maven.apache.org/download.cgi , though instructions for installing and running Maven are beyond the scope of this README.
* To run the tests, from the directory you cloned or downloaded, run `mvn test`.

CPSC 233 Assignment 4 Program Testing Package

This is the testing package that provides you extra input files for testing
your program.

---------------------------------------------------------------
You will find the following *.java files in this package:

* Oracle.java: This version includes a minor update to allow the Oracle to
  accept real numbers as the coordinates of the murder location.

* Time.java: This version includes a minor update in the toString() method to
  present time in the HH:MM format.

* Marker.java: This is a slightly modified version of the Driver class. This
  will be used by the TAs to exam your program for partial mark if your program
  does not have the optimal solution.

---------------------------------------------------------------
You will find the following input files in this package:

* oracle.txt and suspects.txt (The input files for the Oracle and the
  Detective, respectively, released with the assignment.)

* oracle1.txt and oracle2.txt (Two additional input files for the Oracle.
  These two files need to be used with either suspects1.txt or suspects2.txt)

* suspects1.txt and suspects2.txt (Two additional input files for the
  Detective. These two files need to be used with either oracle1.txt or
  oracle2.txt)

---------------------------------------------------------------
Here are few notes on frequently asked questions:

* As can be observed in these input file, you may assume that there will
  always be a match for individual part of the murder case in the suspects list,
  but not necessary the entire case. In other words, you may find one suspect
  case has a matching suspect, but not matching location and time; another
  suspect case has a matching location, but not matching person and time; and
  another suspect case has a matching time, but not matching person and
  location.

* The check() method in the Detective class returns true only if the detective
  has derived the murder case completely. Otherwise, it should return false.

* Please keep in mind that you may loss precision when operating on floating
  point numbers. For this reason, the murder location derived by the detective
  may not be identical to the location specified in the input file for the
  Oracle. The following output is acceptable (don't add extraneous information
  to it):

  $ java Driver suspects.txt oracle.txt 
  Number to times the Oracle is queried: 7
  Number of suspects checked: 2
  Detective found: 
  Person: male, 20's, 1.75m
  Location: (49.99999999999983, -144.0)
  Time: 19:30

* Before submitting your program, please make sure the output is only generated
  by the Driver class or the Marker class.


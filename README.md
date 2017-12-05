# bioe134-final-proj
Final Project for BioE 134, Fall 2017.

Reads in data from BUA.doc files (which are not stored here, but in ../data),
and parses them into BUA objects.
The project structure is:

* `code/this repo`
* `data/init/`
* `data/BUAName.doc`

In order to run the code, first convert your `BUAName.doc` file to a `txt` file of
the same name, and save it in the same directory as the `doc` file. As-is, 
`BUAConverter.java` just converts every single `.doc` file in the `data` directory,
but you can also specify individual filenames to pass into `BUAConverter.createBUA`.

The BUAs aren't stored on this repo for privacy reasons, but a sample blank BUA
can be downloaded from [here](https://ehs.berkeley.edu/biosafety/how-do-i-get-or-renew-bua).

For the same reasons, I don't have any demos/examples posted here, but I can email
over any additional materials; in addition, there are six files in `data/init` that
are not stored here which I used to parse the checkboxes which do not have any
sensitive data in them, but are essentially just blank BUAs with only certain boxes
checked.



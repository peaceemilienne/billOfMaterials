# billOfMaterials 
billOfMaterials is a program which maintains a hypothetical Part Store and a Bill of Materials list for each part in 
that part store. 

As defined by Wikipedia a bill of materials (BOM) is a list of the sub-component parts and the quantities of 
each needed to manufacture a product.

For more details about BOM check out Wikipedia's formal definition here: https://en.wikipedia.org/wiki/Bill_of_materials


## Installation

*git clone this repository on your local computer

*Make sure you have installed Java Development Kit 11+ and it's linked with your IDE.

*This program contain JUnit 5 tests hereby I recommend checking out JUnit 5's user guide: https://junit.org/junit5/docs/snapshot/user-guide/index.html
to be able to run tests included in this program depending on your IDE.

## Usage
This program contain a json file that desribes properties of a part and manipulates it to give different results.

Below there is a detailed desrciption of how the program manipulates that json file which could be considered as database of that hypothetical part store's parts
and all of the implementations are tested in the JUnit 5 test class to make sure they work as expected.

1.Imports the part store from the json file and returns the number of parts imported.

2.Computes the cost to manufacture the part associated with the supplied part number.

3.Retrieves the part associated with the supplied part number from the part store.

4.Returns all final assembly parts sorted alphabetically by their part number (Final assemblies have a part type of “ASSEMBLY”).

5.Returns all purchased parts sorted by their price, highest price to lowest (Purchase parts have a part type of “PURCHASE”).

PS: This program has no main function, all execution are tested in JUnit 5 tests.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

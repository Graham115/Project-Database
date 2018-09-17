CREATE TABLE Ships(
	noOfShip  varchar(4),
    nameOfShip varchar(30) NOT NULL,
    nationID	int NOT NULL,
    PRIMARY KEY(nameOfShip),
	FOREIGN KEY(nationID) REFERENCES Nations(nationID));
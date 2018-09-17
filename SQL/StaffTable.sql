CREATE TABLE Staff(
	captianName varchar(30) NOT NULL,
    rank varchar(20),
    nameOfShip varchar(30) NOT NULL,
    PRIMARY KEY(captianName),
	FOREIGN KEY (nameOfShip) REFERENCES Ships (nameOfShip));
CREATE TABLE CV(
	noOfShip  varchar(4),
    nameOfShip varchar(30) NOT NULL,
	hull	varchar(10),
    flightControl	varchar(10),
    fighters		varchar(20),
    bombers		varchar(20),
    torpendoBomber		varchar(20),
    engineMod		varchar(20),
    PRIMARY KEY(noOfShip));
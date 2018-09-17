CREATE TABLE BB(
	nationName varchar(8),
	noOfShip  varchar(4),
    nameOfShip varchar(30) NOT NULL,
    MainBattery	varchar(20),
    hull	varchar(10),
    GunFireControl		varchar(20),
    engineMod		varchar(20),
    PRIMARY KEY(noOfShip),
	FOREIGN KEY (nationName) REFERENCES Nations (nationName));
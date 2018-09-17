CREATE TABLE Weapons(
    MainBattery	varchar(20) NOT NULL,
    hull	varchar(20),
    torpedos varchar(10),
    nameOfShip varchar(30) NOT NULL,
    PRIMARY KEY(MainBattery),
	FOREIGN KEY (nameOfShip) REFERENCES Ships (nameOfShip));
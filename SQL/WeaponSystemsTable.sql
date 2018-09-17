CREATE TABLE WeaponSystems(
    GunFireControl	varchar(20) NOT NULL,
    engineMod		varchar(30),
    MainBattery varchar(20) NOT NULL,
    PRIMARY KEY(GunFireControl),
	FOREIGN KEY (MainBattery) REFERENCES Weapons (MainBattery));
#INSERT INTO Nations VALUES(100, 'BB');
#INSERT INTO Nations VALUES(101, 'CL');
#INSERT INTO Nations VALUES(102, 'DD');

#INSERT INTO Ships VALUES(1130, 'New York', 100);
#INSERT INTO Ships VALUES(1240, 'Omaha', 101);
#INSERT INTO Ships VALUES(1350, 'Bogue', 102);

#INSERT INTO Weapons VALUES('356mm/45 Mk2', 'New York(B)', 'Mark 12','New York');
#INSERT INTO Weapons VALUES('152 mm/53 Mk13/Mk16', 'Omaha(C)', 'Mark 11', 'Omaha');
#INSERT INTO Weapons VALUES('Planes', 'Bogue(B)',  'Mark 10','Bogue' );

#INSERT INTO Staff VALUES('Charles Powers' , 'Rear Admiral','New York');
#INSERT INTO Staff VALUES('David Dickinson' , 'Captain','Omaha');
#INSERT INTO Staff VALUES('Peter Reed' , 'Vice Admiral','Bogue');

#INSERT INTO WeaponSystems VALUES('Mk5 mod.2', 'Propulsion: 28,100 hp', '356mm/45 Mk2');
#INSERT INTO WeaponSystems VALUES('Mk5 mod.1.5', 'Propulsion: 90,000 hp', '152 mm/53 Mk13/Mk16');
#INSERT INTO WeaponSystems VALUES('Mk5 mod.1', 'Propulsion: 8,500 hp', 'Planes');

########################################################################################################
#INSERT INTO Ships VALUES('USA', 1130, 'New York', '356mm/45 Mk2', 'New York(B)', 'Mk5 mod.2','Propulsion: 28,100 hp');
#INSERT INTO Ships VALUES('USA', 1131, 'New Mexico', '356mm/50 Mk4', 'New Mexico(B)', 'Mk6 mod.2','Propulsion: 37,000 hp');
#INSERT INTO Ships VALUES('USA', 1132, 'Colorado', '406 mm/45 Mk1', 'Colorado(B)', 'Mk7 mod.2','Propulsion: 28,900 hp');

#INSERT INTO Weapons VALUES('1240', 'Omaha', '152 mm/53 Mk13/Mk16', 'Omaha(C)', 'Mk5 mod.2','Mark 11','Propulsion: 90,000 hp');
#INSERT INTO Weapons VALUES('1241', 'Cleveland', '152 mm/47 Mk16', 'Cleveland(B)', 'n/a','Mk6 mod.2','Propulsion: 100,000 hp');
#INSERT INTO Weapons VALUES('1242', 'Pensacola', '203 mm/55 Mk14', 'Pensacola(B)', 'n/a','Mk7 mod.2','Propulsion: 107,000 hp');

#INSERT INTO Staff VALUES('1350', 'Bogue', 'Bogue(B)', 'Mk5 mod.1', 'Grumman F4F-4','Douglas SBD-2','Douglas TBD','Propulsion: 8,500 hp');
#INSERT INTO Staff VALUES('1351', 'Independence', 'Independence(B)', 'Mk6 mod.1', 'Grumman F6F-3','Douglas SBD-5','Douglas TBD','Propulsion: 100,000 hp');
#INSERT INTO Staff VALUES('1352', 'Ranger', 'Ranger(B)', 'Mk7 mod.1', 'Grumman F6F-5','Douglas SBD-5','Grumman TBF','Propulsion: 53,500 hp');

#INSERT INTO WeaponSystems VALUES('1460', 'Nicholas', '127 mm Mk7/Mk21', 'Nicholas(B)', 'Mk5 mod.1','Mark 11','Propulsion: 55,000 hp');
#INSERT INTO WeaponSystems VALUES('1461', 'Farragut', '127 mm/38 Mk21', 'Farragut(C)', 'Mk6 mod.2','Mark 12','Propulsion: 42,800 hp');
#INSERT INTO WeaponSystems VALUES('1462', 'Mahan', '127 mm/38 Mk21', 'Mahan(B)', 'Mk7 mod.2','Mk15 mod.0','Propulsion: 49,000 hp');
#########################################################################################################
 #DROP TABLE Nations;
 #DROP TABLE Ships;
 #DROP TABLE Weapons;
 #DROP TABLE Staff;
 #DROP TABLE WeaponSystems;
 #show tables;
 #UPDATE Nations SET typeOfShip='BB' WHERE nationID=103;
#SELECT * FROM WeaponSystems;
#SELECT Nations.typeOfShip, Ships.nameOfShip FROM Nations INNER JOIN Ships ON Nations.nationID = Ships.nationID;
#SELECT DISTINCT GunFireControl, MainBattery FROM WeaponSystems WHERE GunFireControl = 'Mk5 mod.1';
#SELECT COUNT(noOfShip), nameOfShip FROM Ships GROUP BY nameOfShip;
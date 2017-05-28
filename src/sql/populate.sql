 
INSERT INTO usercredential(username,password,verifyPassword, enabled) VALUES ('guest','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
INSERT INTO usercredential(username,password,verifyPassword, enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);
 
INSERT INTO authority (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_USER');

INSERT INTO  user (firstName, lastName,email,ranking,admin) VALUES ('Curious','George','george@gmail.com',12,TRUE);
INSERT INTO user (firstName, lastName,email,ranking,admin) VALUES ('Allen','Rench','rench@gmail.com',21, TRUE);

INSERT INTO customer (firstName, lastName, passport) VALUES ('Dora', 'Khiev', '123456789');
INSERT INTO customer (firstName, lastName, passport) VALUES ('James', '007', '234332212');
INSERT INTO customer (firstName, lastName, passport) VALUES ('Edy', 'John', '214332212');
INSERT INTO customer (firstName, lastName, passport) VALUES ('Tran', 'Ven', '214332232');

INSERT INTO roomtype (description, roomTypeName) VALUES ('', 'KING ROOM')
INSERT INTO roomtype (description, roomTypeName) VALUES ('', 'QUEEN ROOM')
INSERT INTO roomtype (description, roomTypeName) VALUES ('', 'SINGLE ROOM')

INSERT INTO room (floor, maxGuest, price, roomName, roomNumber, roomType_id) VALUES (1, 2, 50, '001', '001', 3)
INSERT INTO room (floor, maxGuest, price, roomName, roomNumber, roomType_id) VALUES (1, 2, 100, '002', '002', 2)
INSERT INTO room (floor, maxGuest, price, roomName, roomNumber, roomType_id) VALUES (1, 2, 150, '003', '003', 1)

INSERT INTO reservation (checkInDate, checkOutDate, customer_id) VALUES ('2017-05-29', '2017-05-31', 1);
INSERT INTO reservation (checkInDate, checkOutDate, customer_id) VALUES ('2017-05-29', '2017-05-31', 2);
INSERT INTO reservation (checkInDate, checkOutDate, customer_id) VALUES ('2017-05-29', '2017-05-31', 3);

INSERT INTO customer_reservation VALUES(1, 1)
INSERT INTO customer_reservation VALUES(2, 2)
INSERT INTO customer_reservation VALUES(3, 3)

 
INSERT INTO credentials(username,password,enabled) VALUES ('guest','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);
 
INSERT INTO authority (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_USER');

INSERT INTO  `MEMBER` (firstname, lastname,age,title,membernumber, member_id) VALUES ('Curious','George',12,'Boy Monkey', 8754,'admin');
INSERT INTO `MEMBER` (firstname, lastname,age,title,membernumber,member_id) VALUES ('Allen','Rench',123,'Torque Master', 8733,'guest');

					
 
INSERT INTO usercredential(username,password,enabled) VALUES ('guest','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
INSERT INTO usercredential(username,password,enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);
 
INSERT INTO authority (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_USER');

INSERT INTO  user (firstName, lastName,email,ranking,admin) VALUES ('Curious','George','george@gmail.com',12,TRUE);
INSERT INTO user (firstName, lastName,email,ranking,admin) VALUES ('Allen','Rench','rench@gmail.com',21, TRUE);

//INSERT INTO usercredential (username, password, enabled) VALUES 
// ('Paul','$2a$10$cbn04TjztMMe9iQiIk3tT.sv3HBDg8FGnlO8UIlaKtP5PtiNVqPka',TRUE),
//  ('Sean','$2a$10$q2mJubO41mryHffrWrEi6e63BDdCgcadq36pXUXnBunZUxDq96Atu',TRUE);	


//INSERT INTO `authority` VALUES (1,'ROLE_ADMIN','Sean'), (4,'ROLE_SUPERVISOR','Paul');
  
//INSERT INTO `users` VALUES 
// (4,'','Paul@Cookies.com','Paul','Bearer',7,'Paul'),
//(1,'','Sean@Cookies.com','Sean','Smith',1,'Sean');
 
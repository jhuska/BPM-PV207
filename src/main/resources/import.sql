--insert into ORGANIZATION (bussinessDetails) values ('FooBar events s.r.o.');
--insert into APP_USER (kind, organizationId) values ('ORGANIZATION_OFFICIER', 1);
--insert into CONTACT_INFO (contactInfoId) values (1);
--insert into USER_ACCOUNT (login, password, contactInfoId, userId) values ('test', '\\x74657374', 1, 1);
--insert into MEDIA_ITEM (mediaType, url) values ('IMAGE', 'http://dl.dropbox.com/s/rujjiar066nkfln/modnaprehliadka.jpg');
--insert into EVENT (kind, name, description, startOfEvent, endOfEvent, createdToSystem, featured, mediaItem_id) values ('SINGLE_EVENT', 'DnB Fléda', 'Najlepší DnB DJs z Česka a Slovenska', DATE '2013-04-12', DATE '2013-05-12', DATE '2011-05-12', false, 8);

--1
insert into APP_USER (userName, banned) values ('Jozef Spisiak', false);
--2
insert into APP_USER (userName, banned) values ('Milan Rastislav Stefanik', false);
--3
insert into APP_USER (userName, banned) values ('Miriam Chytilova', false);
--4
insert into APP_USER (userName, banned) values ('Janka Hospodarova', false);

--1
insert into BILL (appUserId, forWhat, created) values (1, 'Playstation 4', DATE '2014-09-12');
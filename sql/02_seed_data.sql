

-- Script to populate database tables

INSERT INTO users (full_name, email, password, role, supervisor_id)
VALUES
    ('Muhammad Yahya Moosa', 'yahya@example.com', '$2a$12$QAj8K3TzKAa1vPXz7v.CO.k4m9F.uxZUDrOHO2YxUgsxYo0l8Hxfu', 'PM', NULL),
    ('Mustafa Marri', 'mustafa@example.com', '$2a$12$QAj8K3TzKAa1vPXz7v.CO.k4m9F.uxZUDrOHO2YxUgsxYo0l8Hxfu', 'RM', 1),
    ('Shaghil Qureshi', 'shaghil@example.com', '$2a$12$QAj8K3TzKAa1vPXz7v.CO.k4m9F.uxZUDrOHO2YxUgsxYo0l8Hxfu', 'TGL', 2),
    ('Khalid Khan', 'khalid@example.com', '$2a$12$QAj8K3TzKAa1vPXz7v.CO.k4m9F.uxZUDrOHO2YxUgsxYo0l8Hxfu', 'TGL',2),
    ('Saif ur Rehman', 'saif@example.com', '$2a$12$QAj8K3TzKAa1vPXz7v.CO.k4m9F.uxZUDrOHO2YxUgsxYo0l8Hxfu', 'TGL', 2),
    ('Asghar Rind', 'asghar@example.com', '$2a$12$QAj8K3TzKAa1vPXz7v.CO.k4m9F.uxZUDrOHO2YxUgsxYo0l8Hxfu', 'CO', 3),
    ('Abubakar', 'abubakar@example.com', '$2a$12$QAj8K3TzKAa1vPXz7v.CO.k4m9F.uxZUDrOHO2YxUgsxYo0l8Hxfu', 'CO', 3),
    ('Munawar', 'munawar@example.com', '$2a$12$QAj8K3TzKAa1vPXz7v.CO.k4m9F.uxZUDrOHO2YxUgsxYo0l8Hxfu', 'CO', 4),
    ('Abdul Samad', 'abdul@example.com', '$2a$12$QAj8K3TzKAa1vPXz7v.CO.k4m9F.uxZUDrOHO2YxUgsxYo0l8Hxfu', 'CO', 4),
    ('Javed Iqbal', 'javed@example.com', '$2a$12$QAj8K3TzKAa1vPXz7v.CO.k4m9F.uxZUDrOHO2YxUgsxYo0l8Hxfu', 'CO', 5),
    ('Mohammad Adnan', 'adnan@example.com', '$2a$12$QAj8K3TzKAa1vPXz7v.CO.k4m9F.uxZUDrOHO2YxUgsxYo0l8Hxfu', 'CO', 4),
    ('Asmatullah', 'asmatullah@example.com', '$2a$12$QAj8K3TzKAa1vPXz7v.CO.k4m9F.uxZUDrOHO2YxUgsxYo0l8Hxfu', 'CO', 5),
    ('Abdul Aziz', 'abdulaziz@example.com', '$2a$12$QAj8K3TzKAa1vPXz7v.CO.k4m9F.uxZUDrOHO2YxUgsxYo0l8Hxfu', 'CO', 5),
    ('Sajjad Ahmed', 'sajjad@example.com', '$2a$12$QAj8K3TzKAa1vPXz7v.CO.k4m9F.uxZUDrOHO2YxUgsxYo0l8Hxfu', 'CO', 3),
    ('Mohammad Usman', 'usman@example.com', '$2a$12$QAj8K3TzKAa1vPXz7v.CO.k4m9F.uxZUDrOHO2YxUgsxYo0l8Hxfu', 'CO', 4),
    ('Abdul Malik', 'abdulmalik@example.com', '$2a$12$QAj8K3TzKAa1vPXz7v.CO.k4m9F.uxZUDrOHO2YxUgsxYo0l8Hxfu', 'CO', 5),
    ('Shah Faisal', 'faisal@example.com', '$2a$12$QAj8K3TzKAa1vPXz7v.CO.k4m9F.uxZUDrOHO2YxUgsxYo0l8Hxfu', 'CO', 3),
    ('Kashif', 'kashif@example.com', '$2a$12$QAj8K3TzKAa1vPXz7v.CO.k4m9F.uxZUDrOHO2YxUgsxYo0l8Hxfu', 'CO', 4),
    ('Ateeq ur Rehman', 'ateeq@example.com', '$2a$12$QAj8K3TzKAa1vPXz7v.CO.k4m9F.uxZUDrOHO2YxUgsxYo0l8Hxfu', 'CO', 4),
    ('Admin', 'admin@example.com', '$2a$12$aqHgR2.2S39KvgPNc7Ge.OVfomt2Kyq/gtfrQHzvcC8e8r0jxjEjq', 'ADMIN', 20);


-- Populate Sites Table
INSERT INTO sites (site_name, site_code)
VALUES
    ('ESU-BLN-03628', '03628'),
    ('ESU-BLN-03610', '03610'),
    ('ESU-BLN-03229', '03229'),
    ('ESU-BLN-03608', '03608'),
    ('ESU-BLN-03227', '03227'),
    ('ESU-BLN-03605', '03605'),
    ('ESU-BLN-03559', '03559'),
    ('ESU-BLN-03558', '03558'),
    ('ESU-BLN-03623', '03623'),
    ('ESU-BLN-03624', '03624'),
    ('ES2-BLN-05845', '05845'),
    ('ESU-BLN-03233', '03233'),
    ('ESU-BLN-03617', '03617'),
    ('ESU-BLN-03551', '03551'),
    ('ES2-BLN-05846', '05846'),
    ('ESU-BLN-03560', '03560'),
    ('ESU-BLN-03621', '03621'),
    ('ESU-BLN-03625', '03625'),
    ('ESU-BLN-03619', '03619'),
    ('ESU-BLN-03622', '03622'),
    ('ESU-BLN-03613', '03613'),
    ('ESU-BLN-03612', '03612'),
    ('ESU-BLN-03629', '03629'),
    ('ESU-BLN-03552', '03552'),
    ('ESU-BLN-03604', '03604'),
    ('ESU-BLN-03607', '03607'),
    ('ESU-BLN-03627', '03627'),
    ('ESU-BLN-03231', '03231'),
    ('ESU-BLN-03614', '03614'),
    ('ESU-BLN-03626', '03626'),
    ('ESU-BLN-03232', '03232'),
    ('ESU-BLN-03226', '03226'),
    ('ESU-BLN-03234', '03234'),
    ('ESU-BLN-03620', '03620'),
    ('ESU-BLN-03609', '03609'),
    ('ESU-BLN-03606', '03606'),
    ('ESU-BLN-03228', '03228'),
    ('ESU-BLN-03615', '03615'),
    ('ESU-BLN-03616', '03616'),
    ('EUS-PSN-04419', '04419'),
    ('EUS-PSN-04395', '04395'),
    ('ES2-QTA-03334', '03334'),
    ('ES2-KSF-05601', '05601'),
    ('EUS-LLI-04176', '04176'),
    ('ES2-QTA-04162', '04162'),
    ('ES2-QTA-04156', '04156'),
    ('ES2-QTA-04153', '04153'),
    ('ES2-KZD-05688', '05688'),
    ('ES2-ZHB-05777', '05777'),
    ('ES2-QTA-05116', '05116'),
    ('ES2-KSF-05698', '05698'),
    ('ES2-QTA-05791', '05791'),
    ('ES2-QTA-06831', '06831'),
    ('ES2-QTA-07132', '07132'),
    ('ES2-QTA-06742', '06742'),
    ('ES2-QTA-06924', '06924'),
    ('ES2-QTA-07085', '07085'),
    ('ES2-ZHB-03942', '03942'),
    ('ES2-KLT-04736', '04736'),
    ('EUS-CHG-04585', '04585'),
    ('EUS-PSN-04443', '04443'),
    ('EUS-PSN-04406', '04406'),
    ('EUS-PSN-04439', '04439'),
    ('EUS-PSN-04448', '04448'),
    ('EUS-PSN-04449', '04449'),
    ('ES2-LLI-07220', '07220'),
    ('ES2-QTA-07230', '07230'),
    ('ES2-QTA-07243', '07243'),
    ('ES2-QTA-07244', '07244'),
    ('EUS-CHG-04595', '04595'),
    ('ES2-QTA-07439', '07439'),
    ('ES2-QTA-05870', '05870'),
    ('ES2-QTA-07222', '07222'),
    ('ES2-QTA-07915', '07915'),
    ('EUS-CHG-04586', '04586'),
    ('ES2-QTA-08041', '08041'),
    ('ES2-LLI-01848', '01848'),
    ('ES2-LLI-01849', '01849'),
    ('ES2-LLI-01851', '01851'),
    ('ES2-QTA-02121', '02121'),
    ('ES2-QTA-02118', '02118'),
    ('ES2-LLI-02722', '02722'),
    ('ES2-QTA-02119', '02119'),
    ('ES2-QTA-03239', '03239'),
    ('ES2-QTA-02115', '02115'),
    ('ES2-QTA-03256', '03256'),
    ('ES2-DBN-03211', '03211'),
    ('ES2-QTA-08037', '08037'),
    ('ES2-QTA-01725', '01725'),
    ('ES2-LLI-01846', '01846'),
    ('ES2-LLI-01847', '01847'),
    ('ES2-LLI-03006', '03006'),
    ('ES2-QTA-03251', '03251'),
    ('ES2-KCL-03579', '03579'),
    ('ES2-KZD-04766', '04766'),
    ('ES2-KZD-04847', '04847'),
    ('ES2-KZD-04739', '04739'),
    ('ES2-QTA-05549', '05549'),
    ('ES2-PSN-05733', '05733'),
    ('ES2-PSN-05812', '05812'),
    ('ES2-KAD-05631', '05631'),
    ('ES2-QTA-05661', '05661'),
    ('ES2-QTA-05739', '05739'),
    ('ES2-KLT-05883', '05883'),
    ('ES2-QTA-06830', '06830'),
    ('ES2-QTA-03761', '03761'),
    ('EUS-PSN-04416', '04416'),
    ('EUS-PSN-04372', '04372'),
    ('ES2-QTA-08069', '08069'),
    ('ES2-LLI-03835', '03835'),
    ('ES2-QTA-03324', '03324'),
    ('ES2-QTA-03255', '03255'),
    ('ES2-KZD-04844', '04844'),
    ('ES2-KZD-04846', '04846'),
    ('ES2-KZD-04848', '04848'),
    ('ES2-CHM-05894', '05894'),
    ('ES2-QTA-04072', '04072'),
    ('EUS-PSN-04389', '04389'),
    ('EUS-PSN-04393', '04393'),
    ('ES2-KAD-05690', '05690'),
    ('ES2-KSF-05590', '05590'),
    ('EUS-PSN-04394', '04394'),
    ('EUS-CHG-04590', '04590'),
    ('EUS-PSN-04392', '04392'),
    ('ES2-KAD-05765', '05765'),
    ('ES2-KAD-05691', '05691'),
    ('ES2-PSN-05735', '05735'),
    ('ES2-LLI-05604', '05604'),
    ('ES2-KAD-05593', '05593'),
    ('EUS-CHG-04594', '04594'),
    ('ES2-BLN-07018', '07018'),
    ('ES2-QTA-07435', '07435'),
    ('ES2-QTA-08039', '08039'),
    ('ES2-QTA-08038', '08038'),
    ('ES2-LLI-03005', '03005'),
    ('ES2-NSB-03009', '03009'),
    ('ES2-CHM-03259', '03259'),
    ('EUS-QTA-04159', '04159'),
    ('ES2-QTA-08304', '08304'),
    ('ES2-ZIA-05751', '05751'),
    ('ES2-LLI-05766', '05766'),
    ('ES2-PSN-05868', '05868'),
    ('ES2-LLI-06068', '06068'),
    ('ES2-KNZ-05495', '05495'),
    ('ES2-LLI-05717', '05717'),
    ('ES2-PSN-05737', '05737'),
    ('ES2-ZIA-05560', '05560'),
    ('ES2-HAR-06719', '06719'),
    ('ES2-KZD-07093', '07093'),
    ('ES2-QTA-07131', '07131'),
    ('ES2-ZHB-07106', '07106'),
    ('ES2-ZHB-05596', '05596'),
    ('ES2-ZHB-07301', '07301'),
    ('ES2-ZHB-02753', '02753'),
    ('ES2-QTA-03333', '03333'),
    ('ES2-DKI-03948', '03948'),
    ('ES2-CHM-03671', '03671'),
    ('ES2-QTA-05773', '05773'),
    ('EUS-CHG-04592', '04592'),
    ('ES2-KZD-05687', '05687'),
    ('ES2-KAD-05630', '05630'),
    ('ES2-KSF-05700', '05700'),
    ('ES2-QTA-05738', '05738'),
    ('ES2-QTA-05578', '05578'),
    ('ES2-QTA-05758', '05758'),
    ('ES2-QTA-07235', '07235'),
    ('ES2-KLT-04782', '04782'),
    ('ES2-KLT-04765', '04765'),
    ('ES2-KCL-03759', '03759'),
    ('ES2-QTA-05571', '05571'),
    ('ES2-QTA-05550', '05550'),
    ('ES2-QTA-05585', '05585'),
    ('ES2-QTA-05741', '05741'),
    ('ES2-KLT-05867', '05867'),
    ('ES2-KLT-05672', '05672'),
    ('ES2-QTA-06833', '06833'),
    ('ES2-QTA-07231', '07231'),
    ('ES2-QTA-07232', '07232'),
    ('ES2-QTA-07234', '07234'),
    ('ES2-QTA-02718', '02718'),
    ('ES2-KZD-04842', '04842'),
    ('ES2-KZD-04845', '04845'),
    ('ES2-KZD-04843', '04843'),
    ('ES2-PSN-05635', '05635'),
    ('ES2-QTA-05429', '05429'),
    ('ES2-KSF-05536', '05536'),
    ('ES2-KSF-05569', '05569'),
    ('ES2-QTA-05774', '05774'),
    ('ES2-QTA-05869', '05869'),
    ('ES2-CHM-05892', '05892'),
    ('ES2-MST-05719', '05719'),
    ('ES2-QTA-05776', '05776'),
    ('ES2-MST-05726', '05726'),
    ('ES2-PSN-05586', '05586'),
    ('ES2-QTA-05583', '05583'),
    ('ES2-KZD-07084', '07084'),
    ('ES2-MST-07242', '07242'),
    ('ES2-KZD-01833', '01833'),
    ('ES2-KZD-02721', '02721'),
    ('ES2-QTA-03637', '03637'),
    ('ES2-QTA-02106', '02106'),
    ('EUS-LLI-04177', '04177'),
    ('ES2-QTA-04160', '04160'),
    ('ES2-QTA-03777', '03777'),
    ('ES2-PSN-03691', '03691'),
    ('ES2-QTA-04706', '04706'),
    ('EUS-PSN-04438', '04438'),
    ('ES2-PSN-05634', '05634'),
    ('ES2-MST-05727', '05727'),
    ('ES2-PSN-05790', '05790'),
    ('EUS-CHG-04588', '04588'),
    ('ES2-QTA-05775', '05775'),
    ('EUS-PSN-04451', '04451'),
    ('ES2-QTA-04354', '04354'),
    ('EUS-PSN-04434', '04434'),
    ('ES2-KAD-05895', '05895'),
    ('EUS-PSN-04403', '04403'),
    ('ES2-QTA-07221', '07221'),
    ('EUS-PSN-04405', '04405'),
    ('ES2-QTA-08064', '08064'),
    ('EUS-PSN-04422', '04422'),
    ('ES2-PSN-01694', '01694'),
    ('ES2-PSN-01730', '01730'),
    ('ES2-QTA-02116', '02116'),
    ('EUS-QTA-04155', '04155'),
    ('ES2-QTA-02114', '02114'),
    ('ES2-RCD-04850', '04850'),
    ('EUS-PSN-04430', '04430'),
    ('ES2-KLT-04737', '04737'),
    ('EUS-PSN-04410', '04410'),
    ('EUS-CHG-04589', '04589'),
    ('ES2-MST-05722', '05722'),
    ('ES2-QTA-05638', '05638'),
    ('ES2-QTA-05551', '05551'),
    ('ES2-QTA-05740', '05740'),
    ('ES2-QTA-05813', '05813'),
    ('ES2-QTA-05413', '05413'),
    ('ES2-KLT-05671', '05671'),
    ('ES2-QTA-06920', '06920'),
    ('ES2-QTA-07239', '07239'),
    ('ES2-QTA-07201', '07201'),
    ('ES2-HRZ-01692', '01692'),
    ('ES2-QTA-03019', '03019'),
    ('ES2-QTA-04161', '04161'),
    ('ES2-KZD-04840', '04840'),
    ('ES2-KZD-04849', '04849'),
    ('ES2-QTA-05579', '05579'),
    ('ES2-KAD-05594', '05594'),
    ('ES2-MST-05724', '05724'),
    ('ES2-LLI-05715', '05715'),
    ('ES2-LLI-05716', '05716'),
    ('EUS-PSN-04386', '04386'),
    ('EUS-PSN-04382', '04382'),
    ('ES2-KZD-08684', '08684'),
    ('ES2-KZD-01829', '01829'),
    ('ES2-MST-01842', '01842'),
    ('EUS-PSN-04428', '04428'),
    ('ES2-NSK-05094', '05094'),
    ('ES2-KAD-05697', '05697'),
    ('EUS-PSN-04418', '04418'),
    ('ES2-KAD-05584', '05584'),
    ('ES2-KAD-05689', '05689'),
    ('ES2-QTA-02107', '02107'),
    ('ES2-NSK-03943', '03943'),
    ('EUS-PSN-04441', '04441'),
    ('ES2-KAD-05695', '05695'),
    ('ES2-KAD-05764', '05764'),
    ('ES2-KAD-05598', '05598'),
    ('ES2-KAD-05694', '05694'),
    ('ES2-QTA-05602', '05602'),
    ('ES2-QTA-05592', '05592'),
    ('ES2-QTA-06133', '06133'),
    ('ES2-QTA-06300', '06300'),
    ('ES2-KAD-05580', '05580'),
    ('ES2-CHG-06070', '06070'),
    ('ES2-QTA-07240', '07240'),
    ('ES2-QTA-07228', '07228'),
    ('ES2-MST-07241', '07241'),
    ('EUS-CHG-04596', '04596'),
    ('ES2-QTA-01699', '01699'),
    ('ES2-GUL-02851', '02851'),
    ('EUS-CHG-04587', '04587'),
    ('ES2-PSN-05770', '05770'),
    ('EUS-CHG-04593', '04593'),
    ('ES2-KZT-02309', '02309'),
    ('ES2-QTA-08762', '08762'),
    ('EUS-PSN-04427', '04427'),
    ('EUS-PSN-04444', '04444'),
    ('ES2-QTA-05810', '05810'),
    ('EUS-PSN-04411', '04411'),
    ('ES2-KAD-05589', '05589'),
    ('EUS-PSN-04450', '04450'),
    ('ES2-QTA-07014', '07014'),
    ('ES2-QTA-07229', '07229'),
    ('ES2-QTA-07203', '07203'),
    ('ES2-QTA-07919', '07919'),
    ('ES2-KAD-03782', '03782'),
    ('EUS-PSN-04442', '04442'),
    ('EUS-PSN-04437', '04437'),
    ('ES2-QTA-05793', '05793'),
    ('ES2-SIB-05748', '05748'),
    ('ES2-SIB-05749', '05749'),
    ('ES2-MST-05768', '05768'),
    ('ES2-BLN-05664', '05664'),
    ('ES2-QTA-05430', '05430'),
    ('ES2-SIB-06740', '06740'),
    ('ES2-QTA-06922', '06922'),
    ('ES2-QTA-07233', '07233'),
    ('ES2-QTA-05588', '05588'),
    ('ES2-QTA-01732', '01732'),
    ('ES2-QTA-03706', '03706'),
    ('ES2-QTA-04788', '04788'),
    ('ES2-KAD-05582', '05582'),
    ('ES2-SIB-05897', '05897'),
    ('ES2-PSN-05734', '05734'),
    ('ES2-CHM-05893', '05893'),
    ('ES2-QTA-04825', '04825'),
    ('ES2-SIB-05898', '05898'),
    ('ES2-MST-05767', '05767'),
    ('ES2-DHD-05880', '05880'),
    ('ES2-QTA-05496', '05496'),
    ('ES2-QTA-01700', '01700'),
    ('ES2-MST-01841', '01841'),
    ('ES2-MST-01843', '01843'),
    ('ES2-MST-01845', '01845'),
    ('ES2-MST-01844', '01844'),
    ('ES2-PSN-03581', '03581'),
    ('ES2-KCL-03655', '03655'),
    ('ES2-CHM-03712', '03712'),
    ('ES2-KZD-04841', '04841'),
    ('EUS-PSN-04378', '04378'),
    ('EUS-PSN-04377', '04377'),
    ('EUS-PSN-04379', '04379'),
    ('ES2-KZD-07094', '07094'),
    ('ES2-QTA-07102', '07102'),
    ('ES2-QTA-07200', '07200'),
    ('ES2-KZD-01830', '01830'),
    ('ES2-KZD-02700', '02700'),
    ('ES2-QTA-02120', '02120'),
    ('ES2-KZD-02701', '02701'),
    ('ES2-CHM-03269', '03269'),
    ('ES2-QTA-03266', '03266'),
    ('EUS-PSN-04374', '04374'),
    ('EUS-PSN-04376', '04376'),
    ('EUS-PSN-04375', '04375'),
    ('ES2-MST-05720', '05720'),
    ('ES2-MST-05725', '05725'),
    ('ES2-MST-05718', '05718'),
    ('ES2-MST-05721', '05721'),
    ('EUS-PSN-04373', '04373'),
    ('ES2-KAD-05611', '05611'),
    ('ES2-QTA-07013', '07013'),
    ('ES2-QTA-07237', '07237'),
    ('ES2-QTA-07372', '07372'),
    ('ES2-QTA-07436', '07436'),
    ('ES2-QTA-01735', '01735'),
    ('ES2-KLP-01696', '01696'),
    ('ES2-QTA-03271', '03271'),
    ('ES2-KAD-05629', '05629'),
    ('ES2-QTA-07004', '07004'),
    ('ES2-QTA-03277', '03277'),
    ('ES2-QTA-01729', '01729'),
    ('ES2-CHM-03714', '03714'),
    ('ES2-QTA-04707', '04707'),
    ('EUS-PSN-04436', '04436'),
    ('ES2-PSN-05595', '05595'),
    ('ES2-QTA-06132', '06132'),
    ('ES2-QTA-06915', '06915'),
    ('ES2-QTA-03020', '03020'),
    ('ES2-QTA-03162', '03162'),
    ('ES2-QTA-03656', '03656'),
    ('ES2-QTA-02103', '02103'),
    ('ES2-KZD-04756', '04756'),
    ('ES2-KLT-04738', '04738'),
    ('ES2-MST-05723', '05723'),
    ('ES2-KZD-05890', '05890'),
    ('ES2-PSN-07086', '07086'),
    ('ES2-PSN-07091', '07091'),
    ('ES2-QTA-07897', '07897'),
    ('ES2-KZD-08683', '08683'),
    ('ES2-KZD-01835', '01835'),
    ('ES2-KZD-01832', '01832'),
    ('ES2-KZD-01834', '01834'),
    ('ES2-QTA-01959', '01959'),
    ('ES2-QTA-01969', '01969'),
    ('EUS-PSN-04420', '04420'),
    ('ES2-CHM-05891', '05891'),
    ('ES2-QTA-06126', '06126'),
    ('ES2-QTA-05609', '05609'),
    ('ES2-KAD-05581', '05581'),
    ('ES2-QTA-03238', '03238'),
    ('ES2-KZD-07092', '07092'),
    ('EUS-PSN-04447', '04447'),
    ('EUS-PSN-04383', '04383'),
    ('EUS-PSN-04417', '04417'),
    ('EUS-PSN-04398', '04398'),
    ('EUS-PSN-04401', '04401'),
    ('EUS-PSN-04414', '04414'),
    ('EUS-PSN-04454', '04454'),
    ('EUS-PSN-04399', '04399'),
    ('ES2-QTA-01732 - 1', '01732'),
    ('EUS-PSN-04363', '04363');

-- Populate Site Assignments Table
INSERT INTO site_assignments (site_id, user_id)
VALUES
    -- Site 1
    ((SELECT site_id FROM sites WHERE site_code = '03628'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '03628'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03628'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03628'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 2
    ((SELECT site_id FROM sites WHERE site_code = '03610'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '03610'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03610'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03610'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    ((SELECT site_id FROM sites WHERE site_code = '03610'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03610'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 3
    ((SELECT site_id FROM sites WHERE site_code = '03229'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '03229'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03229'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03229'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 4
    ((SELECT site_id FROM sites WHERE site_code = '03608'), (SELECT user_id FROM users WHERE full_name = 'Abubakar')),
    ((SELECT site_id FROM sites WHERE site_code = '03608'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03608'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03608'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 5
    ((SELECT site_id FROM sites WHERE site_code = '03227'), (SELECT user_id FROM users WHERE full_name = 'Abubakar')),
    ((SELECT site_id FROM sites WHERE site_code = '03227'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03227'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03227'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 6
    ((SELECT site_id FROM sites WHERE site_code = '03605'), (SELECT user_id FROM users WHERE full_name = 'Abubakar')),
    ((SELECT site_id FROM sites WHERE site_code = '03605'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03605'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03605'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 7
    ((SELECT site_id FROM sites WHERE site_code = '03559'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '03559'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03559'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03559'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 8
    ((SELECT site_id FROM sites WHERE site_code = '03558'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '03558'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03558'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03558'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 9
    ((SELECT site_id FROM sites WHERE site_code = '03623'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '03623'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03623'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03623'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 10
    ((SELECT site_id FROM sites WHERE site_code = '03624'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '03624'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03624'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03624'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),


     ((SELECT site_id FROM sites WHERE site_code = '05845'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '05845'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '05845'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '05845'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 12
    ((SELECT site_id FROM sites WHERE site_code = '03233'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '03233'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03233'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03233'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 13
    ((SELECT site_id FROM sites WHERE site_code = '03617'), (SELECT user_id FROM users WHERE full_name = 'Abubakar')),
    ((SELECT site_id FROM sites WHERE site_code = '03617'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03617'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03617'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),


    -- Site 14
    ((SELECT site_id FROM sites WHERE site_code = '03551'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '03551'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03551'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03551'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),


    -- Site 15
    ((SELECT site_id FROM sites WHERE site_code = '05846'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '05846'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '05846'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '05846'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 16
    ((SELECT site_id FROM sites WHERE site_code = '03560'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '03560'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03560'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03560'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 17
    ((SELECT site_id FROM sites WHERE site_code = '03621'), (SELECT user_id FROM users WHERE full_name = 'Abubakar')),
    ((SELECT site_id FROM sites WHERE site_code = '03621'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03621'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03621'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 18
    ((SELECT site_id FROM sites WHERE site_code = '03625'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '03625'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03625'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03625'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 19
    ((SELECT site_id FROM sites WHERE site_code = '03619'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '03619'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03619'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03619'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 20
    ((SELECT site_id FROM sites WHERE site_code = '03622'), (SELECT user_id FROM users WHERE full_name = 'Abubakar')),
    ((SELECT site_id FROM sites WHERE site_code = '03622'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03622'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03622'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),


    -- Site 21
    ((SELECT site_id FROM sites WHERE site_code = '03613'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '03613'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03613'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03613'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 22
    ((SELECT site_id FROM sites WHERE site_code = '03612'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '03612'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03612'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03612'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 23
    ((SELECT site_id FROM sites WHERE site_code = '03629'), (SELECT user_id FROM users WHERE full_name = 'Abubakar')),
    ((SELECT site_id FROM sites WHERE site_code = '03629'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03629'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03629'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 24
    ((SELECT site_id FROM sites WHERE site_code = '03552'), (SELECT user_id FROM users WHERE full_name = 'Abubakar')),
    ((SELECT site_id FROM sites WHERE site_code = '03552'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03552'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03552'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 25
    ((SELECT site_id FROM sites WHERE site_code = '03604'), (SELECT user_id FROM users WHERE full_name = 'Abubakar')),
    ((SELECT site_id FROM sites WHERE site_code = '03604'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03604'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03604'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 26
    ((SELECT site_id FROM sites WHERE site_code = '03607'), (SELECT user_id FROM users WHERE full_name = 'Abubakar')),
    ((SELECT site_id FROM sites WHERE site_code = '03607'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03607'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03607'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 27
    ((SELECT site_id FROM sites WHERE site_code = '03627'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '03627'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03627'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03627'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 28
    ((SELECT site_id FROM sites WHERE site_code = '03231'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '03231'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03231'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03231'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 29
    ((SELECT site_id FROM sites WHERE site_code = '03614'), (SELECT user_id FROM users WHERE full_name = 'Abubakar')),
    ((SELECT site_id FROM sites WHERE site_code = '03614'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03614'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03614'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 30
    ((SELECT site_id FROM sites WHERE site_code = '03626'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '03626'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03626'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03626'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    ((SELECT site_id FROM sites WHERE site_code = '03232'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '03232'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03232'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03232'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 32
    ((SELECT site_id FROM sites WHERE site_code = '03226'), (SELECT user_id FROM users WHERE full_name = 'Abubakar')),
    ((SELECT site_id FROM sites WHERE site_code = '03226'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03226'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03226'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 33
    ((SELECT site_id FROM sites WHERE site_code = '03234'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '03234'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03234'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03234'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 34
    ((SELECT site_id FROM sites WHERE site_code = '03620'), (SELECT user_id FROM users WHERE full_name = 'Abubakar')),
    ((SELECT site_id FROM sites WHERE site_code = '03620'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03620'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03620'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 35
    ((SELECT site_id FROM sites WHERE site_code = '03609'), (SELECT user_id FROM users WHERE full_name = 'Abubakar')),
    ((SELECT site_id FROM sites WHERE site_code = '03609'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03609'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03609'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 36
    ((SELECT site_id FROM sites WHERE site_code = '03606'), (SELECT user_id FROM users WHERE full_name = 'Abubakar')),
    ((SELECT site_id FROM sites WHERE site_code = '03606'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03606'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03606'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 37
    ((SELECT site_id FROM sites WHERE site_code = '03228'), (SELECT user_id FROM users WHERE full_name = 'Abubakar')),
    ((SELECT site_id FROM sites WHERE site_code = '03228'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03228'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03228'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 38
    ((SELECT site_id FROM sites WHERE site_code = '03615'), (SELECT user_id FROM users WHERE full_name = 'Abubakar')),
    ((SELECT site_id FROM sites WHERE site_code = '03615'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03615'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03615'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 39
    ((SELECT site_id FROM sites WHERE site_code = '03616'), (SELECT user_id FROM users WHERE full_name = 'Abubakar')),
    ((SELECT site_id FROM sites WHERE site_code = '03616'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03616'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03616'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 40
    ((SELECT site_id FROM sites WHERE site_code = '04419'), (SELECT user_id FROM users WHERE full_name = 'Munawar')),
    ((SELECT site_id FROM sites WHERE site_code = '04419'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '04419'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04419'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

        ((SELECT site_id FROM sites WHERE site_code = '04395'), (SELECT user_id FROM users WHERE full_name = 'Abdul Samad')),
    ((SELECT site_id FROM sites WHERE site_code = '04395'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '04395'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04395'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 42
    ((SELECT site_id FROM sites WHERE site_code = '03334'), (SELECT user_id FROM users WHERE full_name = 'Javed Iqbal')),
    ((SELECT site_id FROM sites WHERE site_code = '03334'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '03334'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03334'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 43
    ((SELECT site_id FROM sites WHERE site_code = '05601'), (SELECT user_id FROM users WHERE full_name = 'Mohammad Adnan')),
    ((SELECT site_id FROM sites WHERE site_code = '05601'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '05601'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '05601'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 44
    ((SELECT site_id FROM sites WHERE site_code = '04176'), (SELECT user_id FROM users WHERE full_name = 'Mohammad Adnan')),
    ((SELECT site_id FROM sites WHERE site_code = '04176'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '04176'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04176'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 45
    ((SELECT site_id FROM sites WHERE site_code = '04162'), (SELECT user_id FROM users WHERE full_name = 'Asmatullah')),
    ((SELECT site_id FROM sites WHERE site_code = '04162'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '04162'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04162'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 46
    ((SELECT site_id FROM sites WHERE site_code = '04156'), (SELECT user_id FROM users WHERE full_name = 'Abdul Aziz')),
    ((SELECT site_id FROM sites WHERE site_code = '04156'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '04156'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04156'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 47
    ((SELECT site_id FROM sites WHERE site_code = '04153'), (SELECT user_id FROM users WHERE full_name = 'Asmatullah')),
    ((SELECT site_id FROM sites WHERE site_code = '04153'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '04153'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04153'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 48
    ((SELECT site_id FROM sites WHERE site_code = '05688'), (SELECT user_id FROM users WHERE full_name = 'Sajjad Ahmed')),
    ((SELECT site_id FROM sites WHERE site_code = '05688'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '05688'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '05688'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 49
    ((SELECT site_id FROM sites WHERE site_code = '05777'), (SELECT user_id FROM users WHERE full_name = 'Mohammad Adnan')),
    ((SELECT site_id FROM sites WHERE site_code = '05777'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '05777'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '05777'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 50
    ((SELECT site_id FROM sites WHERE site_code = '05116'), (SELECT user_id FROM users WHERE full_name = 'Asmatullah')),
    ((SELECT site_id FROM sites WHERE site_code = '05116'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '05116'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '05116'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    ((SELECT site_id FROM sites WHERE site_code = '05698'), (SELECT user_id FROM users WHERE full_name = 'Mohammad Usman')),
    ((SELECT site_id FROM sites WHERE site_code = '05698'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '05698'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '05698'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 52
    ((SELECT site_id FROM sites WHERE site_code = '05791'), (SELECT user_id FROM users WHERE full_name = 'Asmatullah')),
    ((SELECT site_id FROM sites WHERE site_code = '05791'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '05791'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '05791'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 53
    ((SELECT site_id FROM sites WHERE site_code = '06831'), (SELECT user_id FROM users WHERE full_name = 'Abdul Aziz')),
    ((SELECT site_id FROM sites WHERE site_code = '06831'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '06831'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '06831'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 54
    ((SELECT site_id FROM sites WHERE site_code = '07132'), (SELECT user_id FROM users WHERE full_name = 'Asmatullah')),
    ((SELECT site_id FROM sites WHERE site_code = '07132'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '07132'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '07132'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 55
    ((SELECT site_id FROM sites WHERE site_code = '06742'), (SELECT user_id FROM users WHERE full_name = 'Abdul Malik')),
    ((SELECT site_id FROM sites WHERE site_code = '06742'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '06742'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '06742'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 56
    ((SELECT site_id FROM sites WHERE site_code = '06924'), (SELECT user_id FROM users WHERE full_name = 'Abdul Aziz')),
    ((SELECT site_id FROM sites WHERE site_code = '06924'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '06924'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '06924'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 57
    ((SELECT site_id FROM sites WHERE site_code = '07085'), (SELECT user_id FROM users WHERE full_name = 'Abdul Aziz')),
    ((SELECT site_id FROM sites WHERE site_code = '07085'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '07085'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '07085'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 58
    ((SELECT site_id FROM sites WHERE site_code = '03942'), (SELECT user_id FROM users WHERE full_name = 'Mohammad Adnan')),
    ((SELECT site_id FROM sites WHERE site_code = '03942'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '03942'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03942'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 59
    ((SELECT site_id FROM sites WHERE site_code = '04736'), (SELECT user_id FROM users WHERE full_name = 'Shah Faisal')),
    ((SELECT site_id FROM sites WHERE site_code = '04736'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '04736'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04736'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 60
    ((SELECT site_id FROM sites WHERE site_code = '04585'), (SELECT user_id FROM users WHERE full_name = 'Shah Faisal')),
    ((SELECT site_id FROM sites WHERE site_code = '04585'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '04585'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04585'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    ((SELECT site_id FROM sites WHERE site_code = '04443'), (SELECT user_id FROM users WHERE full_name = 'Munawar')),
    ((SELECT site_id FROM sites WHERE site_code = '04443'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '04443'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04443'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 62
    ((SELECT site_id FROM sites WHERE site_code = '04406'), (SELECT user_id FROM users WHERE full_name = 'Abdul Samad')),
    ((SELECT site_id FROM sites WHERE site_code = '04406'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '04406'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04406'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 63
    ((SELECT site_id FROM sites WHERE site_code = '04439'), (SELECT user_id FROM users WHERE full_name = 'Mohammad Usman')),
    ((SELECT site_id FROM sites WHERE site_code = '04439'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '04439'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04439'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 64
    ((SELECT site_id FROM sites WHERE site_code = '04448'), (SELECT user_id FROM users WHERE full_name = 'Abdul Samad')),
    ((SELECT site_id FROM sites WHERE site_code = '04448'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '04448'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04448'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 65
    ((SELECT site_id FROM sites WHERE site_code = '04449'), (SELECT user_id FROM users WHERE full_name = 'Abdul Samad')),
    ((SELECT site_id FROM sites WHERE site_code = '04449'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '04449'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04449'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 66
    ((SELECT site_id FROM sites WHERE site_code = '07220'), (SELECT user_id FROM users WHERE full_name = 'Mohammad Adnan')),
    ((SELECT site_id FROM sites WHERE site_code = '07220'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '07220'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '07220'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 67
    ((SELECT site_id FROM sites WHERE site_code = '07230'), (SELECT user_id FROM users WHERE full_name = 'Asmatullah')),
    ((SELECT site_id FROM sites WHERE site_code = '07230'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '07230'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '07230'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 68
    ((SELECT site_id FROM sites WHERE site_code = '07243'), (SELECT user_id FROM users WHERE full_name = 'Abdul Malik')),
    ((SELECT site_id FROM sites WHERE site_code = '07243'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '07243'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '07243'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 69
    ((SELECT site_id FROM sites WHERE site_code = '07244'), (SELECT user_id FROM users WHERE full_name = 'Abdul Malik')),
    ((SELECT site_id FROM sites WHERE site_code = '07244'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '07244'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '07244'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 70
    ((SELECT site_id FROM sites WHERE site_code = '04595'), (SELECT user_id FROM users WHERE full_name = 'Shah Faisal')),
    ((SELECT site_id FROM sites WHERE site_code = '04595'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '04595'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04595'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 71
    ((SELECT site_id FROM sites WHERE site_code = '07439'), (SELECT user_id FROM users WHERE full_name = 'Abdul Aziz')),
    ((SELECT site_id FROM sites WHERE site_code = '07439'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '07439'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '07439'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 72
    ((SELECT site_id FROM sites WHERE site_code = '05870'), (SELECT user_id FROM users WHERE full_name = 'Javed Iqbal')),
    ((SELECT site_id FROM sites WHERE site_code = '05870'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '05870'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '05870'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 73
    ((SELECT site_id FROM sites WHERE site_code = '07222'), (SELECT user_id FROM users WHERE full_name = 'Javed Iqbal')),
    ((SELECT site_id FROM sites WHERE site_code = '07222'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '07222'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '07222'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 74
    ((SELECT site_id FROM sites WHERE site_code = '07915'), (SELECT user_id FROM users WHERE full_name = 'Asmatullah')),
    ((SELECT site_id FROM sites WHERE site_code = '07915'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '07915'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '07915'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 75
    ((SELECT site_id FROM sites WHERE site_code = '04586'), (SELECT user_id FROM users WHERE full_name = 'Shah Faisal')),
    ((SELECT site_id FROM sites WHERE site_code = '04586'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '04586'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04586'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 76
    ((SELECT site_id FROM sites WHERE site_code = '08041'), (SELECT user_id FROM users WHERE full_name = 'Abdul Aziz')),
    ((SELECT site_id FROM sites WHERE site_code = '08041'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '08041'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '08041'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 77
    ((SELECT site_id FROM sites WHERE site_code = '01848'), (SELECT user_id FROM users WHERE full_name = 'Mohammad Adnan')),
    ((SELECT site_id FROM sites WHERE site_code = '01848'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '01848'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '01848'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 78
    ((SELECT site_id FROM sites WHERE site_code = '01849'), (SELECT user_id FROM users WHERE full_name = 'Mohammad Adnan')),
    ((SELECT site_id FROM sites WHERE site_code = '01849'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '01849'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '01849'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 79
    ((SELECT site_id FROM sites WHERE site_code = '01851'), (SELECT user_id FROM users WHERE full_name = 'Mohammad Adnan')),
    ((SELECT site_id FROM sites WHERE site_code = '01851'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '01851'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '01851'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 80
    ((SELECT site_id FROM sites WHERE site_code = '02121'), (SELECT user_id FROM users WHERE full_name = 'Abdul Aziz')),
    ((SELECT site_id FROM sites WHERE site_code = '02121'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '02121'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '02121'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 81
    ((SELECT site_id FROM sites WHERE site_code = '02118'), (SELECT user_id FROM users WHERE full_name = 'Asmatullah')),
    ((SELECT site_id FROM sites WHERE site_code = '02118'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '02118'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '02118'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 82
    ((SELECT site_id FROM sites WHERE site_code = '02722'), (SELECT user_id FROM users WHERE full_name = 'Mohammad Adnan')),
    ((SELECT site_id FROM sites WHERE site_code = '02722'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '02722'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '02722'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 83
    ((SELECT site_id FROM sites WHERE site_code = '02119'), (SELECT user_id FROM users WHERE full_name = 'Asmatullah')),
    ((SELECT site_id FROM sites WHERE site_code = '02119'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '02119'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '02119'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 84
    ((SELECT site_id FROM sites WHERE site_code = '03239'), (SELECT user_id FROM users WHERE full_name = 'Asmatullah')),
    ((SELECT site_id FROM sites WHERE site_code = '03239'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '03239'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03239'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 85
    ((SELECT site_id FROM sites WHERE site_code = '02115'), (SELECT user_id FROM users WHERE full_name = 'Javed Iqbal')),
    ((SELECT site_id FROM sites WHERE site_code = '02115'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '02115'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '02115'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 86
    ((SELECT site_id FROM sites WHERE site_code = '03256'), (SELECT user_id FROM users WHERE full_name = 'Abdul Aziz')),
    ((SELECT site_id FROM sites WHERE site_code = '03256'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '03256'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03256'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 87
    ((SELECT site_id FROM sites WHERE site_code = '03211'), (SELECT user_id FROM users WHERE full_name = 'Shah Faisal')),
    ((SELECT site_id FROM sites WHERE site_code = '03211'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03211'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03211'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 88
    ((SELECT site_id FROM sites WHERE site_code = '08037'), (SELECT user_id FROM users WHERE full_name = 'Abdul Malik')),
    ((SELECT site_id FROM sites WHERE site_code = '08037'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '08037'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '08037'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 89
    ((SELECT site_id FROM sites WHERE site_code = '01725'), (SELECT user_id FROM users WHERE full_name = 'Asmatullah')),
    ((SELECT site_id FROM sites WHERE site_code = '01725'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '01725'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '01725'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 90
    ((SELECT site_id FROM sites WHERE site_code = '01846'), (SELECT user_id FROM users WHERE full_name = 'Mohammad Adnan')),
    ((SELECT site_id FROM sites WHERE site_code = '01846'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '01846'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '01846'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 91
    ((SELECT site_id FROM sites WHERE site_code = '01847'), (SELECT user_id FROM users WHERE full_name = 'Mohammad Adnan')),
    ((SELECT site_id FROM sites WHERE site_code = '01847'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '01847'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '01847'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 92
    ((SELECT site_id FROM sites WHERE site_code = '03006'), (SELECT user_id FROM users WHERE full_name = 'Mohammad Adnan')),
    ((SELECT site_id FROM sites WHERE site_code = '03006'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '03006'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03006'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 93
    ((SELECT site_id FROM sites WHERE site_code = '02116'), (SELECT user_id FROM users WHERE full_name = 'Asmatullah')),
    ((SELECT site_id FROM sites WHERE site_code = '02116'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '02116'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '02116'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 94
    ((SELECT site_id FROM sites WHERE site_code = '01849'), (SELECT user_id FROM users WHERE full_name = 'Abdul Malik')),
    ((SELECT site_id FROM sites WHERE site_code = '01849'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '01849'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '01849'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 95
    ((SELECT site_id FROM sites WHERE site_code = '04162'), (SELECT user_id FROM users WHERE full_name = 'Asmatullah')),
    ((SELECT site_id FROM sites WHERE site_code = '04162'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '04162'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04162'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 96
    ((SELECT site_id FROM sites WHERE site_code = '04156'), (SELECT user_id FROM users WHERE full_name = 'Abdul Aziz')),
    ((SELECT site_id FROM sites WHERE site_code = '04156'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '04156'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04156'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 97
    ((SELECT site_id FROM sites WHERE site_code = '04153'), (SELECT user_id FROM users WHERE full_name = 'Asmatullah')),
    ((SELECT site_id FROM sites WHERE site_code = '04153'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '04153'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04153'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 98
    ((SELECT site_id FROM sites WHERE site_code = '04419'), (SELECT user_id FROM users WHERE full_name = 'Munawar')),
    ((SELECT site_id FROM sites WHERE site_code = '04419'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '04419'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04419'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 99
    ((SELECT site_id FROM sites WHERE site_code = '04443'), (SELECT user_id FROM users WHERE full_name = 'Munawar')),
    ((SELECT site_id FROM sites WHERE site_code = '04443'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '04443'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04443'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 100
    ((SELECT site_id FROM sites WHERE site_code = '01848'), (SELECT user_id FROM users WHERE full_name = 'Mohammad Adnan')),
    ((SELECT site_id FROM sites WHERE site_code = '01848'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '01848'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '01848'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 101
    ((SELECT site_id FROM sites WHERE site_code = '07231'), (SELECT user_id FROM users WHERE full_name = 'Abdul Aziz')),
    ((SELECT site_id FROM sites WHERE site_code = '07231'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '07231'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '07231'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 102
    ((SELECT site_id FROM sites WHERE site_code = '02120'), (SELECT user_id FROM users WHERE full_name = 'Javed Iqbal')),
    ((SELECT site_id FROM sites WHERE site_code = '02120'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '02120'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '02120'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 103
    ((SELECT site_id FROM sites WHERE site_code = '04706'), (SELECT user_id FROM users WHERE full_name = 'Abdul Malik')),
    ((SELECT site_id FROM sites WHERE site_code = '04706'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '04706'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04706'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 104
    ((SELECT site_id FROM sites WHERE site_code = '02103'), (SELECT user_id FROM users WHERE full_name = 'Abdul Malik')),
    ((SELECT site_id FROM sites WHERE site_code = '02103'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '02103'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '02103'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 105
    ((SELECT site_id FROM sites WHERE site_code = '03637'), (SELECT user_id FROM users WHERE full_name = 'Abdul Malik')),
    ((SELECT site_id FROM sites WHERE site_code = '03637'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '03637'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03637'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 106
    ((SELECT site_id FROM sites WHERE site_code = '04159'), (SELECT user_id FROM users WHERE full_name = 'Asmatullah')),
    ((SELECT site_id FROM sites WHERE site_code = '04159'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '04159'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04159'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 107
    ((SELECT site_id FROM sites WHERE site_code = '03629'), (SELECT user_id FROM users WHERE full_name = 'Abubakar')),
    ((SELECT site_id FROM sites WHERE site_code = '03629'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03629'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03629'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 108
    ((SELECT site_id FROM sites WHERE site_code = '03234'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '03234'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03234'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03234'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 109
    ((SELECT site_id FROM sites WHERE site_code = '03605'), (SELECT user_id FROM users WHERE full_name = 'Abubakar')),
    ((SELECT site_id FROM sites WHERE site_code = '03605'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03605'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03605'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 110
    ((SELECT site_id FROM sites WHERE site_code = '04177'), (SELECT user_id FROM users WHERE full_name = 'Mohammad Adnan')),
    ((SELECT site_id FROM sites WHERE site_code = '04177'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '04177'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04177'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 111
    ((SELECT site_id FROM sites WHERE site_code = '04788'), (SELECT user_id FROM users WHERE full_name = 'Abdul Aziz')),
    ((SELECT site_id FROM sites WHERE site_code = '04788'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '04788'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04788'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 112
    ((SELECT site_id FROM sites WHERE site_code = '07221'), (SELECT user_id FROM users WHERE full_name = 'Javed Iqbal')),
    ((SELECT site_id FROM sites WHERE site_code = '07221'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '07221'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '07221'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 113
    ((SELECT site_id FROM sites WHERE site_code = '04587'), (SELECT user_id FROM users WHERE full_name = 'Shah Faisal')),
    ((SELECT site_id FROM sites WHERE site_code = '04587'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '04587'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04587'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 114
    ((SELECT site_id FROM sites WHERE site_code = '05595'), (SELECT user_id FROM users WHERE full_name = 'Ateeq ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '05595'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '05595'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '05595'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 115
    ((SELECT site_id FROM sites WHERE site_code = '02114'), (SELECT user_id FROM users WHERE full_name = 'Javed Iqbal')),
    ((SELECT site_id FROM sites WHERE site_code = '02114'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '02114'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '02114'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 116
    ((SELECT site_id FROM sites WHERE site_code = '02119'), (SELECT user_id FROM users WHERE full_name = 'Asmatullah')),
    ((SELECT site_id FROM sites WHERE site_code = '02119'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '02119'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '02119'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 117
    ((SELECT site_id FROM sites WHERE site_code = '02118'), (SELECT user_id FROM users WHERE full_name = 'Asmatullah')),
    ((SELECT site_id FROM sites WHERE site_code = '02118'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '02118'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '02118'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 118
    ((SELECT site_id FROM sites WHERE site_code = '03621'), (SELECT user_id FROM users WHERE full_name = 'Abubakar')),
    ((SELECT site_id FROM sites WHERE site_code = '03621'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03621'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03621'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 119
    ((SELECT site_id FROM sites WHERE site_code = '05897'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '05897'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '05897'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '05897'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 120
    ((SELECT site_id FROM sites WHERE site_code = '07239'), (SELECT user_id FROM users WHERE full_name = 'Abdul Malik')),
    ((SELECT site_id FROM sites WHERE site_code = '07239'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '07239'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '07239'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 121
    ((SELECT site_id FROM sites WHERE site_code = '07235'), (SELECT user_id FROM users WHERE full_name = 'Abdul Aziz')),
    ((SELECT site_id FROM sites WHERE site_code = '07235'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '07235'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '07235'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 122
    ((SELECT site_id FROM sites WHERE site_code = '07232'), (SELECT user_id FROM users WHERE full_name = 'Abdul Aziz')),
    ((SELECT site_id FROM sites WHERE site_code = '07232'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '07232'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '07232'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 123
    ((SELECT site_id FROM sites WHERE site_code = '07230'), (SELECT user_id FROM users WHERE full_name = 'Asmatullah')),
    ((SELECT site_id FROM sites WHERE site_code = '07230'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '07230'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '07230'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 124
    ((SELECT site_id FROM sites WHERE site_code = '05580'), (SELECT user_id FROM users WHERE full_name = 'Kashif')),
    ((SELECT site_id FROM sites WHERE site_code = '05580'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '05580'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '05580'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 125
    ((SELECT site_id FROM sites WHERE site_code = '03259'), (SELECT user_id FROM users WHERE full_name = 'Munawar')),
    ((SELECT site_id FROM sites WHERE site_code = '03259'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '03259'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03259'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 126
    ((SELECT site_id FROM sites WHERE site_code = '03612'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '03612'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03612'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03612'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 127
    ((SELECT site_id FROM sites WHERE site_code = '01833'), (SELECT user_id FROM users WHERE full_name = 'Sajjad Ahmed')),
    ((SELECT site_id FROM sites WHERE site_code = '01833'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '01833'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '01833'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 128
    ((SELECT site_id FROM sites WHERE site_code = '04155'), (SELECT user_id FROM users WHERE full_name = 'Asmatullah')),
    ((SELECT site_id FROM sites WHERE site_code = '04155'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '04155'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04155'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 129
    ((SELECT site_id FROM sites WHERE site_code = '04160'), (SELECT user_id FROM users WHERE full_name = 'Abdul Aziz')),
    ((SELECT site_id FROM sites WHERE site_code = '04160'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '04160'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04160'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 130
    ((SELECT site_id FROM sites WHERE site_code = '02121'), (SELECT user_id FROM users WHERE full_name = 'Javed Iqbal')),
    ((SELECT site_id FROM sites WHERE site_code = '02121'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '02121'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '02121'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 131
    ((SELECT site_id FROM sites WHERE site_code = '04585'), (SELECT user_id FROM users WHERE full_name = 'Shah Faisal')),
    ((SELECT site_id FROM sites WHERE site_code = '04585'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '04585'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04585'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 132
    ((SELECT site_id FROM sites WHERE site_code = '05594'), (SELECT user_id FROM users WHERE full_name = 'Munawar')),
    ((SELECT site_id FROM sites WHERE site_code = '05594'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '05594'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '05594'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 133
    ((SELECT site_id FROM sites WHERE site_code = '05583'), (SELECT user_id FROM users WHERE full_name = 'Kashif')),
    ((SELECT site_id FROM sites WHERE site_code = '05583'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '05583'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '05583'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 134
    ((SELECT site_id FROM sites WHERE site_code = '03616'), (SELECT user_id FROM users WHERE full_name = 'Abubakar')),
    ((SELECT site_id FROM sites WHERE site_code = '03616'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03616'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03616'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 135
    ((SELECT site_id FROM sites WHERE site_code = '04840'), (SELECT user_id FROM users WHERE full_name = 'Sajjad Ahmed')),
    ((SELECT site_id FROM sites WHERE site_code = '04840'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '04840'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04840'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 136
    ((SELECT site_id FROM sites WHERE site_code = '05767'), (SELECT user_id FROM users WHERE full_name = 'Shah Faisal')),
    ((SELECT site_id FROM sites WHERE site_code = '05767'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '05767'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '05767'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 137
    ((SELECT site_id FROM sites WHERE site_code = '05687'), (SELECT user_id FROM users WHERE full_name = 'Sajjad Ahmed')),
    ((SELECT site_id FROM sites WHERE site_code = '05687'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '05687'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '05687'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 138
    ((SELECT site_id FROM sites WHERE site_code = '03624'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '03624'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03624'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03624'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),


    -- Site 139
    ((SELECT site_id FROM sites WHERE site_code = '01830'), (SELECT user_id FROM users WHERE full_name = 'Sajjad Ahmed')),
    ((SELECT site_id FROM sites WHERE site_code = '01830'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '01830'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '01830'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 140
    ((SELECT site_id FROM sites WHERE site_code = '04707'), (SELECT user_id FROM users WHERE full_name = 'Abdul Malik')),
    ((SELECT site_id FROM sites WHERE site_code = '04707'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '04707'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '04707'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 141
    ((SELECT site_id FROM sites WHERE site_code = '07234'), (SELECT user_id FROM users WHERE full_name = 'Abdul Malik')),
    ((SELECT site_id FROM sites WHERE site_code = '07234'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '07234'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '07234'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 142
    ((SELECT site_id FROM sites WHERE site_code = '03606'), (SELECT user_id FROM users WHERE full_name = 'Abubakar')),
    ((SELECT site_id FROM sites WHERE site_code = '03606'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03606'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03606'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 143
    ((SELECT site_id FROM sites WHERE site_code = '02120'), (SELECT user_id FROM users WHERE full_name = 'Javed Iqbal')),
    ((SELECT site_id FROM sites WHERE site_code = '02120'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '02120'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '02120'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 144
    ((SELECT site_id FROM sites WHERE site_code = '05635'), (SELECT user_id FROM users WHERE full_name = 'Ateeq ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '05635'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '05635'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '05635'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 145
    ((SELECT site_id FROM sites WHERE site_code = '07222'), (SELECT user_id FROM users WHERE full_name = 'Javed Iqbal')),
    ((SELECT site_id FROM sites WHERE site_code = '07222'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '07222'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '07222'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 146
    ((SELECT site_id FROM sites WHERE site_code = '03255'), (SELECT user_id FROM users WHERE full_name = 'Asmatullah')),
    ((SELECT site_id FROM sites WHERE site_code = '03255'), (SELECT user_id FROM users WHERE full_name = 'Saif ur Rehman')),
    ((SELECT site_id FROM sites WHERE site_code = '03255'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03255'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 147
    ((SELECT site_id FROM sites WHERE site_code = '03614'), (SELECT user_id FROM users WHERE full_name = 'Abubakar')),
    ((SELECT site_id FROM sites WHERE site_code = '03614'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03614'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03614'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 148
    ((SELECT site_id FROM sites WHERE site_code = '05894'), (SELECT user_id FROM users WHERE full_name = 'Munawar')),
    ((SELECT site_id FROM sites WHERE site_code = '05894'), (SELECT user_id FROM users WHERE full_name = 'Khalid Khan')),
    ((SELECT site_id FROM sites WHERE site_code = '05894'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '05894'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 149
    ((SELECT site_id FROM sites WHERE site_code = '03626'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '03626'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03626'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03626'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa')),

    -- Site 150
    ((SELECT site_id FROM sites WHERE site_code = '03613'), (SELECT user_id FROM users WHERE full_name = 'Asghar Rind')),
    ((SELECT site_id FROM sites WHERE site_code = '03613'), (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi')),
    ((SELECT site_id FROM sites WHERE site_code = '03613'), (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri')),
    ((SELECT site_id FROM sites WHERE site_code = '03613'), (SELECT user_id FROM users WHERE full_name = 'Muhammad Yahya Moosa'));



INSERT INTO requests (user_id, site_id, status, fault_description, image_paths, type,forwarded_to, verified_by, approved_by, current_level, forwarded_by, next_assignee)
VALUES
    -- Request 1
    ((SELECT user_id FROM users WHERE full_name = 'Asghar Rind')
    , (SELECT site_id FROM sites WHERE site_code = '01848')
    , 'PENDING',
     'Fault Description 1',
     'images/1.jpg',
     'CASH',
     (SELECT user_id FROM users WHERE full_name = 'Shaghil Qureshi'),
     NULL, NULL, 'TGL',
     (SELECT user_id FROM users WHERE full_name = 'Asghar Rind'),
     (SELECT user_id FROM users WHERE full_name = 'Mustafa Marri'));
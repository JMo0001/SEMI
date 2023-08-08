

--TBL_PARTY
INSERT INTO TBL_PARTY ( PCODE, PNAME, PINDATE, PLEADER, PTEL1, PTEL2, PTEL3)
    VALUES ('P1', 'A정당', '2010-01-01', '위대표', '02', '1111', '0001');
INSERT INTO TBL_PARTY ( PCODE, PNAME, PINDATE, PLEADER, PTEL1, PTEL2, PTEL3)
    VALUES ('P2', 'B정당', '2010-02-01', '명대표', '02', '1111' ,'0002');
INSERT INTO TBL_PARTY ( PCODE, PNAME, PINDATE, PLEADER, PTEL1, PTEL2, PTEL3)
    VALUES ('P3', 'C정당', '2010-03-01', '기대표', '02', '1111', '0003');
INSERT INTO TBL_PARTY ( PCODE, PNAME, PINDATE, PLEADER, PTEL1, PTEL2, PTEL3)
    VALUES ('P4', 'D정당', '2010-04-01', '옥대표', '02', '1111', '0004');
INSERT INTO TBL_PARTY ( PCODE, PNAME, PINDATE, PLEADER, PTEL1, PTEL2, PTEL3)
    VALUES ('P5', 'E정당', '2010-05-01', '임대표', '02', '1111', '0005');


--TBL_MEMBER
INSERT INTO TBL_MEMBER ( MNO, MNAME, PCODE, PSCHOOL, MJUMIN, MCITY)
    VALUES ('11', '김후보', 'P1', '1', '6603011999991', '수선화동');
INSERT INTO TBL_MEMBER ( MNO, MNAME, PCODE, PSCHOOL, MJUMIN, MCITY)
    VALUES ('12', '이후보', 'P2', '3', '5503011999992', '민들래동');
INSERT INTO TBL_MEMBER ( MNO, MNAME, PCODE, PSCHOOL, MJUMIN, MCITY)
    VALUES ('13', '박후보', 'P3', '2', '7703011999994', '나팔꽃동');
INSERT INTO TBL_MEMBER ( MNO, MNAME, PCODE, PSCHOOL, MJUMIN, MCITY)
    VALUES ('14', '조후보', 'P4', '2', '8803011999994', '진달래동');
INSERT INTO TBL_MEMBER ( MNO, MNAME, PCODE, PSCHOOL, MJUMIN, MCITY)
    VALUES ('15', '최후보', 'P5', '3', '9903011999995', '개나리동');
    

--TBL_VOTE
INSERT INTO TBL_VOTE ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO)
    VALUES ('9901011000100', '김유권', '0930', '제1투표장', 'N', '11');
INSERT INTO TBL_VOTE ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO)
    VALUES ('8901012000200', '이유권', '0930', '제1투표장', 'N', '12');
INSERT INTO TBL_VOTE ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO)
    VALUES ('6901011000300', '박유권', '0930', '제1투표장', 'Y', '13');
INSERT INTO TBL_VOTE ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO)
    VALUES ('5901012000400', '홍유권', '0930', '제1투표장', 'Y', '14');
INSERT INTO TBL_VOTE ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO)
    VALUES ('7901011000500', '조유권', '0930', '제1투표장', 'Y', '15');
INSERT INTO TBL_VOTE ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO)
    VALUES ('8901012000600', '최유권', '0930', '제1투표장', 'Y', '11');
INSERT INTO TBL_VOTE ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO)
    VALUES ('5901011000700', '지유권', '0930', '제1투표장', 'Y', '11');
INSERT INTO TBL_VOTE ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO)
    VALUES ('4901012000800', '장유권', '0930', '제1투표장', 'Y', '13');
INSERT INTO TBL_VOTE ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO)
    VALUES ('7901011000900', '정유권', '0930', '제1투표장', 'Y', '13');
INSERT INTO TBL_VOTE ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO)
    VALUES ('8901012001001', '강유권', '0930', '제1투표장', 'Y', '14');
INSERT INTO TBL_VOTE ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO)
    VALUES ('9901011001100', '신유권', '0930', '제1투표장', 'Y', '15');
INSERT INTO TBL_VOTE ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO)
    VALUES ('7901012001200', '오유권', '1330', '제1투표장', 'Y', '11');
INSERT INTO TBL_VOTE ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO)
    VALUES ('6901011001300', '현유권', '1330', '제2투표장', 'Y', '14');
INSERT INTO TBL_VOTE ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO)
    VALUES ('8901011001400', '왕유권', '1330', '제2투표장', 'Y', '12');
INSERT INTO TBL_VOTE ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO)
    VALUES ('9901011001500', '유유권', '1330', '제2투표장', 'Y', '13');
INSERT INTO TBL_VOTE ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO)
    VALUES ('7901011001600', '한유권', '1330', '제2투표장', 'Y', '12');
INSERT INTO TBL_VOTE ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO)
    VALUES ('8901011001700', '문유권', '1330', '제2투표장', 'Y', '14');
INSERT INTO TBL_VOTE ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO)
    VALUES ('9901011001800', '양유권', '1330', '제2투표장', 'Y', '12');
INSERT INTO TBL_VOTE ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO)
    VALUES ('9901011001900', '구유권', '1330', '제2투표장', 'Y', '14');
INSERT INTO TBL_VOTE ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO)
    VALUES ('4901011002000', '황유권' ,'1330', '제2투표장', 'Y', '15');
INSERT INTO TBL_VOTE ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO)
    VALUES ('6901011002100', '배유권', '1330', '제2투표장', 'Y', '13');
INSERT INTO TBL_VOTE ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO)
    VALUES ('7901011002200', '전유권', '1330', '제2투표장', 'Y', '13');
INSERT INTO TBL_VOTE ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO)
    VALUES ('9901011002300', '고유권', '1330', '제2투표장', 'Y', '11');
INSERT INTO TBL_VOTE ( VJUMIN, VNAME, VTIME, VAREA, VCONFIRM, MNO)
    VALUES ('5901011002400', '권유권', '1330', '제2투표장', 'Y', '13');
    
    
--TBL_GRADE
INSERT INTO TBL_GRADE ( MNO, GDATE, GSCHOOL_NAME)
    VALUES ('11', '1987-03-04', '역삼고등학교');
INSERT INTO TBL_GRADE ( MNO, GDATE, GSCHOOL_NAME)
    VALUES ('12', '1989-05-03', 'KH대학원');
INSERT INTO TBL_GRADE ( MNO, GDATE, GSCHOOL_NAME)
    VALUES ('13', '1999-03-07', 'KH대학교');
INSERT INTO TBL_GRADE ( MNO, GDATE, GSCHOOL_NAME)
    VALUES ('14', '2009-03-02', '역삼대학교');
INSERT INTO TBL_GRADE ( MNO, GDATE, GSCHOOL_NAME)
    VALUES ('15', '2025-07-02', '역삼대학원');

    
COMMIT;
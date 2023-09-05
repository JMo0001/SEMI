desc member;
desc dept;

INSERT INTO DEPT (deptno, deptname)
    values ('1001', '잉여부');
    
INSERT INTO DEPT ( deptno, deptname)
    values ('2001', '숨쉬기부');
    
desc rank;
insert into rank ( mrankno, mrank)
    values ('1', '부장');
    
insert into rank (mrankno, mrank)
    values ('2', '사원');
    
insert into member (mno, mrankno, deptno, mname, memail, mphone)
    values ('1000001', '1', '1001', '나부장', 'na@gaa.co.kr', '01023345566');
    
insert into member (mno, mrankno, deptno, mname, memail, mphone)
    values ('1000002', '2', '1001', '나사원', 'sa@gaa.co.kr', '01011234566');


desc project;

insert into project (pno, mno, pname, pcoment, paccess, pdate, pstartdate, penddate)
    values('202308311001', '1000001', '누워있기 프로젝트', '편하게 눕자', '1', '20230831', '20230831', '20240831');

desc task;

insert into task ( tno, pno, mno, tmember, tcontent, tstatus, tdate, tstartdate, tenddate)
    values ('01', '202308311001', '1000001', '1000002', '잘 누워 있어야해', '진행중', '20230831', '20230831', '20240831');
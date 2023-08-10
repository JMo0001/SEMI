select m.mcity, mno, p.pname, m.mname, 
        extract(year from to_date(substr(mjumin,1,6),'rrmmdd'))||'년'||substr(mjumin,3,2)||'월'||substr(mjumin,5,2)||'일'||' (만'||trunc(to_number(sysdate-to_date(substr(mjumin,1,6),'rrmmdd'))/365)||'세)' birth, 
        decode(substr(mjumin,7,1),1,'남',2,'여') gender, 
        gschool_Name||' 졸업' gschoolname
    from tbl_member m
    join tbl_party p using (pcode) 
    join tbl_grade g using (mno)
    join 
;
select rank()over(partition by mcity order by cnt desc) rnk, mcity, mno, pname, mname, cnt, 
				gschool_Name||' 졸업' gschoolname, 
				extract(year from to_date(substr(mjumin,1,6),'rrmmdd'))||'년'||substr(mjumin,3,2)||'월'||substr(mjumin,5,2)||'일'||' 
				(만'||trunc(to_number(sysdate-to_date(substr(mjumin,1,6),'rrmmdd'))/365)||'세)' birth, 
			    decode(substr(mjumin,7,1),1,'남',2,'여') gender 
				   from (select mjumin, pcode, mno, mname, mcity, count(mno) cnt 
				 from (select mno, vconfirm from tbl_vote where vconfirm ='Y') v 
			   join tbl_member m using(mno) group by mjumin, mno, mname, mcity, pcode order by mcity, cnt desc) 
			  join tbl_party using (pcode) 
			  join tbl_grade using(mno);


select rank()over(partition by mcity order by cnt desc) rank, mcity, mno, pname, mname, cnt, gschool_Name||' 졸업' gschoolname, extract(year from to_date(substr(mjumin,1,6),'rrmmdd'))||'년'||substr(mjumin,3,2)||'월'||substr(mjumin,5,2)||'일'||' (만'||trunc(to_number(sysdate-to_date(substr(mjumin,1,6),'rrmmdd'))/365)||'세)' birth, 
        decode(substr(mjumin,7,1),1,'남',2,'여') gender
    from (select mjumin, pcode, mno, mname, mcity, count(mno) cnt
            from (select mno, vconfirm from tbl_vote where vconfirm ='Y') v 
            join tbl_member m using(mno) group by mjumin, mno, mname, mcity, pcode order by mcity, cnt desc)
    join tbl_party using (pcode)
    join tbl_grade using(mno)
    
;

select mcity, mno, count(mno) cnt
    from tbl_vote 
    join tbl_member using(mno)
    where vconfirm = 'Y' 
    group by mno, mcity 
    order by mcity, mno desc
;
select mcity from tbl_member group by mcity



;






select rank()over(partition by mcity order by count(mno) desc)rr, mcity, mno, count(mno) cnt
    from tbl_member
    join tbl_vote using(mno)
    group by mno, mcity
    order by mcity, cnt desc
;

selct rank() over(order by cnt)
from 
( select mcity, mno, count(mno) cnt
    from tbl_member
    join tbl_vote using(mno)
    group by mno, mcity
    order by mcity, cnt desc )
    
    
    
;

select * from
(
select rownum, tb1.* from
(
select vname, 
				extract(year from to_date(substr(vjumin,1,6),'rrmmdd'))||'년'||
			 substr(vjumin,3,2)||'월'||substr(vjumin,5,2)||'일' vbirth,
			 '만'||trunc(to_number(sysdate-to_date(substr(vjumin,1,6),'rrmmdd'))/365)||'세' vage,
			 decode(substr(vjumin,7,1),1,'남',2,'여') gender, mno, 
			 vtime, vconfirm from tbl_vote 
             )tb1)tb2
             
            ;
            
select count(*) from tbl_vote;


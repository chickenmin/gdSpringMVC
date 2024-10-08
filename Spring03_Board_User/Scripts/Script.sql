SELECT SEQ ,ID ,TITLE ,"DEPTH" ,STEP ,"REF" ,DELFLAG ,REGDATE 
 FROM ANSWERBOARD a;
 
UPDATE ANSWERBOARD SET DELFLAG = 'Y'
 WHERE DELFLAG = 'N'
 AND SEQ IN ('1','2','3');
 

INSERT INTO ANSWERBOARD
		(SEQ, ID, TITLE, 
		CONTENT, "REF", STEP, 
		"DEPTH", REGDATE)
VALUES(ANSWERBOARD_SEQ.NEXTVAL, 'A001', '월요일 좋아요',
		'월요일은 힘들다', (SELECT NVL(MAX(REF),0)+1 FROM ANSWERBOARD a)  , 0, 
		'0', CURRENT_DATE);


SELECT SEQ, ID, TITLE, 
		CONTENT, "REF", STEP, 
		"DEPTH",  DELFLAG,
		TO_CHAR(REGDATE,'YYYY/MM/DD HH:mi:ss') REGDATE 
FROM ANSWERBOARD
WHERE SEQ = '30';

UPDATE ANSWERBOARD SET STEP = STEP +1
 WHERE "REF" =(SELECT "REF"  FROM ANSWERBOARD a WHERE SEQ ='11')
 AND  STEP > (SELECT STEP FROM ANSWERBOARD a2 WHERE SEQ = '11');

INSERT INTO ANSWERBOARD
		(SEQ, ID, TITLE, 
		CONTENT, "REF", STEP, 
		"DEPTH", REGDATE)
VALUES(ANSWERBOARD_SEQ.NEXTVAL, 'A001', '월요일의 답글',
		'월요일의 답글 내용', (SELECT "REF" FROM ANSWERBOARD a WHERE SEQ='11')  , (SELECT STEP+1 FROM ANSWERBOARD a2 WHERE SEQ='11'), 
		(SELECT "DEPTH" FROM ANSWERBOARD a3 WHERE SEQ='11')+1, CURRENT_DATE);

	
SELECT ID,NAME ,EMAIL ,AUTH ,JOININDATE 
 FROM USERINFO u 
 WHERE ID='A001' AND PASSWORD ='A001';

SELECT COUNT(*) 
 FROM USERINFO u 
 WHERE ID ='A005';

 
INSERT INTO EDU.USERINFO
		(ID, NAME, PASSWORD, 
		EMAIL, AUTH, ENABLE, 
		JOININDATE)
VALUES('A004', '워룡이', 'A004', 
		'A004@gmail.com', 'U', 'Y', 
	CURRENT_DATE);



SELECT ID,NAME 
 FROM USERINFO u; 

SELECT ID,NAME  
 FROM USERINFO u
 WHERE AUTH ='U'
 AND NAME='코코볼';

SELECT ID,NAME  
 FROM USERINFO u
 WHERE AUTH ='U'
 AND ID ='A001';


SELECT ID
 FROM USERINFO u 
 WHERE NAME ='코코볼'
 AND EMAIL ='A001@gmail.com';



SELECT SEQ, ID, TITLE, 
		CONTENT, "REF", STEP, 
		"DEPTH",  DELFLAG,
		TO_CHAR(REGDATE,'YYYY/MM/DD HH:mi:ss') REGDATE 
FROM ANSWERBOARD
WHERE DELFLAG ='Y';

UPDATE ANSWERBOARD SET DELFLAG ='N'
	WHERE SEQ IN ('1','2','3');




SELECT 'A'||LPAD(MAX(SUBSTR(ID,4,1))+1,3,'0')
 FROM USERINFO u ;





		INSERT INTO EDU.USERINFO
                (ID, NAME, PASSWORD, 
                EMAIL, AUTH, ENABLE, 
                JOININDATE)
			VALUES((SELECT 'A'||LPAD(MAX(SUBSTR(ID,4,1))+1,3,'0')
 FROM USERINFO u ), '워룡이', 'A004', 
                'A005@gmail.com', 'U', 'Y', 
        CURRENT_DATE);

UPDATE USERINFO  SET AUTH = 'U'
 WHERE ID IN ('A','B');



SELECT 
	CASE 
		WHEN "DEPTH" >0  THEN '<img src=''./img/reply.png''>'
	END||
	LPAD(' ',5*"DEPTH" ,'~~') || TITLE ,"DEPTH" 
 FROM ANSWERBOARD a ;




       
       
       
       
       
       
       
       
       
       
       
       
       
       
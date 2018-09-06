create or replace PROCEDURE TEST AS 
CID_1 NUMBER;                 --declaring the variables
CNAME_1 VARCHAR2(20);
NUMBER_OF_ORDERS_1 NUMBER;  
CLEVEL_1 VARCHAR2(20);
CLEVEL varchar(20);
cate varchar(20);
x NUMBER;
y NUMBER;
z NUMBER;
r NUMBER;
q NUMBER;

--Function to insert values into Customer Table
PROCEDURE INSERT_CUSTOMER (CID_1 IN NUMBER,CNAME_1 IN VARCHAR2, NUMBER_OF_ORDERS_1 IN NUMBER,  CLEVEL_1 IN VARCHAR2) AS
 BEGIN
 --Inserting the values into the customer Table
 INSERT INTO CUSTOMER(CID, CNAME,NUMBER_OF_ORDERS,CLEVEL) VALUES (CID_1, CNAME_1,y,CLEVEL_1);
 END;

BEGIN
CID_1 := 205;
CNAME_1 := 'SaiTeja';
NUMBER_OF_ORDERS_1 := 10;
x := NUMBER_OF_ORDERS_1;
CLEVEL_1 := 'Children';
cate := CLEVEL_1;

DBMS_OUTPUT.PUT_LINE('CID' || ' ' || 'CNAME' || ' ' || 'NUMBER_OF_ORDERS' || ' ' || 'CLEVEL');

FOR CID IN (SELECT CLEVEL into CLEVEL FROM CUSTOMER)
LOOP
IF cate='Children' THEN
SELECT AVG(NUMBER_OF_ORDERS)INTO y FROM CUSTOMER WHERE CLEVEL=cate;
ELSE
SELECT AVG(NUMBER_OF_ORDERS)into y FROM CUSTOMER;
END IF;
END LOOP;

INSERT_CUSTOMER(CID_1, CNAME_1,y,CLEVEL_1);                                      --inserting the value
DBMS_OUTPUT.PUT_LINE('CID' || ' ' || 'CNAME' || ' ' || 'NUMBER_OF_ORDERS' || ' ' || 'CLEVEL');
 FOR object IN (select * from CUSTOMER order by CID)
 LOOP
 DBMS_OUTPUT.PUT_LINE(object.CID || ' ' || object.CNAME || ' ' || object.NUMBER_OF_ORDERS || ' ' || object.CLEVEL);
 END LOOP;

END TEST;
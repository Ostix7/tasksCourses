CREATE TABLE ORDERS (
ID SERIAL PRIMARY KEY,
NAME VARCHAR (30) NOT NULL,
TRAVEL_START DATE,
TRAVEL_START_TIME TIME,
PRICE FLOAT
);

CREATE TABLE ORDERS_INFO (
ID SERIAL PRIMARY KEY,
SHIP_ID INTEGER REFERENCES ORDERS(ID),
USER_ID INTEGER REFERENCES USER_ROLE(ID),
TOTAL_PRICE FLOAT
);



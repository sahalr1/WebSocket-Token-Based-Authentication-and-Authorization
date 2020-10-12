# WebSocket-Token-Based-Authentication-and-Authorization
Angular Client and Spring boot Server


# Run

Angular :- Websocket-client 
1) npm install
2) ng serve

Spring boot :- Websocket-server
1) Create database name testSocket
2) insert sql data 
- INSERT INTO Role (id,deleted,description,name) VALUES (1,0,'teacher','teacher'),(2,0,'admin','admin'),(3,0,'student','student');

- INSERT INTO User(id,'username','password') VALUES (2,'sahal','$2a$10$GuVunMmGALrHb0nkaYzh7e.oh5QAIxNd829W1yB/0SL00z.3S46RG');

- INSERT INTO `USER_ROLES` VALUES (1,1);
3) mvn spring-boot:run


# Login User

username : sahal
password: user@V2



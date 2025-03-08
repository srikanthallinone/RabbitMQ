# RabbitMQ

https://hub.docker.com/_/rabbitmq	(image  : rabbitmq:3-management )
docker run  --rm  -it -p 15672:15672 -p 5672:5672 rabbitmq:3-management

http://localhost:15672/
guest/guest


RABBITMQ SERVER  RUNNING
SPRING BOOT APPLICAITON  CREATED

spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest


In sprinboot  service
create   config, producer, consumer, controller, dto  packages
a)Create  Rabbitmq config class under config package
configure   queue, exchange , Binding  queue  and exchange with routing key

b)rabbittemplate
c)conneciton factory
d)rabbitAdmin
b,c,d  are automatically  do  these theree by  spring bean autoconfiguation, just we need to inject these

Create  Producer

create send method to send message using   Rabbitmqtempalte,  need  exchangem routing key


Controller:

add endpoint to  publish  message

Create Consumer

add method to consume message use  @RabbitListener




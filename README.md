# microserviceviaspringbootproject
end to end implementation of microservice using spring boot
it covers writing Individual microservices , API Gateway ,Service Registry setup

There are 3 microservices created.
1. User Service - It provides API to create , fetch user details
2. Hotel Service - It provides API to register , fetch hotel details
3. Rating Service - It provides API to add ratings for a hotel by a user , fetch the rating given by user details
4. Service Registry - Its implemented via Eureka Server Spring boot dependency. It provides names to each microservice removing the hardcoding to be called by host/port details. Also it provides details of availability of each microservice (up/down).
5. API Gateway - It acts as gateway for all microservices to client so that client need not remember and call individual microservices
   


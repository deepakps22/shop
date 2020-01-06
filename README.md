# ecommerce
An ecommerce clone made with springboot.

#### Prerequisites
- [OpenJDK 8](https://openjdk.java.net/projects/jdk/8/)
- [Maven 3.6+](https://maven.apache.org/install.html)

#### Running

- Before running application is required configure Postgres database on port 5432 and run this command:

```
create database ecommerce
```


After this you can run the application:
```
mvn clean compile spring-boot:run
```

#### Endpoints
##### Customer
```
[GET] /customers
[POST] /customers
[PUT] /customers
[GET] /customers/{id}
[DELETE] /customers/{id}
```

##### Products
```
[GET] /products
[POST] /products
[PUT] /products
[GET] /products/{id}
[DELETE] /products/{id}
```

##### Order
```
[POST] /customers/{customerId}/orders
```

##### StockItems
```
[GET] /stockItems
[POST] /stockItems
[PUT] /stockItems
[GET] /stockItems/{id}
[DELETE] /stockItems/{id}
```

##### StockRequest
```
[POST] /stockRequest
```

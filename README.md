# BicycleRentalService

The application allows to registrate customers and provide rental service.

The pet project built on stack: Spring Core, Spring JDBC template, Spring MVC, Spring Validator and PostgreSQL.

Application functionality:
- You can manage two entity, customers and bicycles. Standard CRUD operations are implemented via SQL scripts
  and Spring JDBC on repository layer.
- Customers are able to rent  several bicycles. Bicycle can only be rented by one customer. 
  One-to-many relationship is implemented at database level and managing via SQL scripts.


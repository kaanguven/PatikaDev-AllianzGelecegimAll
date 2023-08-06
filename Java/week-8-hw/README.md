ERP Application Readme
This is a README file providing an overview of the ERP (Enterprise Resource Planning) application. The application consists of controllers, entities, services, and repositories that manage customer, order, product, and receipt data. The application is built using Spring Boot and uses PostgreSQL as the database.

Controllers
CustomerController.java
This controller handles CRUD operations related to customers. It provides endpoints for getting a list of customers, creating a new customer, getting a customer by name, deleting a customer by UUID, and updating a customer by UUID.

OrderController.java
This controller handles CRUD operations related to orders. It provides endpoints for getting a list of orders, creating a new order, adding a product to an order, deleting an order by UUID, and updating an order by UUID.

ProductController.java
This controller handles CRUD operations related to products. It provides endpoints for getting a list of products, creating a new product, getting a product by name, deleting a product by UUID, and updating a product by UUID.

ReceiptController.java
This controller handles creating receipts for orders. It provides an endpoint for creating a receipt for a specific order.

Entities
CustomerEntity.java
The CustomerEntity represents a customer and is mapped to the database table “customer.” It contains properties for the customer’s name, surname, and a list of orders associated with the customer.

OrderEntity.java
The OrderEntity represents an order and is mapped to the database table “order.” It contains properties for the order status, a reference to the associated customer, and a list of products in the order.

ProductEntity.java
The ProductEntity represents a product and is mapped to the database table “product.” It contains properties for the product’s name, price, stock amount, whether KDV (Value Added Tax) is applied, and a list of orders in which the product is included.

ReceiptEntity.java
The ReceiptEntity represents a receipt and is mapped to the database table “receipt.” It contains properties for the receipt, including the names of products, the number of products, KDV prices, normal prices, KDV total prices, and normal total prices.

Repositories
CustomerRepository.java
This repository provides methods for CRUD operations on the “customer” table.

OrderRepository.java
This repository provides methods for CRUD operations on the “order” table.

ProductRepository.java
This repository provides methods for CRUD operations on the “product” table.

ReceiptRepository.java
This repository provides methods for CRUD operations on the “receipt” table.

Models
Customer.java
The Customer model is a representation of a customer used for data transfer. It includes properties for the customer’s UUID, name, surname, and a list of orders associated with the customer.

Order.java
The Order model is a representation of an order used for data transfer. It includes properties for the order’s UUID, status, associated customer, and a list of products in the order.

Product.java
The Product model is a representation of a product used for data transfer. It includes properties for the product’s UUID, name, stock amount, price, and a list of orders in which the product is included.

Enums
OrderStatusEnum.java
The OrderStatusEnum is an enumeration that defines the possible statuses of an order. The possible values are REJECTED, PENDING, and APPROVED.

Services
CustomerService.java
The CustomerService provides business logic for handling customer-related operations, such as creating, updating, deleting, and retrieving customers.

OrderService.java
The OrderService provides business logic for handling order-related operations, such as creating, updating, deleting, and retrieving orders. It also allows adding a product to an order.

ProductService.java
The ProductService provides business logic for handling product-related operations, such as creating, updating, deleting, and retrieving products.

ReceiptService.java
The ReceiptService provides business logic for handling receipt-related operations, such as creating receipts for orders.

Base Entity
BaseEntity.java
The BaseEntity is a common entity class extended by other entities. It provides properties for ID, UUID, creation date, and last update date.

Application Properties
The application.properties file contains configuration settings for the Spring Boot application, such as the server port, database connection details, and other properties.

Note: The application.properties file also includes a property “tax.rate” for defining the tax rate used in receipt calculations.
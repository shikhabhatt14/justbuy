JustBuy Project is created to practice and cover various modules associated with a e-commerce website.
Technology used:
1. Java 17
2. Spring Boot 3
3. Spring Security 6.1
4. Docker
5. in-memory DB - H2
6. NoSQL DB - MongoDB
7. Spring Profiles
8. Spring Data

DOCKER COMMANDS USED:
docker-machine start
docker build -t proj:justbuy .

Docker Container created using Docker Window App.


Roles Allowed: Admin, Buyer, Seller Visitor

operations:
1. Visitor: listProduct, viewProduct, addToCart
2. Buyer: listProduct, viewProduct, addToCart, makePurchase, updateProfile, addPaymentMethod, listOrders, viewOrder, returnProduct, replaceProduct
3. Seller: updateProfile, listProduct, viewProduct, addProduct, deleteProduct, getOrder, replacementOrder, returnOrder
4. Admin:
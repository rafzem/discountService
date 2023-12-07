# discountService

## Database
Service uses four database tables.
 1. PRODUCT - holds all information about product with its uuid, name and base price
2. DISCOUNT - holds necessary data about discounts. Basing on type holds different type of discounts.
 3. DISCOUNT_GROUP - groups discounts. Discount is attached to the group not to the product itself. 
 4. PRODUCT_DISCOUNT_GROUP_ASSOCIATION - associates products with discount group.

Idea behind was to attach discounting policies to groups instead of products. It should make process of creating discounting policies easier.
In order to check the relations see schema.sql and data.sql

## Discounts
 - Two types of discounts available in system
   - Percentage discount - plain percentage discount subtracted from price
   - Amount Based discount - More you buy less you pay. This kind of discount is counted basing on equation.
     - If you buy minimal requested amount of products (i.e 3) then you get base discount
     - Each another requested product raises discount for specified step
     - After reaching maximal level you will get max discount besides amount of additional products
## API
   Two endpoints exposed 
- List of products
    - GET ``/products`` - returns list of products
```json
  [
      {
      "uuid": "0c457dae-f96f-4641-a0a0-6b33c23beacd",
      "name": "Buty",
      "price": 100.00
      },
      {
      "uuid": "be9f7d7e-fb9b-40af-b7fd-b994af874313",
      "name": "Kurtki",
      "price": 45.50
      }
]
```
- GET product prices ``/products/{productId}/discount?amount=40``
```json
  {
  "uuid": "32e864d6-65a7-4a27-9a06-d0ac878ec99f",
  "name": "Bombka",
  "basePrice": 200.00,
  "discountPrice": 100.0000,
  "offerAmount": 40
  }
```

## Usage
 - To build the project ``mvn clean package``
 - To execute run `` mvn spring-boot:run``
## Instructor TODO:
* Create an application with simple user/password login that feeds in to an
  unsanitized SQL query that's vulnerable to SQL injection.
* Create a server that accepts an item price via the HTTP request, like

```
GET /buy?product_id=42&quantity=7&price_per_item=320
```

Students should notice that the price is baked into the URL and use their own
HTTP client to change the price outside of an Android application.

Students should correct this by having the server use the product_id to look
up the price_per_item on the server instead of trusting the HTTP request to
tell the server how much the item costs.

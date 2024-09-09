# Gilded Rose Inventory Management
## How to run

1. Clone the repository.
2. Run `mvn clean install` to build the project.
3. Start the application with `mvn spring-boot:run`.
4. POST JSON data to `/api/inventory/update` to update inventory.

## Running Tests

Run `mvn test` to execute the unit tests

## Frontend

1. Open `http://localhost:8080/index.html` in your browser.
2. Enter data in the text are e.g 
   [
      {"name":"Aged Brie", "sellIn": 0, "quality": 2}
      {"name": "Backstage passes", "sellIn": -2, "quality": 0}
   ]
3. Click "Update Inventory" to send a sample request. 

## Using POSTMAN or CURL
Once the application is running , the API can be tested with tools
like POSTMAN or CURL. Below is an example:

## Sample Test Data
'[
    {"name": "Aged Brie", "sellIn": 1, "quality": 1},
    {"name": "Aged Brie", "sellIn": 0, "quality": 50},
    {"name": "Backstage passes", "sellIn": -1, "quality": 2}
    {"name": "Backstage passes", "sellIn": 9, "quality": 2}
    {"name": "Sulfuras", "sellIn": 2, "quality": 2},
    {"name": "Normal Item", "sellIn": -1, "quality": 55}
    {"name": "Normal Item", "sellIn": 2, "quality": 2},
    {"name": "INVALID ITEM", "sellIn": 2, "quality": 2}
    {"name": "Conjured", "sellIn": 2, "quality": 2},
    {"name": "Conjured", "sellIn": -1, "quality": 5}
]'
## CURL
curl -X POST http://localhost:8080/api/inventory/update -H "Content-TYpe: application/json" -d 
'[{"name":"Aged Brie", "sellIn": 1, "quality": 1},
  {"name": "Backstage passes", "sellIn": -1, "quality": 2}
]'

## The JSON response using the CURL and its data
[
    {"name":"Aged Brie", "sellIn": 0, "quality": 2}
    {"name": "Backstage passes", "sellIn": -2, "quality": 0}
]
# API-Testing

Youtube reference: https://www.youtube.com/playlist?list=PLD_oMT3yQBF-ZB4EIRYKP1BQLhzzDmEPD

GitHub reference: https://github.com/typicode/json-server


For the branch api_blog, new json has been made. Steps followed:

1) npm install -g json-server
2) json-server --watch companies.json

Before running the above second command, companies.json file has been created

{
  "E-Commerce": [
    {
      "id": 1,
      "name": "Amazon",
      "ceo": "Jeff Bezos",
      "isGlobal": true
    },
    {
      "id": 2,
      "name": "Flipkart",
      "ceo": "Kalyan Krishnamurthy",
      "isGlobal": false
    }
  ],
  "Banking": [
	{
      "id": 1,
      "name": "JP Morgan",
      "ceo": "Jamie Dimon",
      "isGlobal": true
    },
    {
      "id": 2,
      "name": "Wells Fargo",
      "ceo": "Charles W. Scharf",
      "isGlobal": true
    }
  ],
  "Automobile": [
    {
      "id": 1,
      "name": "BMW",
      "ceo": "Harald Krueger",
      "isGlobal": true
    }
  ]
}




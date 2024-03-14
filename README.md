# ForeignExchange

`IMPORTANT: AS OF WRITING THIS LINE, THE ACCESS KEY FOR THE EXTERNAL API SERVICE HAS EXPIRED, BY EXCEEDING MAXIMUM REQUESTS OF 100 PER MONTH!`

Add the time of submission, the only implementation of endpoints that exists yet is of the exchange and conversion API.
The fetched exchange rates/new conversions are stored in a in-memory db.

Start the server by running the main app DemoApplication.

The in-memory database can be started by navigating to
`http://localhost:8080/h2-console`
and clicking Enter/Log In.

Fetching exchange rate:
`/rates/{source}/`,
`/rates/{source}/{target}`

Make and persist a conversion:
`/convert/{amount}/{source}/{target}`

TO BE IMPLEMENTED:
`Unit tests;
Conversion List API;
JavaDoc;
Appropriate ErrorHandling;
Better utilization of RestTemplate (with possibly a design pattern)
`
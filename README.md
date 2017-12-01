# biggis-rest

REST interface for unified observations (e.g. data of LUBW, DWD, WU, ...)

# Quick and dirty usage example

* first, we deploy everything on our application server, e.g. Tomcat
* now we can query for all wanted parameters
* if a parameter is not supported, an error message explains the currently supported parameters (may change on run time)
* if a value for a valid parameter is not supported, an error message explains the currently supported values for this parameter (may change on run time)

query pattern:

``` txt
<Path>/rest?parameter1=value1&parameter2=value2&...
```

example:

``` txt
http://localhost/rest?quantity=temp&start=1995-01-01&end=2015-12-31&timeFormat=iso8601&placeFormat=gausskrueger&limit=100&offset=100
```

using content negotiation, the following media types can be produced:

``` txt
TEXT_HTML
TEXT_PLAIN
APPLICATION_JSON
```

the produced media type can also be forced by adding it to the path:

``` txt
<Path>/rest/html?parameter1=value1&parameter2=value2&...
<Path>/rest/csv?parameter1=value1&parameter2=value2&...
<Path>/rest/json?parameter1=value1&parameter2=value2&...
```


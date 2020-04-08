---
title: search Specification v0.0.1
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
highlight_theme: darkula
headingLevel: 2

---

<!-- Generator: Widdershins v4.0.1 -->

<h1 id="search-specification">search Specification v0.0.1</h1>

> Scroll down for code samples, example requests and responses. Select a language for code samples from the tabs above or the mobile navigation menu.

**This specification was generated from old data and may not reflect the actual API.**

Base URLs:

* <a href="/">/</a>

<h2 id="search-specification-search-overview">search-overview</h2>

## officersearch

<a id="opIdofficersearch"></a>

> Code samples

```shell
# You can also use wget
curl -X GET /search/officers?q=string \
  -H 'Accept: */*'

```

```http
GET /search/officers?q=string HTTP/1.1

Accept: */*

```

```javascript

const headers = {
  'Accept':'*/*'

};

fetch('/search/officers?q=string',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*'
}

result = RestClient.get '/search/officers',
  params: {
  'q' => 'string'
}, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*'
}

r = requests.get('/search/officers', params={
  'q': 'string'
}, headers = headers)

print r.json()

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
    
    );

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','/search/officers', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("/search/officers?q=string");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
        
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "/search/officers", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /search/officers`

*Search company officers*

<h4 id="officersearch-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|q|query|string|true|The term being searched for.|
|items_per_page|query|integer|false|The number of search results to return per page.|
|start_index|query|integer|false|The index of the first result item to return.|

> Example responses

> 200 Response

<h4 id="officersearch-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[OfficerSearch](#schemaofficersearch)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Invalid query string supplied.|None|

<h4 id="officersearch-responseschema">Response Schema</h4>

<aside class="success">
This operation does not require authentication
</aside>

## search

<a id="opIdsearch"></a>

> Code samples

```shell
# You can also use wget
curl -X GET /search?q=string \
  -H 'Accept: */*'

```

```http
GET /search?q=string HTTP/1.1

Accept: */*

```

```javascript

const headers = {
  'Accept':'*/*'

};

fetch('/search?q=string',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*'
}

result = RestClient.get '/search',
  params: {
  'q' => 'string'
}, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*'
}

r = requests.get('/search', params={
  'q': 'string'
}, headers = headers)

print r.json()

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
    
    );

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','/search', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("/search?q=string");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
        
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "/search", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /search`

*Search Companies House*

Search across all indexed information. To search against specific resource types, see <a href="/api/docs/search/companies/companysearch.html">company search</a>, <a href="/api/docs/search/officers/officersearch.html">officer search</a> or <a href="/api/docs/search/disqualified-officers/disqualifiedofficersearch.html">disqualified officer search</a>

<h4 id="search-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|q|query|string|true|The term being searched for.|
|items_per_page|query|integer|false|The number of search results to return per page.|
|start_index|query|integer|false|The index of the first result item to return.|

> Example responses

> 200 Response

<h4 id="search-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[Search](#schemasearch)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Invalid query string supplied.|None|

<h4 id="search-responseschema">Response Schema</h4>

<aside class="success">
This operation does not require authentication
</aside>

## companysearch

<a id="opIdcompanysearch"></a>

> Code samples

```shell
# You can also use wget
curl -X GET /search/companies?q=string \
  -H 'Accept: */*'

```

```http
GET /search/companies?q=string HTTP/1.1

Accept: */*

```

```javascript

const headers = {
  'Accept':'*/*'

};

fetch('/search/companies?q=string',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*'
}

result = RestClient.get '/search/companies',
  params: {
  'q' => 'string'
}, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*'
}

r = requests.get('/search/companies', params={
  'q': 'string'
}, headers = headers)

print r.json()

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
    
    );

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','/search/companies', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("/search/companies?q=string");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
        
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "/search/companies", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /search/companies`

*Search companies*

<h4 id="companysearch-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|q|query|string|true|The term being searched for.|
|items_per_page|query|integer|false|The number of search results to return per page.|
|start_index|query|integer|false|The index of the first result item to return.|

> Example responses

> 200 Response

<h4 id="companysearch-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[CompanySearch](#schemacompanysearch)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Invalid query string supplied.|None|

<h4 id="companysearch-responseschema">Response Schema</h4>

<aside class="success">
This operation does not require authentication
</aside>

## disqualifiedofficersearch

<a id="opIddisqualifiedofficersearch"></a>

> Code samples

```shell
# You can also use wget
curl -X GET /search/disqualified-officers?q=string \
  -H 'Accept: */*'

```

```http
GET /search/disqualified-officers?q=string HTTP/1.1

Accept: */*

```

```javascript

const headers = {
  'Accept':'*/*'

};

fetch('/search/disqualified-officers?q=string',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => '*/*'
}

result = RestClient.get '/search/disqualified-officers',
  params: {
  'q' => 'string'
}, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': '*/*'
}

r = requests.get('/search/disqualified-officers', params={
  'q': 'string'
}, headers = headers)

print r.json()

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => '*/*',
    
    );

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','/search/disqualified-officers', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("/search/disqualified-officers?q=string");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"*/*"},
        
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "/search/disqualified-officers", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /search/disqualified-officers`

*Search disqualified officers*

<h4 id="disqualifiedofficersearch-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|q|query|string|true|The term being searched for.|
|items_per_page|query|integer|false|The number of search results to return per page.|
|start_index|query|integer|false|The index of the first result item to return.|

> Example responses

> 200 Response

<h4 id="disqualifiedofficersearch-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[DisqualifiedOfficerSearch](#schemadisqualifiedofficersearch)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Invalid query string supplied.|None|

<h4 id="disqualifiedofficersearch-responseschema">Response Schema</h4>

<aside class="success">
This operation does not require authentication
</aside>

## Schemas

<h3 id="tocS_DisqualifiedOfficerSearchItems">DisqualifiedOfficerSearchItems</h3>
<!-- backwards compatibility -->
<a id="schemadisqualifiedofficersearchitems"></a>
<a id="schema_DisqualifiedOfficerSearchItems"></a>
<a id="tocSdisqualifiedofficersearchitems"></a>
<a id="tocsdisqualifiedofficersearchitems"></a>

```json
{
  "kind": "searchresults#disqualified-officer",
  "date_of_birth": "2020-04-08",
  "links": [
    {
      "self": "string"
    }
  ],
  "description": "string",
  "description_identifiers": [
    0
  ],
  "snippet": "string",
  "matches": [
    {
      "title": [
        0
      ],
      "snippet": [
        0
      ],
      "address_snippet": [
        0
      ]
    }
  ],
  "address": [
    {
      "address_line_1": "string",
      "address_line_2": "string",
      "country": "string",
      "locality": "string",
      "postal_code": "string",
      "premises": "string",
      "region": "string"
    }
  ],
  "address_snippet": "string",
  "title": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|kind|string|true|none|Describes the type of result returned.|
|date_of_birth|string(date)|false|none|The disqualified officer's date of birth.|
|links|[[LinksModel](#schemalinksmodel)]|false|none|Links to other resources associated with this search item.|
|description|string|true|none|The result description.|
|description_identifiers|[integer]|false|none|An array of enumeration types that make up the search description. See search_descriptions_raw.yaml in api-enumerations.|
|snippet|string|false|none|Summary information for the result, showing additional details that have matched. In the case of disqualified officers, this would be other disqualification names for the officer, if they exist.|
|matches|[[MatchesModel](#schemamatchesmodel)]|false|none|A list of members and arrays of character offset, defining substrings that matched the search terms.|
|address|[[DisqualifiedOfficerAddress](#schemadisqualifiedofficeraddress)]|true|none|The address of the disqualified officer as provided by the disqualifying authority.|
|address_snippet|string|true|none|A single line address. This will be the address that matched within the indexed document, or the primary address otherwise (as returned by the `address` member).|
|title|string|true|none|The title of the search result.|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|searchresults#disqualified-officer|

<h3 id="tocS_MatchesModel">MatchesModel</h3>
<!-- backwards compatibility -->
<a id="schemamatchesmodel"></a>
<a id="schema_MatchesModel"></a>
<a id="tocSmatchesmodel"></a>
<a id="tocsmatchesmodel"></a>

```json
{
  "title": [
    0
  ],
  "snippet": [
    0
  ],
  "address_snippet": [
    0
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|title|[integer]|false|none|An array of character offset into the `title` string. These always occur in pairs, and define the start and end of substrings in the member `title` that matched the search terms. The first character of the string is index 1.|
|snippet|[integer]|false|none|An array of character offset into the `snippet` string. These always occur in pairs, and define the start and end of substrings in the member `snippet` that matched the search terms. The first character of the string is index 1.|
|address_snippet|[integer]|false|none|An array of character offset into the `address_snippet` string. These always occur in pairs, and define the start and end of substrings in the member `address_snippet` that matched the search terms.|

<h3 id="tocS_DisqualifiedOfficerSearch">DisqualifiedOfficerSearch</h3>
<!-- backwards compatibility -->
<a id="schemadisqualifiedofficersearch"></a>
<a id="schema_DisqualifiedOfficerSearch"></a>
<a id="tocSdisqualifiedofficersearch"></a>
<a id="tocsdisqualifiedofficersearch"></a>

```json
{
  "kind": "search#disqualified-officers",
  "total_results": 0,
  "start_index": 0,
  "items_per_page": 0,
  "items": [
    {
      "kind": "searchresults#disqualified-officer",
      "date_of_birth": "2020-04-08",
      "links": [
        {
          "self": "string"
        }
      ],
      "description": "string",
      "description_identifiers": [
        0
      ],
      "snippet": "string",
      "matches": [
        {
          "title": [
            0
          ],
          "snippet": [
            0
          ],
          "address_snippet": [
            0
          ]
        }
      ],
      "address": [
        {
          "address_line_1": "string",
          "address_line_2": "string",
          "country": "string",
          "locality": "string",
          "postal_code": "string",
          "premises": "string",
          "region": "string"
        }
      ],
      "address_snippet": "string",
      "title": "string"
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|kind|string|true|none|The type of response returned.|
|total_results|integer|false|none|The number of further search results available for the current search.|
|start_index|integer|false|none|The index into the entire result set that this result page starts.|
|items_per_page|integer|false|none|The number of search items returned per page.|
|items|[[DisqualifiedOfficerSearchItems](#schemadisqualifiedofficersearchitems)]|false|none|The results of the completed search.|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|search#disqualified-officers|

<h3 id="tocS_OfficerAddress">OfficerAddress</h3>
<!-- backwards compatibility -->
<a id="schemaofficeraddress"></a>
<a id="schema_OfficerAddress"></a>
<a id="tocSofficeraddress"></a>
<a id="tocsofficeraddress"></a>

```json
{
  "address_line_1": "string",
  "address_line_2": "string",
  "care_of": "string",
  "country": "string",
  "locality": "string",
  "po_box": "string",
  "postal_code": "string",
  "premises": "string",
  "region": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|address_line_1|string|false|none|The first line of the address.|
|address_line_2|string|false|none|The second line of the address.|
|care_of|string|false|none|The care of name.|
|country|string|false|none|The country. For example, UK.|
|locality|string|false|none|The locality. For example London.|
|po_box|string|false|none|The post-office box number.|
|postal_code|string|false|none|The postal code. For example CF14 3UZ.|
|premises|string|false|none|The property name or number.|
|region|string|false|none|The region. For example Surrey.|

<h3 id="tocS_DisqualifiedOfficerAddress">DisqualifiedOfficerAddress</h3>
<!-- backwards compatibility -->
<a id="schemadisqualifiedofficeraddress"></a>
<a id="schema_DisqualifiedOfficerAddress"></a>
<a id="tocSdisqualifiedofficeraddress"></a>
<a id="tocsdisqualifiedofficeraddress"></a>

```json
{
  "address_line_1": "string",
  "address_line_2": "string",
  "country": "string",
  "locality": "string",
  "postal_code": "string",
  "premises": "string",
  "region": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|address_line_1|string|false|none|The first line of the address.|
|address_line_2|string|false|none|The second line of the address.|
|country|string|false|none|The country. For example, UK.|
|locality|string|false|none|The locality. For example London.|
|postal_code|string|false|none|The postal code. For example CF14 3UZ.|
|premises|string|false|none|The property name or number.|
|region|string|false|none|The region. For example Surrey.|

<h3 id="tocS_OfficerSearchItems">OfficerSearchItems</h3>
<!-- backwards compatibility -->
<a id="schemaofficersearchitems"></a>
<a id="schema_OfficerSearchItems"></a>
<a id="tocSofficersearchitems"></a>
<a id="tocsofficersearchitems"></a>

```json
{
  "kind": "searchresults#officer",
  "date_of_birth": [
    {
      "month": 0,
      "year": 0
    }
  ],
  "title": "string",
  "address_snippet": "string",
  "links": [
    {
      "self": "string"
    }
  ],
  "appointment_count": 0,
  "description": "string",
  "description_identifiers": [
    0
  ],
  "snippet": "string",
  "matches": [
    {
      "title": [
        0
      ],
      "snippet": [
        0
      ],
      "address_snippet": [
        0
      ]
    }
  ],
  "address": [
    {
      "address_line_1": "string",
      "address_line_2": "string",
      "care_of": "string",
      "country": "string",
      "locality": "string",
      "po_box": "string",
      "postal_code": "string",
      "premises": "string",
      "region": "string"
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|kind|string|true|none|Describes the type of result returned.|
|date_of_birth|[[OfficerDateOfBirth](#schemaofficerdateofbirth)]|false|none|The officer date of birth details.|
|title|string|true|none|The title of the search result.|
|address_snippet|string|true|none|A single line address. This will be the address that matched within the indexed document, or the primary address otherwise (as returned by the `address` member).|
|links|[[LinksModel](#schemalinksmodel)]|false|none|Links to other resources associated with this search item.|
|appointment_count|integer|true|none|The total number of appointments the officer has.|
|description|string|true|none|The result description.|
|description_identifiers|[integer]|false|none|An array of enumeration types that make up the search description. See search_descriptions_raw.yaml in api-enumerations.|
|snippet|string|false|none|Summary information for the result, showing additional details that have matched. In the case of company officers, this would be other appointment names for the officer .|
|matches|[[MatchesModel](#schemamatchesmodel)]|false|none|A list of members and arrays of character offset, defining substrings that matched the search terms.|
|address|[[OfficerAddress](#schemaofficeraddress)]|true|none|The service address of the officer.|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|searchresults#officer|

<h3 id="tocS_CompanySearch">CompanySearch</h3>
<!-- backwards compatibility -->
<a id="schemacompanysearch"></a>
<a id="schema_CompanySearch"></a>
<a id="tocScompanysearch"></a>
<a id="tocscompanysearch"></a>

```json
{
  "kind": "search#companies",
  "etag": "string",
  "items": [
    {
      "kind": "searchresult#company",
      "title": "string",
      "address_snippet": "string",
      "links": [
        {
          "self": "string"
        }
      ],
      "description": "string",
      "description_identifier": [
        0
      ],
      "company_number": "string",
      "external_registration_number": "string",
      "snippet": "string",
      "date_of_creation": "2020-04-08",
      "date_of_cessation": "2020-04-08",
      "company_type": "private-unlimited",
      "company_status": "active",
      "address": [
        {
          "address_line_1": "string",
          "address_line_2": "string",
          "country": "Wales",
          "locality": "string",
          "po_box": "string",
          "postal_code": "string",
          "care_of": "string",
          "region": "string"
        }
      ],
      "matches": [
        {
          "title": [
            0
          ],
          "snippet": [
            0
          ],
          "address_snippet": [
            0
          ]
        }
      ]
    }
  ],
  "total_results": 0,
  "start_index": 0,
  "items_per_page": 0
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|kind|string|false|none|The type of search response returned.|
|etag|string|false|none|The ETag of the resource.|
|items|[[CompanySearchItems](#schemacompanysearchitems)]|false|none|The results of the completed search.|
|total_results|integer|false|none|The number of further search results available for the current search.|
|start_index|integer|false|none|The index into the entire result set that this result page starts.|
|items_per_page|integer|false|none|The number of search items returned per page.|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|search#companies|

<h3 id="tocS_OfficerSearch">OfficerSearch</h3>
<!-- backwards compatibility -->
<a id="schemaofficersearch"></a>
<a id="schema_OfficerSearch"></a>
<a id="tocSofficersearch"></a>
<a id="tocsofficersearch"></a>

```json
{
  "kind": "search#officers",
  "total_results": 0,
  "start_index": 0,
  "items_per_page": 0,
  "items": [
    {
      "kind": "searchresults#officer",
      "date_of_birth": [
        {
          "month": 0,
          "year": 0
        }
      ],
      "title": "string",
      "address_snippet": "string",
      "links": [
        {
          "self": "string"
        }
      ],
      "appointment_count": 0,
      "description": "string",
      "description_identifiers": [
        0
      ],
      "snippet": "string",
      "matches": [
        {
          "title": [
            0
          ],
          "snippet": [
            0
          ],
          "address_snippet": [
            0
          ]
        }
      ],
      "address": [
        {
          "address_line_1": "string",
          "address_line_2": "string",
          "care_of": "string",
          "country": "string",
          "locality": "string",
          "po_box": "string",
          "postal_code": "string",
          "premises": "string",
          "region": "string"
        }
      ]
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|kind|string|true|none|The type of response returned.|
|total_results|integer|false|none|The number of further search results available for the current search.|
|start_index|integer|false|none|The index into the entire result set that this result page starts.|
|items_per_page|integer|false|none|The number of search items returned per page.|
|items|[[OfficerSearchItems](#schemaofficersearchitems)]|false|none|The results of the completed search.|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|search#officers|

<h3 id="tocS_Search">Search</h3>
<!-- backwards compatibility -->
<a id="schemasearch"></a>
<a id="schema_Search"></a>
<a id="tocSsearch"></a>
<a id="tocssearch"></a>

```json
{
  "kind": "search#all",
  "etag": "string",
  "items": [
    {
      "kind": "searchresult#company",
      "title": "string",
      "address_snippet": "string",
      "links": [
        {
          "self": "string"
        }
      ],
      "description": "string",
      "description_identifier": [
        0
      ],
      "snippet": "string",
      "address": [
        {
          "address_line_1": "string",
          "address_line_2": "string",
          "country": "Wales",
          "locality": "string",
          "po_box": "string",
          "postal_code": "string",
          "care_of": "string",
          "region": "string"
        }
      ],
      "matches": [
        {
          "title": [
            0
          ],
          "snippet": [
            0
          ],
          "address_snippet": [
            0
          ]
        }
      ]
    }
  ],
  "total_results": 0,
  "start_index": 0,
  "items_per_page": 0
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|kind|string|false|none|The type of search response returned.|
|etag|string|false|none|The ETag of the resource.|
|items|[[SearchItems](#schemasearchitems)]|false|none|The results of the completed search. See `items.kind` for details of each specific result resource returned.|
|total_results|integer|false|none|The number of further search results available for the current search.|
|start_index|integer|false|none|The index into the entire result set that this result page starts.|
|items_per_page|integer|false|none|The number of search items returned per page.|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|search#all|

<h3 id="tocS_CompanySearchItems">CompanySearchItems</h3>
<!-- backwards compatibility -->
<a id="schemacompanysearchitems"></a>
<a id="schema_CompanySearchItems"></a>
<a id="tocScompanysearchitems"></a>
<a id="tocscompanysearchitems"></a>

```json
{
  "kind": "searchresult#company",
  "title": "string",
  "address_snippet": "string",
  "links": [
    {
      "self": "string"
    }
  ],
  "description": "string",
  "description_identifier": [
    0
  ],
  "company_number": "string",
  "external_registration_number": "string",
  "snippet": "string",
  "date_of_creation": "2020-04-08",
  "date_of_cessation": "2020-04-08",
  "company_type": "private-unlimited",
  "company_status": "active",
  "address": [
    {
      "address_line_1": "string",
      "address_line_2": "string",
      "country": "Wales",
      "locality": "string",
      "po_box": "string",
      "postal_code": "string",
      "care_of": "string",
      "region": "string"
    }
  ],
  "matches": [
    {
      "title": [
        0
      ],
      "snippet": [
        0
      ],
      "address_snippet": [
        0
      ]
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|kind|string|false|none|The type of search result.|
|title|string|false|none|The title of the search result.|
|address_snippet|string|false|none|A single line address. This will be the address that matched within the indexed document, or the primary address otherwise (as returned by the `address` member).|
|links|[[LinksModel](#schemalinksmodel)]|false|none|The URL of the search result.|
|description|string|false|none|The result description.|
|description_identifier|[integer]|false|none|An array of enumeration types that make up the search description. See search_descriptions_raw.yaml in api-enumerations|
|company_number|string|false|none|The company registration / incorporation number of the company.|
|external_registration_number|string|false|none|The number given by an external registration body.|
|snippet|string|false|none|Summary information for the result, showing additional details that have matched. In the case of companies, this would be previous company names.|
|date_of_creation|string(date)|false|none|The date the company was created.|
|date_of_cessation|string(date)|false|none|The date the company ended.|
|company_type|string|false|none|The company type.|
|company_status|string|false|none|The company status.|
|address|[[registeredOfficeAddress](#schemaregisteredofficeaddress)]|false|none|The address of the company's registered office.|
|matches|[[MatchesModel](#schemamatchesmodel)]|false|none|A list of members and arrays of character offset, defining substrings that matched the search terms.|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|searchresult#company|
|company_type|private-unlimited|
|company_type|ltd|
|company_type|plc|
|company_type|old-public-company|
|company_type|private-limited-guarant-nsc-limited-exemption|
|company_type|limited-partnership|
|company_type|private-limited-guarant-nsc|
|company_type|converted-or-closed|
|company_type|private-unlimited-nsc|
|company_type|private-limited-shares-section-30-exemption|
|company_type|protected-cell-company|
|company_type|assurance-company|
|company_type|oversea-company|
|company_type|eeig|
|company_type|icvc-securities|
|company_type|icvc-warrant|
|company_type|icvc-umbrella|
|company_type|industrial-and-provident-society|
|company_type|northern-ireland|
|company_type|northern-ireland-other|
|company_type|llp|
|company_type|royal-charter|
|company_type|investment-company-with-variable-capital|
|company_type|unregistered-company|
|company_type|other|
|company_type|european-public-limited-liability-company-se|
|company_type|scottish-partnership|
|company_type|charitable-incorporated-organisation|
|company_type|scottish-charitable-incorporated-organisation|
|company_type|further-education-or-sixth-form-college-corporation|
|company_status|active|
|company_status|dissolved|
|company_status|liquidation|
|company_status|receivership|
|company_status|administration|
|company_status|voluntary-arrangement|
|company_status|converted-closed|
|company_status|insolvency-proceedings|

<h3 id="tocS_SearchItems">SearchItems</h3>
<!-- backwards compatibility -->
<a id="schemasearchitems"></a>
<a id="schema_SearchItems"></a>
<a id="tocSsearchitems"></a>
<a id="tocssearchitems"></a>

```json
{
  "kind": "searchresult#company",
  "title": "string",
  "address_snippet": "string",
  "links": [
    {
      "self": "string"
    }
  ],
  "description": "string",
  "description_identifier": [
    0
  ],
  "snippet": "string",
  "address": [
    {
      "address_line_1": "string",
      "address_line_2": "string",
      "country": "Wales",
      "locality": "string",
      "po_box": "string",
      "postal_code": "string",
      "care_of": "string",
      "region": "string"
    }
  ],
  "matches": [
    {
      "title": [
        0
      ],
      "snippet": [
        0
      ],
      "address_snippet": [
        0
      ]
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|kind|string|false|none|The type of search result. Refer to the full resource descriptions [api/docs/company/company_number/CompanySearch-resource.html](api/docs/company/company_number/CompanySearch-resource.html)CompanySearch resource, [api/docs/company/company_number/OfficerSearch-resource.html](api/docs/company/company_number/OfficerSearch-resource.html)OfficerSearch resource and [api/docs/company/company_number/DisqualifiedOfficerSearch-resource.html](api/docs/company/company_number/DisqualifiedOfficerSearch-resource.html)DisqualifiedOfficerSearch resource for the full list of members returned.|
|title|string|false|none|The title of the search result.|
|address_snippet|string|false|none|A single line address. This will be the address that matched within the indexed document, or the primary address otherwise (as returned by the `address` member).|
|links|[[LinksModel](#schemalinksmodel)]|false|none|The URL of the search result.|
|description|string|false|none|The result description.|
|description_identifier|[integer]|false|none|An array of enumeration types that make up the search description. See search_descriptions_raw.yaml in api-enumerations|
|snippet|string|false|none|Summary information for the result, showing additional details that have matched. In the case of companies, this would be previous company names.|
|address|[[registeredOfficeAddress](#schemaregisteredofficeaddress)]|false|none|The address of the company's registered office.|
|matches|[[MatchesModel](#schemamatchesmodel)]|false|none|A list of members and arrays of character offset, defining substrings that matched the search terms.|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|searchresult#company|
|kind|searchresults#officer|
|kind|searchresults#disqualified-officer|

<h3 id="tocS_OfficerDateOfBirth">OfficerDateOfBirth</h3>
<!-- backwards compatibility -->
<a id="schemaofficerdateofbirth"></a>
<a id="schema_OfficerDateOfBirth"></a>
<a id="tocSofficerdateofbirth"></a>
<a id="tocsofficerdateofbirth"></a>

```json
{
  "month": 0,
  "year": 0
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|month|integer|true|none|The month the officer was born in.|
|year|integer|true|none|The year the officer was born in.|

<h3 id="tocS_LinksModel">LinksModel</h3>
<!-- backwards compatibility -->
<a id="schemalinksmodel"></a>
<a id="schema_LinksModel"></a>
<a id="tocSlinksmodel"></a>
<a id="tocslinksmodel"></a>

```json
{
  "self": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|self|string|false|none|The URL of the resource being returned by the search item.|

<h3 id="tocS_registeredOfficeAddress">registeredOfficeAddress</h3>
<!-- backwards compatibility -->
<a id="schemaregisteredofficeaddress"></a>
<a id="schema_registeredOfficeAddress"></a>
<a id="tocSregisteredofficeaddress"></a>
<a id="tocsregisteredofficeaddress"></a>

```json
{
  "address_line_1": "string",
  "address_line_2": "string",
  "country": "Wales",
  "locality": "string",
  "po_box": "string",
  "postal_code": "string",
  "care_of": "string",
  "region": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|address_line_1|string|false|none|The first line of the address.|
|address_line_2|string|false|none|The second line of the address.|
|country|string|false|none|The country.|
|locality|string|false|none|The locality e.g London.|
|po_box|string|false|none|The post-office box number.|
|postal_code|string|false|none|The postal code e.g CF14 3UZ.|
|care_of|string|false|none|The care of name.|
|region|string|false|none|The region e.g Surrey.|

##### Enumerated Values

|Property|Value|
|---|---|
|country|Wales|
|country|England|
|country|Scotland|
|country|Great Britain|
|country|Not specified|
|country|United Kingdom|
|country|Northern Ireland|


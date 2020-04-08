---
title: filingHistory Specification v0.0.1
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

<h1 id="filinghistory-specification">filingHistory Specification v0.0.1</h1>

> Scroll down for code samples, example requests and responses. Select a language for code samples from the tabs above or the mobile navigation menu.

**This specification was generated from old data and may not reflect the actual API.**

Base URLs:

* <a href="http://example.com/api_url">http://example.com/api_url</a>

<h2 id="filinghistory-specification-company-company_number-filing-history">company{company_number}filing-history</h2>

## getFilingHistoryItem

<a id="opIdgetFilingHistoryItem"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://example.com/api_url/company/{company_number}/filing-history/{transaction_id} \
  -H 'Accept: application/json'

```

```http
GET http://example.com/api_url/company/{company_number}/filing-history/{transaction_id} HTTP/1.1
Host: example.com
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'

};

fetch('http://example.com/api_url/company/{company_number}/filing-history/{transaction_id}',
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
  'Accept' => 'application/json'
}

result = RestClient.get 'http://example.com/api_url/company/{company_number}/filing-history/{transaction_id}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://example.com/api_url/company/{company_number}/filing-history/{transaction_id}', headers = headers)

print r.json()

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => 'application/json',
    
    );

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://example.com/api_url/company/{company_number}/filing-history/{transaction_id}', array(
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
URL obj = new URL("http://example.com/api_url/company/{company_number}/filing-history/{transaction_id}");
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
        "Accept": []string{"application/json"},
        
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://example.com/api_url/company/{company_number}/filing-history/{transaction_id}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /company/{company_number}/filing-history/{transaction_id}`

*Get the filing history of the company*

<h4 id="getfilinghistoryitem-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|company_number|path|string|true|The company number that the single filing is required for.|
|transaction_id|path|string|true|The transaction id that the filing history is required for.|

> Example responses

> 200 Response

```json
{
  "annotations": [
    {
      "annotation": "string",
      "category": "accounts",
      "date": "2020-04-08",
      "description": "string",
      "description_values": {},
      "type": "string"
    }
  ],
  "associated_filings": [
    {
      "category": "accounts",
      "date": "2020-04-08",
      "description": "string",
      "description_values": {},
      "type": "string"
    }
  ],
  "barcode": "string",
  "transaction_id": "string",
  "category": "accounts",
  "date": "2020-04-08",
  "description": "string",
  "description_values": {},
  "links": {},
  "pages": 0,
  "paper_filed": true,
  "resolutions": [
    {
      "category": "miscellaneous",
      "description": "string",
      "description_values": {},
      "document_id": "string",
      "receive_date": "2020-04-08",
      "subcategory": "resolution",
      "type": "string"
    }
  ],
  "subcategory": "resolution",
  "type": "string"
}
```

<h4 id="getfilinghistoryitem-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[filingHistoryItem](#schemafilinghistoryitem)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Filing history not available for this company|None|

<h4 id="getfilinghistoryitem-responseschema">Response Schema</h4>

<aside class="success">
This operation does not require authentication
</aside>

## getFilingHistoryList

<a id="opIdgetFilingHistoryList"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://example.com/api_url/company/{company_number}/filing-history \
  -H 'Accept: application/json'

```

```http
GET http://example.com/api_url/company/{company_number}/filing-history HTTP/1.1
Host: example.com
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'

};

fetch('http://example.com/api_url/company/{company_number}/filing-history',
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
  'Accept' => 'application/json'
}

result = RestClient.get 'http://example.com/api_url/company/{company_number}/filing-history',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://example.com/api_url/company/{company_number}/filing-history', headers = headers)

print r.json()

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => 'application/json',
    
    );

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://example.com/api_url/company/{company_number}/filing-history', array(
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
URL obj = new URL("http://example.com/api_url/company/{company_number}/filing-history");
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
        "Accept": []string{"application/json"},
        
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://example.com/api_url/company/{company_number}/filing-history", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /company/{company_number}/filing-history`

*Get the filing history of the company*

<h4 id="getfilinghistorylist-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|category|query|array[string]|false|One or more comma-separated categories to filter by (inclusive).|
|company_number|path|string|true|The company number that the filing history is required for.|
|items_per_page|query|integer|false|The number of filing history items to return per page.|
|start_index|query|integer|false|The index into the entire result set that this result page starts.|

> Example responses

> 200 Response

```json
{
  "filing_history_status": "filing-history-available",
  "etag": "string",
  "items": [
    {
      "annotations": [
        {
          "annotation": "string",
          "category": "accounts",
          "date": "2020-04-08",
          "description": "string",
          "description_values": {},
          "type": "string"
        }
      ],
      "associated_filings": [
        {
          "category": "accounts",
          "date": "2020-04-08",
          "description": "string",
          "description_values": {},
          "type": "string"
        }
      ],
      "barcode": "string",
      "transaction_id": "string",
      "category": "accounts",
      "date": "2020-04-08",
      "description": "string",
      "description_values": {},
      "links": {},
      "pages": 0,
      "paper_filed": true,
      "resolutions": [
        {
          "category": "miscellaneous",
          "description": "string",
          "description_values": {},
          "document_id": "string",
          "receive_date": "2020-04-08",
          "subcategory": "resolution",
          "type": "string"
        }
      ],
      "subcategory": "resolution",
      "type": "string"
    }
  ],
  "items_per_page": 0,
  "kind": "filing-history",
  "start_index": 0,
  "total_count": 0
}
```

<h4 id="getfilinghistorylist-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[filingHistoryList](#schemafilinghistorylist)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Filing history not available for this company|None|

<h4 id="getfilinghistorylist-responseschema">Response Schema</h4>

<aside class="success">
This operation does not require authentication
</aside>

## Schemas

<h3 id="tocS_annotation">annotation</h3>
<!-- backwards compatibility -->
<a id="schemaannotation"></a>
<a id="schema_annotation"></a>
<a id="tocSannotation"></a>
<a id="tocsannotation"></a>

```json
{
  "annotation": "string",
  "category": "accounts",
  "date": "2020-04-08",
  "description": "string",
  "description_values": {},
  "type": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|annotation|string|false|none|The annotation text.|
|category|string|false|none|The category of the document filed.|
|date|string(date)|true|none|The date the annotation was added.|
|description|string|true|none|A description of the annotation.  For enumeration descriptions see `description` section in the enumeration mappings file.|
|description_values|object|false|none|Map of data values used to populate place holder id's in the description member|
|type|string|false|none|The type of filing|

##### Enumerated Values

|Property|Value|
|---|---|
|category|accounts|
|category|address|
|category|annual-return|
|category|capital|
|category|change-of-name|
|category|incorporation|
|category|liquidation|
|category|miscellaneous|
|category|mortgage|
|category|officers|
|category|resolution|

<h3 id="tocS_descriptionValues">descriptionValues</h3>
<!-- backwards compatibility -->
<a id="schemadescriptionvalues"></a>
<a id="schema_descriptionValues"></a>
<a id="tocSdescriptionvalues"></a>
<a id="tocsdescriptionvalues"></a>

```json
{
  "key": {}
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|key|object|false|none|A key-value pair|

<h3 id="tocS_filingHistoryItemLinks">filingHistoryItemLinks</h3>
<!-- backwards compatibility -->
<a id="schemafilinghistoryitemlinks"></a>
<a id="schema_filingHistoryItemLinks"></a>
<a id="tocSfilinghistoryitemlinks"></a>
<a id="tocsfilinghistoryitemlinks"></a>

```json
{
  "self": "string",
  "document_metadata": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|self|string|false|none|Link to this filing history item.|
|document_metadata|string|false|none|Link to the document metadata associated with this filing history item. See the Document API documentation for more details.|

<h3 id="tocS_filingHistoryList">filingHistoryList</h3>
<!-- backwards compatibility -->
<a id="schemafilinghistorylist"></a>
<a id="schema_filingHistoryList"></a>
<a id="tocSfilinghistorylist"></a>
<a id="tocsfilinghistorylist"></a>

```json
{
  "filing_history_status": "filing-history-available",
  "etag": "string",
  "items": [
    {
      "annotations": [
        {
          "annotation": "string",
          "category": "accounts",
          "date": "2020-04-08",
          "description": "string",
          "description_values": {},
          "type": "string"
        }
      ],
      "associated_filings": [
        {
          "category": "accounts",
          "date": "2020-04-08",
          "description": "string",
          "description_values": {},
          "type": "string"
        }
      ],
      "barcode": "string",
      "transaction_id": "string",
      "category": "accounts",
      "date": "2020-04-08",
      "description": "string",
      "description_values": {},
      "links": {},
      "pages": 0,
      "paper_filed": true,
      "resolutions": [
        {
          "category": "miscellaneous",
          "description": "string",
          "description_values": {},
          "document_id": "string",
          "receive_date": "2020-04-08",
          "subcategory": "resolution",
          "type": "string"
        }
      ],
      "subcategory": "resolution",
      "type": "string"
    }
  ],
  "items_per_page": 0,
  "kind": "filing-history",
  "start_index": 0,
  "total_count": 0
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|filing_history_status|string|false|none|The status of this filing history.|
|etag|string|true|none|The ETag of the resource.|
|items|[[filingHistoryItem](#schemafilinghistoryitem)]|true|none|The filing history items|
|items_per_page|integer|true|none|The number of filing history items returned per page.|
|kind|string|true|none|Indicates this resource is a filing history.|
|start_index|integer|true|none|The index into the entire result set that this result page starts.|
|total_count|integer|true|none|The total number of filing history items for this company.|

##### Enumerated Values

|Property|Value|
|---|---|
|filing_history_status|filing-history-available|
|kind|filing-history|

<h3 id="tocS_resolution">resolution</h3>
<!-- backwards compatibility -->
<a id="schemaresolution"></a>
<a id="schema_resolution"></a>
<a id="tocSresolution"></a>
<a id="tocsresolution"></a>

```json
{
  "category": "miscellaneous",
  "description": "string",
  "description_values": {},
  "document_id": "string",
  "receive_date": "2020-04-08",
  "subcategory": "resolution",
  "type": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|category|string|true|none|The category of the resolution filed.|
|description|string|true|none|A description of the associated filing.  For enumeration descriptions see `description` section in the enumeration mappings.|
|description_values|object|false|none|Map of data values used to populate place holder id's in the description member|
|document_id|string|false|none|The document id of the resolution.|
|receive_date|string(date)|true|none|The date the resolution was processed.|
|subcategory|string|true|none|The sub-category of the document filed.|
|type|string|true|none|The type of the associated filing.|

##### Enumerated Values

|Property|Value|
|---|---|
|category|miscellaneous|
|subcategory|resolution|

<h3 id="tocS_associatedFiling">associatedFiling</h3>
<!-- backwards compatibility -->
<a id="schemaassociatedfiling"></a>
<a id="schema_associatedFiling"></a>
<a id="tocSassociatedfiling"></a>
<a id="tocsassociatedfiling"></a>

```json
{
  "category": "accounts",
  "date": "2020-04-08",
  "description": "string",
  "description_values": {},
  "type": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|category|string|false|none|The category of the document filed.|
|date|string(date)|true|none|The date the associated filing was processed.|
|description|string|true|none|A description of the associated filing.  For enumeration descriptions see `description` section in the enumeration mappings.|
|description_values|object|false|none|Map of data values used to populate place holder id's in the description member|
|type|string|true|none|The type of the associated filing.|

##### Enumerated Values

|Property|Value|
|---|---|
|category|accounts|
|category|address|
|category|annual-return|
|category|capital|
|category|change-of-name|
|category|incorporation|
|category|liquidation|
|category|miscellaneous|
|category|mortgage|
|category|officers|
|category|resolution|

<h3 id="tocS_filingHistoryItem">filingHistoryItem</h3>
<!-- backwards compatibility -->
<a id="schemafilinghistoryitem"></a>
<a id="schema_filingHistoryItem"></a>
<a id="tocSfilinghistoryitem"></a>
<a id="tocsfilinghistoryitem"></a>

```json
{
  "annotations": [
    {
      "annotation": "string",
      "category": "accounts",
      "date": "2020-04-08",
      "description": "string",
      "description_values": {},
      "type": "string"
    }
  ],
  "associated_filings": [
    {
      "category": "accounts",
      "date": "2020-04-08",
      "description": "string",
      "description_values": {},
      "type": "string"
    }
  ],
  "barcode": "string",
  "transaction_id": "string",
  "category": "accounts",
  "date": "2020-04-08",
  "description": "string",
  "description_values": {},
  "links": {},
  "pages": 0,
  "paper_filed": true,
  "resolutions": [
    {
      "category": "miscellaneous",
      "description": "string",
      "description_values": {},
      "document_id": "string",
      "receive_date": "2020-04-08",
      "subcategory": "resolution",
      "type": "string"
    }
  ],
  "subcategory": "resolution",
  "type": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|annotations|[[annotation](#schemaannotation)]|false|none|Annotations for the filing|
|associated_filings|[[associatedFiling](#schemaassociatedfiling)]|false|none|Any filings associated with the current item|
|barcode|string|false|none|The barcode of the document.|
|transaction_id|string|true|none|The transaction ID of the filing.|
|category|string|true|none|The category of the document filed.|
|date|string(date)|true|none|The date the filing was processed.|
|description|string|true|none|A description of the filing.  For enumeration descriptions see `description` section in the enumeration mappings.|
|description_values|object|false|none|Map of data values used to populate place holder id's in the description member|
|links|object|false|none|Links to other resources associated with this filing history item.|
|pages|integer|false|none|Number of pages within the PDF document (links.document_metadata)|
|paper_filed|boolean|false|none|If true, indicates this is a paper filing.|
|resolutions|[[resolution](#schemaresolution)]|false|none|Resolutions for the filing|
|subcategory|string|false|none|The sub-category of the document filed.|
|type|string|true|none|The type of filing.|

##### Enumerated Values

|Property|Value|
|---|---|
|category|accounts|
|category|address|
|category|annual-return|
|category|capital|
|category|change-of-name|
|category|incorporation|
|category|liquidation|
|category|miscellaneous|
|category|mortgage|
|category|officers|
|category|resolution|
|subcategory|resolution|


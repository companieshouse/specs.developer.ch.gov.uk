---
title: charges Specification v0.0.1
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

<h1 id="charges-specification">charges Specification v0.0.1</h1>

> Scroll down for code samples, example requests and responses. Select a language for code samples from the tabs above or the mobile navigation menu.

**This specification was generated from old data and may not reflect the actual API.**

Base URLs:

* <a href="http://example.com/api_url">http://example.com/api_url</a>

<h2 id="charges-specification-company-company_number-charges">company{company_number}charges</h2>

## getChargeList

<a id="opIdgetChargeList"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://example.com/api_url/company/{company_number}/charges \
  -H 'Accept: application/json'

```

```http
GET http://example.com/api_url/company/{company_number}/charges HTTP/1.1
Host: example.com
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'

};

fetch('http://example.com/api_url/company/{company_number}/charges',
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

result = RestClient.get 'http://example.com/api_url/company/{company_number}/charges',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://example.com/api_url/company/{company_number}/charges', headers = headers)

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
    $response = $client->request('GET','http://example.com/api_url/company/{company_number}/charges', array(
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
URL obj = new URL("http://example.com/api_url/company/{company_number}/charges");
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
    req, err := http.NewRequest("GET", "http://example.com/api_url/company/{company_number}/charges", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /company/{company_number}/charges`

*Get a list of charges for a company*

<h4 id="getchargelist-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|company_number|path|string|true|The company number that the charge list is required for.|
|items_per_page|query|integer|false|The number of charges to return per page.|
|start_index|query|integer|false|The index into the entire result set that this result page starts.|

> Example responses

> 200 Response

```json
{
  "etag": "string",
  "total_count": 0,
  "unfiletered_count": 0,
  "satisfied_count": 0,
  "part_satisfied_count": 0,
  "items": [
    {
      "etag": "string",
      "id": "string",
      "charge_code": "string",
      "charge_number": 0,
      "classification": [
        {
          "type": "charge-description",
          "description": "string"
        }
      ],
      "status": "outstanding",
      "assets_ceased_released": "property-ceased-to-belong",
      "acquired_on": "2020-04-08",
      "delivered_on": "2020-04-08",
      "resolved_on": "2020-04-08",
      "covering_instrument_date": "2020-04-08",
      "created_on": "2020-04-08",
      "satisfied_on": "2020-04-08",
      "particulars": [
        {
          "type": "short-particulars",
          "description": "string",
          "contains_floating_charge": true,
          "contains_fixed_charge": true,
          "floating_charge_covers_all": true,
          "contains_negative_pledge": true,
          "chargor_acting_as_bare_trustee": true
        }
      ],
      "secured_details": [
        {
          "type": "amount-secured",
          "description": "string"
        }
      ],
      "scottish_alterations": [
        {
          "has_alterations_to_order": true,
          "has_alterations_to_prohibitions": true,
          "has_restricting_provisions": true
        }
      ],
      "more_than_four_persons_entitled": true,
      "persons_entitled": [
        {
          "name": "string"
        }
      ],
      "transactions": [
        {
          "filing_type": "string",
          "transaction_id": 0,
          "delivered_on": "2020-04-08",
          "insolvency_case_number": 0,
          "links": [
            {
              "filing": "string",
              "insolvency_case": "string"
            }
          ]
        }
      ],
      "insolvency_cases": [
        {
          "case_number": 0,
          "transaction_id": 0,
          "links": [
            {
              "case": "string"
            }
          ]
        }
      ],
      "links": [
        {
          "self": "string"
        }
      ]
    }
  ]
}
```

<h4 id="getchargelist-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[chargeList](#schemachargelist)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Invalid request|None|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Not authorised|None|

<h4 id="getchargelist-responseschema">Response Schema</h4>

<aside class="success">
This operation does not require authentication
</aside>

## getChargeDetails

<a id="opIdgetChargeDetails"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://example.com/api_url/company/{company_number}/charges/{charge_id} \
  -H 'Accept: application/json'

```

```http
GET http://example.com/api_url/company/{company_number}/charges/{charge_id} HTTP/1.1
Host: example.com
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'

};

fetch('http://example.com/api_url/company/{company_number}/charges/{charge_id}',
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

result = RestClient.get 'http://example.com/api_url/company/{company_number}/charges/{charge_id}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://example.com/api_url/company/{company_number}/charges/{charge_id}', headers = headers)

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
    $response = $client->request('GET','http://example.com/api_url/company/{company_number}/charges/{charge_id}', array(
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
URL obj = new URL("http://example.com/api_url/company/{company_number}/charges/{charge_id}");
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
    req, err := http.NewRequest("GET", "http://example.com/api_url/company/{company_number}/charges/{charge_id}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /company/{company_number}/charges/{charge_id}`

*Get a single charge for a company*

<h4 id="getchargedetails-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|company_number|path|string|true|The company number that the charge is required for.|
|charge_id|path|string|true|The id of the charge details that are required.|

> Example responses

> 200 Response

```json
{
  "etag": "string",
  "id": "string",
  "charge_code": "string",
  "charge_number": 0,
  "classification": [
    {
      "type": "charge-description",
      "description": "string"
    }
  ],
  "status": "outstanding",
  "assets_ceased_released": "property-ceased-to-belong",
  "acquired_on": "2020-04-08",
  "delivered_on": "2020-04-08",
  "resolved_on": "2020-04-08",
  "covering_instrument_date": "2020-04-08",
  "created_on": "2020-04-08",
  "satisfied_on": "2020-04-08",
  "particulars": [
    {
      "type": "short-particulars",
      "description": "string",
      "contains_floating_charge": true,
      "contains_fixed_charge": true,
      "floating_charge_covers_all": true,
      "contains_negative_pledge": true,
      "chargor_acting_as_bare_trustee": true
    }
  ],
  "secured_details": [
    {
      "type": "amount-secured",
      "description": "string"
    }
  ],
  "scottish_alterations": [
    {
      "has_alterations_to_order": true,
      "has_alterations_to_prohibitions": true,
      "has_restricting_provisions": true
    }
  ],
  "more_than_four_persons_entitled": true,
  "persons_entitled": [
    {
      "name": "string"
    }
  ],
  "transactions": [
    {
      "filing_type": "string",
      "transaction_id": 0,
      "delivered_on": "2020-04-08",
      "insolvency_case_number": 0,
      "links": [
        {
          "filing": "string",
          "insolvency_case": "string"
        }
      ]
    }
  ],
  "insolvency_cases": [
    {
      "case_number": 0,
      "transaction_id": 0,
      "links": [
        {
          "case": "string"
        }
      ]
    }
  ],
  "links": [
    {
      "self": "string"
    }
  ]
}
```

<h4 id="getchargedetails-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[chargeDetails](#schemachargedetails)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Invalid request|None|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Not authorised|None|

<h4 id="getchargedetails-responseschema">Response Schema</h4>

<aside class="success">
This operation does not require authentication
</aside>

## Schemas

<h3 id="tocS_insolvency_cases">insolvency_cases</h3>
<!-- backwards compatibility -->
<a id="schemainsolvency_cases"></a>
<a id="schema_insolvency_cases"></a>
<a id="tocSinsolvency_cases"></a>
<a id="tocsinsolvency_cases"></a>

```json
{
  "case_number": 0,
  "transaction_id": 0,
  "links": [
    {
      "case": "string"
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|case_number|integer|false|none|The number of this insolvency case|
|transaction_id|integer|false|none|The id of the insolvency filing|
|links|[[insolvency_case_links](#schemainsolvency_case_links)]|false|none|The resources related to this insolvency case|

<h3 id="tocS_transactions">transactions</h3>
<!-- backwards compatibility -->
<a id="schematransactions"></a>
<a id="schema_transactions"></a>
<a id="tocStransactions"></a>
<a id="tocstransactions"></a>

```json
{
  "filing_type": "string",
  "transaction_id": 0,
  "delivered_on": "2020-04-08",
  "insolvency_case_number": 0,
  "links": [
    {
      "filing": "string",
      "insolvency_case": "string"
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|filing_type|string|false|none|Filing type which created, updated or satisfied the charge|
|transaction_id|integer|false|none|The id of the filing|
|delivered_on|string(date)|false|none|The date the filing was submitted to Companies House|
|insolvency_case_number|integer|false|none|The insolvency case related to this filing|
|links|[[transaction_links](#schematransaction_links)]|false|none|The resources related to this filing|

<h3 id="tocS_error">error</h3>
<!-- backwards compatibility -->
<a id="schemaerror"></a>
<a id="schema_error"></a>
<a id="tocSerror"></a>
<a id="tocserror"></a>

```json
{
  "errors": [
    {
      "type": "ch:service",
      "location_type": "json-path",
      "location": "string",
      "error": "string",
      "error_values": [
        {
          "argument": {}
        }
      ]
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|errors|[[errorDetail](#schemaerrordetail)]|true|none|A list of errors found|

<h3 id="tocS_chargeDetails">chargeDetails</h3>
<!-- backwards compatibility -->
<a id="schemachargedetails"></a>
<a id="schema_chargeDetails"></a>
<a id="tocSchargedetails"></a>
<a id="tocschargedetails"></a>

```json
{
  "etag": "string",
  "id": "string",
  "charge_code": "string",
  "charge_number": 0,
  "classification": [
    {
      "type": "charge-description",
      "description": "string"
    }
  ],
  "status": "outstanding",
  "assets_ceased_released": "property-ceased-to-belong",
  "acquired_on": "2020-04-08",
  "delivered_on": "2020-04-08",
  "resolved_on": "2020-04-08",
  "covering_instrument_date": "2020-04-08",
  "created_on": "2020-04-08",
  "satisfied_on": "2020-04-08",
  "particulars": [
    {
      "type": "short-particulars",
      "description": "string",
      "contains_floating_charge": true,
      "contains_fixed_charge": true,
      "floating_charge_covers_all": true,
      "contains_negative_pledge": true,
      "chargor_acting_as_bare_trustee": true
    }
  ],
  "secured_details": [
    {
      "type": "amount-secured",
      "description": "string"
    }
  ],
  "scottish_alterations": [
    {
      "has_alterations_to_order": true,
      "has_alterations_to_prohibitions": true,
      "has_restricting_provisions": true
    }
  ],
  "more_than_four_persons_entitled": true,
  "persons_entitled": [
    {
      "name": "string"
    }
  ],
  "transactions": [
    {
      "filing_type": "string",
      "transaction_id": 0,
      "delivered_on": "2020-04-08",
      "insolvency_case_number": 0,
      "links": [
        {
          "filing": "string",
          "insolvency_case": "string"
        }
      ]
    }
  ],
  "insolvency_cases": [
    {
      "case_number": 0,
      "transaction_id": 0,
      "links": [
        {
          "case": "string"
        }
      ]
    }
  ],
  "links": [
    {
      "self": "string"
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|etag|string|true|none|none|
|id|string|false|none|The id of the charge|
|charge_code|string|false|none|The charge code is a replacement of the mortgage description|
|charge_number|integer|true|none|The charge number is used to reference an individual charge|
|classification|[[classificationDesc](#schemaclassificationdesc)]|true|none|Classification information|
|status|string|true|none|The status of the charge.  For enumeration descriptions see `status` section in the enumeration mappings.|
|assets_ceased_released|string|false|none|Cease/release information about the charge.  For enumeration descriptions see `assets-ceased-released` section in the enumeration mappings.|
|acquired_on|string(date)|false|none|The date the property or undertaking was acquired on|
|delivered_on|string(date)|false|none|The date the charge was submitted to Companies House|
|resolved_on|string(date)|false|none|The date the issue was resolved on|
|covering_instrument_date|string(date)|false|none|The date by which the series of debentures were created|
|created_on|string(date)|false|none|The date the charge was created|
|satisfied_on|string(date)|false|none|The date the charge was satisfied|
|particulars|[[particularDesc](#schemaparticulardesc)]|false|none|Details of charge or undertaking|
|secured_details|[[securedDetailsDesc](#schemasecureddetailsdesc)]|false|none|Information about what is secured against this charge|
|scottish_alterations|[[alterationsDesc](#schemaalterationsdesc)]|false|none|Information about alterations for Scottish companies|
|more_than_four_persons_entitled|boolean|false|none|Charge has more than four person entitled|
|persons_entitled|[[persons_entitled](#schemapersons_entitled)]|false|none|People that are entitled to the charge|
|transactions|[[transactions](#schematransactions)]|false|none|Transactions that have been filed for the charge.|
|insolvency_cases|[[insolvency_cases](#schemainsolvency_cases)]|false|none|The insolvency cases related to this charge|
|links|[[charge_links](#schemacharge_links)]|false|none|The resources related to this charge|

##### Enumerated Values

|Property|Value|
|---|---|
|status|outstanding|
|status|fully-satisfied|
|status|part-satisfied|
|status|satisfied|
|assets_ceased_released|property-ceased-to-belong|
|assets_ceased_released|part-property-release-and-ceased-to-belong|
|assets_ceased_released|part-property-released|
|assets_ceased_released|part-property-ceased-to-belong|
|assets_ceased_released|whole-property-released|
|assets_ceased_released|multiple-filings|
|assets_ceased_released|whole-property-released-and-ceased-to-belong|

<h3 id="tocS_chargeList">chargeList</h3>
<!-- backwards compatibility -->
<a id="schemachargelist"></a>
<a id="schema_chargeList"></a>
<a id="tocSchargelist"></a>
<a id="tocschargelist"></a>

```json
{
  "etag": "string",
  "total_count": 0,
  "unfiletered_count": 0,
  "satisfied_count": 0,
  "part_satisfied_count": 0,
  "items": [
    {
      "etag": "string",
      "id": "string",
      "charge_code": "string",
      "charge_number": 0,
      "classification": [
        {
          "type": "charge-description",
          "description": "string"
        }
      ],
      "status": "outstanding",
      "assets_ceased_released": "property-ceased-to-belong",
      "acquired_on": "2020-04-08",
      "delivered_on": "2020-04-08",
      "resolved_on": "2020-04-08",
      "covering_instrument_date": "2020-04-08",
      "created_on": "2020-04-08",
      "satisfied_on": "2020-04-08",
      "particulars": [
        {
          "type": "short-particulars",
          "description": "string",
          "contains_floating_charge": true,
          "contains_fixed_charge": true,
          "floating_charge_covers_all": true,
          "contains_negative_pledge": true,
          "chargor_acting_as_bare_trustee": true
        }
      ],
      "secured_details": [
        {
          "type": "amount-secured",
          "description": "string"
        }
      ],
      "scottish_alterations": [
        {
          "has_alterations_to_order": true,
          "has_alterations_to_prohibitions": true,
          "has_restricting_provisions": true
        }
      ],
      "more_than_four_persons_entitled": true,
      "persons_entitled": [
        {
          "name": "string"
        }
      ],
      "transactions": [
        {
          "filing_type": "string",
          "transaction_id": 0,
          "delivered_on": "2020-04-08",
          "insolvency_case_number": 0,
          "links": [
            {
              "filing": "string",
              "insolvency_case": "string"
            }
          ]
        }
      ],
      "insolvency_cases": [
        {
          "case_number": 0,
          "transaction_id": 0,
          "links": [
            {
              "case": "string"
            }
          ]
        }
      ],
      "links": [
        {
          "self": "string"
        }
      ]
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|etag|string|true|none|The ETag of the resource.|
|total_count|integer|false|none|Total number of charges returned by the API ( filtering applies ).|
|unfiletered_count|integer|false|none|Total number of charges ( filtering ignored ).|
|satisfied_count|integer|false|none|Number of satisfied charges|
|part_satisfied_count|integer|false|none|Number of part satisfied charges|
|items|[[chargeDetails](#schemachargedetails)]|true|none|List of charges.|

<h3 id="tocS_error_values">error_values</h3>
<!-- backwards compatibility -->
<a id="schemaerror_values"></a>
<a id="schema_error_values"></a>
<a id="tocSerror_values"></a>
<a id="tocserror_values"></a>

```json
{
  "argument": {}
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|argument|object|false|none|The element name and value pair required to complete the error description, will repeat as necessary.|

<h3 id="tocS_persons_entitled">persons_entitled</h3>
<!-- backwards compatibility -->
<a id="schemapersons_entitled"></a>
<a id="schema_persons_entitled"></a>
<a id="tocSpersons_entitled"></a>
<a id="tocspersons_entitled"></a>

```json
{
  "name": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|name|string|true|none|The name of the person entitled.|

<h3 id="tocS_alterationsDesc">alterationsDesc</h3>
<!-- backwards compatibility -->
<a id="schemaalterationsdesc"></a>
<a id="schema_alterationsDesc"></a>
<a id="tocSalterationsdesc"></a>
<a id="tocsalterationsdesc"></a>

```json
{
  "has_alterations_to_order": true,
  "has_alterations_to_prohibitions": true,
  "has_restricting_provisions": true
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|has_alterations_to_order|boolean|false|none|The charge has alterations to order|
|has_alterations_to_prohibitions|boolean|false|none|The charge has alterations to prohibitions|
|has_restricting_provisions|boolean|false|none|The charge has provisions restricting the creation of further charges|

<h3 id="tocS_securedDetailsDesc">securedDetailsDesc</h3>
<!-- backwards compatibility -->
<a id="schemasecureddetailsdesc"></a>
<a id="schema_securedDetailsDesc"></a>
<a id="tocSsecureddetailsdesc"></a>
<a id="tocssecureddetailsdesc"></a>

```json
{
  "type": "amount-secured",
  "description": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|type|string|true|none|The type of secured details.  For enumeration descriptions see `secured-details-description` section in the enumeration mappings.|
|description|string|true|none|Details of the amount or obligation secured by the charge|

##### Enumerated Values

|Property|Value|
|---|---|
|type|amount-secured|
|type|obligations-secured|

<h3 id="tocS_classificationDesc">classificationDesc</h3>
<!-- backwards compatibility -->
<a id="schemaclassificationdesc"></a>
<a id="schema_classificationDesc"></a>
<a id="tocSclassificationdesc"></a>
<a id="tocsclassificationdesc"></a>

```json
{
  "type": "charge-description",
  "description": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|type|string|true|none|The type of charge classication.  For enumeration descriptions see `classificationDesc` section in the enumeration mappings.|
|description|string|true|none|Details of the charge classification|

##### Enumerated Values

|Property|Value|
|---|---|
|type|charge-description|
|type|nature-of-charge|

<h3 id="tocS_insolvency_case_links">insolvency_case_links</h3>
<!-- backwards compatibility -->
<a id="schemainsolvency_case_links"></a>
<a id="schema_insolvency_case_links"></a>
<a id="tocSinsolvency_case_links"></a>
<a id="tocsinsolvency_case_links"></a>

```json
{
  "case": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|case|string|false|none|Link to the insolvency case data|

<h3 id="tocS_charge_links">charge_links</h3>
<!-- backwards compatibility -->
<a id="schemacharge_links"></a>
<a id="schema_charge_links"></a>
<a id="tocScharge_links"></a>
<a id="tocscharge_links"></a>

```json
{
  "self": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|self|string|true|none|Link to the this charge data|

<h3 id="tocS_errorDetail">errorDetail</h3>
<!-- backwards compatibility -->
<a id="schemaerrordetail"></a>
<a id="schema_errorDetail"></a>
<a id="tocSerrordetail"></a>
<a id="tocserrordetail"></a>

```json
{
  "type": "ch:service",
  "location_type": "json-path",
  "location": "string",
  "error": "string",
  "error_values": [
    {
      "argument": {}
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|type|string|true|none|Type of error.|
|location_type|string|false|none|Describes the type of location returned so that it may be parsed appropriately.|
|location|string|false|none|The location in the submitted request in which the error relates. This parameter is only provided when errors[].type is set to "ch:validation".|
|error|string|true|none|The error being returned. See github for valid [https://github.com/companieshouse/api-enumerations/blob/develop/errors.yml](https://github.com/companieshouse/api-enumerations/blob/develop/errors.yml)error enumeration types.|
|error_values|[[error_values](#schemaerror_values)]|false|none|A collection of argument name and value pairs which, when substituted into the error string, provide the full description of the error. As many name/value pairs as necessary to complete the error description are returned. See example above.|

##### Enumerated Values

|Property|Value|
|---|---|
|type|ch:service|
|type|ch:validation|
|location_type|json-path|
|location_type|query-parameter|

<h3 id="tocS_transaction_links">transaction_links</h3>
<!-- backwards compatibility -->
<a id="schematransaction_links"></a>
<a id="schema_transaction_links"></a>
<a id="tocStransaction_links"></a>
<a id="tocstransaction_links"></a>

```json
{
  "filing": "string",
  "insolvency_case": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|filing|string|false|none|Link to the charge filing data|
|insolvency_case|string|false|none|Link to the insolvency case related to this filing|

<h3 id="tocS_particularDesc">particularDesc</h3>
<!-- backwards compatibility -->
<a id="schemaparticulardesc"></a>
<a id="schema_particularDesc"></a>
<a id="tocSparticulardesc"></a>
<a id="tocsparticulardesc"></a>

```json
{
  "type": "short-particulars",
  "description": "string",
  "contains_floating_charge": true,
  "contains_fixed_charge": true,
  "floating_charge_covers_all": true,
  "contains_negative_pledge": true,
  "chargor_acting_as_bare_trustee": true
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|type|string|true|none|The type of charge particulars.  For enumeration descriptions see `particular-description` section in the enumeration mappings.|
|description|string|true|none|Details of charge particulars|
|contains_floating_charge|boolean|false|none|The charge contains a floating charge|
|contains_fixed_charge|boolean|false|none|The charge contains a fixed charge|
|floating_charge_covers_all|boolean|false|none|The floating charge covers all the property or undertaking or the company|
|contains_negative_pledge|boolean|false|none|The charge contains a negative pledge|
|chargor_acting_as_bare_trustee|boolean|false|none|The chargor is acting as a bare trustee for the property|

##### Enumerated Values

|Property|Value|
|---|---|
|type|short-particulars|
|type|charged-property-description|
|type|charged-property-or-undertaking-description|
|type|brief-description|


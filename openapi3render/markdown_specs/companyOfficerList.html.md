---
title: companyOfficerList Specification v0.0.1
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

<h1 id="companyofficerlist-specification">companyOfficerList Specification v0.0.1</h1>

> Scroll down for code samples, example requests and responses. Select a language for code samples from the tabs above or the mobile navigation menu.

**This specification was generated from old data and may not reflect the actual API.**

Base URLs:

* <a href="http://example.com/api_url">http://example.com/api_url</a>

<h2 id="companyofficerlist-specification-company-company_number-officers">company{company_number}officers</h2>

## officerList

<a id="opIdofficerList"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://example.com/api_url/company/{company_number}/officers \
  -H 'Accept: application/json'

```

```http
GET http://example.com/api_url/company/{company_number}/officers HTTP/1.1
Host: example.com
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'

};

fetch('http://example.com/api_url/company/{company_number}/officers',
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

result = RestClient.get 'http://example.com/api_url/company/{company_number}/officers',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://example.com/api_url/company/{company_number}/officers', headers = headers)

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
    $response = $client->request('GET','http://example.com/api_url/company/{company_number}/officers', array(
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
URL obj = new URL("http://example.com/api_url/company/{company_number}/officers");
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
    req, err := http.NewRequest("GET", "http://example.com/api_url/company/{company_number}/officers", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /company/{company_number}/officers`

*List the company officers*

<h4 id="officerlist-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|company_number|path|string|true|The company number of the officer list being requested.|
|items_per_page|query|integer|false|The number of officers to return per page.|
|register_type|query|string|false|The register_type determines which officer type is returned for the registers view. Accepted values are: <ul><li><code>directors</code></li><li><code>secretaries</code></li><li><code>llp-members</code></li></ul>The register_type field will only work if registers_view is set to true|
|register_view|query|string|false|Display register specific information. If given register is held at Companies House, registers_view set to true and correct register_type specified, only active officers will be returned. Those will also have full date of birth. Accepted values are: <ul><li><code>true</code></li><li><code>false</code></li></ul>Defaults to false|
|start_index|query|integer|false|The offset into the entire result set that this page starts.|
|order_by|query|string|false|The field by which to order the result set. Possible values are: <ul><li><code>appointed_on</code></li><li><code>resigned_on</code></li><li><code>surname</code></li></ul>|

> Example responses

> 200 Response

```json
{
  "active_count": 0,
  "etag": "string",
  "inactive_count": 0,
  "items": [
    {
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
      ],
      "appointed_on": "2020-04-08",
      "country_of_residence": "string",
      "date_of_birth": [
        {
          "day": 0,
          "month": 0,
          "year": 0
        }
      ],
      "links": [
        {
          "officer": [
            {
              "appointments": "string"
            }
          ]
        }
      ],
      "name": "string",
      "nationality": "string",
      "occupation": "string",
      "officer_role": "cic-manager",
      "resigned_on": "2020-04-08",
      "former_names": [
        {
          "forenames": "string",
          "surname": "string"
        }
      ],
      "identification": [
        {
          "identification_type": "eea",
          "legal_authority": "string",
          "legal_form": "string",
          "place_registered": "string",
          "registration_number": "string"
        }
      ]
    }
  ],
  "items_per_page": 0,
  "kind": "officer-list",
  "links": [
    {
      "self": "string"
    }
  ],
  "resigned_count": 0,
  "start_index": 0,
  "total_results": 0
}
```

<h4 id="officerlist-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[officerList](#schemaofficerlist)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Bad request|[error](#schemaerror)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Not authorised|[error](#schemaerror)|

<aside class="success">
This operation does not require authentication
</aside>

## Schemas

<h3 id="tocS_formerNames">formerNames</h3>
<!-- backwards compatibility -->
<a id="schemaformernames"></a>
<a id="schema_formerNames"></a>
<a id="tocSformernames"></a>
<a id="tocsformernames"></a>

```json
{
  "forenames": "string",
  "surname": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|forenames|string|false|none|Former forenames of the officer.|
|surname|string|false|none|Former surnames of the officer.|

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

<h3 id="tocS_address">address</h3>
<!-- backwards compatibility -->
<a id="schemaaddress"></a>
<a id="schema_address"></a>
<a id="tocSaddress"></a>
<a id="tocsaddress"></a>

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
|country|string|false|none|The country e.g. United Kingdom.|
|locality|string|false|none|The locality e.g. London.|
|po_box|string|false|none|The post-office box number.|
|postal_code|string|false|none|The postal code e.g. CF14 3UZ.|
|premises|string|false|none|The property name or number.|
|region|string|false|none|The region e.g. Surrey.|

<h3 id="tocS_itemLinkTypes">itemLinkTypes</h3>
<!-- backwards compatibility -->
<a id="schemaitemlinktypes"></a>
<a id="schema_itemLinkTypes"></a>
<a id="tocSitemlinktypes"></a>
<a id="tocsitemlinktypes"></a>

```json
{
  "officer": [
    {
      "appointments": "string"
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|officer|[[officerLinkTypes](#schemaofficerlinktypes)]|true|none|Links to other officer resources associated with this officer list item.|

<h3 id="tocS_linkTypes">linkTypes</h3>
<!-- backwards compatibility -->
<a id="schemalinktypes"></a>
<a id="schema_linkTypes"></a>
<a id="tocSlinktypes"></a>
<a id="tocslinktypes"></a>

```json
{
  "self": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|self|string|true|none|Link to this officer list resource.|

<h3 id="tocS_corporateIdent">corporateIdent</h3>
<!-- backwards compatibility -->
<a id="schemacorporateident"></a>
<a id="schema_corporateIdent"></a>
<a id="tocScorporateident"></a>
<a id="tocscorporateident"></a>

```json
{
  "identification_type": "eea",
  "legal_authority": "string",
  "legal_form": "string",
  "place_registered": "string",
  "registration_number": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|identification_type|string|false|none|none|
|legal_authority|string|false|none|The legal authority supervising the company.|
|legal_form|string|false|none|The legal form of the company as defined by its country of registration.|
|place_registered|string|false|none|Place registered.|
|registration_number|string|false|none|Company registration number.|

##### Enumerated Values

|Property|Value|
|---|---|
|identification_type|eea|
|identification_type|non-eea|

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

<h3 id="tocS_dateOfBirth">dateOfBirth</h3>
<!-- backwards compatibility -->
<a id="schemadateofbirth"></a>
<a id="schema_dateOfBirth"></a>
<a id="tocSdateofbirth"></a>
<a id="tocsdateofbirth"></a>

```json
{
  "day": 0,
  "month": 0,
  "year": 0
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|day|integer|false|none|The day of the date of birth.|
|month|integer|true|none|The month of date of birth.|
|year|integer|true|none|The year of date of birth.|

<h3 id="tocS_officerLinkTypes">officerLinkTypes</h3>
<!-- backwards compatibility -->
<a id="schemaofficerlinktypes"></a>
<a id="schema_officerLinkTypes"></a>
<a id="tocSofficerlinktypes"></a>
<a id="tocsofficerlinktypes"></a>

```json
{
  "appointments": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|appointments|string|true|none|Link to the officer appointment resource that this appointment is associated with.|

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

<h3 id="tocS_officerList">officerList</h3>
<!-- backwards compatibility -->
<a id="schemaofficerlist"></a>
<a id="schema_officerList"></a>
<a id="tocSofficerlist"></a>
<a id="tocsofficerlist"></a>

```json
{
  "active_count": 0,
  "etag": "string",
  "inactive_count": 0,
  "items": [
    {
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
      ],
      "appointed_on": "2020-04-08",
      "country_of_residence": "string",
      "date_of_birth": [
        {
          "day": 0,
          "month": 0,
          "year": 0
        }
      ],
      "links": [
        {
          "officer": [
            {
              "appointments": "string"
            }
          ]
        }
      ],
      "name": "string",
      "nationality": "string",
      "occupation": "string",
      "officer_role": "cic-manager",
      "resigned_on": "2020-04-08",
      "former_names": [
        {
          "forenames": "string",
          "surname": "string"
        }
      ],
      "identification": [
        {
          "identification_type": "eea",
          "legal_authority": "string",
          "legal_form": "string",
          "place_registered": "string",
          "registration_number": "string"
        }
      ]
    }
  ],
  "items_per_page": 0,
  "kind": "officer-list",
  "links": [
    {
      "self": "string"
    }
  ],
  "resigned_count": 0,
  "start_index": 0,
  "total_results": 0
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|active_count|integer|true|none|The number of active officers in this result set.|
|etag|string|true|none|The ETag of the resource.|
|inactive_count|integer|true|none|The number of officers who have not resigned where the company status is dissolved or converted-closed in this result set.|
|items|[[officerSummary](#schemaofficersummary)]|true|none|The list of officers.|
|items_per_page|integer|true|none|The number of officers to return per page.|
|kind|string|true|none|none|
|links|[[linkTypes](#schemalinktypes)]|true|none|Links to other resources associated with this officer list resource.|
|resigned_count|integer|true|none|The number of resigned officers in this result set.|
|start_index|integer|true|none|The offset into the entire result set that this page starts.|
|total_results|integer|false|none|The total number of officers in this result set.|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|officer-list|

<h3 id="tocS_officerSummary">officerSummary</h3>
<!-- backwards compatibility -->
<a id="schemaofficersummary"></a>
<a id="schema_officerSummary"></a>
<a id="tocSofficersummary"></a>
<a id="tocsofficersummary"></a>

```json
{
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
  ],
  "appointed_on": "2020-04-08",
  "country_of_residence": "string",
  "date_of_birth": [
    {
      "day": 0,
      "month": 0,
      "year": 0
    }
  ],
  "links": [
    {
      "officer": [
        {
          "appointments": "string"
        }
      ]
    }
  ],
  "name": "string",
  "nationality": "string",
  "occupation": "string",
  "officer_role": "cic-manager",
  "resigned_on": "2020-04-08",
  "former_names": [
    {
      "forenames": "string",
      "surname": "string"
    }
  ],
  "identification": [
    {
      "identification_type": "eea",
      "legal_authority": "string",
      "legal_form": "string",
      "place_registered": "string",
      "registration_number": "string"
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|address|[[address](#schemaaddress)]|true|none|The correspondence address of the officer.|
|appointed_on|string(date)|true|none|The date on which the officer was appointed.|
|country_of_residence|string|false|none|The officer's country of residence.|
|date_of_birth|[[dateOfBirth](#schemadateofbirth)]|false|none|Details of director date of birth.|
|links|[[itemLinkTypes](#schemaitemlinktypes)]|true|none|Links to other resources associated with this officer list item.|
|name|string|true|none|Corporate or natural officer name.|
|nationality|string|false|none|The officer's nationality.|
|occupation|string|false|none|The officer's job title.|
|officer_role|string|true|none|none|
|resigned_on|string(date)|false|none|The date on which the officer resigned.|
|former_names|[[formerNames](#schemaformernames)]|false|none|Former names for the officer.|
|identification|[[corporateIdent](#schemacorporateident)]|false|none|Only one from `eea` or `non-eea` can be supplied, not both.|

##### Enumerated Values

|Property|Value|
|---|---|
|officer_role|cic-manager|
|officer_role|corporate-director|
|officer_role|corporate-llp-designated-member|
|officer_role|corporate-llp-member|
|officer_role|corporate-manager-of-an-eeig|
|officer_role|corporate-member-of-a-management-organ|
|officer_role|corporate-member-of-a-supervisory-organ|
|officer_role|corporate-member-of-an-administrative-organ|
|officer_role|corporate-nominee-director|
|officer_role|corporate-nominee-secretary|
|officer_role|corporate-secretary|
|officer_role|director|
|officer_role|general-partner-in-a-limited-partnership|
|officer_role|judicial-factor|
|officer_role|limited-partner-in-a-limited-partnership|
|officer_role|llp-designated-member|
|officer_role|llp-member|
|officer_role|manager-of-an-eeig|
|officer_role|member-of-a-management-organ|
|officer_role|member-of-a-supervisory-organ|
|officer_role|member-of-an-administrative-organ|
|officer_role|nominee-director|
|officer_role|nominee-secretary|
|officer_role|person-authorised-to-accept|
|officer_role|person-authorised-to-represent|
|officer_role|person-authorised-to-represent-and-accept|
|officer_role|receiver-and-manager|
|officer_role|secretary|


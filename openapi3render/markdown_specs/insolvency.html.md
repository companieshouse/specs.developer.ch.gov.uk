---
title: insolvency Specification v0.0.1
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

<h1 id="insolvency-specification">insolvency Specification v0.0.1</h1>

> Scroll down for code samples, example requests and responses. Select a language for code samples from the tabs above or the mobile navigation menu.

**This specification was generated from old data and may not reflect the actual API.**

Base URLs:

* <a href="http://example.com/api_url">http://example.com/api_url</a>

<h2 id="insolvency-specification-company-company_number-insolvency">company{company_number}insolvency</h2>

## readCompanyInsolvency

<a id="opIdreadCompanyInsolvency"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://example.com/api_url/company/{company_number}/insolvency \
  -H 'Accept: application/json'

```

```http
GET http://example.com/api_url/company/{company_number}/insolvency HTTP/1.1
Host: example.com
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'

};

fetch('http://example.com/api_url/company/{company_number}/insolvency',
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

result = RestClient.get 'http://example.com/api_url/company/{company_number}/insolvency',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://example.com/api_url/company/{company_number}/insolvency', headers = headers)

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
    $response = $client->request('GET','http://example.com/api_url/company/{company_number}/insolvency', array(
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
URL obj = new URL("http://example.com/api_url/company/{company_number}/insolvency");
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
    req, err := http.NewRequest("GET", "http://example.com/api_url/company/{company_number}/insolvency", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /company/{company_number}/insolvency`

*Get company insolvency information*

<h4 id="readcompanyinsolvency-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|company_number|path|string|true|The company number of the basic information to return.|

> Example responses

> 200 Response

```json
{
  "etag": "string",
  "cases": [
    {
      "type": "compulsory-liquidation",
      "dates": [
        {
          "type": "instrumented-on",
          "date": "2020-04-08"
        }
      ],
      "notes": [
        "string"
      ],
      "practitioners": [
        {
          "name": "string",
          "address": [
            {
              "address_line_1": "string",
              "address_line_2": "string",
              "locality": "string",
              "region": "string",
              "postal_code": "string",
              "country": "string"
            }
          ],
          "appointed_on": "2020-04-08",
          "ceased_to_act_on": "2020-04-08",
          "role": "final-liquidator"
        }
      ],
      "links": [
        {
          "charge": "string"
        }
      ],
      "number": 0
    }
  ],
  "status": [
    {}
  ]
}
```

<h4 id="readcompanyinsolvency-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[companyInsolvency](#schemacompanyinsolvency)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Resource not found|[error](#schemaerror)|

<aside class="success">
This operation does not require authentication
</aside>

## Schemas

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

<h3 id="tocS_companyInsolvency">companyInsolvency</h3>
<!-- backwards compatibility -->
<a id="schemacompanyinsolvency"></a>
<a id="schema_companyInsolvency"></a>
<a id="tocScompanyinsolvency"></a>
<a id="tocscompanyinsolvency"></a>

```json
{
  "etag": "string",
  "cases": [
    {
      "type": "compulsory-liquidation",
      "dates": [
        {
          "type": "instrumented-on",
          "date": "2020-04-08"
        }
      ],
      "notes": [
        "string"
      ],
      "practitioners": [
        {
          "name": "string",
          "address": [
            {
              "address_line_1": "string",
              "address_line_2": "string",
              "locality": "string",
              "region": "string",
              "postal_code": "string",
              "country": "string"
            }
          ],
          "appointed_on": "2020-04-08",
          "ceased_to_act_on": "2020-04-08",
          "role": "final-liquidator"
        }
      ],
      "links": [
        {
          "charge": "string"
        }
      ],
      "number": 0
    }
  ],
  "status": [
    {}
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|etag|string|true|none|The ETag of the resource.|
|cases|[[case](#schemacase)]|true|none|List of insolvency cases.|
|status|[object]|true|none|Company insolvency status details|

<h3 id="tocS_practitioners">practitioners</h3>
<!-- backwards compatibility -->
<a id="schemapractitioners"></a>
<a id="schema_practitioners"></a>
<a id="tocSpractitioners"></a>
<a id="tocspractitioners"></a>

```json
{
  "name": "string",
  "address": [
    {
      "address_line_1": "string",
      "address_line_2": "string",
      "locality": "string",
      "region": "string",
      "postal_code": "string",
      "country": "string"
    }
  ],
  "appointed_on": "2020-04-08",
  "ceased_to_act_on": "2020-04-08",
  "role": "final-liquidator"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|name|string|true|none|The name of the practitioner.|
|address|[[practitionerAddress](#schemapractitioneraddress)]|true|none|The practitioners' address.|
|appointed_on|string(date)|false|none|The date the practitioner was appointed on.|
|ceased_to_act_on|string(date)|false|none|The date the practitioner ceased to act for the case.|
|role|string|false|none|The type of role.|

##### Enumerated Values

|Property|Value|
|---|---|
|role|final-liquidator|
|role|receiver|
|role|receiver-manager|
|role|proposed-liquidator|
|role|provisional-liquidator|
|role|administrative-receiver|
|role|practitioner|
|role|interim-liquidator|

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

<h3 id="tocS_links">links</h3>
<!-- backwards compatibility -->
<a id="schemalinks"></a>
<a id="schema_links"></a>
<a id="tocSlinks"></a>
<a id="tocslinks"></a>

```json
{
  "charge": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|charge|string|false|none|The link to the charge this case is lodged against.|

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

<h3 id="tocS_case">case</h3>
<!-- backwards compatibility -->
<a id="schemacase"></a>
<a id="schema_case"></a>
<a id="tocScase"></a>
<a id="tocscase"></a>

```json
{
  "type": "compulsory-liquidation",
  "dates": [
    {
      "type": "instrumented-on",
      "date": "2020-04-08"
    }
  ],
  "notes": [
    "string"
  ],
  "practitioners": [
    {
      "name": "string",
      "address": [
        {
          "address_line_1": "string",
          "address_line_2": "string",
          "locality": "string",
          "region": "string",
          "postal_code": "string",
          "country": "string"
        }
      ],
      "appointed_on": "2020-04-08",
      "ceased_to_act_on": "2020-04-08",
      "role": "final-liquidator"
    }
  ],
  "links": [
    {
      "charge": "string"
    }
  ],
  "number": 0
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|type|string|true|none|The type of case. For enumeration descriptions see `insolvency_case_type` section in the enumeration mappings.|
|dates|[[caseDates](#schemacasedates)]|true|none|The dates specific to the case.|
|notes|[string]|false|none|Notes that apply to the case.|
|practitioners|[[practitioners](#schemapractitioners)]|true|none|The practitioners for the case.|
|links|[[links](#schemalinks)]|false|none|The resources related to this case|
|number|integer|false|none|The case number.|

##### Enumerated Values

|Property|Value|
|---|---|
|type|compulsory-liquidation|
|type|creditors-voluntary-liquidation|
|type|members-voluntary-liquidation|
|type|in-administration|
|type|corporate-voluntary-arrangement|
|type|corporate-voluntary-arrangement-moratorium|
|type|administration-order|
|type|receiver-manager|
|type|administrative-receiver|
|type|receivership|
|type|foreign-insolvency|

<h3 id="tocS_caseDates">caseDates</h3>
<!-- backwards compatibility -->
<a id="schemacasedates"></a>
<a id="schema_caseDates"></a>
<a id="tocScasedates"></a>
<a id="tocscasedates"></a>

```json
{
  "type": "instrumented-on",
  "date": "2020-04-08"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|type|string|true|none|Describes what date is represented by the associated `date` element.  For enumeration descriptions see `insolvency_case_date_type` section in the enumeration mappings.|
|date|string(date)|true|none|The case date, described by `date_type`.|

##### Enumerated Values

|Property|Value|
|---|---|
|type|instrumented-on|
|type|administration-started-on|
|type|administration-discharged-on|
|type|administration-ended-on|
|type|concluded-winding-up-on|
|type|petitioned-on|
|type|ordered-to-wind-up-on|
|type|due-to-be-dissolved-on|
|type|case-end-on|
|type|wound-up-on|
|type|voluntary-arrangement-started-on|
|type|voluntary-arrangement-ended-on|
|type|moratorium-started-on|
|type|moratorium-ended-on|
|type|declaration-solvent-on|

<h3 id="tocS_practitionerAddress">practitionerAddress</h3>
<!-- backwards compatibility -->
<a id="schemapractitioneraddress"></a>
<a id="schema_practitionerAddress"></a>
<a id="tocSpractitioneraddress"></a>
<a id="tocspractitioneraddress"></a>

```json
{
  "address_line_1": "string",
  "address_line_2": "string",
  "locality": "string",
  "region": "string",
  "postal_code": "string",
  "country": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|address_line_1|string|true|none|The first line of the address.|
|address_line_2|string|false|none|The second line of the address.|
|locality|string|false|none|The locality. For example London.|
|region|string|false|none|The region. For example Surrey.|
|postal_code|string|true|none|The postal code. For example CF14 3UZ.|
|country|string|false|none|The country.|


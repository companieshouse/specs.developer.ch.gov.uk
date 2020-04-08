---
title: disqualifications Specification v0.0.1
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

<h1 id="disqualifications-specification">disqualifications Specification v0.0.1</h1>

> Scroll down for code samples, example requests and responses. Select a language for code samples from the tabs above or the mobile navigation menu.

**This specification was generated from old data and may not reflect the actual API.**

Base URLs:

* <a href="http://example.com/api_url">http://example.com/api_url</a>

<h2 id="disqualifications-specification-disqualified-officers">disqualified-officers</h2>

## naturalDisqualification

<a id="opIdnaturalDisqualification"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://example.com/api_url/disqualified-officers/natural/{officer_id} \
  -H 'Accept: application/json'

```

```http
GET http://example.com/api_url/disqualified-officers/natural/{officer_id} HTTP/1.1
Host: example.com
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'

};

fetch('http://example.com/api_url/disqualified-officers/natural/{officer_id}',
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

result = RestClient.get 'http://example.com/api_url/disqualified-officers/natural/{officer_id}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://example.com/api_url/disqualified-officers/natural/{officer_id}', headers = headers)

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
    $response = $client->request('GET','http://example.com/api_url/disqualified-officers/natural/{officer_id}', array(
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
URL obj = new URL("http://example.com/api_url/disqualified-officers/natural/{officer_id}");
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
    req, err := http.NewRequest("GET", "http://example.com/api_url/disqualified-officers/natural/{officer_id}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /disqualified-officers/natural/{officer_id}`

*Get a natural officer's disqualifications*

<h4 id="naturaldisqualification-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|officer_id|path|string|true|The disqualified officer's id.|

> Example responses

> 200 Response

```json
{
  "date_of_birth": "2020-04-08",
  "etag": "string",
  "forename": "string",
  "honours": "string",
  "kind": "natural-disqualification",
  "nationality": "string",
  "other_forenames": "string",
  "surname": "string",
  "title": "string",
  "links": [
    {
      "self": "string"
    }
  ],
  "disqualifications": [
    {
      "case_identifier": "string",
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
      "company_names": [
        "string"
      ],
      "court_name": "string",
      "disqualification_type": "string",
      "disqualified_from": "2020-04-08",
      "disqualified_until": "2020-04-08",
      "heard_on": "2020-04-08",
      "undertaken_on": "2020-04-08",
      "last_variation": [
        {
          "varied_on": "2020-04-08",
          "case_identifier": "string",
          "court_name": "string"
        }
      ],
      "reason": [
        {
          "description_identifier": "string",
          "act": "string",
          "article": "string",
          "section": "string"
        }
      ]
    }
  ],
  "permissions_to_act": [
    {
      "company_names": [
        "string"
      ],
      "court_name": "string",
      "expires_on": "2020-04-08",
      "granted_on": "2020-04-08"
    }
  ]
}
```

<h4 id="naturaldisqualification-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[naturalDisqualification](#schemanaturaldisqualification)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Not authorised|[error](#schemaerror)|

<aside class="success">
This operation does not require authentication
</aside>

## corporateDisqualification

<a id="opIdcorporateDisqualification"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://example.com/api_url/disqualified-officers/corporate/{officer_id} \
  -H 'Accept: application/json'

```

```http
GET http://example.com/api_url/disqualified-officers/corporate/{officer_id} HTTP/1.1
Host: example.com
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'

};

fetch('http://example.com/api_url/disqualified-officers/corporate/{officer_id}',
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

result = RestClient.get 'http://example.com/api_url/disqualified-officers/corporate/{officer_id}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://example.com/api_url/disqualified-officers/corporate/{officer_id}', headers = headers)

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
    $response = $client->request('GET','http://example.com/api_url/disqualified-officers/corporate/{officer_id}', array(
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
URL obj = new URL("http://example.com/api_url/disqualified-officers/corporate/{officer_id}");
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
    req, err := http.NewRequest("GET", "http://example.com/api_url/disqualified-officers/corporate/{officer_id}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /disqualified-officers/corporate/{officer_id}`

*Get a corporate officer's disqualifications*

<h4 id="corporatedisqualification-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|officer_id|path|string|true|The disqualified officer id.|

> Example responses

> 200 Response

```json
{
  "company_number": "string",
  "country_of_registration": "string",
  "etag": "string",
  "kind": "corporate-disqualification",
  "name": "string",
  "links": [
    {
      "self": "string"
    }
  ],
  "disqualifications": [
    {
      "case_identifier": "string",
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
      "company_names": [
        "string"
      ],
      "court_name": "string",
      "disqualification_type": "string",
      "disqualified_from": "2020-04-08",
      "disqualified_until": "2020-04-08",
      "heard_on": "2020-04-08",
      "undertaken_on": "2020-04-08",
      "last_variation": [
        {
          "varied_on": "2020-04-08",
          "case_identifier": "string",
          "court_name": "string"
        }
      ],
      "reason": [
        {
          "description_identifier": "string",
          "act": "string",
          "article": "string",
          "section": "string"
        }
      ]
    }
  ],
  "permissions_to_act": [
    {
      "company_names": [
        "string"
      ],
      "court_name": "string",
      "expires_on": "2020-04-08",
      "granted_on": "2020-04-08"
    }
  ]
}
```

<h4 id="corporatedisqualification-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[corporateDisqualification](#schemacorporatedisqualification)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Not authorised|[error](#schemaerror)|

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

<h3 id="tocS_reason">reason</h3>
<!-- backwards compatibility -->
<a id="schemareason"></a>
<a id="schema_reason"></a>
<a id="tocSreason"></a>
<a id="tocsreason"></a>

```json
{
  "description_identifier": "string",
  "act": "string",
  "article": "string",
  "section": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|description_identifier|string|true|none|An enumeration type that provides the description for the reason of disqualification.|
|act|string|true|none|An enumeration type that provides the law under which the disqualification was made.|
|article|string|false|none|The article of the act under which the disqualification was made.|
|section|string|false|none|The section of the act under which the disqualification was made.|

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

<h3 id="tocS_corporateDisqualification">corporateDisqualification</h3>
<!-- backwards compatibility -->
<a id="schemacorporatedisqualification"></a>
<a id="schema_corporateDisqualification"></a>
<a id="tocScorporatedisqualification"></a>
<a id="tocscorporatedisqualification"></a>

```json
{
  "company_number": "string",
  "country_of_registration": "string",
  "etag": "string",
  "kind": "corporate-disqualification",
  "name": "string",
  "links": [
    {
      "self": "string"
    }
  ],
  "disqualifications": [
    {
      "case_identifier": "string",
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
      "company_names": [
        "string"
      ],
      "court_name": "string",
      "disqualification_type": "string",
      "disqualified_from": "2020-04-08",
      "disqualified_until": "2020-04-08",
      "heard_on": "2020-04-08",
      "undertaken_on": "2020-04-08",
      "last_variation": [
        {
          "varied_on": "2020-04-08",
          "case_identifier": "string",
          "court_name": "string"
        }
      ],
      "reason": [
        {
          "description_identifier": "string",
          "act": "string",
          "article": "string",
          "section": "string"
        }
      ]
    }
  ],
  "permissions_to_act": [
    {
      "company_names": [
        "string"
      ],
      "court_name": "string",
      "expires_on": "2020-04-08",
      "granted_on": "2020-04-08"
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|company_number|string|false|none|The registration number of the disqualified officer.|
|country_of_registration|string|false|none|The country in which the disqualified officer was registered.|
|etag|string|true|none|The ETag of the resource.|
|kind|string|true|none|none|
|name|string|true|none|The name of the disqualified officer.|
|links|[[links](#schemalinks)]|true|none|Links to other resources associated with this officer disqualification resource.|
|disqualifications|[[disqualification](#schemadisqualification)]|true|none|The officer's disqualifications.|
|permissions_to_act|[[permission_to_act](#schemapermission_to_act)]|false|none|Permissions that the disqualified officer has to act outside of their disqualification.|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|corporate-disqualification|

<h3 id="tocS_naturalDisqualification">naturalDisqualification</h3>
<!-- backwards compatibility -->
<a id="schemanaturaldisqualification"></a>
<a id="schema_naturalDisqualification"></a>
<a id="tocSnaturaldisqualification"></a>
<a id="tocsnaturaldisqualification"></a>

```json
{
  "date_of_birth": "2020-04-08",
  "etag": "string",
  "forename": "string",
  "honours": "string",
  "kind": "natural-disqualification",
  "nationality": "string",
  "other_forenames": "string",
  "surname": "string",
  "title": "string",
  "links": [
    {
      "self": "string"
    }
  ],
  "disqualifications": [
    {
      "case_identifier": "string",
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
      "company_names": [
        "string"
      ],
      "court_name": "string",
      "disqualification_type": "string",
      "disqualified_from": "2020-04-08",
      "disqualified_until": "2020-04-08",
      "heard_on": "2020-04-08",
      "undertaken_on": "2020-04-08",
      "last_variation": [
        {
          "varied_on": "2020-04-08",
          "case_identifier": "string",
          "court_name": "string"
        }
      ],
      "reason": [
        {
          "description_identifier": "string",
          "act": "string",
          "article": "string",
          "section": "string"
        }
      ]
    }
  ],
  "permissions_to_act": [
    {
      "company_names": [
        "string"
      ],
      "court_name": "string",
      "expires_on": "2020-04-08",
      "granted_on": "2020-04-08"
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|date_of_birth|string(date)|false|none|The disqualified officer's date of birth.|
|etag|string|true|none|The ETag of the resource.|
|forename|string|false|none|The forename of the disqualified officer.|
|honours|string|false|none|The honours that the disqualified officer has.|
|kind|string|true|none|none|
|nationality|string|false|none|The nationality of the disqualified officer.|
|other_forenames|string|false|none|The other forenames of the disqualified officer.|
|surname|string|true|none|The surname of the disqualified officer.|
|title|string|false|none|The title of the disqualified officer.|
|links|[[links](#schemalinks)]|true|none|Links to other resources associated with this officer disqualification resource.|
|disqualifications|[[disqualification](#schemadisqualification)]|true|none|The officer's disqualifications.|
|permissions_to_act|[[permission_to_act](#schemapermission_to_act)]|false|none|Permissions to act that have been granted for the disqualified officer.|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|natural-disqualification|

<h3 id="tocS_disqualification">disqualification</h3>
<!-- backwards compatibility -->
<a id="schemadisqualification"></a>
<a id="schema_disqualification"></a>
<a id="tocSdisqualification"></a>
<a id="tocsdisqualification"></a>

```json
{
  "case_identifier": "string",
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
  "company_names": [
    "string"
  ],
  "court_name": "string",
  "disqualification_type": "string",
  "disqualified_from": "2020-04-08",
  "disqualified_until": "2020-04-08",
  "heard_on": "2020-04-08",
  "undertaken_on": "2020-04-08",
  "last_variation": [
    {
      "varied_on": "2020-04-08",
      "case_identifier": "string",
      "court_name": "string"
    }
  ],
  "reason": [
    {
      "description_identifier": "string",
      "act": "string",
      "article": "string",
      "section": "string"
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|case_identifier|string|false|none|The case identifier of the disqualification.|
|address|[[address](#schemaaddress)]|true|none|The address of the disqualified officer as provided by the disqualifying authority.|
|company_names|[string]|false|none|The companies in which the misconduct took place.|
|court_name|string|false|none|The name of the court that handled the disqualification case.|
|disqualification_type|string|true|none|An enumeration type that provides the disqualifying authority that handled the disqualification case.|
|disqualified_from|string(date)|true|none|The date that the disqualification starts.|
|disqualified_until|string(date)|true|none|The date that the disqualification ends.|
|heard_on|string(date)|false|none|The date the disqualification hearing was on.|
|undertaken_on|string(date)|false|none|The date the disqualification undertaking was agreed on.|
|last_variation|[[last_variation](#schemalast_variation)]|false|none|The latest variation made to the disqualification.|
|reason|[[reason](#schemareason)]|true|none|The reason for the disqualification.|

<h3 id="tocS_last_variation">last_variation</h3>
<!-- backwards compatibility -->
<a id="schemalast_variation"></a>
<a id="schema_last_variation"></a>
<a id="tocSlast_variation"></a>
<a id="tocslast_variation"></a>

```json
{
  "varied_on": "2020-04-08",
  "case_identifier": "string",
  "court_name": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|varied_on|string(date)|false|none|The date the variation was made against the disqualification.|
|case_identifier|string|false|none|The case identifier of the variation.|
|court_name|string|false|none|The name of the court that handled the variation case.|

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
  "self": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|self|string|true|none|Link to this disqualification resource.|

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

<h3 id="tocS_permission_to_act">permission_to_act</h3>
<!-- backwards compatibility -->
<a id="schemapermission_to_act"></a>
<a id="schema_permission_to_act"></a>
<a id="tocSpermission_to_act"></a>
<a id="tocspermission_to_act"></a>

```json
{
  "company_names": [
    "string"
  ],
  "court_name": "string",
  "expires_on": "2020-04-08",
  "granted_on": "2020-04-08"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|company_names|[string]|false|none|The companies for which the disqualified officer has permission to act.|
|court_name|string|false|none|The name of the court that granted the permission to act.|
|expires_on|string(date)|true|none|The date that the permission ends.|
|granted_on|string(date)|true|none|The date that the permission starts.|


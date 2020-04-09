---
title: companyAddress Specification v0.0.1
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

<h1 id="companyaddress-specification">companyAddress Specification v0.0.1</h1>

> Scroll down for code samples, example requests and responses. Select a language for code samples from the tabs above or the mobile navigation menu.

**This specification was generated from old data and may not reflect the actual API.**

Base URLs:

* <a href="http://example.com/api_url">http://example.com/api_url</a>

<h2 id="companyaddress-specification-company-company_number-registered-office-address">company{company_number}registered-office-address</h2>

## readRegisteredOfficeAddress

<a id="opIdreadRegisteredOfficeAddress"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://example.com/api_url/company/{company_number}/registered-office-address \
  -H 'Accept: application/json'

```

```http
GET http://example.com/api_url/company/{company_number}/registered-office-address HTTP/1.1
Host: example.com
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'

};

fetch('http://example.com/api_url/company/{company_number}/registered-office-address',
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

result = RestClient.get 'http://example.com/api_url/company/{company_number}/registered-office-address',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://example.com/api_url/company/{company_number}/registered-office-address', headers = headers)

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
    $response = $client->request('GET','http://example.com/api_url/company/{company_number}/registered-office-address', array(
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
URL obj = new URL("http://example.com/api_url/company/{company_number}/registered-office-address");
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
    req, err := http.NewRequest("GET", "http://example.com/api_url/company/{company_number}/registered-office-address", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /company/{company_number}/registered-office-address`

*Get the current address of a company*

<h4 id="readregisteredofficeaddress-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|company_number|path|string|true|The number of the company to create an address for.|

> Example responses

> 200 Response

```json
{
  "etag": "string",
  "premises": "string",
  "address_line_1": "string",
  "address_line_2": "string",
  "locality": "string",
  "region": "string",
  "postal_code": "string",
  "country": "England",
  "po_box": "string"
}
```

<h4 id="readregisteredofficeaddress-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[registeredOfficeAddress](#schemaregisteredofficeaddress)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Not authorised|[error](#schemaerror)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|Not found|[error](#schemaerror)|

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

<h3 id="tocS_serviceError">serviceError</h3>
<!-- backwards compatibility -->
<a id="schemaserviceerror"></a>
<a id="schema_serviceError"></a>
<a id="tocSserviceerror"></a>
<a id="tocsserviceerror"></a>

```json
{
  "error": "string",
  "error_description": "string",
  "exception_id": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|error|string|true|none|The error that occured.|
|error_description|string|false|none|A description of the error.|
|exception_id|string|false|none|A unique ID referencing the occurrence of the error.|

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

<h3 id="tocS_registeredOfficeAddress">registeredOfficeAddress</h3>
<!-- backwards compatibility -->
<a id="schemaregisteredofficeaddress"></a>
<a id="schema_registeredOfficeAddress"></a>
<a id="tocSregisteredofficeaddress"></a>
<a id="tocsregisteredofficeaddress"></a>

```json
{
  "etag": "string",
  "premises": "string",
  "address_line_1": "string",
  "address_line_2": "string",
  "locality": "string",
  "region": "string",
  "postal_code": "string",
  "country": "England",
  "po_box": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|etag|string|true|none|The ETag of the resource.|
|premises|string|true|none|The property name or number.|
|address_line_1|string|true|none|The first line of the address.|
|address_line_2|string|false|none|The second line of the address.|
|locality|string|true|none|The locality e.g London.|
|region|string|false|none|The region e.g Surrey.|
|postal_code|string|false|none|The postal code e.g CF14 3UZ.|
|country|string|true|none|The country.|
|po_box|string|false|none|The post-office box number.|

##### Enumerated Values

|Property|Value|
|---|---|
|country|England|
|country|Wales|
|country|Scotland|
|country|Northern Ireland|
|country|Great Britain|
|country|United Kingdom|
|country|Not specified|


---
title: companyUKEstablishments Specification v0.0.1
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

<h1 id="companyukestablishments-specification">companyUKEstablishments Specification v0.0.1</h1>

> Scroll down for code samples, example requests and responses. Select a language for code samples from the tabs above or the mobile navigation menu.

**This specification was generated from old data and may not reflect the actual API.**

Base URLs:

* <a href="http://example.com/api_url">http://example.com/api_url</a>

<h2 id="companyukestablishments-specification-company-company_number-uk-establishments">company{company_number}uk-establishments</h2>

## getCompanyUKEstablishments

<a id="opIdgetCompanyUKEstablishments"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://example.com/api_url/company/{company_number}/uk-establishments \
  -H 'Accept: application/json'

```

```http
GET http://example.com/api_url/company/{company_number}/uk-establishments HTTP/1.1
Host: example.com
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'

};

fetch('http://example.com/api_url/company/{company_number}/uk-establishments',
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

result = RestClient.get 'http://example.com/api_url/company/{company_number}/uk-establishments',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://example.com/api_url/company/{company_number}/uk-establishments', headers = headers)

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
    $response = $client->request('GET','http://example.com/api_url/company/{company_number}/uk-establishments', array(
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
URL obj = new URL("http://example.com/api_url/company/{company_number}/uk-establishments");
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
    req, err := http.NewRequest("GET", "http://example.com/api_url/company/{company_number}/uk-establishments", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /company/{company_number}/uk-establishments`

*Get a list of UK Establishment companies*

<h4 id="getcompanyukestablishments-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|company_number|path|string|true|Company number.|

> Example responses

> 200 Response

```json
{
  "etag": "string",
  "kind": "ukestablishment-companies",
  "links": [
    {
      "self": "string"
    }
  ],
  "items": [
    {
      "company_number": "string",
      "company_name": "string",
      "company_status": "string",
      "locality": "string",
      "links": [
        {
          "company": "string"
        }
      ]
    }
  ]
}
```

<h4 id="getcompanyukestablishments-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[companyUKEstablishments](#schemacompanyukestablishments)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Invalid request|None|

<h4 id="getcompanyukestablishments-responseschema">Response Schema</h4>

<aside class="success">
This operation does not require authentication
</aside>

## Schemas

<h3 id="tocS_self_links">self_links</h3>
<!-- backwards compatibility -->
<a id="schemaself_links"></a>
<a id="schema_self_links"></a>
<a id="tocSself_links"></a>
<a id="tocsself_links"></a>

```json
{
  "self": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|self|string|false|none|Link to this company.|

<h3 id="tocS_companyUKEstablishments">companyUKEstablishments</h3>
<!-- backwards compatibility -->
<a id="schemacompanyukestablishments"></a>
<a id="schema_companyUKEstablishments"></a>
<a id="tocScompanyukestablishments"></a>
<a id="tocscompanyukestablishments"></a>

```json
{
  "etag": "string",
  "kind": "ukestablishment-companies",
  "links": [
    {
      "self": "string"
    }
  ],
  "items": [
    {
      "company_number": "string",
      "company_name": "string",
      "company_status": "string",
      "locality": "string",
      "links": [
        {
          "company": "string"
        }
      ]
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|etag|string|false|none|The ETag of the resource.|
|kind|string|false|none|UK Establishment companies.|
|links|[[self_links](#schemaself_links)]|false|none|UK Establishment Resources related to this company.|
|items|[[companyDetails](#schemacompanydetails)]|false|none|List of UK Establishment companies|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|ukestablishment-companies|

<h3 id="tocS_companyDetails">companyDetails</h3>
<!-- backwards compatibility -->
<a id="schemacompanydetails"></a>
<a id="schema_companyDetails"></a>
<a id="tocScompanydetails"></a>
<a id="tocscompanydetails"></a>

```json
{
  "company_number": "string",
  "company_name": "string",
  "company_status": "string",
  "locality": "string",
  "links": [
    {
      "company": "string"
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|company_number|string|true|none|The number of the company.|
|company_name|string|true|none|The name of the company.|
|company_status|string|true|none|company status.|
|locality|string|false|none|The locality e.g London.|
|links|[[links](#schemalinks)]|true|none|Resources related to this company.|

<h3 id="tocS_links">links</h3>
<!-- backwards compatibility -->
<a id="schemalinks"></a>
<a id="schema_links"></a>
<a id="tocSlinks"></a>
<a id="tocslinks"></a>

```json
{
  "company": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|company|string|false|none|The link to the company.|


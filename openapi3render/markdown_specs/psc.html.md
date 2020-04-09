---
title: psc Specification v0.0.1
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

<h1 id="psc-specification">psc Specification v0.0.1</h1>

> Scroll down for code samples, example requests and responses. Select a language for code samples from the tabs above or the mobile navigation menu.

**This specification was generated from old data and may not reflect the actual API.**

Base URLs:

* <a href="http://example.com/api_url">http://example.com/api_url</a>

<h2 id="psc-specification-company-company_number-persons-with-significant-control">company{company_number}persons-with-significant-control</h2>

## getCorporateEntityWithSignificantControl

<a id="opIdgetCorporateEntityWithSignificantControl"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://example.com/api_url/company/{company_number}/persons-with-significant-control/corporate-entity/{psc_id} \
  -H 'Accept: application/json'

```

```http
GET http://example.com/api_url/company/{company_number}/persons-with-significant-control/corporate-entity/{psc_id} HTTP/1.1
Host: example.com
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'

};

fetch('http://example.com/api_url/company/{company_number}/persons-with-significant-control/corporate-entity/{psc_id}',
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

result = RestClient.get 'http://example.com/api_url/company/{company_number}/persons-with-significant-control/corporate-entity/{psc_id}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://example.com/api_url/company/{company_number}/persons-with-significant-control/corporate-entity/{psc_id}', headers = headers)

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
    $response = $client->request('GET','http://example.com/api_url/company/{company_number}/persons-with-significant-control/corporate-entity/{psc_id}', array(
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
URL obj = new URL("http://example.com/api_url/company/{company_number}/persons-with-significant-control/corporate-entity/{psc_id}");
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
    req, err := http.NewRequest("GET", "http://example.com/api_url/company/{company_number}/persons-with-significant-control/corporate-entity/{psc_id}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /company/{company_number}/persons-with-significant-control/corporate-entity/{psc_id}`

*Get the corporate entity with significant control*

<h4 id="getcorporateentitywithsignificantcontrol-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|company_number|path|string|true|The company number of the corporate entity with significant control details being requested.|
|psc_id|path|string|true|The id of the corporate entity with significant control details being requested.|

> Example responses

> 200 Response

```json
{
  "etag": "string",
  "notified_on": "2020-04-08",
  "ceased_on": "2020-04-08",
  "kind": "corporate-entity-person-with-significant-control",
  "name": "string",
  "links": [
    {
      "self": "string",
      "statement": "string"
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
  ],
  "identification": [
    {
      "legal_authority": "string",
      "legal_form": "string",
      "place_registered": "string",
      "registration_number": "string",
      "country_registered": "string"
    }
  ],
  "natures_of_control": [
    "ownership-of-shares-25-to-50-percent"
  ]
}
```

<h4 id="getcorporateentitywithsignificantcontrol-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[corporateEntity](#schemacorporateentity)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Bad request|[error](#schemaerror)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Not authorised|[error](#schemaerror)|

<aside class="success">
This operation does not require authentication
</aside>

## listPersonsWithSignificantControl

<a id="opIdlistPersonsWithSignificantControl"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://example.com/api_url/company/{company_number}/persons-with-significant-control \
  -H 'Accept: application/json'

```

```http
GET http://example.com/api_url/company/{company_number}/persons-with-significant-control HTTP/1.1
Host: example.com
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'

};

fetch('http://example.com/api_url/company/{company_number}/persons-with-significant-control',
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

result = RestClient.get 'http://example.com/api_url/company/{company_number}/persons-with-significant-control',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://example.com/api_url/company/{company_number}/persons-with-significant-control', headers = headers)

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
    $response = $client->request('GET','http://example.com/api_url/company/{company_number}/persons-with-significant-control', array(
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
URL obj = new URL("http://example.com/api_url/company/{company_number}/persons-with-significant-control");
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
    req, err := http.NewRequest("GET", "http://example.com/api_url/company/{company_number}/persons-with-significant-control", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /company/{company_number}/persons-with-significant-control`

*List the company persons with significant control*

<h4 id="listpersonswithsignificantcontrol-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|company_number|path|string|true|The company number of the persons with significant control list being requested.|
|items_per_page|query|integer|false|The number of persons with significant control to return per page.|
|start_index|query|integer|false|The offset into the entire result set that this page starts.|
|register_view|query|string|false|Display register specific information. If register is held at Companies House and register_view is set to true, only PSCs which are active or were terminated during election period are shown together with full dates of birth where available. Accepted values are: <ul><li><code>true</code></li><li><code>false</code></li></ul>Defaults to false|

> Example responses

> 200 Response

```json
{
  "etag": "string",
  "items_per_page": 0,
  "kind": "persons-with-significant-control#list",
  "items": [
    {
      "etag": "string",
      "notified_on": "2020-04-08",
      "ceased_on": "2020-04-08",
      "country_of_residence": "string",
      "date_of_birth": [
        {
          "day": 0,
          "month": 0,
          "year": 0
        }
      ],
      "name": "string",
      "name_elements": [
        {
          "forename": "string",
          "title": "string",
          "other_forenames": "string",
          "surname": "string"
        }
      ],
      "links": [
        {
          "self": "string",
          "statement": "string"
        }
      ],
      "nationality": "string",
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
      "natures_of_control": [
        "ownership-of-shares-25-to-50-percent"
      ]
    }
  ],
  "start_index": 0,
  "total_results": 0,
  "active_count": 0,
  "ceased_count": 0,
  "links": [
    {
      "self": "string",
      "persons_with_significant_control_statements_list": "string"
    }
  ]
}
```

<h4 id="listpersonswithsignificantcontrol-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[list](#schemalist)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Bad request|[error](#schemaerror)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Not authorised|[error](#schemaerror)|

<aside class="success">
This operation does not require authentication
</aside>

## getLegalPersonWithSignificantControl

<a id="opIdgetLegalPersonWithSignificantControl"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://example.com/api_url/company/{company_number}/persons-with-significant-control/legal-person/{psc_id} \
  -H 'Accept: application/json'

```

```http
GET http://example.com/api_url/company/{company_number}/persons-with-significant-control/legal-person/{psc_id} HTTP/1.1
Host: example.com
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'

};

fetch('http://example.com/api_url/company/{company_number}/persons-with-significant-control/legal-person/{psc_id}',
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

result = RestClient.get 'http://example.com/api_url/company/{company_number}/persons-with-significant-control/legal-person/{psc_id}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://example.com/api_url/company/{company_number}/persons-with-significant-control/legal-person/{psc_id}', headers = headers)

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
    $response = $client->request('GET','http://example.com/api_url/company/{company_number}/persons-with-significant-control/legal-person/{psc_id}', array(
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
URL obj = new URL("http://example.com/api_url/company/{company_number}/persons-with-significant-control/legal-person/{psc_id}");
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
    req, err := http.NewRequest("GET", "http://example.com/api_url/company/{company_number}/persons-with-significant-control/legal-person/{psc_id}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /company/{company_number}/persons-with-significant-control/legal-person/{psc_id}`

*Get the legal person with significant control*

<h4 id="getlegalpersonwithsignificantcontrol-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|company_number|path|string|true|The company number of the legal person with significant control details being requested.|
|psc_id|path|string|true|The id of the legal person with significant control details being requested.|

> Example responses

> 200 Response

```json
{
  "etag": "string",
  "notified_on": "2020-04-08",
  "ceased_on": "2020-04-08",
  "kind": "legal-person-with-significant-control",
  "name": "string",
  "links": [
    {
      "self": "string",
      "statement": "string"
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
  ],
  "identification": [
    {
      "legal_authority": "string",
      "legal_form": "string"
    }
  ],
  "natures_of_control": [
    "ownership-of-shares-25-to-50-percent"
  ]
}
```

<h4 id="getlegalpersonwithsignificantcontrol-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[legalPerson](#schemalegalperson)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Bad request|[error](#schemaerror)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Not authorised|[error](#schemaerror)|

<aside class="success">
This operation does not require authentication
</aside>

## getIndividualWithSignificantControl

<a id="opIdgetIndividualWithSignificantControl"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://example.com/api_url/company/{company_number}/persons-with-significant-control/individual/{psc_id} \
  -H 'Accept: application/json'

```

```http
GET http://example.com/api_url/company/{company_number}/persons-with-significant-control/individual/{psc_id} HTTP/1.1
Host: example.com
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'

};

fetch('http://example.com/api_url/company/{company_number}/persons-with-significant-control/individual/{psc_id}',
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

result = RestClient.get 'http://example.com/api_url/company/{company_number}/persons-with-significant-control/individual/{psc_id}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://example.com/api_url/company/{company_number}/persons-with-significant-control/individual/{psc_id}', headers = headers)

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
    $response = $client->request('GET','http://example.com/api_url/company/{company_number}/persons-with-significant-control/individual/{psc_id}', array(
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
URL obj = new URL("http://example.com/api_url/company/{company_number}/persons-with-significant-control/individual/{psc_id}");
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
    req, err := http.NewRequest("GET", "http://example.com/api_url/company/{company_number}/persons-with-significant-control/individual/{psc_id}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /company/{company_number}/persons-with-significant-control/individual/{psc_id}`

*Get the individual person with significant control*

<h4 id="getindividualwithsignificantcontrol-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|company_number|path|string|true|The company number of the person with significant control details being requested.|
|psc_id|path|string|true|The id of the person with significant control details being requested.|

> Example responses

> 200 Response

```json
{
  "etag": "string",
  "notified_on": "2020-04-08",
  "ceased_on": "2020-04-08",
  "kind": "individual-person-with-significant-control",
  "country_of_residence": "string",
  "date_of_birth": [
    {
      "day": 0,
      "month": 0,
      "year": 0
    }
  ],
  "name": "string",
  "name_elements": [
    {
      "forename": "string",
      "title": "string",
      "other_forenames": "string",
      "surname": "string"
    }
  ],
  "links": [
    {
      "self": "string",
      "statement": "string"
    }
  ],
  "nationality": "string",
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
  "natures_of_control": [
    "ownership-of-shares-25-to-50-percent"
  ]
}
```

<h4 id="getindividualwithsignificantcontrol-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[individual](#schemaindividual)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Bad request|[error](#schemaerror)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Not authorised|[error](#schemaerror)|

<aside class="success">
This operation does not require authentication
</aside>

## getSuperSecurePersonWithSignificantControl

<a id="opIdgetSuperSecurePersonWithSignificantControl"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://example.com/api_url/company/{company_number}/persons-with-significant-control/super-secure/{super_secure_id} \
  -H 'Accept: application/json'

```

```http
GET http://example.com/api_url/company/{company_number}/persons-with-significant-control/super-secure/{super_secure_id} HTTP/1.1
Host: example.com
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'

};

fetch('http://example.com/api_url/company/{company_number}/persons-with-significant-control/super-secure/{super_secure_id}',
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

result = RestClient.get 'http://example.com/api_url/company/{company_number}/persons-with-significant-control/super-secure/{super_secure_id}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://example.com/api_url/company/{company_number}/persons-with-significant-control/super-secure/{super_secure_id}', headers = headers)

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
    $response = $client->request('GET','http://example.com/api_url/company/{company_number}/persons-with-significant-control/super-secure/{super_secure_id}', array(
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
URL obj = new URL("http://example.com/api_url/company/{company_number}/persons-with-significant-control/super-secure/{super_secure_id}");
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
    req, err := http.NewRequest("GET", "http://example.com/api_url/company/{company_number}/persons-with-significant-control/super-secure/{super_secure_id}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /company/{company_number}/persons-with-significant-control/super-secure/{super_secure_id}`

*Get the super secure person with significant control*

<h4 id="getsupersecurepersonwithsignificantcontrol-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|company_number|path|string|true|The company number of the super secure person with significant control details being requested.|
|super_secure_id|path|string|true|The id of the super secure person with significant control details being requested.|

> Example responses

> 200 Response

```json
{
  "etag": "string",
  "kind": "super-secure-person-with-significant-control",
  "description": "super-secure-persons-with-significant-control",
  "ceased": true,
  "links": [
    {
      "self": "string"
    }
  ]
}
```

<h4 id="getsupersecurepersonwithsignificantcontrol-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[superSecure](#schemasupersecure)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Bad request|[error](#schemaerror)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Not authorised|[error](#schemaerror)|

<aside class="success">
This operation does not require authentication
</aside>

## listPersonsWithSignificantControlStatements

<a id="opIdlistPersonsWithSignificantControlStatements"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://example.com/api_url/company/{company_number}/persons-with-significant-control-statements \
  -H 'Accept: application/json'

```

```http
GET http://example.com/api_url/company/{company_number}/persons-with-significant-control-statements HTTP/1.1
Host: example.com
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'

};

fetch('http://example.com/api_url/company/{company_number}/persons-with-significant-control-statements',
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

result = RestClient.get 'http://example.com/api_url/company/{company_number}/persons-with-significant-control-statements',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://example.com/api_url/company/{company_number}/persons-with-significant-control-statements', headers = headers)

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
    $response = $client->request('GET','http://example.com/api_url/company/{company_number}/persons-with-significant-control-statements', array(
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
URL obj = new URL("http://example.com/api_url/company/{company_number}/persons-with-significant-control-statements");
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
    req, err := http.NewRequest("GET", "http://example.com/api_url/company/{company_number}/persons-with-significant-control-statements", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /company/{company_number}/persons-with-significant-control-statements`

*List the company persons with significant control statements*

<h4 id="listpersonswithsignificantcontrolstatements-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|company_number|path|string|true|The company number of the persons with significant control statements list being requested.|
|items_per_page|query|integer|false|The number of persons with significant control statements to return per page.|
|start_index|query|integer|false|The offset into the entire result set that this page starts.|
|register_view|query|string|false|Display register specific information. If register is held at Companies House and register_view is set to true, only statements which are active or were withdrawn during election period are shown. Accepted values are: <ul><li><code>true</code></li><li><code>false</code></li></ul>Defaults to false|

> Example responses

> 200 Response

```json
{
  "etag": "string",
  "items_per_page": 0,
  "kind": "persons-with-significant-control#statements-list",
  "items": [
    {
      "etag": "string",
      "kind": "person-with-significant-control-statement",
      "notified_on": "2020-04-08",
      "ceased_on": "2020-04-08",
      "restrictions_notice_withdrawal_reason": "restrictions-notice-withdrawn-by-court-order",
      "statement": "no-individual-or-entity-with-signficant-control",
      "linked_psc_name": "string",
      "links": [
        {
          "self": "string",
          "person_with_significant_control": "string"
        }
      ]
    }
  ],
  "start_index": 0,
  "total_results": 0,
  "active_count": 0,
  "ceased_count": 0,
  "links": [
    {
      "self": "string",
      "persons_with_significant_control_list": "string"
    }
  ]
}
```

<h4 id="listpersonswithsignificantcontrolstatements-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[statementList](#schemastatementlist)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Bad request|[error](#schemaerror)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Not authorised|[error](#schemaerror)|

<aside class="success">
This operation does not require authentication
</aside>

## getPersonsWithSignificantControlStatement

<a id="opIdgetPersonsWithSignificantControlStatement"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://example.com/api_url/company/{company_number}/persons-with-significant-control-statements/{statement_id} \
  -H 'Accept: application/json'

```

```http
GET http://example.com/api_url/company/{company_number}/persons-with-significant-control-statements/{statement_id} HTTP/1.1
Host: example.com
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'

};

fetch('http://example.com/api_url/company/{company_number}/persons-with-significant-control-statements/{statement_id}',
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

result = RestClient.get 'http://example.com/api_url/company/{company_number}/persons-with-significant-control-statements/{statement_id}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://example.com/api_url/company/{company_number}/persons-with-significant-control-statements/{statement_id}', headers = headers)

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
    $response = $client->request('GET','http://example.com/api_url/company/{company_number}/persons-with-significant-control-statements/{statement_id}', array(
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
URL obj = new URL("http://example.com/api_url/company/{company_number}/persons-with-significant-control-statements/{statement_id}");
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
    req, err := http.NewRequest("GET", "http://example.com/api_url/company/{company_number}/persons-with-significant-control-statements/{statement_id}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /company/{company_number}/persons-with-significant-control-statements/{statement_id}`

*Get the person with significant control statement*

<h4 id="getpersonswithsignificantcontrolstatement-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|company_number|path|string|true|The company number of the person with significant control statement details being requested.|
|statement_id|path|string|true|The id of the person with significant control statement details being requested.|

> Example responses

> 200 Response

```json
{
  "etag": "string",
  "kind": "person-with-significant-control-statement",
  "notified_on": "2020-04-08",
  "ceased_on": "2020-04-08",
  "restrictions_notice_withdrawal_reason": "restrictions-notice-withdrawn-by-court-order",
  "statement": "no-individual-or-entity-with-signficant-control",
  "linked_psc_name": "string",
  "links": [
    {
      "self": "string",
      "person_with_significant_control": "string"
    }
  ]
}
```

<h4 id="getpersonswithsignificantcontrolstatement-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[statement](#schemastatement)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|Bad request|[error](#schemaerror)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Not authorised|[error](#schemaerror)|

<aside class="success">
This operation does not require authentication
</aside>

## Schemas

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
|address_line_1|string|true|none|The first line of the address.|
|address_line_2|string|false|none|The second line of the address.|
|care_of|string|false|none|Care of name.|
|country|string|false|none|The country. For example, UK.|
|locality|string|false|none|The locality. For example London.|
|po_box|string|false|none|The post-officer box number.|
|postal_code|string|true|none|The postal code. For example CF14 3UZ.|
|premises|string|true|none|The property name or number.|
|region|string|false|none|The region. For example Surrey.|

<h3 id="tocS_individual">individual</h3>
<!-- backwards compatibility -->
<a id="schemaindividual"></a>
<a id="schema_individual"></a>
<a id="tocSindividual"></a>
<a id="tocsindividual"></a>

```json
{
  "etag": "string",
  "notified_on": "2020-04-08",
  "ceased_on": "2020-04-08",
  "kind": "individual-person-with-significant-control",
  "country_of_residence": "string",
  "date_of_birth": [
    {
      "day": 0,
      "month": 0,
      "year": 0
    }
  ],
  "name": "string",
  "name_elements": [
    {
      "forename": "string",
      "title": "string",
      "other_forenames": "string",
      "surname": "string"
    }
  ],
  "links": [
    {
      "self": "string",
      "statement": "string"
    }
  ],
  "nationality": "string",
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
  "natures_of_control": [
    "ownership-of-shares-25-to-50-percent"
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|etag|string|true|none|The ETag of the resource.|
|notified_on|string(date)|true|none|The date that Companies House was notified about this person with significant control.|
|ceased_on|string(date)|false|none|The date that Companies House was notified about the cessation of this person with significant control.|
|kind|string|true|none|none|
|country_of_residence|string|true|none|The country of residence of the person with significant control.|
|date_of_birth|[[dateOfBirth](#schemadateofbirth)]|true|none|The date of birth of the person with significant control.|
|name|string|true|none|Name of the person with significant control.|
|name_elements|[[nameElements](#schemanameelements)]|true|none|A document encapsulating the seperate elements of a person with significant control's name.|
|links|[[pscLinksType](#schemapsclinkstype)]|true|none|A set of URLs related to the resource, including self.|
|nationality|string|true|none|The nationality of the person with significant control.|
|address|[[address](#schemaaddress)]|true|none|The service address of the person with significant control. If given, this address will be shown on the public record instead of the residential address.|
|natures_of_control|[string]|true|none|Indicates the nature of control the person with significant control holds.  For enumeration descriptions see `description` section in the enumeration mappings file.|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|individual-person-with-significant-control|

<h3 id="tocS_listSummary">listSummary</h3>
<!-- backwards compatibility -->
<a id="schemalistsummary"></a>
<a id="schema_listSummary"></a>
<a id="tocSlistsummary"></a>
<a id="tocslistsummary"></a>

```json
{
  "etag": "string",
  "notified_on": "2020-04-08",
  "ceased_on": "2020-04-08",
  "country_of_residence": "string",
  "date_of_birth": [
    {
      "day": 0,
      "month": 0,
      "year": 0
    }
  ],
  "name": "string",
  "name_elements": [
    {
      "forename": "string",
      "title": "string",
      "other_forenames": "string",
      "surname": "string"
    }
  ],
  "links": [
    {
      "self": "string",
      "statement": "string"
    }
  ],
  "nationality": "string",
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
  "natures_of_control": [
    "ownership-of-shares-25-to-50-percent"
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|etag|string|true|none|The ETag of the resource.|
|notified_on|string(date)|true|none|The date that Companies House was notified about this person with significant control.|
|ceased_on|string(date)|false|none|The date that Companies House was notified about the cessation of this person with significant control.|
|country_of_residence|string|false|none|The country of residence of the person with significant control.|
|date_of_birth|[[dateOfBirth](#schemadateofbirth)]|false|none|The date of birth of the person with significant control.|
|name|string|true|none|Name of the person with significant control.|
|name_elements|[[nameElements](#schemanameelements)]|false|none|A document encapsulating the seperate elements of a person with significant control's name.|
|links|[[pscLinksType](#schemapsclinkstype)]|true|none|A set of URLs related to the resource, including self.|
|nationality|string|false|none|The nationality of the person with significant control.|
|address|[[address](#schemaaddress)]|true|none|The service address of the person with significant control. If given, this address will be shown on the public record instead of the residential address.|
|natures_of_control|[string]|true|none|Indicates the nature of control the person with significant control holds.  For enumeration descriptions see `description` section in the enumeration mappings file.|

<h3 id="tocS_superSecure">superSecure</h3>
<!-- backwards compatibility -->
<a id="schemasupersecure"></a>
<a id="schema_superSecure"></a>
<a id="tocSsupersecure"></a>
<a id="tocssupersecure"></a>

```json
{
  "etag": "string",
  "kind": "super-secure-person-with-significant-control",
  "description": "super-secure-persons-with-significant-control",
  "ceased": true,
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
|etag|string|true|none|The ETag of the resource.|
|kind|string|true|none|none|
|description|string|true|none|Description of the super secure legal statement|
|ceased|boolean|false|none|Presence of that indicator means the super secure person status is ceased|
|links|[[superSecureLinksType](#schemasupersecurelinkstype)]|true|none|A set of URLs related to the resource, including self.|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|super-secure-person-with-significant-control|
|description|super-secure-persons-with-significant-control|

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

<h3 id="tocS_corporateEntity">corporateEntity</h3>
<!-- backwards compatibility -->
<a id="schemacorporateentity"></a>
<a id="schema_corporateEntity"></a>
<a id="tocScorporateentity"></a>
<a id="tocscorporateentity"></a>

```json
{
  "etag": "string",
  "notified_on": "2020-04-08",
  "ceased_on": "2020-04-08",
  "kind": "corporate-entity-person-with-significant-control",
  "name": "string",
  "links": [
    {
      "self": "string",
      "statement": "string"
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
  ],
  "identification": [
    {
      "legal_authority": "string",
      "legal_form": "string",
      "place_registered": "string",
      "registration_number": "string",
      "country_registered": "string"
    }
  ],
  "natures_of_control": [
    "ownership-of-shares-25-to-50-percent"
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|etag|string|true|none|The ETag of the resource.|
|notified_on|string(date)|true|none|The date that Companies House was notified about this person with significant control.|
|ceased_on|string(date)|false|none|The date that Companies House was notified about the cessation of this person with significant control.|
|kind|string|true|none|none|
|name|string|true|none|Name of the person with significant control.|
|links|[[pscLinksType](#schemapsclinkstype)]|true|none|A set of URLs related to the resource, including self.|
|address|[[address](#schemaaddress)]|true|none|The address of the person with significant control.|
|identification|[[corporateEntityIdent](#schemacorporateentityident)]|true|none|none|
|natures_of_control|[string]|true|none|Indicates the nature of control the person with significant control holds.  For enumeration descriptions see `description` section in the enumeration mappings file.|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|corporate-entity-person-with-significant-control|

<h3 id="tocS_corporateEntityIdent">corporateEntityIdent</h3>
<!-- backwards compatibility -->
<a id="schemacorporateentityident"></a>
<a id="schema_corporateEntityIdent"></a>
<a id="tocScorporateentityident"></a>
<a id="tocscorporateentityident"></a>

```json
{
  "legal_authority": "string",
  "legal_form": "string",
  "place_registered": "string",
  "registration_number": "string",
  "country_registered": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|legal_authority|string|true|none|The legal authority supervising the corporate entity with significant control.|
|legal_form|string|true|none|The legal form of the corporate entity with significant control as defined by its country of registration.|
|place_registered|string|false|none|The place the corporate entity with significant control is registered.|
|registration_number|string|false|none|The registration number of the corporate entity with significant control.|
|country_registered|string|false|none|The country or state the corporate entity with significant control is registered in.|

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

<h3 id="tocS_list">list</h3>
<!-- backwards compatibility -->
<a id="schemalist"></a>
<a id="schema_list"></a>
<a id="tocSlist"></a>
<a id="tocslist"></a>

```json
{
  "etag": "string",
  "items_per_page": 0,
  "kind": "persons-with-significant-control#list",
  "items": [
    {
      "etag": "string",
      "notified_on": "2020-04-08",
      "ceased_on": "2020-04-08",
      "country_of_residence": "string",
      "date_of_birth": [
        {
          "day": 0,
          "month": 0,
          "year": 0
        }
      ],
      "name": "string",
      "name_elements": [
        {
          "forename": "string",
          "title": "string",
          "other_forenames": "string",
          "surname": "string"
        }
      ],
      "links": [
        {
          "self": "string",
          "statement": "string"
        }
      ],
      "nationality": "string",
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
      "natures_of_control": [
        "ownership-of-shares-25-to-50-percent"
      ]
    }
  ],
  "start_index": 0,
  "total_results": 0,
  "active_count": 0,
  "ceased_count": 0,
  "links": [
    {
      "self": "string",
      "persons_with_significant_control_statements_list": "string"
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|etag|string|true|none|The ETag of the resource.|
|items_per_page|integer|true|none|The number of persons with significant control to return per page.|
|kind|string|true|none|none|
|items|[[listSummary](#schemalistsummary)]|true|none|The list of persons with significant control.|
|start_index|integer|true|none|The offset into the entire result set that this page starts.|
|total_results|integer|true|none|The total number of persons with significant control in this result set.|
|active_count|integer|true|none|The number of active persons with significant control in this result set.|
|ceased_count|integer|true|none|The number of ceased persons with significant control in this result set.|
|links|[[pscListLinksType](#schemapsclistlinkstype)]|true|none|A set of URLs related to the resource, including self.|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|persons-with-significant-control#list|

<h3 id="tocS_corporateEntityList">corporateEntityList</h3>
<!-- backwards compatibility -->
<a id="schemacorporateentitylist"></a>
<a id="schema_corporateEntityList"></a>
<a id="tocScorporateentitylist"></a>
<a id="tocscorporateentitylist"></a>

```json
{
  "etag": "string",
  "items_per_page": 0,
  "kind": "persons-with-significant-control#list-corporate-entity",
  "items": [
    {
      "etag": "string",
      "notified_on": "2020-04-08",
      "ceased_on": "2020-04-08",
      "country_of_residence": "string",
      "date_of_birth": [
        {
          "day": 0,
          "month": 0,
          "year": 0
        }
      ],
      "name": "string",
      "name_elements": [
        {
          "forename": "string",
          "title": "string",
          "other_forenames": "string",
          "surname": "string"
        }
      ],
      "links": [
        {
          "self": "string",
          "statement": "string"
        }
      ],
      "nationality": "string",
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
      "natures_of_control": [
        "ownership-of-shares-25-to-50-percent"
      ]
    }
  ],
  "start_index": 0,
  "total_results": 0,
  "active_count": 0,
  "ceased_count": 0,
  "links": [
    {
      "self": "string",
      "persons_with_significant_control_statements_list": "string"
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|etag|string|true|none|The ETag of the resource.|
|items_per_page|integer|true|none|The number of corporate entity persons with significant control to return per page.|
|kind|string|true|none|none|
|items|[[listSummary](#schemalistsummary)]|true|none|The list of corporate entity persons with significant control.|
|start_index|integer|true|none|The offset into the entire result set that this page starts.|
|total_results|integer|true|none|The total number of corporate entity persons with significant control in this result set.|
|active_count|integer|true|none|The number of active persons with significant control in this result set.|
|ceased_count|integer|true|none|The number of ceased persons with significant control in this result set.|
|links|[[pscListLinksType](#schemapsclistlinkstype)]|true|none|A set of URLs related to the resource, including self.|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|persons-with-significant-control#list-corporate-entity|

<h3 id="tocS_pscListLinksType">pscListLinksType</h3>
<!-- backwards compatibility -->
<a id="schemapsclistlinkstype"></a>
<a id="schema_pscListLinksType"></a>
<a id="tocSpsclistlinkstype"></a>
<a id="tocspsclistlinkstype"></a>

```json
{
  "self": "string",
  "persons_with_significant_control_statements_list": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|self|string|true|none|The URL of the resource.|
|persons_with_significant_control_statements_list|string|false|none|The URL of the persons with significant control statements list resource.|

<h3 id="tocS_statementLinksType">statementLinksType</h3>
<!-- backwards compatibility -->
<a id="schemastatementlinkstype"></a>
<a id="schema_statementLinksType"></a>
<a id="tocSstatementlinkstype"></a>
<a id="tocsstatementlinkstype"></a>

```json
{
  "self": "string",
  "person_with_significant_control": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|self|string|true|none|The URL of the resource.|
|person_with_significant_control|string|false|none|The URL of the person with significant control linked to this statement.|

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

<h3 id="tocS_statementListLinksType">statementListLinksType</h3>
<!-- backwards compatibility -->
<a id="schemastatementlistlinkstype"></a>
<a id="schema_statementListLinksType"></a>
<a id="tocSstatementlistlinkstype"></a>
<a id="tocsstatementlistlinkstype"></a>

```json
{
  "self": "string",
  "persons_with_significant_control_list": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|self|string|true|none|The URL of the resource.|
|persons_with_significant_control_list|string|false|none|The URL of the persons with significant control list resource.|

<h3 id="tocS_statementList">statementList</h3>
<!-- backwards compatibility -->
<a id="schemastatementlist"></a>
<a id="schema_statementList"></a>
<a id="tocSstatementlist"></a>
<a id="tocsstatementlist"></a>

```json
{
  "etag": "string",
  "items_per_page": 0,
  "kind": "persons-with-significant-control#statements-list",
  "items": [
    {
      "etag": "string",
      "kind": "person-with-significant-control-statement",
      "notified_on": "2020-04-08",
      "ceased_on": "2020-04-08",
      "restrictions_notice_withdrawal_reason": "restrictions-notice-withdrawn-by-court-order",
      "statement": "no-individual-or-entity-with-signficant-control",
      "linked_psc_name": "string",
      "links": [
        {
          "self": "string",
          "person_with_significant_control": "string"
        }
      ]
    }
  ],
  "start_index": 0,
  "total_results": 0,
  "active_count": 0,
  "ceased_count": 0,
  "links": [
    {
      "self": "string",
      "persons_with_significant_control_list": "string"
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|etag|string|true|none|The ETag of the resource.|
|items_per_page|integer|true|none|The number of persons with significant control statements to return per page.|
|kind|string|true|none|none|
|items|[[statement](#schemastatement)]|true|none|The list of persons with significant control statements.|
|start_index|integer|true|none|The offset into the entire result set that this page starts.|
|total_results|integer|true|none|The total number of persons with significant control statements in this result set.|
|active_count|integer|true|none|The number of active persons with significant control statements in this result set.|
|ceased_count|integer|true|none|The number of ceased persons with significant control statements in this result set.|
|links|[[statementListLinksType](#schemastatementlistlinkstype)]|true|none|A set of URLs related to the resource, including self.|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|persons-with-significant-control#statements-list|

<h3 id="tocS_legalPerson">legalPerson</h3>
<!-- backwards compatibility -->
<a id="schemalegalperson"></a>
<a id="schema_legalPerson"></a>
<a id="tocSlegalperson"></a>
<a id="tocslegalperson"></a>

```json
{
  "etag": "string",
  "notified_on": "2020-04-08",
  "ceased_on": "2020-04-08",
  "kind": "legal-person-with-significant-control",
  "name": "string",
  "links": [
    {
      "self": "string",
      "statement": "string"
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
  ],
  "identification": [
    {
      "legal_authority": "string",
      "legal_form": "string"
    }
  ],
  "natures_of_control": [
    "ownership-of-shares-25-to-50-percent"
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|etag|string|true|none|The ETag of the resource.|
|notified_on|string(date)|true|none|The date that Companies House was notified about this person with significant control.|
|ceased_on|string(date)|false|none|The date that Companies House was notified about the cessation of this person with significant control.|
|kind|string|true|none|none|
|name|string|true|none|Name of the person with significant control.|
|links|[[pscLinksType](#schemapsclinkstype)]|true|none|A set of URLs related to the resource, including self.|
|address|[[address](#schemaaddress)]|true|none|The address of the person with significant control.|
|identification|[[legalPersonIdent](#schemalegalpersonident)]|true|none|none|
|natures_of_control|[string]|true|none|Indicates the nature of control the person with significant control holds.  For enumeration descriptions see `description` section in the enumeration mappings file.|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|legal-person-with-significant-control|

<h3 id="tocS_statement">statement</h3>
<!-- backwards compatibility -->
<a id="schemastatement"></a>
<a id="schema_statement"></a>
<a id="tocSstatement"></a>
<a id="tocsstatement"></a>

```json
{
  "etag": "string",
  "kind": "person-with-significant-control-statement",
  "notified_on": "2020-04-08",
  "ceased_on": "2020-04-08",
  "restrictions_notice_withdrawal_reason": "restrictions-notice-withdrawn-by-court-order",
  "statement": "no-individual-or-entity-with-signficant-control",
  "linked_psc_name": "string",
  "links": [
    {
      "self": "string",
      "person_with_significant_control": "string"
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|etag|string|true|none|The ETag of the resource.|
|kind|string|true|none|none|
|notified_on|string(date)|true|none|The date that the person with significant control statement was processed by Companies House.|
|ceased_on|string(date)|false|none|The date that Companies House was notified about the cessation of this person with significant control.|
|restrictions_notice_withdrawal_reason|string|false|none|The reason for the company withdrawing a `restrictions-notice-issued-to-psc` statement|
|statement|string|true|none|Indicates the type of statement filed.  For enumeration descriptions see `statement_description` section in the enumeration mappings file.|
|linked_psc_name|string|false|none|The name of the psc linked to this statement.|
|links|[[statementLinksType](#schemastatementlinkstype)]|true|none|A set of URLs related to the resource, including self.|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|person-with-significant-control-statement|
|restrictions_notice_withdrawal_reason|restrictions-notice-withdrawn-by-court-order|
|restrictions_notice_withdrawal_reason|restrictions-notice-withdrawn-by-company|
|statement|no-individual-or-entity-with-signficant-control|
|statement|steps-to-find-psc-not-yet-completed|
|statement|psc-exists-but-not-identified|
|statement|psc-details-not-confirmed|
|statement|psc-contacted-but-no-response|
|statement|restrictions-notice-issued-to-psc|
|statement|psc-has-failed-to-confirm-changed-details|

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

<h3 id="tocS_legalPersonList">legalPersonList</h3>
<!-- backwards compatibility -->
<a id="schemalegalpersonlist"></a>
<a id="schema_legalPersonList"></a>
<a id="tocSlegalpersonlist"></a>
<a id="tocslegalpersonlist"></a>

```json
{
  "etag": "string",
  "items_per_page": 0,
  "kind": "persons-with-significant-control#list-legal-person",
  "items": [
    {
      "etag": "string",
      "notified_on": "2020-04-08",
      "ceased_on": "2020-04-08",
      "country_of_residence": "string",
      "date_of_birth": [
        {
          "day": 0,
          "month": 0,
          "year": 0
        }
      ],
      "name": "string",
      "name_elements": [
        {
          "forename": "string",
          "title": "string",
          "other_forenames": "string",
          "surname": "string"
        }
      ],
      "links": [
        {
          "self": "string",
          "statement": "string"
        }
      ],
      "nationality": "string",
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
      "natures_of_control": [
        "ownership-of-shares-25-to-50-percent"
      ]
    }
  ],
  "start_index": 0,
  "total_results": 0,
  "active_count": 0,
  "ceased_count": 0,
  "links": [
    {
      "self": "string",
      "persons_with_significant_control_statements_list": "string"
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|etag|string|true|none|The ETag of the resource.|
|items_per_page|integer|true|none|The number of legal persons with significant control to return per page.|
|kind|string|true|none|none|
|items|[[listSummary](#schemalistsummary)]|true|none|The list of legal persons with significant control.|
|start_index|integer|true|none|The offset into the entire result set that this page starts.|
|total_results|integer|true|none|The total number of legal persons with significant control in this result set.|
|active_count|integer|true|none|The number of active persons with significant control in this result set.|
|ceased_count|integer|true|none|The number of ceased persons with significant control in this result set.|
|links|[[pscListLinksType](#schemapsclistlinkstype)]|true|none|A set of URLs related to the resource, including self.|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|persons-with-significant-control#list-legal-person|

<h3 id="tocS_individualList">individualList</h3>
<!-- backwards compatibility -->
<a id="schemaindividuallist"></a>
<a id="schema_individualList"></a>
<a id="tocSindividuallist"></a>
<a id="tocsindividuallist"></a>

```json
{
  "etag": "string",
  "items_per_page": 0,
  "kind": "persons-with-significant-control#list-individual",
  "items": [
    {
      "etag": "string",
      "notified_on": "2020-04-08",
      "ceased_on": "2020-04-08",
      "country_of_residence": "string",
      "date_of_birth": [
        {
          "day": 0,
          "month": 0,
          "year": 0
        }
      ],
      "name": "string",
      "name_elements": [
        {
          "forename": "string",
          "title": "string",
          "other_forenames": "string",
          "surname": "string"
        }
      ],
      "links": [
        {
          "self": "string",
          "statement": "string"
        }
      ],
      "nationality": "string",
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
      "natures_of_control": [
        "ownership-of-shares-25-to-50-percent"
      ]
    }
  ],
  "start_index": 0,
  "total_results": 0,
  "active_count": 0,
  "ceased_count": 0,
  "links": [
    {
      "self": "string",
      "persons_with_significant_control_statements_list": "string"
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|etag|string|true|none|The ETag of the resource.|
|items_per_page|integer|true|none|The number of individual persons with significant control to return per page.|
|kind|string|true|none|none|
|items|[[listSummary](#schemalistsummary)]|true|none|The list of individual persons with significant control.|
|start_index|integer|true|none|The offset into the entire result set that this page starts.|
|total_results|integer|true|none|The total number of individual persons with significant control in this result set.|
|active_count|integer|true|none|The number of active persons with significant control in this result set.|
|ceased_count|integer|true|none|The number of ceased persons with significant control in this result set.|
|links|[[pscListLinksType](#schemapsclistlinkstype)]|true|none|A set of URLs related to the resource, including self.|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|persons-with-significant-control#list-individual|

<h3 id="tocS_pscLinksType">pscLinksType</h3>
<!-- backwards compatibility -->
<a id="schemapsclinkstype"></a>
<a id="schema_pscLinksType"></a>
<a id="tocSpsclinkstype"></a>
<a id="tocspsclinkstype"></a>

```json
{
  "self": "string",
  "statement": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|self|string|true|none|The URL of the resource.|
|statement|string|false|none|The URL of the statement linked to this person with significant control.|

<h3 id="tocS_superSecureLinksType">superSecureLinksType</h3>
<!-- backwards compatibility -->
<a id="schemasupersecurelinkstype"></a>
<a id="schema_superSecureLinksType"></a>
<a id="tocSsupersecurelinkstype"></a>
<a id="tocssupersecurelinkstype"></a>

```json
{
  "self": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|self|string|true|none|The URL of the resource.|

<h3 id="tocS_nameElements">nameElements</h3>
<!-- backwards compatibility -->
<a id="schemanameelements"></a>
<a id="schema_nameElements"></a>
<a id="tocSnameelements"></a>
<a id="tocsnameelements"></a>

```json
{
  "forename": "string",
  "title": "string",
  "other_forenames": "string",
  "surname": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|forename|string|false|none|The forename of the person with significant control.|
|title|string|false|none|Title of the person with significant control.|
|other_forenames|string|false|none|Other forenames of the person with significant control.|
|surname|string|true|none|The surname of the person with significant control.|

<h3 id="tocS_legalPersonIdent">legalPersonIdent</h3>
<!-- backwards compatibility -->
<a id="schemalegalpersonident"></a>
<a id="schema_legalPersonIdent"></a>
<a id="tocSlegalpersonident"></a>
<a id="tocslegalpersonident"></a>

```json
{
  "legal_authority": "string",
  "legal_form": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|legal_authority|string|true|none|The legal authority supervising the legal person with significant control.|
|legal_form|string|true|none|The legal form of the legal person with significant control as defined by its country of registration.|


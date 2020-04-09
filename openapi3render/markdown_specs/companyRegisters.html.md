---
title: companyRegisters Specification v0.0.1
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

<h1 id="companyregisters-specification">companyRegisters Specification v0.0.1</h1>

> Scroll down for code samples, example requests and responses. Select a language for code samples from the tabs above or the mobile navigation menu.

**This specification was generated from old data and may not reflect the actual API.**

Base URLs:

* <a href="http://example.com/api_url">http://example.com/api_url</a>

<h2 id="companyregisters-specification-company-company_number-registers">company{company_number}registers</h2>

## readCompanyRegister

<a id="opIdreadCompanyRegister"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://example.com/api_url/company/{company_number}/registers \
  -H 'Accept: application/json'

```

```http
GET http://example.com/api_url/company/{company_number}/registers HTTP/1.1
Host: example.com
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'

};

fetch('http://example.com/api_url/company/{company_number}/registers',
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

result = RestClient.get 'http://example.com/api_url/company/{company_number}/registers',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://example.com/api_url/company/{company_number}/registers', headers = headers)

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
    $response = $client->request('GET','http://example.com/api_url/company/{company_number}/registers', array(
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
URL obj = new URL("http://example.com/api_url/company/{company_number}/registers");
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
    req, err := http.NewRequest("GET", "http://example.com/api_url/company/{company_number}/registers", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /company/{company_number}/registers`

*Get the company registers information*

<h4 id="readcompanyregister-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|company_number|path|string|true|The company number of the register information to return.|

> Example responses

> 200 Response

```json
{
  "links": [
    {
      "self": "string"
    }
  ],
  "company_number": "string",
  "kind": "registers",
  "registers": [
    {
      "directors": [
        {
          "register_type": "directors",
          "items": [
            {
              "moved_on": "2020-04-08",
              "register_moved_to": "public-register",
              "links": {}
            }
          ],
          "links": {}
        }
      ],
      "secretaries": [
        {
          "register_type": "secretaries",
          "items": [
            {
              "moved_on": "2020-04-08",
              "register_moved_to": "public-register",
              "links": {}
            }
          ],
          "links": {}
        }
      ],
      "persons_with_significant_control": [
        {
          "register_type": "persons-with-significant-control",
          "items": [
            {
              "moved_on": "2020-04-08",
              "register_moved_to": "public-register",
              "links": {}
            }
          ],
          "links": {}
        }
      ],
      "usual_residential_address": [
        {
          "register_type": "usual-residential-address",
          "items": [
            {
              "moved_on": "2020-04-08",
              "register_moved_to": "public-register",
              "links": {}
            }
          ],
          "links": {}
        }
      ],
      "llp_usual_residential_address": [
        {
          "register_type": "llp-usual-residential-address",
          "items": [
            {
              "moved_on": "2020-04-08",
              "register_moved_to": "public-register",
              "links": {}
            }
          ],
          "links": {}
        }
      ],
      "members": [
        {
          "register_type": "members",
          "items": [
            {
              "moved_on": "2020-04-08",
              "register_moved_to": "public-register",
              "links": {}
            }
          ],
          "links": {}
        }
      ],
      "llp_members": [
        {
          "register_type": "llp-members",
          "items": [
            {
              "moved_on": "2020-04-08",
              "register_moved_to": "public-register",
              "links": {}
            }
          ],
          "links": {}
        }
      ]
    }
  ],
  "etag": "string"
}
```

<h4 id="readcompanyregister-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[companyRegister](#schemacompanyregister)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Not authorised|[error](#schemaerror)|

<aside class="success">
This operation does not require authentication
</aside>

## Schemas

<h3 id="tocS_registerListLLPUsualResidentialAddress">registerListLLPUsualResidentialAddress</h3>
<!-- backwards compatibility -->
<a id="schemaregisterlistllpusualresidentialaddress"></a>
<a id="schema_registerListLLPUsualResidentialAddress"></a>
<a id="tocSregisterlistllpusualresidentialaddress"></a>
<a id="tocsregisterlistllpusualresidentialaddress"></a>

```json
{
  "register_type": "llp-usual-residential-address",
  "items": [
    {
      "moved_on": "2020-04-08",
      "register_moved_to": "public-register",
      "links": {}
    }
  ],
  "links": {}
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|register_type|string|true|none|The register type.|
|items|[[registeredItems](#schemaregistereditems)]|true|none|[Registered details for the company]|
|links|object|false|none|A set of URLs related to the resource.|

##### Enumerated Values

|Property|Value|
|---|---|
|register_type|llp-usual-residential-address|

<h3 id="tocS_linksListLLPUsualResidentialAddress">linksListLLPUsualResidentialAddress</h3>
<!-- backwards compatibility -->
<a id="schemalinkslistllpusualresidentialaddress"></a>
<a id="schema_linksListLLPUsualResidentialAddress"></a>
<a id="tocSlinkslistllpusualresidentialaddress"></a>
<a id="tocslinkslistllpusualresidentialaddress"></a>

```json
{
  "llp_usual_residential_address": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|llp_usual_residential_address|string|false|none|The URL for the resource.|

<h3 id="tocS_registerListPersonsWithSignificantControl">registerListPersonsWithSignificantControl</h3>
<!-- backwards compatibility -->
<a id="schemaregisterlistpersonswithsignificantcontrol"></a>
<a id="schema_registerListPersonsWithSignificantControl"></a>
<a id="tocSregisterlistpersonswithsignificantcontrol"></a>
<a id="tocsregisterlistpersonswithsignificantcontrol"></a>

```json
{
  "register_type": "persons-with-significant-control",
  "items": [
    {
      "moved_on": "2020-04-08",
      "register_moved_to": "public-register",
      "links": {}
    }
  ],
  "links": {}
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|register_type|string|true|none|The register type.|
|items|[[registeredItems](#schemaregistereditems)]|true|none|[Registered details for the company]|
|links|object|false|none|A set of URLs related to the resource.|

##### Enumerated Values

|Property|Value|
|---|---|
|register_type|persons-with-significant-control|

<h3 id="tocS_linksListLLPMembers">linksListLLPMembers</h3>
<!-- backwards compatibility -->
<a id="schemalinkslistllpmembers"></a>
<a id="schema_linksListLLPMembers"></a>
<a id="tocSlinkslistllpmembers"></a>
<a id="tocslinkslistllpmembers"></a>

```json
{
  "llp_members": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|llp_members|string|false|none|The URL for the resource.|

<h3 id="tocS_linksListUsualResidentialAddress">linksListUsualResidentialAddress</h3>
<!-- backwards compatibility -->
<a id="schemalinkslistusualresidentialaddress"></a>
<a id="schema_linksListUsualResidentialAddress"></a>
<a id="tocSlinkslistusualresidentialaddress"></a>
<a id="tocslinkslistusualresidentialaddress"></a>

```json
{
  "usual_residential_address": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|usual_residential_address|string|false|none|The URL for the resource.|

<h3 id="tocS_linksItems">linksItems</h3>
<!-- backwards compatibility -->
<a id="schemalinksitems"></a>
<a id="schema_linksItems"></a>
<a id="tocSlinksitems"></a>
<a id="tocslinksitems"></a>

```json
{
  "filing": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|filing|string|true|none|The URL of the transaction for the resource.|

<h3 id="tocS_linksDirectorsRegister">linksDirectorsRegister</h3>
<!-- backwards compatibility -->
<a id="schemalinksdirectorsregister"></a>
<a id="schema_linksDirectorsRegister"></a>
<a id="tocSlinksdirectorsregister"></a>
<a id="tocslinksdirectorsregister"></a>

```json
{
  "directors_register": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|directors_register|string|false|none|The URL for the resource.|

<h3 id="tocS_registerListDirectors">registerListDirectors</h3>
<!-- backwards compatibility -->
<a id="schemaregisterlistdirectors"></a>
<a id="schema_registerListDirectors"></a>
<a id="tocSregisterlistdirectors"></a>
<a id="tocsregisterlistdirectors"></a>

```json
{
  "register_type": "directors",
  "items": [
    {
      "moved_on": "2020-04-08",
      "register_moved_to": "public-register",
      "links": {}
    }
  ],
  "links": {}
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|register_type|string|true|none|The register type.|
|items|[[registeredItems](#schemaregistereditems)]|true|none|[Registered details for the company]|
|links|object|false|none|A set of URLs related to the resource.|

##### Enumerated Values

|Property|Value|
|---|---|
|register_type|directors|

<h3 id="tocS_linksSecretaryRegister">linksSecretaryRegister</h3>
<!-- backwards compatibility -->
<a id="schemalinkssecretaryregister"></a>
<a id="schema_linksSecretaryRegister"></a>
<a id="tocSlinkssecretaryregister"></a>
<a id="tocslinkssecretaryregister"></a>

```json
{
  "secretaries_register": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|secretaries_register|string|false|none|The URL for the resource.|

<h3 id="tocS_linksType">linksType</h3>
<!-- backwards compatibility -->
<a id="schemalinkstype"></a>
<a id="schema_linksType"></a>
<a id="tocSlinkstype"></a>
<a id="tocslinkstype"></a>

```json
{
  "self": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|self|string|true|none|The URL of the resource.|

<h3 id="tocS_registerListUsualResidentialAddress">registerListUsualResidentialAddress</h3>
<!-- backwards compatibility -->
<a id="schemaregisterlistusualresidentialaddress"></a>
<a id="schema_registerListUsualResidentialAddress"></a>
<a id="tocSregisterlistusualresidentialaddress"></a>
<a id="tocsregisterlistusualresidentialaddress"></a>

```json
{
  "register_type": "usual-residential-address",
  "items": [
    {
      "moved_on": "2020-04-08",
      "register_moved_to": "public-register",
      "links": {}
    }
  ],
  "links": {}
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|register_type|string|true|none|The register type.|
|items|[[registeredItems](#schemaregistereditems)]|true|none|[Registered details for the company]|
|links|object|false|none|A set of URLs related to the resource.|

##### Enumerated Values

|Property|Value|
|---|---|
|register_type|usual-residential-address|

<h3 id="tocS_companyRegister">companyRegister</h3>
<!-- backwards compatibility -->
<a id="schemacompanyregister"></a>
<a id="schema_companyRegister"></a>
<a id="tocScompanyregister"></a>
<a id="tocscompanyregister"></a>

```json
{
  "links": [
    {
      "self": "string"
    }
  ],
  "company_number": "string",
  "kind": "registers",
  "registers": [
    {
      "directors": [
        {
          "register_type": "directors",
          "items": [
            {
              "moved_on": "2020-04-08",
              "register_moved_to": "public-register",
              "links": {}
            }
          ],
          "links": {}
        }
      ],
      "secretaries": [
        {
          "register_type": "secretaries",
          "items": [
            {
              "moved_on": "2020-04-08",
              "register_moved_to": "public-register",
              "links": {}
            }
          ],
          "links": {}
        }
      ],
      "persons_with_significant_control": [
        {
          "register_type": "persons-with-significant-control",
          "items": [
            {
              "moved_on": "2020-04-08",
              "register_moved_to": "public-register",
              "links": {}
            }
          ],
          "links": {}
        }
      ],
      "usual_residential_address": [
        {
          "register_type": "usual-residential-address",
          "items": [
            {
              "moved_on": "2020-04-08",
              "register_moved_to": "public-register",
              "links": {}
            }
          ],
          "links": {}
        }
      ],
      "llp_usual_residential_address": [
        {
          "register_type": "llp-usual-residential-address",
          "items": [
            {
              "moved_on": "2020-04-08",
              "register_moved_to": "public-register",
              "links": {}
            }
          ],
          "links": {}
        }
      ],
      "members": [
        {
          "register_type": "members",
          "items": [
            {
              "moved_on": "2020-04-08",
              "register_moved_to": "public-register",
              "links": {}
            }
          ],
          "links": {}
        }
      ],
      "llp_members": [
        {
          "register_type": "llp-members",
          "items": [
            {
              "moved_on": "2020-04-08",
              "register_moved_to": "public-register",
              "links": {}
            }
          ],
          "links": {}
        }
      ]
    }
  ],
  "etag": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|links|[[linksType](#schemalinkstype)]|true|none|A set of URLs related to the resource, including self.|
|company_number|string|true|none|The number of the company.|
|kind|string|true|none|none|
|registers|[[registers](#schemaregisters)]|true|none|company registers information.|
|etag|string|false|none|The ETag of the resource.|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|registers|

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

<h3 id="tocS_registerListMembers">registerListMembers</h3>
<!-- backwards compatibility -->
<a id="schemaregisterlistmembers"></a>
<a id="schema_registerListMembers"></a>
<a id="tocSregisterlistmembers"></a>
<a id="tocsregisterlistmembers"></a>

```json
{
  "register_type": "members",
  "items": [
    {
      "moved_on": "2020-04-08",
      "register_moved_to": "public-register",
      "links": {}
    }
  ],
  "links": {}
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|register_type|string|true|none|The register type.|
|items|[[registeredItems](#schemaregistereditems)]|true|none|[Registered details for the company]|
|links|object|false|none|A set of URLs related to the resource.|

##### Enumerated Values

|Property|Value|
|---|---|
|register_type|members|

<h3 id="tocS_linksListMembers">linksListMembers</h3>
<!-- backwards compatibility -->
<a id="schemalinkslistmembers"></a>
<a id="schema_linksListMembers"></a>
<a id="tocSlinkslistmembers"></a>
<a id="tocslinkslistmembers"></a>

```json
{
  "members": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|members|string|false|none|The URL for the resource.|

<h3 id="tocS_registeredItems">registeredItems</h3>
<!-- backwards compatibility -->
<a id="schemaregistereditems"></a>
<a id="schema_registeredItems"></a>
<a id="tocSregistereditems"></a>
<a id="tocsregistereditems"></a>

```json
{
  "moved_on": "2020-04-08",
  "register_moved_to": "public-register",
  "links": {}
}

```

Registered details for the company

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|moved_on|string(date)|true|none|The date registered on|
|register_moved_to|string|true|none|Location of registration|
|links|object|true|none|A set of URLs related to the resource.|

##### Enumerated Values

|Property|Value|
|---|---|
|register_moved_to|public-register|
|register_moved_to|registered-office|
|register_moved_to|single-alternative-inspection-location|
|register_moved_to|unspecified-location|

<h3 id="tocS_linksPersonsWithSignificantControlRegister">linksPersonsWithSignificantControlRegister</h3>
<!-- backwards compatibility -->
<a id="schemalinkspersonswithsignificantcontrolregister"></a>
<a id="schema_linksPersonsWithSignificantControlRegister"></a>
<a id="tocSlinkspersonswithsignificantcontrolregister"></a>
<a id="tocslinkspersonswithsignificantcontrolregister"></a>

```json
{
  "persons_with_significant_control_register": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|persons_with_significant_control_register|string|false|none|The URL for the resource.|

<h3 id="tocS_registers">registers</h3>
<!-- backwards compatibility -->
<a id="schemaregisters"></a>
<a id="schema_registers"></a>
<a id="tocSregisters"></a>
<a id="tocsregisters"></a>

```json
{
  "directors": [
    {
      "register_type": "directors",
      "items": [
        {
          "moved_on": "2020-04-08",
          "register_moved_to": "public-register",
          "links": {}
        }
      ],
      "links": {}
    }
  ],
  "secretaries": [
    {
      "register_type": "secretaries",
      "items": [
        {
          "moved_on": "2020-04-08",
          "register_moved_to": "public-register",
          "links": {}
        }
      ],
      "links": {}
    }
  ],
  "persons_with_significant_control": [
    {
      "register_type": "persons-with-significant-control",
      "items": [
        {
          "moved_on": "2020-04-08",
          "register_moved_to": "public-register",
          "links": {}
        }
      ],
      "links": {}
    }
  ],
  "usual_residential_address": [
    {
      "register_type": "usual-residential-address",
      "items": [
        {
          "moved_on": "2020-04-08",
          "register_moved_to": "public-register",
          "links": {}
        }
      ],
      "links": {}
    }
  ],
  "llp_usual_residential_address": [
    {
      "register_type": "llp-usual-residential-address",
      "items": [
        {
          "moved_on": "2020-04-08",
          "register_moved_to": "public-register",
          "links": {}
        }
      ],
      "links": {}
    }
  ],
  "members": [
    {
      "register_type": "members",
      "items": [
        {
          "moved_on": "2020-04-08",
          "register_moved_to": "public-register",
          "links": {}
        }
      ],
      "links": {}
    }
  ],
  "llp_members": [
    {
      "register_type": "llp-members",
      "items": [
        {
          "moved_on": "2020-04-08",
          "register_moved_to": "public-register",
          "links": {}
        }
      ],
      "links": {}
    }
  ]
}

```

Registered company information.

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|directors|[[registerListDirectors](#schemaregisterlistdirectors)]|true|none|List of registered company directors|
|secretaries|[[registerListSecretaries](#schemaregisterlistsecretaries)]|true|none|List of registered company secretaries.|
|persons_with_significant_control|[[registerListPersonsWithSignificantControl](#schemaregisterlistpersonswithsignificantcontrol)]|true|none|List of registered company persons with significant control.|
|usual_residential_address|[[registerListUsualResidentialAddress](#schemaregisterlistusualresidentialaddress)]|true|none|List of register addresses.|
|llp_usual_residential_address|[[registerListLLPUsualResidentialAddress](#schemaregisterlistllpusualresidentialaddress)]|false|none|List of register addresses.|
|members|[[registerListMembers](#schemaregisterlistmembers)]|true|none|List of registered company members.|
|llp_members|[[registerListLLPMembers](#schemaregisterlistllpmembers)]|false|none|List of registered llp members.|

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

<h3 id="tocS_registerListLLPMembers">registerListLLPMembers</h3>
<!-- backwards compatibility -->
<a id="schemaregisterlistllpmembers"></a>
<a id="schema_registerListLLPMembers"></a>
<a id="tocSregisterlistllpmembers"></a>
<a id="tocsregisterlistllpmembers"></a>

```json
{
  "register_type": "llp-members",
  "items": [
    {
      "moved_on": "2020-04-08",
      "register_moved_to": "public-register",
      "links": {}
    }
  ],
  "links": {}
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|register_type|string|true|none|The register type.|
|items|[[registeredItems](#schemaregistereditems)]|true|none|[Registered details for the company]|
|links|object|false|none|A set of URLs related to the resource.|

##### Enumerated Values

|Property|Value|
|---|---|
|register_type|llp-members|

<h3 id="tocS_registerListSecretaries">registerListSecretaries</h3>
<!-- backwards compatibility -->
<a id="schemaregisterlistsecretaries"></a>
<a id="schema_registerListSecretaries"></a>
<a id="tocSregisterlistsecretaries"></a>
<a id="tocsregisterlistsecretaries"></a>

```json
{
  "register_type": "secretaries",
  "items": [
    {
      "moved_on": "2020-04-08",
      "register_moved_to": "public-register",
      "links": {}
    }
  ],
  "links": {}
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|register_type|string|true|none|The register type.|
|items|[[registeredItems](#schemaregistereditems)]|true|none|[Registered details for the company]|
|links|object|false|none|A set of URLs related to the resource.|

##### Enumerated Values

|Property|Value|
|---|---|
|register_type|secretaries|


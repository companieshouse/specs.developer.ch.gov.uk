---
title: exemptions Specification v0.0.1
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

<h1 id="exemptions-specification">exemptions Specification v0.0.1</h1>

> Scroll down for code samples, example requests and responses. Select a language for code samples from the tabs above or the mobile navigation menu.

**This specification was generated from old data and may not reflect the actual API.**

Base URLs:

* <a href="http://example.com/api_url">http://example.com/api_url</a>

<h2 id="exemptions-specification-company-company_number-exemptions">company{company_number}exemptions</h2>

## readCompanyExemptions

<a id="opIdreadCompanyExemptions"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://example.com/api_url/company/{company_number}/exemptions \
  -H 'Accept: application/json'

```

```http
GET http://example.com/api_url/company/{company_number}/exemptions HTTP/1.1
Host: example.com
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'

};

fetch('http://example.com/api_url/company/{company_number}/exemptions',
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

result = RestClient.get 'http://example.com/api_url/company/{company_number}/exemptions',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://example.com/api_url/company/{company_number}/exemptions', headers = headers)

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
    $response = $client->request('GET','http://example.com/api_url/company/{company_number}/exemptions', array(
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
URL obj = new URL("http://example.com/api_url/company/{company_number}/exemptions");
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
    req, err := http.NewRequest("GET", "http://example.com/api_url/company/{company_number}/exemptions", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /company/{company_number}/exemptions`

*Get the company exemptions information.*

<h4 id="readcompanyexemptions-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|company_number|path|string|true|The company number that the exemptions list is required for.|

> Example responses

> 200 Response

```json
{
  "links": [
    {
      "self": "string"
    }
  ],
  "kind": "exemptions",
  "etag": "string",
  "exemptions": [
    {
      "psc_exempt_as_trading_on_regulated_market": [
        {
          "items": [
            {
              "exempt_from": "2020-04-08",
              "exempt_to": "2020-04-08"
            }
          ],
          "exemption_type": "psc-exempt-as-trading-on-regulated-market"
        }
      ],
      "psc_exempt_as_shares_admitted_on_market": [
        {
          "items": [
            {
              "exempt_from": "2020-04-08",
              "exempt_to": "2020-04-08"
            }
          ],
          "exemption_type": "psc-exempt-as-shares-admitted-on-market"
        }
      ],
      "psc_exempt_as_trading_on_uk_regulated_market": [
        {
          "items": [
            {
              "exempt_from": "2020-04-08",
              "exempt_to": "2020-04-08"
            }
          ],
          "exemption_type": "psc-exempt-as-trading-on-uk-regulated-market"
        }
      ],
      "disclosure_transparency_rules_chapter_five_applies": [
        {
          "items": [
            {
              "exempt_from": "2020-04-08",
              "exempt_to": "2020-04-08"
            }
          ],
          "exemption_type": "disclosure-transparency-rules-chapter-five-applies"
        }
      ]
    }
  ]
}
```

<h4 id="readcompanyexemptions-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[companyExemptions](#schemacompanyexemptions)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Not authorised|[error](#schemaerror)|

<aside class="success">
This operation does not require authentication
</aside>

## Schemas

<h3 id="tocS_companyExemptions">companyExemptions</h3>
<!-- backwards compatibility -->
<a id="schemacompanyexemptions"></a>
<a id="schema_companyExemptions"></a>
<a id="tocScompanyexemptions"></a>
<a id="tocscompanyexemptions"></a>

```json
{
  "links": [
    {
      "self": "string"
    }
  ],
  "kind": "exemptions",
  "etag": "string",
  "exemptions": [
    {
      "psc_exempt_as_trading_on_regulated_market": [
        {
          "items": [
            {
              "exempt_from": "2020-04-08",
              "exempt_to": "2020-04-08"
            }
          ],
          "exemption_type": "psc-exempt-as-trading-on-regulated-market"
        }
      ],
      "psc_exempt_as_shares_admitted_on_market": [
        {
          "items": [
            {
              "exempt_from": "2020-04-08",
              "exempt_to": "2020-04-08"
            }
          ],
          "exemption_type": "psc-exempt-as-shares-admitted-on-market"
        }
      ],
      "psc_exempt_as_trading_on_uk_regulated_market": [
        {
          "items": [
            {
              "exempt_from": "2020-04-08",
              "exempt_to": "2020-04-08"
            }
          ],
          "exemption_type": "psc-exempt-as-trading-on-uk-regulated-market"
        }
      ],
      "disclosure_transparency_rules_chapter_five_applies": [
        {
          "items": [
            {
              "exempt_from": "2020-04-08",
              "exempt_to": "2020-04-08"
            }
          ],
          "exemption_type": "disclosure-transparency-rules-chapter-five-applies"
        }
      ]
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|links|[[linksType](#schemalinkstype)]|true|none|A set of URLs related to the resource, including self.|
|kind|string|true|none|none|
|etag|string|true|none|The ETag of the resource.|
|exemptions|[[exemptions](#schemaexemptions)]|true|none|Company exemptions information.|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|exemptions|

<h3 id="tocS_pscExemptAsSharesAdmittedOnMarketItem">pscExemptAsSharesAdmittedOnMarketItem</h3>
<!-- backwards compatibility -->
<a id="schemapscexemptassharesadmittedonmarketitem"></a>
<a id="schema_pscExemptAsSharesAdmittedOnMarketItem"></a>
<a id="tocSpscexemptassharesadmittedonmarketitem"></a>
<a id="tocspscexemptassharesadmittedonmarketitem"></a>

```json
{
  "items": [
    {
      "exempt_from": "2020-04-08",
      "exempt_to": "2020-04-08"
    }
  ],
  "exemption_type": "psc-exempt-as-shares-admitted-on-market"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|items|[[exemptionItem](#schemaexemptionitem)]|true|none|List of dates|
|exemption_type|string|true|none|The exemption type.|

##### Enumerated Values

|Property|Value|
|---|---|
|exemption_type|psc-exempt-as-shares-admitted-on-market|

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

<h3 id="tocS_pscExemptAsTradingOnRegulatedMarketItem">pscExemptAsTradingOnRegulatedMarketItem</h3>
<!-- backwards compatibility -->
<a id="schemapscexemptastradingonregulatedmarketitem"></a>
<a id="schema_pscExemptAsTradingOnRegulatedMarketItem"></a>
<a id="tocSpscexemptastradingonregulatedmarketitem"></a>
<a id="tocspscexemptastradingonregulatedmarketitem"></a>

```json
{
  "items": [
    {
      "exempt_from": "2020-04-08",
      "exempt_to": "2020-04-08"
    }
  ],
  "exemption_type": "psc-exempt-as-trading-on-regulated-market"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|items|[[exemptionItem](#schemaexemptionitem)]|true|none|List of dates|
|exemption_type|string|true|none|The exemption type.|

##### Enumerated Values

|Property|Value|
|---|---|
|exemption_type|psc-exempt-as-trading-on-regulated-market|

<h3 id="tocS_exemptions">exemptions</h3>
<!-- backwards compatibility -->
<a id="schemaexemptions"></a>
<a id="schema_exemptions"></a>
<a id="tocSexemptions"></a>
<a id="tocsexemptions"></a>

```json
{
  "psc_exempt_as_trading_on_regulated_market": [
    {
      "items": [
        {
          "exempt_from": "2020-04-08",
          "exempt_to": "2020-04-08"
        }
      ],
      "exemption_type": "psc-exempt-as-trading-on-regulated-market"
    }
  ],
  "psc_exempt_as_shares_admitted_on_market": [
    {
      "items": [
        {
          "exempt_from": "2020-04-08",
          "exempt_to": "2020-04-08"
        }
      ],
      "exemption_type": "psc-exempt-as-shares-admitted-on-market"
    }
  ],
  "psc_exempt_as_trading_on_uk_regulated_market": [
    {
      "items": [
        {
          "exempt_from": "2020-04-08",
          "exempt_to": "2020-04-08"
        }
      ],
      "exemption_type": "psc-exempt-as-trading-on-uk-regulated-market"
    }
  ],
  "disclosure_transparency_rules_chapter_five_applies": [
    {
      "items": [
        {
          "exempt_from": "2020-04-08",
          "exempt_to": "2020-04-08"
        }
      ],
      "exemption_type": "disclosure-transparency-rules-chapter-five-applies"
    }
  ]
}

```

Exemptions information.

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|psc_exempt_as_trading_on_regulated_market|[[pscExemptAsTradingOnRegulatedMarketItem](#schemapscexemptastradingonregulatedmarketitem)]|false|none|If present the company has been or is exempt from keeping a PSC register, as it has voting shares admitted to trading on a regulated market other than the UK.|
|psc_exempt_as_shares_admitted_on_market|[[pscExemptAsSharesAdmittedOnMarketItem](#schemapscexemptassharesadmittedonmarketitem)]|false|none|If present the company has been or is exempt from keeping a PSC register, as it has voting shares admitted to trading on a market listed in the Register of People with Significant Control Regulations 2016.|
|psc_exempt_as_trading_on_uk_regulated_market|[[pscExemptAsTradingOnUKRegulatedMarketItem](#schemapscexemptastradingonukregulatedmarketitem)]|false|none|If present the company has been or is exempt from keeping a PSC register, as it has voting shares admitted to trading on a UK regulated market.|
|disclosure_transparency_rules_chapter_five_applies|[[diclosureTransparencyRulesChapterFiveAppliesItem](#schemadiclosuretransparencyruleschapterfiveappliesitem)]|false|none|If present the company is a traded, DTR5 issuing company. Therefore it may be exempt from updating its PSC information.|

<h3 id="tocS_exemptionItem">exemptionItem</h3>
<!-- backwards compatibility -->
<a id="schemaexemptionitem"></a>
<a id="schema_exemptionItem"></a>
<a id="tocSexemptionitem"></a>
<a id="tocsexemptionitem"></a>

```json
{
  "exempt_from": "2020-04-08",
  "exempt_to": "2020-04-08"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|exempt_from|string(date)|true|none|Exemption valid from.|
|exempt_to|string(date)|false|none|Exemption valid to.|

<h3 id="tocS_pscExemptAsTradingOnUKRegulatedMarketItem">pscExemptAsTradingOnUKRegulatedMarketItem</h3>
<!-- backwards compatibility -->
<a id="schemapscexemptastradingonukregulatedmarketitem"></a>
<a id="schema_pscExemptAsTradingOnUKRegulatedMarketItem"></a>
<a id="tocSpscexemptastradingonukregulatedmarketitem"></a>
<a id="tocspscexemptastradingonukregulatedmarketitem"></a>

```json
{
  "items": [
    {
      "exempt_from": "2020-04-08",
      "exempt_to": "2020-04-08"
    }
  ],
  "exemption_type": "psc-exempt-as-trading-on-uk-regulated-market"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|items|[[exemptionItem](#schemaexemptionitem)]|true|none|List of dates|
|exemption_type|string|true|none|The exemption type.|

##### Enumerated Values

|Property|Value|
|---|---|
|exemption_type|psc-exempt-as-trading-on-uk-regulated-market|

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
|self|string|true|none|The URL of this resource.|

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

<h3 id="tocS_diclosureTransparencyRulesChapterFiveAppliesItem">diclosureTransparencyRulesChapterFiveAppliesItem</h3>
<!-- backwards compatibility -->
<a id="schemadiclosuretransparencyruleschapterfiveappliesitem"></a>
<a id="schema_diclosureTransparencyRulesChapterFiveAppliesItem"></a>
<a id="tocSdiclosuretransparencyruleschapterfiveappliesitem"></a>
<a id="tocsdiclosuretransparencyruleschapterfiveappliesitem"></a>

```json
{
  "items": [
    {
      "exempt_from": "2020-04-08",
      "exempt_to": "2020-04-08"
    }
  ],
  "exemption_type": "disclosure-transparency-rules-chapter-five-applies"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|items|[[exemptionItem](#schemaexemptionitem)]|true|none|List of exemption periods.|
|exemption_type|string|true|none|The exemption type.|

##### Enumerated Values

|Property|Value|
|---|---|
|exemption_type|disclosure-transparency-rules-chapter-five-applies|


---
title: officerAppointmentList Specification v0.0.1
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

<h1 id="officerappointmentlist-specification">officerAppointmentList Specification v0.0.1</h1>

> Scroll down for code samples, example requests and responses. Select a language for code samples from the tabs above or the mobile navigation menu.

**This specification was generated from old data and may not reflect the actual API.**

Base URLs:

* <a href="http://example.com/api_url">http://example.com/api_url</a>

<h2 id="officerappointmentlist-specification-officers-officer_id-appointments">officers{officer_id}appointments</h2>

## appointmentList

<a id="opIdappointmentList"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://example.com/api_url/officers/{officer_id}/appointments \
  -H 'Accept: application/json'

```

```http
GET http://example.com/api_url/officers/{officer_id}/appointments HTTP/1.1
Host: example.com
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'

};

fetch('http://example.com/api_url/officers/{officer_id}/appointments',
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

result = RestClient.get 'http://example.com/api_url/officers/{officer_id}/appointments',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://example.com/api_url/officers/{officer_id}/appointments', headers = headers)

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
    $response = $client->request('GET','http://example.com/api_url/officers/{officer_id}/appointments', array(
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
URL obj = new URL("http://example.com/api_url/officers/{officer_id}/appointments");
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
    req, err := http.NewRequest("GET", "http://example.com/api_url/officers/{officer_id}/appointments", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /officers/{officer_id}/appointments`

*List the officer appointments*

<h4 id="appointmentlist-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|officer_id|path|string|true|The officer id of the appointment list being requested.|
|items_per_page|query|integer|false|The number of appointments to return per page.|
|start_index|query|integer|false|The first row of data to retrieve, starting at 0. Use this parameter as a pagination mechanism along with the items_per_page parameter.|

> Example responses

> 200 Response

```json
{
  "date_of_birth": [
    {
      "month": 0,
      "year": 0
    }
  ],
  "etag": "string",
  "is_corporate_officer": true,
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
      "appointed_before": "2020-04-08",
      "appointed_on": "2020-04-08",
      "appointed_to": [
        {
          "company_name": "string",
          "company_number": "string",
          "company_status": "string"
        }
      ],
      "name": "string",
      "country_of_residence": "string",
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
      ],
      "is_pre_1992_appointment": true,
      "links": [
        {
          "company": "string"
        }
      ],
      "name_elements": [
        {
          "forename": "string",
          "title": "string",
          "other_forenames": "string",
          "surname": "string",
          "honours": "string"
        }
      ],
      "nationality": "string",
      "occupation": "string",
      "officer_role": "cic-manager",
      "resigned_on": "2020-04-08"
    }
  ],
  "items_per_page": 0,
  "kind": "personal-appointment",
  "links": [
    {
      "self": "string"
    }
  ],
  "name": "string",
  "start_index": 0,
  "total_results": 0
}
```

<h4 id="appointmentlist-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[appointmentList](#schemaappointmentlist)|
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
|address_line_1|string|false|none|The first line of the address.|
|address_line_2|string|false|none|The second line of the address.|
|care_of|string|false|none|The care of name.|
|country|string|false|none|The country. For example, UK.|
|locality|string|false|none|The locality. For example London.|
|po_box|string|false|none|The post-office box number.|
|postal_code|string|false|none|The postal code. For example CF14 3UZ.|
|premises|string|false|none|The property name or number.|
|region|string|false|none|The region. For example Surrey.|

<h3 id="tocS_appointmentLinkTypes">appointmentLinkTypes</h3>
<!-- backwards compatibility -->
<a id="schemaappointmentlinktypes"></a>
<a id="schema_appointmentLinkTypes"></a>
<a id="tocSappointmentlinktypes"></a>
<a id="tocsappointmentlinktypes"></a>

```json
{
  "company": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|company|string|true|none|Link to the company profile resource that this appointment is associated with.|

<h3 id="tocS_appointmentList">appointmentList</h3>
<!-- backwards compatibility -->
<a id="schemaappointmentlist"></a>
<a id="schema_appointmentList"></a>
<a id="tocSappointmentlist"></a>
<a id="tocsappointmentlist"></a>

```json
{
  "date_of_birth": [
    {
      "month": 0,
      "year": 0
    }
  ],
  "etag": "string",
  "is_corporate_officer": true,
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
      "appointed_before": "2020-04-08",
      "appointed_on": "2020-04-08",
      "appointed_to": [
        {
          "company_name": "string",
          "company_number": "string",
          "company_status": "string"
        }
      ],
      "name": "string",
      "country_of_residence": "string",
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
      ],
      "is_pre_1992_appointment": true,
      "links": [
        {
          "company": "string"
        }
      ],
      "name_elements": [
        {
          "forename": "string",
          "title": "string",
          "other_forenames": "string",
          "surname": "string",
          "honours": "string"
        }
      ],
      "nationality": "string",
      "occupation": "string",
      "officer_role": "cic-manager",
      "resigned_on": "2020-04-08"
    }
  ],
  "items_per_page": 0,
  "kind": "personal-appointment",
  "links": [
    {
      "self": "string"
    }
  ],
  "name": "string",
  "start_index": 0,
  "total_results": 0
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|date_of_birth|[[dateOfBirth](#schemadateofbirth)]|false|none|The officer's date of birth details.|
|etag|string|true|none|The ETag of the resource.|
|is_corporate_officer|boolean|true|none|Indicator representing if the officer is a corporate body.|
|items|[[officerAppointmentSummary](#schemaofficerappointmentsummary)]|true|none|The list of officer appointments.|
|items_per_page|integer|true|none|The number of officer appointments to return per page.|
|kind|string|true|none|none|
|links|[[officerLinkTypes](#schemaofficerlinktypes)]|true|none|Links to other resources associated with this officer appointment resource.|
|name|string|true|none|The corporate or natural officer name.|
|start_index|integer|true|none|The first row of data to retrieve, starting at 0. Use this parameter as a pagination mechanism along with the `items_per_page` parameter.|
|total_results|integer|true|none|The total number of officer appointments in this result set.|

##### Enumerated Values

|Property|Value|
|---|---|
|kind|personal-appointment|

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

<h3 id="tocS_appointedTo">appointedTo</h3>
<!-- backwards compatibility -->
<a id="schemaappointedto"></a>
<a id="schema_appointedTo"></a>
<a id="tocSappointedto"></a>
<a id="tocsappointedto"></a>

```json
{
  "company_name": "string",
  "company_number": "string",
  "company_status": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|company_name|string|false|none|The name of the company the officer is acting for.|
|company_number|string|true|none|The number of the company the officer is acting for.|
|company_status|string|false|none|The status of the company the officer is acting for.|

<h3 id="tocS_dateOfBirth">dateOfBirth</h3>
<!-- backwards compatibility -->
<a id="schemadateofbirth"></a>
<a id="schema_dateOfBirth"></a>
<a id="tocSdateofbirth"></a>
<a id="tocsdateofbirth"></a>

```json
{
  "month": 0,
  "year": 0
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|month|integer|true|none|The month the officer was born in.|
|year|integer|true|none|The year the officer was born in.|

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

<h3 id="tocS_officerAppointmentSummary">officerAppointmentSummary</h3>
<!-- backwards compatibility -->
<a id="schemaofficerappointmentsummary"></a>
<a id="schema_officerAppointmentSummary"></a>
<a id="tocSofficerappointmentsummary"></a>
<a id="tocsofficerappointmentsummary"></a>

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
  "appointed_before": "2020-04-08",
  "appointed_on": "2020-04-08",
  "appointed_to": [
    {
      "company_name": "string",
      "company_number": "string",
      "company_status": "string"
    }
  ],
  "name": "string",
  "country_of_residence": "string",
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
  ],
  "is_pre_1992_appointment": true,
  "links": [
    {
      "company": "string"
    }
  ],
  "name_elements": [
    {
      "forename": "string",
      "title": "string",
      "other_forenames": "string",
      "surname": "string",
      "honours": "string"
    }
  ],
  "nationality": "string",
  "occupation": "string",
  "officer_role": "cic-manager",
  "resigned_on": "2020-04-08"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|address|[[address](#schemaaddress)]|true|none|The correspondence address of the officer.|
|appointed_before|string(date)|false|none|The date the officer was appointed before. Only present when the `is_pre_1992_appointment` attribute is `true`.|
|appointed_on|string(date)|false|none|The date the officer was appointed.|
|appointed_to|[[appointedTo](#schemaappointedto)]|true|none|The company information of the appointment.|
|name|string|true|none|The full name of the officer.|
|country_of_residence|string|false|none|The officer's country of residence.|
|former_names|[[formerNames](#schemaformernames)]|false|none|Former names for the officer, if there are any.|
|identification|[[corporateIdent](#schemacorporateident)]|false|none|Only one from `eea` or `non-eea` can be supplied, not both.|
|is_pre_1992_appointment|boolean|false|none|Indicator representing if the officer was appointed before their appointment date.|
|links|[[appointmentLinkTypes](#schemaappointmentlinktypes)]|true|none|Links to other resources associated with this officer appointment item.|
|name_elements|[[nameElements](#schemanameelements)]|false|none|A document encapsulating the separate elements of a natural officer's name.|
|nationality|string|false|none|The officer's nationality.|
|occupation|string|false|none|The officer's occupation.|
|officer_role|string|true|none|none|
|resigned_on|string(date)|false|none|The date the officer was resigned.|

##### Enumerated Values

|Property|Value|
|---|---|
|officer_role|cic-manager|
|officer_role|corporate-director|
|officer_role|corporate-llp-designated-member|
|officer_role|corporate-llp-member|
|officer_role|corporate-member-of-a-management|
|officer_role|corporate-member-of-a-supervisory-organ|
|officer_role|corporate-member-of-an-administrative-organ|
|officer_role|corporate-nominee-director|
|officer_role|corporate-nominee-secretary|
|officer_role|corporate-secretary|
|officer_role|director|
|officer_role|judicial-factor|
|officer_role|llp-designated-member|
|officer_role|llp-member|
|officer_role|member-of-a-management|
|officer_role|member-of-a-supervisory-organ|
|officer_role|member-of-an-administrative-organ|
|officer_role|nominee-director|
|officer_role|nominee-secretary|
|officer_role|receiver-and-manager|
|officer_role|secretary|

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

<h3 id="tocS_officerLinkTypes">officerLinkTypes</h3>
<!-- backwards compatibility -->
<a id="schemaofficerlinktypes"></a>
<a id="schema_officerLinkTypes"></a>
<a id="tocSofficerlinktypes"></a>
<a id="tocsofficerlinktypes"></a>

```json
{
  "self": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|self|string|true|none|Link to this officer appointment resource.|

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
  "surname": "string",
  "honours": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|forename|string|false|none|The forename of the officer.|
|title|string|false|none|Title of the officer.|
|other_forenames|string|false|none|Other forenames of the officer.|
|surname|string|true|none|The surname of the officer.|
|honours|string|false|none|Honours an officer might have.|


---
title: companyProfile Specification v0.0.1
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

<h1 id="companyprofile-specification">companyProfile Specification v0.0.1</h1>

> Scroll down for code samples, example requests and responses. Select a language for code samples from the tabs above or the mobile navigation menu.

**This specification was generated from old data and may not reflect the actual API.**

Base URLs:

* <a href="http://example.com/api_url">http://example.com/api_url</a>

<h2 id="companyprofile-specification-company-company_number-">company{company_number}</h2>

## readCompanyProfile

<a id="opIdreadCompanyProfile"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://example.com/api_url/company/{company_number} \
  -H 'Accept: application/json'

```

```http
GET http://example.com/api_url/company/{company_number} HTTP/1.1
Host: example.com
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'

};

fetch('http://example.com/api_url/company/{company_number}',
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

result = RestClient.get 'http://example.com/api_url/company/{company_number}',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://example.com/api_url/company/{company_number}', headers = headers)

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
    $response = $client->request('GET','http://example.com/api_url/company/{company_number}', array(
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
URL obj = new URL("http://example.com/api_url/company/{company_number}");
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
    req, err := http.NewRequest("GET", "http://example.com/api_url/company/{company_number}", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /company/{company_number}`

*Get the basic company information*

<h4 id="readcompanyprofile-parameters">Parameters</h4>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|company_number|path|string|true|The company number of the basic information to return.|

> Example responses

> 200 Response

```json
{
  "accounts": [
    {
      "accounting_reference_date": [
        {
          "day": 0,
          "month": 0
        }
      ],
      "last_accounts": [
        {
          "made_up_to": "2020-04-08",
          "period_start_on": "2020-04-08",
          "period_end_on": "2020-04-08",
          "type": "null"
        }
      ],
      "next_accounts": [
        {
          "period_start_on": "2020-04-08",
          "period_end_on": "2020-04-08",
          "due_on": "2020-04-08",
          "overdue": true
        }
      ],
      "next_due": "2020-04-08",
      "next_made_up_to": "2020-04-08",
      "overdue": true
    }
  ],
  "annual_return": [
    {
      "last_made_up_to": "2020-04-08",
      "next_due": "2020-04-08",
      "next_made_up_to": "2020-04-08",
      "overdue": true
    }
  ],
  "can_file": true,
  "confirmation_statement": [
    {
      "last_made_up_to": "2020-04-08",
      "next_due": "2020-04-08",
      "next_made_up_to": "2020-04-08",
      "overdue": true
    }
  ],
  "company_name": "string",
  "company_number": "string",
  "date_of_creation": "2020-04-08",
  "date_of_cessation": "2020-04-08",
  "etag": "string",
  "has_been_liquidated": true,
  "has_charges": true,
  "is_community_interest_company": true,
  "subtype": "community-interest-company",
  "jurisdiction": "england-wales",
  "last_full_members_list_date": "2020-04-08",
  "foreign_company_details": [
    {
      "originating_registry": [
        {
          "country": "string",
          "name": "string"
        }
      ],
      "registration_number": "string",
      "governed_by": "string",
      "company_type": "string",
      "is_a_credit_finance_institution": true,
      "accounts": [
        {
          "account_period_from": [
            {
              "day": 0,
              "month": 0
            }
          ],
          "account_period_to": [
            {
              "day": 0,
              "month": 0
            }
          ],
          "must_file_within": [
            {
              "months": 0
            }
          ]
        }
      ],
      "business_activity": "string",
      "accounting_requirement": "string"
    }
  ],
  "registered_office_address": [
    {
      "care_of": "string",
      "address_line_1": "string",
      "address_line_2": "string",
      "country": "Wales",
      "locality": "string",
      "po_box": "string",
      "postal_code": "string",
      "premises": "string",
      "region": "string"
    }
  ],
  "sic_codes": [
    "string"
  ],
  "previous_company_names": [
    {
      "name": "string",
      "effective_from": "2020-04-08",
      "ceased_on": "2020-04-08"
    }
  ],
  "company_status": "active",
  "company_status_detail": "transferred-from-uk",
  "type": "private-unlimited",
  "external_registration_number": "string",
  "has_insolvency_history": true,
  "undeliverable_registered_office_address": true,
  "registered_office_is_in_dispute": true,
  "branch_company_details": [
    {
      "business_activity": "string",
      "parent_company_number": "string",
      "parent_company_name": "string"
    }
  ],
  "links": [
    {
      "self": "string",
      "persons_with_significant_control": "string",
      "persons_with_significant_control_statements": "string",
      "filing_history": "string",
      "officers": "string",
      "insolvency": "string",
      "charges": "string",
      "registers": "string"
    }
  ],
  "partial_data_available": "full-data-available-from-financial-conduct-authority"
}
```

<h4 id="readcompanyprofile-responses">Responses</h4>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success|[companyProfile](#schemacompanyprofile)|
|401|[Unauthorized](https://tools.ietf.org/html/rfc7235#section-3.1)|Not authorised|[error](#schemaerror)|

<aside class="success">
This operation does not require authentication
</aside>

## Schemas

<h3 id="tocS_foreignCompanyDetails">foreignCompanyDetails</h3>
<!-- backwards compatibility -->
<a id="schemaforeigncompanydetails"></a>
<a id="schema_foreignCompanyDetails"></a>
<a id="tocSforeigncompanydetails"></a>
<a id="tocsforeigncompanydetails"></a>

```json
{
  "originating_registry": [
    {
      "country": "string",
      "name": "string"
    }
  ],
  "registration_number": "string",
  "governed_by": "string",
  "company_type": "string",
  "is_a_credit_finance_institution": true,
  "accounts": [
    {
      "account_period_from": [
        {
          "day": 0,
          "month": 0
        }
      ],
      "account_period_to": [
        {
          "day": 0,
          "month": 0
        }
      ],
      "must_file_within": [
        {
          "months": 0
        }
      ]
    }
  ],
  "business_activity": "string",
  "accounting_requirement": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|originating_registry|[[originatingRegistry](#schemaoriginatingregistry)]|false|none|Company origin informations|
|registration_number|string|false|none|Registration number in company of incorporation.|
|governed_by|string|false|none|Law governing the company in country of incorporation.|
|company_type|string|false|none|Legal form of the company in the country of incorporation.|
|is_a_credit_finance_institution|boolean|false|none|Is it a financial or credit institution.|
|accounts|[[accountInformation](#schemaaccountinformation)]|false|none|Foreign company account information.|
|business_activity|string|false|none|Type of business undertaken by the company.|
|accounting_requirement|string|false|none|Accounts requirement.|

<h3 id="tocS_accountPeriodTo">accountPeriodTo</h3>
<!-- backwards compatibility -->
<a id="schemaaccountperiodto"></a>
<a id="schema_accountPeriodTo"></a>
<a id="tocSaccountperiodto"></a>
<a id="tocsaccountperiodto"></a>

```json
{
  "day": 0,
  "month": 0
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|day|integer|false|none|Day on which accounting period ends under parent law.|
|month|integer|false|none|Month in which accounting period ends under parent law.|

<h3 id="tocS_annualReturnInformation">annualReturnInformation</h3>
<!-- backwards compatibility -->
<a id="schemaannualreturninformation"></a>
<a id="schema_annualReturnInformation"></a>
<a id="tocSannualreturninformation"></a>
<a id="tocsannualreturninformation"></a>

```json
{
  "last_made_up_to": "2020-04-08",
  "next_due": "2020-04-08",
  "next_made_up_to": "2020-04-08",
  "overdue": true
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|last_made_up_to|string(date)|false|none|The date the last annual return was made up to.|
|next_due|string(date)|false|none|The date the next annual return is due. This member will only be returned if a confirmation statement has not been filed and the date is before 28th July 2016, otherwise refer to `confirmation_statement.next_due`|
|next_made_up_to|string(date)|false|none|The date the next annual return should be made up to. This member will only be returned if a confirmation statement has not been filed and the date is before 30th July 2016, otherwise refer to `confirmation_statement.next_made_up_to`|
|overdue|boolean|false|none|Flag indicating if the annual return is overdue.|

<h3 id="tocS_linksType">linksType</h3>
<!-- backwards compatibility -->
<a id="schemalinkstype"></a>
<a id="schema_linksType"></a>
<a id="tocSlinkstype"></a>
<a id="tocslinkstype"></a>

```json
{
  "self": "string",
  "persons_with_significant_control": "string",
  "persons_with_significant_control_statements": "string",
  "filing_history": "string",
  "officers": "string",
  "insolvency": "string",
  "charges": "string",
  "registers": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|self|string|true|none|The URL of the resource.|
|persons_with_significant_control|string|false|none|The URL of the company's persons with significant control list resource.|
|persons_with_significant_control_statements|string|false|none|The URL of the company's persons with significant control statements list resource.|
|filing_history|string|false|none|The URL of the company's filing history list resource.|
|officers|string|false|none|The URL of the company's officer list resource.|
|insolvency|string|false|none|The URL of the company's insolvency list resource|
|charges|string|false|none|The URL of the company's charge resource|
|registers|string|false|none|The URL of the registers resource for this company|

<h3 id="tocS_previousCompanyNames">previousCompanyNames</h3>
<!-- backwards compatibility -->
<a id="schemapreviouscompanynames"></a>
<a id="schema_previousCompanyNames"></a>
<a id="tocSpreviouscompanynames"></a>
<a id="tocspreviouscompanynames"></a>

```json
{
  "name": "string",
  "effective_from": "2020-04-08",
  "ceased_on": "2020-04-08"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|name|string|true|none|The previous company name|
|effective_from|string(date)|true|none|The date from which the company name was effective.|
|ceased_on|string(date)|true|none|The date on which the company name ceased.|

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

<h3 id="tocS_branchCompanyDetails">branchCompanyDetails</h3>
<!-- backwards compatibility -->
<a id="schemabranchcompanydetails"></a>
<a id="schema_branchCompanyDetails"></a>
<a id="tocSbranchcompanydetails"></a>
<a id="tocsbranchcompanydetails"></a>

```json
{
  "business_activity": "string",
  "parent_company_number": "string",
  "parent_company_name": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|business_activity|string|false|none|Type of business undertaken by the UK establishment.|
|parent_company_number|string|false|none|Parent company number.|
|parent_company_name|string|false|none|Parent company name.|

<h3 id="tocS_accountsInformation">accountsInformation</h3>
<!-- backwards compatibility -->
<a id="schemaaccountsinformation"></a>
<a id="schema_accountsInformation"></a>
<a id="tocSaccountsinformation"></a>
<a id="tocsaccountsinformation"></a>

```json
{
  "accounting_reference_date": [
    {
      "day": 0,
      "month": 0
    }
  ],
  "last_accounts": [
    {
      "made_up_to": "2020-04-08",
      "period_start_on": "2020-04-08",
      "period_end_on": "2020-04-08",
      "type": "null"
    }
  ],
  "next_accounts": [
    {
      "period_start_on": "2020-04-08",
      "period_end_on": "2020-04-08",
      "due_on": "2020-04-08",
      "overdue": true
    }
  ],
  "next_due": "2020-04-08",
  "next_made_up_to": "2020-04-08",
  "overdue": true
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|accounting_reference_date|[[accountingReferenceDate](#schemaaccountingreferencedate)]|true|none|The Accounting Reference Date (ARD) of the company.|
|last_accounts|[[lastAccounts](#schemalastaccounts)]|false|none|The last company accounts filed.|
|next_accounts|[[nextAccounts](#schemanextaccounts)]|false|none|The next company accounts filed.|
|next_due|string(date)|false|none|Deprecated. Please use next_accounts.due_on.|
|next_made_up_to|string(date)|true|none|Deprecated. Please use next_accounts.period_end_on.|
|overdue|boolean|true|none|Deprecated. Please use next_accounts.overdue|

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

<h3 id="tocS_lastAccounts">lastAccounts</h3>
<!-- backwards compatibility -->
<a id="schemalastaccounts"></a>
<a id="schema_lastAccounts"></a>
<a id="tocSlastaccounts"></a>
<a id="tocslastaccounts"></a>

```json
{
  "made_up_to": "2020-04-08",
  "period_start_on": "2020-04-08",
  "period_end_on": "2020-04-08",
  "type": "null"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|made_up_to|string(date)|true|none|Deprecated. Please use period_end_on.|
|period_start_on|string(date)|false|none|The first day of the most recently filed accounting period|
|period_end_on|string(date)|false|none|The last day of the most recently filed accounting period|
|type|string|true|none|The type of the last company accounts filed.  For enumeration descriptions see `account_type` section in the enumeration mappings.|

##### Enumerated Values

|Property|Value|
|---|---|
|type|null|
|type|full|
|type|small|
|type|medium|
|type|group|
|type|dormant|
|type|interim|
|type|initial|
|type|total-exemption-full|
|type|total-exemption-small|
|type|partial-exemption|
|type|audit-exemption-subsidiary|
|type|filing-exemption-subsidiary|
|type|micro-entity|

<h3 id="tocS_nextAccounts">nextAccounts</h3>
<!-- backwards compatibility -->
<a id="schemanextaccounts"></a>
<a id="schema_nextAccounts"></a>
<a id="tocSnextaccounts"></a>
<a id="tocsnextaccounts"></a>

```json
{
  "period_start_on": "2020-04-08",
  "period_end_on": "2020-04-08",
  "due_on": "2020-04-08",
  "overdue": true
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|period_start_on|string(date)|false|none|The first day of the next accounting period to be filed.|
|period_end_on|string(date)|false|none|The last day of the next accounting period to be filed.|
|due_on|string(date)|false|none|The date the next company accounts are due.|
|overdue|boolean|false|none|Flag indicating if the company accounts are overdue.|

<h3 id="tocS_accountPeriodFrom">accountPeriodFrom</h3>
<!-- backwards compatibility -->
<a id="schemaaccountperiodfrom"></a>
<a id="schema_accountPeriodFrom"></a>
<a id="tocSaccountperiodfrom"></a>
<a id="tocsaccountperiodfrom"></a>

```json
{
  "day": 0,
  "month": 0
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|day|integer|false|none|Day on which accounting period starts under parent law.|
|month|integer|false|none|Month in which accounting period starts under parent law.|

<h3 id="tocS_officerSummary">officerSummary</h3>
<!-- backwards compatibility -->
<a id="schemaofficersummary"></a>
<a id="schema_officerSummary"></a>
<a id="tocSofficersummary"></a>
<a id="tocsofficersummary"></a>

```json
{
  "appointed_on": "2020-04-08",
  "date_of_birth": [
    {
      "day": 0,
      "month": 0,
      "year": 0
    }
  ],
  "officer_role": "cic-manager",
  "name": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|appointed_on|string(date)|true|none|The date the officer was appointed.|
|date_of_birth|[[dateOfBirth](#schemadateofbirth)]|false|none|Details of director date of birth.|
|officer_role|string|true|none|For enumeration descriptions see `officer_role` section in the enumeration mappings.|
|name|string|true|none|Corporate or natural officer name.|

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

<h3 id="tocS_confirmationOfStatementInformation">confirmationOfStatementInformation</h3>
<!-- backwards compatibility -->
<a id="schemaconfirmationofstatementinformation"></a>
<a id="schema_confirmationOfStatementInformation"></a>
<a id="tocSconfirmationofstatementinformation"></a>
<a id="tocsconfirmationofstatementinformation"></a>

```json
{
  "last_made_up_to": "2020-04-08",
  "next_due": "2020-04-08",
  "next_made_up_to": "2020-04-08",
  "overdue": true
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|last_made_up_to|string(date)|false|none|The date to which the company last made a confirmation statement.|
|next_due|string(date)|true|none|The date by which the next confimation statement must be received.|
|next_made_up_to|string(date)|true|none|The date to which the company must next make a confirmation statement.|
|overdue|boolean|false|none|Flag indicating if the confirmation statement is overdue.|

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

<h3 id="tocS_accountingReferenceDate">accountingReferenceDate</h3>
<!-- backwards compatibility -->
<a id="schemaaccountingreferencedate"></a>
<a id="schema_accountingReferenceDate"></a>
<a id="tocSaccountingreferencedate"></a>
<a id="tocsaccountingreferencedate"></a>

```json
{
  "day": 0,
  "month": 0
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|day|integer|true|none|The Accounting Reference Date (ARD) day.|
|month|integer|true|none|The Accounting Reference Date (ARD) month.|

<h3 id="tocS_accountInformation">accountInformation</h3>
<!-- backwards compatibility -->
<a id="schemaaccountinformation"></a>
<a id="schema_accountInformation"></a>
<a id="tocSaccountinformation"></a>
<a id="tocsaccountinformation"></a>

```json
{
  "account_period_from": [
    {
      "day": 0,
      "month": 0
    }
  ],
  "account_period_to": [
    {
      "day": 0,
      "month": 0
    }
  ],
  "must_file_within": [
    {
      "months": 0
    }
  ]
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|account_period_from|[[accountPeriodFrom](#schemaaccountperiodfrom)]|false|none|Date account period starts under parent law.|
|account_period_to|[[accountPeriodTo](#schemaaccountperiodto)]|false|none|Date account period ends under parent law.|
|must_file_within|[[fileWithin](#schemafilewithin)]|false|none|Time allowed from period end for disclosure of accounts under parent law.|

<h3 id="tocS_originatingRegistry">originatingRegistry</h3>
<!-- backwards compatibility -->
<a id="schemaoriginatingregistry"></a>
<a id="schema_originatingRegistry"></a>
<a id="tocSoriginatingregistry"></a>
<a id="tocsoriginatingregistry"></a>

```json
{
  "country": "string",
  "name": "string"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|country|string|false|none|Country in which company was incorporated.|
|name|string|false|none|Identity of register in country of incorporation.|

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

<h3 id="tocS_companyProfile">companyProfile</h3>
<!-- backwards compatibility -->
<a id="schemacompanyprofile"></a>
<a id="schema_companyProfile"></a>
<a id="tocScompanyprofile"></a>
<a id="tocscompanyprofile"></a>

```json
{
  "accounts": [
    {
      "accounting_reference_date": [
        {
          "day": 0,
          "month": 0
        }
      ],
      "last_accounts": [
        {
          "made_up_to": "2020-04-08",
          "period_start_on": "2020-04-08",
          "period_end_on": "2020-04-08",
          "type": "null"
        }
      ],
      "next_accounts": [
        {
          "period_start_on": "2020-04-08",
          "period_end_on": "2020-04-08",
          "due_on": "2020-04-08",
          "overdue": true
        }
      ],
      "next_due": "2020-04-08",
      "next_made_up_to": "2020-04-08",
      "overdue": true
    }
  ],
  "annual_return": [
    {
      "last_made_up_to": "2020-04-08",
      "next_due": "2020-04-08",
      "next_made_up_to": "2020-04-08",
      "overdue": true
    }
  ],
  "can_file": true,
  "confirmation_statement": [
    {
      "last_made_up_to": "2020-04-08",
      "next_due": "2020-04-08",
      "next_made_up_to": "2020-04-08",
      "overdue": true
    }
  ],
  "company_name": "string",
  "company_number": "string",
  "date_of_creation": "2020-04-08",
  "date_of_cessation": "2020-04-08",
  "etag": "string",
  "has_been_liquidated": true,
  "has_charges": true,
  "is_community_interest_company": true,
  "subtype": "community-interest-company",
  "jurisdiction": "england-wales",
  "last_full_members_list_date": "2020-04-08",
  "foreign_company_details": [
    {
      "originating_registry": [
        {
          "country": "string",
          "name": "string"
        }
      ],
      "registration_number": "string",
      "governed_by": "string",
      "company_type": "string",
      "is_a_credit_finance_institution": true,
      "accounts": [
        {
          "account_period_from": [
            {
              "day": 0,
              "month": 0
            }
          ],
          "account_period_to": [
            {
              "day": 0,
              "month": 0
            }
          ],
          "must_file_within": [
            {
              "months": 0
            }
          ]
        }
      ],
      "business_activity": "string",
      "accounting_requirement": "string"
    }
  ],
  "registered_office_address": [
    {
      "care_of": "string",
      "address_line_1": "string",
      "address_line_2": "string",
      "country": "Wales",
      "locality": "string",
      "po_box": "string",
      "postal_code": "string",
      "premises": "string",
      "region": "string"
    }
  ],
  "sic_codes": [
    "string"
  ],
  "previous_company_names": [
    {
      "name": "string",
      "effective_from": "2020-04-08",
      "ceased_on": "2020-04-08"
    }
  ],
  "company_status": "active",
  "company_status_detail": "transferred-from-uk",
  "type": "private-unlimited",
  "external_registration_number": "string",
  "has_insolvency_history": true,
  "undeliverable_registered_office_address": true,
  "registered_office_is_in_dispute": true,
  "branch_company_details": [
    {
      "business_activity": "string",
      "parent_company_number": "string",
      "parent_company_name": "string"
    }
  ],
  "links": [
    {
      "self": "string",
      "persons_with_significant_control": "string",
      "persons_with_significant_control_statements": "string",
      "filing_history": "string",
      "officers": "string",
      "insolvency": "string",
      "charges": "string",
      "registers": "string"
    }
  ],
  "partial_data_available": "full-data-available-from-financial-conduct-authority"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|accounts|[[accountsInformation](#schemaaccountsinformation)]|false|none|Company accounts information.|
|annual_return|[[annualReturnInformation](#schemaannualreturninformation)]|false|none|Annual return information. This member is only returned if a confirmation statement has not be filed.|
|can_file|boolean|true|none|Flag indicating whether this company can file.|
|confirmation_statement|[[confirmationOfStatementInformation](#schemaconfirmationofstatementinformation)]|false|none|Confirmation statement information.|
|company_name|string|true|none|The name of the company.|
|company_number|string|true|none|The number of the company.|
|date_of_creation|string(date)|false|none|The date when the company was created.|
|date_of_cessation|string(date)|false|none|The date which the company was converted/closed or dissolved. Please refer to company status to determine which.|
|etag|string|false|none|The ETag of the resource.|
|has_been_liquidated|boolean|false|none|The flag indicating if the company has been liquidated in the past.|
|has_charges|boolean|false|none|Deprecated. Please use links.charges|
|is_community_interest_company|boolean|false|none|Deprecated. Please use subtype|
|subtype|string|false|none|The subtype of the company.|
|jurisdiction|string|true|none|The jurisdiction specifies the political body responsible for the company.|
|last_full_members_list_date|string(date)|false|none|The date of last full members list update.|
|foreign_company_details|[[foreignCompanyDetails](#schemaforeigncompanydetails)]|false|none|Foreign company details.|
|registered_office_address|[[registeredOfficeAddress](#schemaregisteredofficeaddress)]|false|none|The address of the company's registered office.|
|sic_codes|[string]|false|none|SIC codes for this company.|
|previous_company_names|[[previousCompanyNames](#schemapreviouscompanynames)]|false|none|The previous names of this company.|
|company_status|string|false|none|The status of the company.  For enumeration descriptions see `company_status` section in the enumeration mappings.|
|company_status_detail|string|false|none|Extra details about the status of the company.  For enumeration descriptions see `company_status_detail` section in the enumeration mappings.|
|type|string|true|none|The type of the company.  For enumeration descriptions see `company_type` section in the enumeration mappings.|
|external_registration_number|string|false|none|The number given by an external registration body.|
|has_insolvency_history|boolean|false|none|Deprecated. Please use links.insolvency|
|undeliverable_registered_office_address|boolean|false|none|Flag indicating whether post can be delivered to the registered office.|
|registered_office_is_in_dispute|boolean|false|none|Flag indicating registered office address as been replaced.|
|branch_company_details|[[branchCompanyDetails](#schemabranchcompanydetails)]|false|none|UK branch of a foreign company.|
|links|[[linksType](#schemalinkstype)]|true|none|A set of URLs related to the resource, including self.|
|partial_data_available|string|false|none|Returned if Companies House is not the primary source of data for this company.  For enumeration descriptions see `partial_data_available` section in the enumeration mappings.|

##### Enumerated Values

|Property|Value|
|---|---|
|subtype|community-interest-company|
|subtype|private-fund-limited-partnership|
|jurisdiction|england-wales|
|jurisdiction|wales|
|jurisdiction|scotland|
|jurisdiction|northern-ireland|
|jurisdiction|european-union|
|jurisdiction|united-kingdom|
|jurisdiction|england|
|jurisdiction|noneu|
|company_status|active|
|company_status|dissolved|
|company_status|liquidation|
|company_status|receivership|
|company_status|administration|
|company_status|voluntary-arrangement|
|company_status|converted-closed|
|company_status|insolvency-proceedings|
|company_status_detail|transferred-from-uk|
|company_status_detail|active-proposal-to-strike-off|
|company_status_detail|petition-to-restore-dissolved|
|company_status_detail|transformed-to-se|
|company_status_detail|converted-to-plc|
|type|private-unlimited|
|type|ltd|
|type|protected-cell-company|
|type|plc|
|type|old-public-company|
|type|private-limited-guarant-nsc-limited-exemption|
|type|limited-partnership|
|type|private-limited-guarant-nsc|
|type|converted-or-closed|
|type|private-unlimited-nsc|
|type|private-limited-shares-section-30-exemption|
|type|assurance-company|
|type|oversea-company|
|type|eeig|
|type|icvc-securities|
|type|icvc-warrant|
|type|icvc-umbrella|
|type|industrial-and-provident-society|
|type|northern-ireland|
|type|northern-ireland-other|
|type|llp|
|type|royal-charter|
|type|investment-company-with-variable-capital|
|type|unregistered-company|
|type|other|
|type|european-public-limited-liability-company-se|
|type|scottish-partnership|
|type|charitable-incorporated-organisation|
|type|scottish-charitable-incorporated-organisation|
|type|further-education-or-sixth-form-college-corporation|
|partial_data_available|full-data-available-from-financial-conduct-authority|
|partial_data_available|full-data-available-from-department-of-the-economy|
|partial_data_available|full-data-available-from-the-company|

<h3 id="tocS_fileWithin">fileWithin</h3>
<!-- backwards compatibility -->
<a id="schemafilewithin"></a>
<a id="schema_fileWithin"></a>
<a id="tocSfilewithin"></a>
<a id="tocsfilewithin"></a>

```json
{
  "months": 0
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|months|integer|false|none|Number of months within which to file.|

<h3 id="tocS_accountsRequired">accountsRequired</h3>
<!-- backwards compatibility -->
<a id="schemaaccountsrequired"></a>
<a id="schema_accountsRequired"></a>
<a id="tocSaccountsrequired"></a>
<a id="tocsaccountsrequired"></a>

```json
{
  "foreign_account_type": "accounting-requirements-of-originating-country-apply",
  "terms_of_account_publication": "accounts-publication-date-supplied-by-company"
}

```

#### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|foreign_account_type|string|false|none|Type of accounting requirement that applies.  For enumeration descriptions see `foreign_account_type` section in the enumeration mappings.|
|terms_of_account_publication|string|false|none|Describes how the publication date is derived.  For enumeration descriptions see `terms_of_account_publication` section in the enumeration mappings.|

##### Enumerated Values

|Property|Value|
|---|---|
|foreign_account_type|accounting-requirements-of-originating-country-apply|
|foreign_account_type|accounting-requirements-of-originating-country-do-not-apply|
|terms_of_account_publication|accounts-publication-date-supplied-by-company|
|terms_of_account_publication|accounting-publication-date-does-not-need-to-be-supplied-by-company|
|terms_of_account_publication|accounting-reference-date-allocated-by-companies-house|

<h3 id="tocS_registeredOfficeAddress">registeredOfficeAddress</h3>
<!-- backwards compatibility -->
<a id="schemaregisteredofficeaddress"></a>
<a id="schema_registeredOfficeAddress"></a>
<a id="tocSregisteredofficeaddress"></a>
<a id="tocsregisteredofficeaddress"></a>

```json
{
  "care_of": "string",
  "address_line_1": "string",
  "address_line_2": "string",
  "country": "Wales",
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
|care_of|string|false|none|The care of name.|
|address_line_1|string|false|none|The first line of the address.|
|address_line_2|string|false|none|The second line of the address.|
|country|string|false|none|The country.|
|locality|string|false|none|The locality e.g London.|
|po_box|string|false|none|The post-office box number.|
|postal_code|string|false|none|The postal code e.g CF14 3UZ.|
|premises|string|false|none|The property name or number.|
|region|string|false|none|The region e.g Surrey.|

##### Enumerated Values

|Property|Value|
|---|---|
|country|Wales|
|country|England|
|country|Scotland|
|country|Great Britain|
|country|Not specified|
|country|United Kingdom|
|country|Northern Ireland|


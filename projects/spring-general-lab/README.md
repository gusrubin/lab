# Getting Started

### Reference Documentation

Freezing procedure for test in Oracle Database:

```
CREATE OR REPLACE PROCEDURE DEVELOPER.generate_message_freezing
    (request_id in varchar, generated_message out clob)
    
AS

BEGIN
	DBMS_SESSION.Sleep(10);

    generated_message := '{ "attribute": "value" }';

END generate_message_freezing;
```



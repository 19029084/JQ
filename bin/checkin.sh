#!/bin/bash

cp ../target/jq-0.0.1-SNAPSHOT.jar ../../jqkf_backend/bin/

cp ../src/main/resources/data.xml ../../jqkf_backend/

sudo mysqldump -B JQ > ../../jqkf_backend/db.sql



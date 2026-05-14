# Spring Batch Billing Job

Spring Batch application that processes billing data from CSV files, calculates billing totals, and generates reporting files using chunk-oriented batch processing with retry and fault-tolerance support.

## Build and Run

### PostgreSQL Setup

Download the PostgreSQL image:
```bash
docker pull postgres:14.1-alpine
```
Start the PostgreSQL container:
```bash
docker run --name postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=postgres -p 5432:5432 -d postgres:14.1-alpine
```
Connect to PostgreSQL:
```bash
docker exec -it postgres psql -U postgres -d postgres
```

### Database Initialization

Drop existing Spring Batch tables:
```bash
Get-Content src/main/resources/schema-drop-postgresql.sql | docker exec -i postgres psql -U postgres -d postgres
```
Create Spring Batch metadata tables:
```bash
Get-Content src/main/resources/schema-postgresql.sql | docker exec -i postgres psql -U postgres -d postgres
```
Create billing tables:
```bash
Get-Content src/main/resources/schema-billing.sql | docker exec -i postgres psql -U postgres -d postgres
```

### Build

Build the project without running tests:
```bash
./mvnw install "-Dmaven.test.skip=true"
```
Run tests without automatically starting batch jobs:
```bash
./mvnw clean test "-Dspring.batch.job.enabled=false"
```

### Example Execution

Execute the batch job:
```bash
java -jar target/billing-job-0.0.1-SNAPSHOT.jar input.file=input/billing-2023-01.csv output.file=staging/billing-report-2023-01.csv data.year=2023 data.month=1
```

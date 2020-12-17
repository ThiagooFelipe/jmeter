# Gravacao de CSV com Java

```java
try (CSVPrinter csvPrinter = new CSVPrinter(bufferedWriter, autoChoiseParseFileFormat(PARSE_SPEC).withAutoFlush(true).withHeader().withDelimiter(',').withFirstRecordAsHeader().withNullString("null"))){
```

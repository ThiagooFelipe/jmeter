# Gravacao de CSV com Java

## Refs

[Link ref](https://spring.io/blog/2015/02/23/better-dependency-management-for-gradle)

## Processos

```java
try (CSVPrinter csvPrinter = new CSVPrinter(bufferedWriter, autoChoiseParseFileFormat(PARSE_SPEC).withAutoFlush(true).withHeader().withDelimiter(',').withFirstRecordAsHeader().withNullString("null"))){
```

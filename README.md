# MySQL Connector/J

[![GitHub top language](https://img.shields.io/github/languages/top/mysql/mysql-connector-j.svg?color=5382a1)](https://github.com/mysql/mysql-connector-j/tree/release/8.0/src) [![License: GPLv2 with FOSS exception](https://img.shields.io/badge/license-GPLv2_with_FOSS_exception-c30014.svg)](LICENSE) [![Maven Central](https://img.shields.io/maven-central/v/mysql/mysql-connector-java.svg)](https://search.maven.org/artifact/mysql/mysql-connector-java/8.0.23/jar)

The driver also contains an implementation of [MySQL X DevAPI](https://dev.mysql.com/doc/x-devapi-userguide/en/), an application programming interface for working with [MySQL as a Document Store](https://dev.mysql.com/doc/refman/8.0/en/document-store.html) through CRUD-based, NoSQL operations.


## Licensing

Please refer to the [README](README) and [LICENSE](LICENSE) files, available in this repository, and the [Legal Notices in the Connector/J documentation](https://dev.mysql.com/doc/connector-j/8.0/en/preface.html) for further details.

## Working

Add below code in 
**scala_project/build.sbt file**

```
unmanagedResourceDirectories in Compile += {baseDirectory.value / "lib"}
```

Make sure jar file is present in folder 


**scala_project/lib/mysql-connector-java-8.0.23-SNAPSHOT.jar**

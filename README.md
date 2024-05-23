# PerfLab_JavaHomework_IvanovIS
Jar библитекf находится в папке src/lib. Можно добавить зависимость через intellij idea: 
project structure -> modules -> dependencies -> + ->  src/lib/Jar файл -> apply -> ok 
или можно прописать в pom следующую зависисмость:
```xml
<dependencies>
    <dependency>
        <groupId>ru.pflb.mq.dummy</groupId>
        <artifactId>dummy-connector</artifactId>
        <version>1.0</version>
    </dependency>
</dependencies>
Я ее не стал добавлять, только потому, что при скачивании с репозитория пропадают коментарии кода, но при добаленнии кода после скачивания все работает нормально

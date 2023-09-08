```
spring init -d=web,thymeleaf,mysql,data-jpa,lombok,devtools addressapp
```

```
mysql -uroot -e 'CREATE DATABASE sbtest'
mysql -uroot -D sbtest < db.sql
```
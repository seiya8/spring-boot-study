- データベース、テーブル作成

    ```
    mysql -uroot -e 'CREATE DATABASE sbtest;'
    mysql -uroot -D sbtest < data.sql
    ```

- 起動

    ```
    gradle bootRun
    ```

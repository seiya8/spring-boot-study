- データベース、テーブル作成

    ```
    mysql -uroot -e 'CREATE DATABASE sbtest;'
    mysql -uroot -p sbtest < data.sql
    ```

- 起動

    ```
    gradle bootRun
    ```

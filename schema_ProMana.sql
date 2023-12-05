-- ユーザーテーブル
DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE IF NOT EXISTS users
(
   id SERIAL PRIMARY KEY,
   username VARCHAR (50) NOT NULL,
   password VARCHAR (255) NOT NULL
);
-- lines テーブル クエリの起点となるテーブル
DROP TABLE IF EXISTS lines CASCADE;
CREATE TABLE IF NOT EXISTS lines
(
   id SERIAL PRIMARY KEY,
   name VARCHAR (50) NOT NULL,
   product_name VARCHAR (50) NOT NULL,
   case_count_per_hour INT NOT NULL,
   created_at TIMESTAMP NOT NULL,
   updated_at TIMESTAMP NOT NULL
);
-- plans 製造計画テーブル
DROP TABLE IF EXISTS plans CASCADE;
CREATE TABLE IF NOT EXISTS plans
(
   id SERIAL PRIMARY KEY,
   planned_case_count INT,
   lines_id LONG,
   created_at TIMESTAMP NOT NULL,
   updated_at TIMESTAMP NOT NULL,
   FOREIGN KEY (lines_id) REFERENCES lines (id)
);
-- produced_cases 製造済みケース数テーブル
DROP TABLE IF EXISTS produced_case_counts CASCADE;
CREATE TABLE IF NOT EXISTS produced_case_counts
(
   id SERIAL PRIMARY KEY,
   lines_id LONG,
   count INT,
   created_at TIMESTAMP NOT NULL,
   updated_at TIMESTAMP NOT NULL,
   FOREIGN KEY (id) REFERENCES lines (id)
);
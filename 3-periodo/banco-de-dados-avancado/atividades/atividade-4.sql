use db_stackoverflow ;
describe posts ;

# exemplo
select * from posts limit 5 ;

## 01
# a)
select * from posts where id = 3 ;

# b)
explain select * from posts where id = 3 ;

# c)
CREATE INDEX idx_id ON posts (id) ;

# d)
select * from posts where id = 3 ;

# e)
explain select * from posts where id = 3 ;

# f)
drop index idx_id on posts ;

# g)
CREATE UNIQUE INDEX idx_id_unique ON posts(Id) ;

# h)
explain select * from posts where id = 3 ;
SHOW INDEX FROM posts WHERE Column_name = 'Id' ;

## 02
# a)
select * from posts where owneruserid in (3993,96,770254) ;

# b)
explain select * from posts where owneruserid in (3993,96,770254) ;

# c)
CREATE INDEX idx_owner_user_id ON posts (OwnerUserID) ;

# d)
select * from posts where owneruserid in (3993,96,770254) ;

# e)
explain select * from posts where owneruserid in (3993,96,770254) ;


## 3
SELECT *
FROM posts
WHERE lower(title) LIKE '%rest %' ; 

CREATE INDEX idx_title_lower ON posts ((CAST(LOWER(title) AS CHAR(255)))) ;

SELECT *
FROM posts
WHERE lower(title) LIKE '%rest %' ; 

## 4
SELECT Count(*),year(creationDate)
FROM posts
WHERE AnswerCount > 4
AND PostTypeID = 1
GROUP BY year(creationDate) ;

CREATE INDEX idx_posts_filters ON posts (PostTypeID, AnswerCount, creationDate) ;

## 5
SELECT * FROM posts WHERE Score > 100 AND ViewCount > 10000 ;

CREATE INDEX idx_score_viewcount ON posts (Score DESC, ViewCount DESC) ;

EXPLAIN SELECT * FROM posts WHERE Score > 100 AND ViewCount > 10000 ;


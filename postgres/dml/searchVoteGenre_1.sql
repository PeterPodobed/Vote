select max(genre_1) as max,
count(genre_1)
from vote
group by (genre_1)



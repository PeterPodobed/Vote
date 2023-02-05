select max(artist),
count(artist) as count
from vote
group by (artist)
order by count desc
limit 1

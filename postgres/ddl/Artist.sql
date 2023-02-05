<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> dd5461a2633fecada107e5187a47f100e75071d0
SELECT
MAX(artist),
COUNT(artist)

FROM public.vote
GROUP BY (artist)
<<<<<<< HEAD
order by Count desc
=======
SELECT MAX(ARTIST) AS MAX,
	COUNT(ARTIST)
FROM VOTE
GROUP BY (ARTIST)
ORDER BY COUNT DESC
LIMIT 1
>>>>>>> db24eef (third)
=======
order by Count desc
>>>>>>> dd5461a2633fecada107e5187a47f100e75071d0

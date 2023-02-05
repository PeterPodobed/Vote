<<<<<<< HEAD
SELECT
MAX(artist),
COUNT(artist)

FROM public.vote
GROUP BY (artist)
order by Count desc
=======
SELECT MAX(ARTIST) AS MAX,
	COUNT(ARTIST)
FROM VOTE
GROUP BY (ARTIST)
ORDER BY COUNT DESC
LIMIT 1
>>>>>>> db24eef (third)

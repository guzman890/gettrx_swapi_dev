SELECT T.YEAR_GET, T.month_GET, min(T.customerid), max(TOTAL_AMOUNT_MAX)
FROM(
	SELECT 
		EXTRACT('YEAR' FROM orderdate) AS YEAR_GET,
		EXTRACT('month' FROM orderdate) AS month_GET,
		MIN(customerid) AS customerid, 
		MAX(TOTAL_AMOUNT) AS TOTAL_AMOUNT_MAX
	FROM orders as E
	INNER JOIN 
		(SELECT d.orderid, SUM(d.unitprice*d.quantity) as TOTAL_AMOUNT 
		FROM public.order_details as d
		GROUP BY orderid) 
	as D
	ON E.orderid = D.orderid
	GROUP BY month_GET,YEAR_GET,customerid
	order by YEAR_GET,month_GET
) AS T
GROUP BY YEAR_GET, month_GET
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">
.submitted {
	font-family: Arial, Helvetica, sans-serif;
	color: #6F9;
	background-color: #F00;
	float: left;
	height: 10%;
	width: 50%;
}
</style>
</head>

<body>

<?php

echo $_POST["shop_name"];
echo $_POST["shop_address"];
echo $_POST["shop_email"];
echo $_POST["shop_telephone"];
echo $_POST["shop_description"];
echo $_POST["shop_longitude"];
echo $_POST["shop_latitude"];

echo" <div class=\"submitted\" id=\"submitted\">Submitted!</div>";


 ?>
<div class="error">sdsds</div>
</body>
</html>
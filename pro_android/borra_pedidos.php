<?php
$link = mysql_connect('localhost', 'root', '');
if (!$link) {
    die('No se pudo conectar: ' . mysql_error());
}
mysql_select_db("cafeteria");

//Recojo las variables que he pasado por el enlace
$a=$_GET["id_pedido"];

//Realizo el update
$q ="DELETE FROM pedidos WHERE id_pedido='".$a."';";
mysql_query($q);

//cierro la base de datos
mysql_close($link);

//Redirecciono de vuelta a index.php
header('Location: /pro_android/index.php');

?>

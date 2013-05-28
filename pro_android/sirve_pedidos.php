<?php
date_default_timezone_set('UTC');
$link = mysql_connect('localhost', 'root', '');
if (!$link) {
    die('No se pudo conectar: ' . mysql_error());
}
mysql_select_db("cafeteria");

//Recojo las variables que he pasado por el enlace
$a=$_GET["id_pedido"];
$var1=$_GET["var1"];
$var2=$_GET["var2"];
$var3=$_GET["var3"];

//Los elseif me estan dando bastantes problemas asi que no tengo mas remedio que hacerlo asi:
if (isset($var1)){
	//Realizo el update
	$q ="UPDATE pedidos SET estado='servido' WHERE id_pedido='".$a."';";
	mysql_query($q);
} 
if (isset($var2)){
	//Realizo el delete
	$q ="DELETE FROM pedidos WHERE id_pedido='".$a."';";
	mysql_query($q);
}
if(isset($var3)){
	$q="SELECT pedido,id_mesa,id_pedido FROM pedidos WHERE estado='servido';";
	$consulta=mysql_query($q);
		while($row = mysql_fetch_array($consulta)){
			$c="INSERT INTO historico_pedidos (pedido,id_mesa) VALUES ('".$row['pedido']."','".$row['id_mesa']."')";
			mysql_query($c);	
			
			$d="DELETE FROM pedidos WHERE id_pedido='".$row['id_pedido']."'";
			mysql_query($d);
		}
}

//cierro la base de datos
mysql_close($link);

//Redirecciono de vuelta a index.php
header('Location: /pro_android/index.php');

?>

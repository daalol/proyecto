<?php
$pedido = $_POST['Pedido'];
$pass = $_POST['Contrasena'];

$link = mysql_connect('localhost', 'root', '');
if (!$link) {
    die('No se pudo conectar: ' . mysql_error());
}

mysql_select_db("cafeteria");

$q = mysql_query("SELECT id_mesa, password  FROM contrasenas WHERE password='{$pass}' ");

/*while($a=mysql_fetch_assoc($q))
				mysql_query("INSERT INTO pedidos (pedido,estado,id_mesa) VALUES ('".$pedido."','nuevo','".$a['id_mesa']."')");*/

while($e=mysql_fetch_assoc($q)){
			  $a=$e['id_mesa'];
              $output[]=$e;
				}
     print(json_encode($output));

	 if(isset($a)){
			mysql_query("INSERT INTO pedidos (pedido,estado,id_mesa) VALUES ('".$pedido."','nuevo','".$a."')");
	 }
mysql_close($link);
?>

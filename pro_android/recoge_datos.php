<?php
$pedido = $_POST['Pedido'];
$pass = $_POST['Contrasena'];

$link = mysql_connect('localhost', 'root', '');
if (!$link) {
    die('No se pudo conectar: ' . mysql_error());
}

mysql_select_db("cafeteria");

$q = mysql_query("SELECT password, id_mesa FROM contrasenas WHERE password='{$pass}' ");

while($e=mysql_fetch_assoc($q)){
				mysql_query("INSERT INTO pedidos (pedido,estado,id_mesa) VALUES ('".$pedido."','nuevo','".$e['id_mesa']."')");
              $output[]=$e;
}
      print(json_encode($output));

mysql_close($link);
?>

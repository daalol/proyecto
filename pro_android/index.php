<html>
<?php  

  $link = mysql_connect('localhost', 'root', '');
		if (!$link) {
			die('No se pudo conectar: ' . mysql_error());
		}          
			mysql_select_db("cafeteria");

  $query1 = "SELECT * FROM pedidos WHERE estado='nuevo'; ";
  $query2 = "SELECT * FROM pedidos WHERE estado='servido'; ";
	  
  $mesasNuevas = mysql_query($query1);
  $mesasServidas = mysql_query($query2);
  //fin conexion y consultas iniciales

  ?>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Cafeteria & heladeria, Panel de control</title></head>

<!-- estilo de la pagina-->
<style type="text/css">
#td1{	
	width:70%;
}
#td2 {
	width:15%;
}
</style>
		
<body background="fondo8.png">

<center><h1>Cafeteria & heladeria</h1></center>
    <div style=" padding: 0px 50px 50px 50px;">
            <center><h3>Pedidos:</h3></center>
					<div style=" height:80%; width:100%; background-color:#a6c53b;">
						<div style="overflow-y: scroll; height:50%;">
							<table border="1" style="font-size: 14pt;">
							<br></br>
								<tr>
									<td><b>Pedidos pendientes:</b></td><td><b>Mesa:</b></td><td><b>Estado:</b></td>
								</tr>
									<?php
										while($row = mysql_fetch_array($mesasNuevas)){
											echo "<tr><td id='td1'>".$row['pedido']."</td><td id='td2'>".$row['id_mesa']."</td><td id='td2'>".$row['estado'].
											"</td><td id='td2'><a href='sirve_pedidos.php?id_pedido=".$row['id_pedido']."&var1=terminado'>Terminado!!!</a></td></tr>";
										}
									?>
							</table>
						</div>
						<div style="overflow-y: scroll; height:50%;">
						<table border="1" style="font-size: 14pt;">
							<tr>
								<td><b>Pedidos terminados:</b></td><td><b>Mesa:</b></td><td><b>Estado:</b></td>
							</tr>
								<?php
									while($row = mysql_fetch_array($mesasServidas)){
										echo "<tr><td id='td1'>".$row['pedido']."</td><td id='td2'>".$row['id_mesa']."</td><td id='td2'>".$row['estado'].
										"</td><td id='td2'><a href='sirve_pedidos.php?id_pedido=".$row['id_pedido']."&var2=borrado'>Borrar!!!</a></td></tr>";
									}
								?>
						</table>
						<center><a href='sirve_pedidos.php?var3=historico'>Limpiar registro de mesas servidas</a></center>
						</div>
						
					</div>     					
    </div>
</body>
<!-- Cierro la conexion -->
<?php   mysql_close($link); ?>
</html>

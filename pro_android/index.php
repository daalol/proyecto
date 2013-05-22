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

<style type="text/css">
<!--
#td1{	
	width:700px;
}
#td2 {
	width:75px;
}

-->
        </style>
		
<body background="fondo8.png">

<center><h1>Cafeteria & heladeria</h1></center>
    <div style=" padding: 15px 50px 50px 50px;">
        <div style=" height:100%; width:100%; background-color:#fff444;">
            <center><h3>Pedidos:</h3></center>
				<div style=" padding: 0px 50px 50px 50px;">
					<div style=" height:90%; width:100%; background-color:#444fff;">
						<table border="1" style="font-size: 14pt">
							<tr>
								<td><b>Pedidos pendientes:</b></td><td><b>Mesa:</b></td><td><b>Estado:</b></td>
							</tr>
								<?php
									while($row = mysql_fetch_array($mesasNuevas)){
										echo "<tr><td id='td1'>".$row['pedido']."</td><td id='td2'>".$row['id_mesa']."</td><td id='td2'>".$row['estado'].
										"</td><td id='td2'><a href='sirve_pedidos.php?pedido=".urlencode($row['pedido'])."&id_mesa=".$row['id_mesa']."'>Terminado!!!</a></td></tr><br></br>";
									}
								?>
						</table>
						<br></br>
						<table border="1" style="font-size: 14pt">
							<tr>
								<td><b>Pedidos terminados:</b></td><td><b>Mesa:</b></td><td><b>Estado:</b></td>
							</tr>
								<?php
									while($row = mysql_fetch_array($mesasServidas)){
										echo "<tr><td id='td1'>".$row['pedido']."</td><td id='td2'>".$row['id_mesa']."</td><td id='td2'>".$row['estado']."</td></tr><br></br>";
									}
								?>
						</table>
					</div>
				</div>
				<!--<div style="float:right; height:80%; width:19%; background-color:#ffffff;">
					<table>	
						<td>
							<tr>Aqui va el estado/botones de "pedido realizado" o algo similar</tr>
						<td>
					</table>
				</div>-->
           
        </div>
    </div>
<table>

</table>
</body>
<?php   mysql_close($link); ?>
</html>

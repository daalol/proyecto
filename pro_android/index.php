<html>
<?php  
  $link = mysql_connect('localhost', 'root', '');
		if (!$link) {
			die('No se pudo conectar: ' . mysql_error());
		}          
			mysql_select_db("cafeteria");

  $query = "SELECT * FROM pedidos; ";
	  
  $result = mysql_query($query);
  ?>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Cafeteria & heladeria, Panel de control</title></head>
<body background="fondo8.png">
<center><h1>Cafeteria & heladeria</h1></center>
    <div style=" padding: 15px 50px 50px 50px;">
        <div style=" height:100%; width:100%; background-color:#fff444;">
            <center><h3>Pedidos pendientes:</h3></center>
				<div style="padding-left:5px; height:90%; width:95%; background-color:#444fff;">
					<table border="1" style="font-size: 16pt">
							<?php
								while($row = mysql_fetch_array($result)){
									echo "<tr><td>".$row['pedido']."</tr></td><br></br>";
								}
							?>
					</table>
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

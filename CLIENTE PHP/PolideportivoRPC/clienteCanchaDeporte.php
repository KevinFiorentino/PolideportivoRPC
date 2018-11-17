<?php
	// Setea el path a las librerías de Thrift
	$GLOBALS['THRIFT_ROOT'] = 'Thrift';
	  
	//Carga automáticamente las clases requeridas
	 function __autoload($classname) {
		$directories = glob("Thrift" . '/*' , GLOB_ONLYDIR);
		$found = false;
		$i = 0;
		while (!$found && $i < count($directories)){
			$dir = $directories[$i];
			$filename = str_replace("\\", "/", "./" . $classname . ".php");
			if(file_exists( $filename ))
			{
				$found = true;
				require_once($filename);
			}else{
				$i++;
			}
		}
	}

	require_once 'PoliService.php'; 
	require_once 'Types.php'; 
	use Thrift\Exception\TException;
	use Thrift\Transport\TSocket;
	use Thrift\Protocol\TBinaryProtocol;
	use Thrift\Transport\TBufferedTransport;
	use poli\PoliServiceClient;
	use poli\Turno;
	try {
		// Crea una conexión con el servidor
		$socket = new TSocket('localhost', '9090');
		$socket->setRecvTimeout(10*1000); //Timeout de espera
		$transport = new TBufferedTransport($socket);
		$protocol = new TBinaryProtocol($transport);
	 
		// Creamos un cliente
		$client = new PoliServiceClient($protocol);

		// Abrimos la conexión
		$transport->open();
	 
		$deporte = $_POST['deporte'];
		$resultado = $client->traerCanchasPorDeporte($deporte);
?>

<html>
	<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Distribuidos 2018 - Trabajo Practico RPC">
    <meta name="author" content="Fiorentino - Violi">

    <title>Distribuidos 2018</title>

    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/Distribuidos.css">
    
    <link rel="stylesheet" href="assets/css/datatables.min.css">
    <link rel="stylesheet" href="assets/css/jquery.dataTables.min.css">
    
</head>  

<!-- Barra de Navegacion -->
<nav class="navbar navbar-expand-xl bg-dark navbar-dark">
<ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="index.php">Turnos por Filial</a>
    </li>
    <li class="nav-item">
	      <a class="nav-link" href="turnoId.php">Turno por Id</a>
    </li>
    <li class="nav-item">
       <a class="nav-link" href="telefonoUsuario.php">Telefono por Usuario</a>
    </li>
    <li class="nav-item">
     <a class="nav-link" href="canchaId.php">Traer Cancha</a>
    </li>
	<li class="nav-item active">
     <a class="nav-link" href="canchaDeporte.php">Canchas por Deporte</a>
    </li>
	<li class="nav-item">
     <a class="nav-link" href="canchaLocalidad.php">Localidad de Filial</a>
    </li>
  </ul>
</nav>
<!-- Fin Barra de Navegacion -->

	<body>
		<br><br>	
		
		<div class="container">
		<div class="panel-group">
			<div class="panel panel-primary">
  				<div class="panel-body">
            		<div class="tab-content col-sm-12">
					
		<?php
			echo "<h1> Canchas de $deporte </h1> <br/>"; ?>
			<table class="table"> <?php
			echo "<thead>";
			echo "<tr><th>localidad</th><th>ID Filial</th><th>Tipo Cancha</th><th>ID Cancha</th><th>Deporte</th></tr>";
			echo "</thead><tbody>";
				
			foreach ($resultado as $cancha){
				echo "<tr>";
				echo "<td>" . $cancha->localidad . "</td>";
				echo "<td>" . $cancha->idFilial . "</td>";
				echo "<td>" . $cancha->tipoCancha . "</td>";
				echo "<td>" . $cancha->idCancha . "</td>";
				echo "<td>" . $cancha->deporte . "</td>";
				echo "</tr>";
			}
			echo "</tbody></table>";
		} catch (TException $tx) {
			// Excepción propia de Thrift (falló en la conexión, timeout, etc.)
			echo "ThriftException: ".$tx->getMessage()."\r\n";
		} finally{
			// Cerramos la conexión
			$transport->close();
		}
		?>
		
			</div>
    			</div>
    		</div>
    	</div>
    </div>
    
    <br><br><br>
	
	</body>
	
	
<!-- Footer -->
	<section id="footer">
		<div class="container">
			
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-2 text-center text-white">
					<p>Desarrollo de Software en Sistemas Distribuidos 2018 - Universidad Nacional de Lan&uacute;s</p>
					<p class="h6">Fiorentino, Kevin / Violi, Pablo</p>
				</div>
			</div>	
			
		</div>
	</section>
</html>
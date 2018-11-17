<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Distribuidos 2018 - Trabajo Practico RPC">
    <meta name="author" content="Fiorentino - Violi">

    <title>Distribuidos 2018</title>

    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/Distribuidos.css">
    
    
</head>  

<!-- Barra de Navegacion -->
<nav class="navbar navbar-expand-xl bg-dark navbar-dark">
<ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="index.php">Turnos por Filial</a>
    </li>
    <li class="nav-item active">
	      <a class="nav-link" href="turnoId.php">Turno por Id</a>
    </li>
    <li class="nav-item">
       <a class="nav-link" href="telefonoUsuario.php">Telefono por Usuario</a>
    </li>
       <li class="nav-item">
     <a class="nav-link" href="canchaId.php">Traer Cancha</a>
    </li>
	<li class="nav-item">
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
					
		<h3> Consultar turno por idTurno </h3>
		<br>
		<form action="clienteTurnoId.php" method="POST" class="form-inline">
			<label>Identidad Turno : &nbsp; </label><input type="number" class="form-control" name="idTurno" value=""/>
			<span style="padding-right:50px;"></span>
			<button type="submit" value="Consultar" class="btn btn-default">Consultar</button>
		</form>
		
			</div>
    			</div>
    		</div>
    	</div>
    </div>
    
    <br><br><br>
	
	</body>
	

<!-- Footer -->
<br>
<br>
<br>
<br>
<br>
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
<!-- ./Footer -->
</html>
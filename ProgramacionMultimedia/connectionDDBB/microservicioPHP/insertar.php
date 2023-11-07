<?php

include 'conexion.php';

$nombre=$_POST['nombre'];
$apellido=$_POST['apellido'];
$telefono=$_POST['telefono'];

$sql = "INSERT INTO contactos (nombre, apellido, telefono) values ('".$nombre."', '".$apellido."', '".$telefono."')";

mysqli_query($conexion, $sql) or die(mysqli_error());
mysqli_close($conexion);

?>
<?php

include 'conexion.php';

$nombre=$_POST['nombre'];
$apellido=$_POST['apellido'];
$telefono=$_POST['telefono'];

$sql = "DELETE FROM contactos WHERE nombre='".$nombre."' AND apellido='".$apellido."' AND telefono='".$telefono."'";
mysqli_query($conexion, $sql) or die(mysqli_error());
mysqli_close($conexion);

?>
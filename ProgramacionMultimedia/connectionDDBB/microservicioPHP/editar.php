<?php

include 'conexion.php';

$nombre=$_POST['nombre'];
$apellido=$_POST['apellido'];
$telefono=$_POST['telefono'];

$sql = "UPDATE contactos SET telefono='".$telefono."' WHERE nombre='".$nombre."' AND apellido='".$apellido."'";

mysqli_query($conexion, $sql) or die(mysqli_error());
mysqli_close($conexion);

?>
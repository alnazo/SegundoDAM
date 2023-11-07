<?php

include 'conexion.php';

if(isset($_GET['id'])){
    $id = $_GET['id'];
    $sql = "SELECT * FROM contactos WHERE id='$id'";
} else {
    $sql = "SELECT * FROM contactos";
}

$resultado = $conexion->query($sql);

while($fila = $resultado->fetch_array(MYSQLI_ASSOC)){
    $contactos[] = array_map('utf8_encode', $fila);
}

echo json_encode($contactos);
$resultado->close();

?>
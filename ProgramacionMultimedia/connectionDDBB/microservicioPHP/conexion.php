<?php

$hostname="localhost";
$database="springdbc";
$username="root";
$password="Antonio";

$conexion = new MySQLi($hostname, $username, $password, $database);
if ($conexion->connect_error){
    echo "error al conectar";
}

?>
<?php
require_once '../controlador/Usuarioscontroller.php';
$controller = new Usuarioscontroller();
$socios = $controller->listarUsuario();
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Listado de Usuarios</title>
</head>
<body>
    <h1>Usuarios Registrados</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido1</th>
            <th>Apellido2</th>
            <th>Email</th>
            <th>Edad</th>
            <th>Acciones</th>
        </tr>
        <?php foreach ($usuarios as $usuario): ?>
            <tr>
                <td><?= $usuario['id_socio'] ?></td>
                <td><?= $usuario['nombre'] ?></td>
                <td><?= $usuario['apellido1'] ?></td>
                <td><?= $usuario['apellido2'] ?></td>
                <td><?= $usuario['email'] ?></td>
                <td><?= $usuario['edad'] ?></td>
                <td>
                    <a href="editar_usuario.php?id=<?= $usuario['id_socio'] ?>">Editar</a>
                    <a href="eliminar_usuario.php?id=<?= $usuario['id_socio'] ?>">Eliminar</a>
                </td>
            </tr>
        <?php endforeach; ?>
    </table>
    <br>
    <a href="alta_usuario.php">Agregar un nuevo usuario</a>
</body>
</html>
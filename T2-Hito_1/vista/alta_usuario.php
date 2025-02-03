<?php
require_once '../controlador/Usuarioscontroller.php';
$controller = new Usuarioscontroller();
$socios = $controller->listarUsuario();
?>

<div class="card mt-4">
    <div class="card-header">
        <h5>Agregar Socio</h5>
    </div>
    <div class="card-body">
        <form action="../controlador/SociosController.php?action=guardar" method="POST">
            <div class="form-group">
                <label for="nombre">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="nombre" required>
            </div>
            <div class="form-group">
                <label for="apellido1">Apellido1</label>
                <input type="text" class="form-control" id="apellido1" name="apellido1" required>
            </div>
            <div class="form-group">
                <label for="apellido2">Apellido2</label>
                <input type="text" class="form-control" id="apellido2" name="apellido2" required>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="edad">Edad</label>
                <input type="text" class="form-control" id="edad" name="edad" required>
            </div>
            <button type="submit" class="btn btn-primary">Agregar Usuario</button>
            <a href="index.php?action=lista" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
</div>
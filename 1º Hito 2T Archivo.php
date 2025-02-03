<?php
header("Location: vista/lista_usuarios.php");
exit();
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>1º Hito 2T - Usuarios</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-4">Gestión de Usuarios</h1>
    
        <?php
        if (isset($_GET['action'])) {
            $action = $_GET['action'];
            if ($action == 'alta') {
                include 'vista/alta_Usuarios.php';
            } elseif ($action == 'lista') {
                include 'vista/lista_Usuarios.php';
            }
        } else {
            include 'vista/lista_Usuarios.php';
        }
        ?>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
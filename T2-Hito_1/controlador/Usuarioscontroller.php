<?php
require_once '../modelo/class_usuario.php';

class Usuarioscontroller {
    private $modelo;

    public function __construct() {
        $this->modelo = new Usuario();
    }

    public function agregarUsuario($nombre, $apellido1, $apellido2, $email, $edad) {
        $this->modelo->agregarUsuario($nombre, $apellido1, $apellido2, $email, $edad);
    }

    public function listarUsuario() {
        return $this->modelo->obtenerUsuario();
    }

    public function obtenerUsuarioPorId($id_usuario) {
        return $this->modelo->obtenerUsuarioPorId($id_usuario);
    }

    public function actualizarUsuario($id_usuario, $nombre, $apellido1, $apellido2, $email, $edad) {
        $this->modelo->actualizarUsuario($id_usuario, $nombre, $apellido1, $apellido2, $email, $edad);
    }

    public function eliminarUsuario($id_usuario) {
        $this->modelo->eliminarUsuario($id_usuario);
    }
}
?>
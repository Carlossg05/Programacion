import java.sql.*;
import java.util.Scanner;

public class ServicioCine {

    public void verPeliculas() {
        String query = "SELECT p.titulo, p.director, p.año, p.genero, " +
                       "f.fecha, f.hora, f.sala " +
                       "FROM peliculas p " +
                       "LEFT JOIN funciones f ON p.id_pelicula = f.id_pelicula " +
                       "ORDER BY p.titulo, f.fecha, f.hora";

        try (Connection conexion = ConexionBaseDeDatos.getConnection();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.printf("%-30s %-20s %-5s %-15s %-10s %-8s %-5s%n", 
                "Título", "Director", "Año", "Género", "Fecha", "Hora", "Sala");
            System.out.println("--------------------------------------------------------------------------------------------------");

            boolean hayDatos = false;
            while (rs.next()) {
                hayDatos = true;
                String titulo = rs.getString("titulo");
                String director = rs.getString("director");
                int año = rs.getInt("año");
                String genero = rs.getString("genero");
                Date fecha = rs.getDate("fecha");
                Time hora = rs.getTime("hora");
                int sala = rs.getInt("sala");

                String fechaStr = (fecha != null) ? fecha.toString() : "-";
                String horaStr = (hora != null) ? hora.toString() : "-";
                String salaStr = (rs.wasNull()) ? "-" : Integer.toString(sala);

                System.out.printf("%-30s %-20s %-5d %-15s %-10s %-8s %-5s%n", 
                    titulo, director, año, genero, fechaStr, horaStr, salaStr);
            }
            if (!hayDatos) {
                System.out.println("No hay películas registradas en la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al acceder a la base de datos: " + e.getMessage());
        }
    }

    public void anadirPelicula(Scanner scanner) {
        try {
            System.out.print("Ingrese el título de la película: ");
            String titulo = scanner.nextLine().trim();

            System.out.print("Ingrese el director de la película: ");
            String director = scanner.nextLine().trim();

            int año;
            while (true) {
                System.out.print("Ingrese el año de la película: ");
                if (scanner.hasNextInt()) {
                    año = scanner.nextInt();
                    scanner.nextLine(); // limpiar buffer
                    if (año > 1800 && año <= 2100) break;
                    else System.out.println("Año inválido. Intente de nuevo.");
                } else {
                    System.out.println("Por favor, ingrese un número válido para el año.");
                    scanner.next();
                }
            }

            System.out.print("Ingrese el género de la película: ");
            String genero = scanner.nextLine().trim();

            String insertQuery = "INSERT INTO peliculas (titulo, director, año, genero) VALUES (?, ?, ?, ?)";

            try (Connection conexion = ConexionBaseDeDatos.getConnection();
                 PreparedStatement pstmt = conexion.prepareStatement(insertQuery)) {
                 
                pstmt.setString(1, titulo);
                pstmt.setString(2, director);
                pstmt.setInt(3, año);
                pstmt.setString(4, genero);

                pstmt.executeUpdate();
                System.out.println("Película añadida con éxito.");
            } catch (SQLIntegrityConstraintViolationException ex) {
                System.out.println("La película ya existe (clave duplicada). No se añadió.");
            } catch (SQLException e) {
                System.out.println("Error al añadir la película: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error en la entrada de datos: " + e.getMessage());
            scanner.nextLine(); // limpiar buffer en caso de error
        }
    }

    public void eliminarPelicula(Scanner scanner) {
        try {
            System.out.print("Ingrese el id de la película a eliminar: ");
            int idPelicula;
            if (scanner.hasNextInt()) {
                idPelicula = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer
            } else {
                System.out.println("ID inválido.");
                scanner.nextLine();
                return;
            }

            String deleteQuery = "DELETE FROM peliculas WHERE id_pelicula = ?";

            try (Connection conexion = ConexionBaseDeDatos.getConnection();
                 PreparedStatement pstmt = conexion.prepareStatement(deleteQuery)) {
                 
                pstmt.setInt(1, idPelicula);
                int filasAfectadas = pstmt.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Película eliminada con éxito.");
                } else {
                    System.out.println("No se encontró la película con la clave proporcionada.");
                }
            } catch (SQLException e) {
                System.out.println("Error al eliminar la película: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error en la entrada: " + e.getMessage());
            scanner.nextLine(); // limpiar buffer en caso de error
        }
    }

    public void modificarPelicula(Scanner scanner) {
        try {
            System.out.print("Ingrese el id de la película a modificar: ");
            int idPelicula;
            if (scanner.hasNextInt()) {
                idPelicula = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer
            } else {
                System.out.println("ID inválido.");
                scanner.nextLine();
                return;
            }

            System.out.print("Ingrese el nuevo título de la película: ");
            String nuevoTitulo = scanner.nextLine().trim();

            System.out.print("Ingrese el nuevo director de la película: ");
            String nuevoDirector = scanner.nextLine().trim();

            String updateQuery = "UPDATE peliculas SET titulo = ?, director = ? WHERE id_pelicula = ?";

            try (Connection conexion = ConexionBaseDeDatos.getConnection();
                 PreparedStatement pstmt = conexion.prepareStatement(updateQuery)) {
                 
                pstmt.setString(1, nuevoTitulo);
                pstmt.setString(2, nuevoDirector);
                pstmt.setInt(3, idPelicula);

                int filasAfectadas = pstmt.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Película modificada con éxito.");
                } else {
                    System.out.println("No se encontró la película con la clave proporcionada.");
                }
            } catch (SQLException e) {
                System.out.println("Error al modificar la película: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error en la entrada: " + e.getMessage());
            scanner.nextLine(); // limpiar buffer en caso de error
        }
    }
}
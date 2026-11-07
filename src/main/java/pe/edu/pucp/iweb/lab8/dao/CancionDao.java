package pe.edu.pucp.iweb.lab8.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pe.edu.pucp.iweb.lab8.beans.Cancion;

public class CancionDao extends BaseDao { // TODO: heredar de BaseDao

    /**
     * Ejercicio 2: todas las canciones (con el nombre de su género, JOIN),
     * ordenadas por título. Use PreparedStatement.
     */
    public ArrayList<Cancion> listar() {
        ArrayList<Cancion> lista = new ArrayList<>();
        String sql = "SELECT idcancion, titulo,artista,duracion_seg,anio,c.idgenero " +
                "FROM cancion c INNER JOIN genero g ON c.idgenero = g.idgenero " +
                "ORDER BY titulo";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Cancion cancion = new Cancion();
                cancion.setIdcancion(rs.getInt("idcancion"));
                cancion.setTitulo(rs.getString("titulo"));
                cancion.setArtista(rs.getString("artista"));
                cancion.setDuracion_seg(rs.getInt("duracion_seg"));
                cancion.setAnio(rs.getInt("anio"));
                cancion.setGenero(rs.getInt("idgenero"));
                lista.add(cancion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }



    /**
     * Ejercicio 2: la canción con ese id, o null si no existe.
     */
    public Cancion buscarPorId(int idCancion) {
        String sql = "SELECT idcancion, nombre FROM centro WHERE idcancion = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idCancion);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Cancion();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Ejercicio 2: INSERT de una canción nueva (PreparedStatement).
     */
    public void crear(Cancion cancion) {
        String sql = "INSERT INTO cancion(titulo, artista, duracion_seg, " +
                "anio, idgenero) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cancion.getTitulo());
            ps.setString(2, cancion.getArtista());
            ps.setInt(3, cancion.getDuracion_seg());
            ps.setInt(4, cancion.getAnio());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear la cancion", e);
        }
    }
    /**
     * Ejercicio 2: UPDATE de una canción existente (PreparedStatement).
     */
    public void actualizar(Cancion cancion) {
        // TODO
        String sql = "UPDATE cancion SET titulo = ?, artista = ?, duracion_seg = ?,anio = ?,idgenero = ? "
                + "WHERE idcancion = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cancion.getTitulo());
            pstmt.setString(2, cancion.getArtista());
            pstmt.setInt(3, cancion.getDuracion_seg());
            pstmt.setInt(4, cancion.getAnio());
            pstmt.setInt(5, cancion.getIdcancion());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Ejercicio 3: DELETE por id (PreparedStatement).
     */
    public void eliminar(int idCancion) {
        String sql = "DELETE FROM cancion WHERE id_cancion = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idCancion);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

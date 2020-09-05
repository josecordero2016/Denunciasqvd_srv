/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "puntuacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puntuacion.findAll", query = "SELECT p FROM Puntuacion p")
    , @NamedQuery(name = "Puntuacion.findByIdPuntuacion", query = "SELECT p FROM Puntuacion p WHERE p.idPuntuacion = :idPuntuacion")})
public class Puntuacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_puntuacion")
    private Integer idPuntuacion;
    @JoinColumn(name = "id_denuncia", referencedColumnName = "id_denuncia")
    @ManyToOne(optional = false)
    private Denuncia idDenuncia;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Puntuacion() {
    }

    public Puntuacion(Integer idPuntuacion) {
        this.idPuntuacion = idPuntuacion;
    }

    public Integer getIdPuntuacion() {
        return idPuntuacion;
    }

    public void setIdPuntuacion(Integer idPuntuacion) {
        this.idPuntuacion = idPuntuacion;
    }

    public Denuncia getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(Denuncia idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPuntuacion != null ? idPuntuacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puntuacion)) {
            return false;
        }
        Puntuacion other = (Puntuacion) object;
        if ((this.idPuntuacion == null && other.idPuntuacion != null) || (this.idPuntuacion != null && !this.idPuntuacion.equals(other.idPuntuacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rest.Puntuacion[ idPuntuacion=" + idPuntuacion + " ]";
    }
    
}

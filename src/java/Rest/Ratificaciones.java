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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author im_jo
 */
@Entity
@Table(name = "ratificaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ratificaciones.findAll", query = "SELECT r FROM Ratificaciones r")
    , @NamedQuery(name = "Ratificaciones.findByIdRatificacion", query = "SELECT r FROM Ratificaciones r WHERE r.idRatificacion = :idRatificacion")
    , @NamedQuery(name = "Ratificaciones.findByVerdadero", query = "SELECT r FROM Ratificaciones r WHERE r.verdadero = :verdadero")})
public class Ratificaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ratificacion")
    private Integer idRatificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "verdadero")
    private String verdadero;
    @JoinColumn(name = "id_denuncia", referencedColumnName = "id_denuncia")
    @ManyToOne(optional = false)
    private Denuncia idDenuncia;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Ratificaciones() {
    }

    public Ratificaciones(Integer idRatificacion) {
        this.idRatificacion = idRatificacion;
    }

    public Ratificaciones(Integer idRatificacion, String verdadero) {
        this.idRatificacion = idRatificacion;
        this.verdadero = verdadero;
    }

    public Integer getIdRatificacion() {
        return idRatificacion;
    }

    public void setIdRatificacion(Integer idRatificacion) {
        this.idRatificacion = idRatificacion;
    }

    public String getVerdadero() {
        return verdadero;
    }

    public void setVerdadero(String verdadero) {
        this.verdadero = verdadero;
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
        hash += (idRatificacion != null ? idRatificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ratificaciones)) {
            return false;
        }
        Ratificaciones other = (Ratificaciones) object;
        if ((this.idRatificacion == null && other.idRatificacion != null) || (this.idRatificacion != null && !this.idRatificacion.equals(other.idRatificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rest.Ratificaciones[ idRatificacion=" + idRatificacion + " ]";
    }
    
}

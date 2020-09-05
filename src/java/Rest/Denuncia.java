/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "denuncia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Denuncia.findAll", query = "SELECT d FROM Denuncia d")
    , @NamedQuery(name = "Denuncia.findByIdDenuncia", query = "SELECT d FROM Denuncia d WHERE d.idDenuncia = :idDenuncia")
    , @NamedQuery(name = "Denuncia.findByLatitud", query = "SELECT d FROM Denuncia d WHERE d.latitud = :latitud")
    , @NamedQuery(name = "Denuncia.findByLongitud", query = "SELECT d FROM Denuncia d WHERE d.longitud = :longitud")
    , @NamedQuery(name = "Denuncia.findByTitulo", query = "SELECT d FROM Denuncia d WHERE d.titulo = :titulo")
    , @NamedQuery(name = "Denuncia.findByDetalles", query = "SELECT d FROM Denuncia d WHERE d.detalles = :detalles")
    , @NamedQuery(name = "Denuncia.findByTipo", query = "SELECT d FROM Denuncia d WHERE d.tipo = :tipo")
    , @NamedQuery(name = "Denuncia.findByFecha", query = "SELECT d FROM Denuncia d WHERE d.fecha = :fecha")})
public class Denuncia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_denuncia")
    private Integer idDenuncia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "latitud")
    private String latitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "longitud")
    private String longitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 250)
    @Column(name = "detalles")
    private String detalles;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDenuncia")
    private Collection<Puntuacion> puntuacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDenuncia")
    private Collection<DetalleDenuncia> detalleDenunciaCollection;
    @OneToMany(mappedBy = "idDenuncia")
    private Collection<Notificacion> notificacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDenuncia")
    private Collection<Ratificaciones> ratificacionesCollection;

    public Denuncia() {
    }

    public Denuncia(Integer idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public Denuncia(Integer idDenuncia, String latitud, String longitud, String titulo, String tipo, Date fecha) {
        this.idDenuncia = idDenuncia;
        this.latitud = latitud;
        this.longitud = longitud;
        this.titulo = titulo;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public Integer getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(Integer idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public Collection<Puntuacion> getPuntuacionCollection() {
        return puntuacionCollection;
    }

    public void setPuntuacionCollection(Collection<Puntuacion> puntuacionCollection) {
        this.puntuacionCollection = puntuacionCollection;
    }

    @XmlTransient
    public Collection<DetalleDenuncia> getDetalleDenunciaCollection() {
        return detalleDenunciaCollection;
    }

    public void setDetalleDenunciaCollection(Collection<DetalleDenuncia> detalleDenunciaCollection) {
        this.detalleDenunciaCollection = detalleDenunciaCollection;
    }

    @XmlTransient
    public Collection<Notificacion> getNotificacionCollection() {
        return notificacionCollection;
    }

    public void setNotificacionCollection(Collection<Notificacion> notificacionCollection) {
        this.notificacionCollection = notificacionCollection;
    }

    @XmlTransient
    public Collection<Ratificaciones> getRatificacionesCollection() {
        return ratificacionesCollection;
    }

    public void setRatificacionesCollection(Collection<Ratificaciones> ratificacionesCollection) {
        this.ratificacionesCollection = ratificacionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDenuncia != null ? idDenuncia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Denuncia)) {
            return false;
        }
        Denuncia other = (Denuncia) object;
        if ((this.idDenuncia == null && other.idDenuncia != null) || (this.idDenuncia != null && !this.idDenuncia.equals(other.idDenuncia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rest.Denuncia[ idDenuncia=" + idDenuncia + " ]";
    }
    
}

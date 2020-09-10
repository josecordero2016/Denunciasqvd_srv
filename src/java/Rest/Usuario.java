/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author im_jo
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByNombres", query = "SELECT u FROM Usuario u WHERE u.nombres = :nombres")
    , @NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos")
    , @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono")
    , @NamedQuery(name = "Usuario.findByLatitudHogar", query = "SELECT u FROM Usuario u WHERE u.latitudHogar = :latitudHogar")
    , @NamedQuery(name = "Usuario.findByLongitudHogar", query = "SELECT u FROM Usuario u WHERE u.longitudHogar = :longitudHogar")
    , @NamedQuery(name = "Usuario.findByLatitudActual", query = "SELECT u FROM Usuario u WHERE u.latitudActual = :latitudActual")
    , @NamedQuery(name = "Usuario.findByLongitudActual", query = "SELECT u FROM Usuario u WHERE u.longitudActual = :longitudActual")
    , @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo")
    , @NamedQuery(name = "Usuario.findByNombreUsuario", query = "SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario")
    , @NamedQuery(name = "Usuario.findByClave", query = "SELECT u FROM Usuario u WHERE u.clave = :clave")
    , @NamedQuery(name = "Usuario.findByTipo", query = "SELECT u FROM Usuario u WHERE u.tipo = :tipo")})
public class Usuario implements Serializable {

    @Lob
    @Column(name = "imagen")
    private byte[] imagen;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "latitud_hogar")
    private String latitudHogar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "longitud_hogar")
    private String longitudHogar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "latitud_actual")
    private String latitudActual;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "longitud_actual")
    private String longitudActual;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<Denuncia> denunciaCollection;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Notificacion> notificacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<Ratificaciones> ratificacionesCollection;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String nombres, String apellidos, String telefono, String latitudHogar, String longitudHogar, String latitudActual, String longitudActual, String correo, String nombreUsuario, String clave, String tipo) {
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.latitudHogar = latitudHogar;
        this.longitudHogar = longitudHogar;
        this.latitudActual = latitudActual;
        this.longitudActual = longitudActual;
        this.correo = correo;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.tipo = tipo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLatitudHogar() {
        return latitudHogar;
    }

    public void setLatitudHogar(String latitudHogar) {
        this.latitudHogar = latitudHogar;
    }

    public String getLongitudHogar() {
        return longitudHogar;
    }

    public void setLongitudHogar(String longitudHogar) {
        this.longitudHogar = longitudHogar;
    }

    public String getLatitudActual() {
        return latitudActual;
    }

    public void setLatitudActual(String latitudActual) {
        this.latitudActual = latitudActual;
    }

    public String getLongitudActual() {
        return longitudActual;
    }

    public void setLongitudActual(String longitudActual) {
        this.longitudActual = longitudActual;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    @XmlTransient
    public Collection<Denuncia> getDenunciaCollection() {
        return denunciaCollection;
    }

    public void setDenunciaCollection(Collection<Denuncia> denunciaCollection) {
        this.denunciaCollection = denunciaCollection;
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
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rest.Usuario[ idUsuario=" + idUsuario + " ]";
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
}

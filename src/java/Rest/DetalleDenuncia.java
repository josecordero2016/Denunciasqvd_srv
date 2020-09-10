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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author im_jo
 */
@Entity
@Table(name = "detalle_denuncia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleDenuncia.findAll", query = "SELECT d FROM DetalleDenuncia d")
    , @NamedQuery(name = "DetalleDenuncia.findByIdDetalleDenuncia", query = "SELECT d FROM DetalleDenuncia d WHERE d.idDetalleDenuncia = :idDetalleDenuncia")})
public class DetalleDenuncia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_denuncia")
    private Integer idDetalleDenuncia;
    @Lob
    @Column(name = "imagen")
    private byte[] imagen;
    @JoinColumn(name = "id_denuncia", referencedColumnName = "id_denuncia")
    @ManyToOne(optional = false)
    private Denuncia idDenuncia;

    public DetalleDenuncia() {
    }

    public DetalleDenuncia(Integer idDetalleDenuncia) {
        this.idDetalleDenuncia = idDetalleDenuncia;
    }

    public Integer getIdDetalleDenuncia() {
        return idDetalleDenuncia;
    }

    public void setIdDetalleDenuncia(Integer idDetalleDenuncia) {
        this.idDetalleDenuncia = idDetalleDenuncia;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Denuncia getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(Denuncia idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleDenuncia != null ? idDetalleDenuncia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleDenuncia)) {
            return false;
        }
        DetalleDenuncia other = (DetalleDenuncia) object;
        if ((this.idDetalleDenuncia == null && other.idDetalleDenuncia != null) || (this.idDetalleDenuncia != null && !this.idDetalleDenuncia.equals(other.idDetalleDenuncia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rest.DetalleDenuncia[ idDetalleDenuncia=" + idDetalleDenuncia + " ]";
    }
    
}

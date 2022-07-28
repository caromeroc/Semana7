package com.co.udea.mintic.db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "vendedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedores.findAll", query = "SELECT v FROM Vendedores v"),
    @NamedQuery(name = "Vendedores.findByDocumentoVendedor", query = "SELECT v FROM Vendedores v WHERE v.documentoVendedor = :documentoVendedor"),
    @NamedQuery(name = "Vendedores.findByNombres", query = "SELECT v FROM Vendedores v WHERE v.nombres = :nombres"),
    @NamedQuery(name = "Vendedores.findByApellidos", query = "SELECT v FROM Vendedores v WHERE v.apellidos = :apellidos"),
    @NamedQuery(name = "Vendedores.findByCiudad", query = "SELECT v FROM Vendedores v WHERE v.ciudad = :ciudad")})
public class Vendedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "documento_vendedor")
    private Integer documentoVendedor;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentoVendedor")
    private Collection<Vehiculos> vehiculosCollection;

    public Vendedores() {
    }

    public Vendedores(Integer documentoVendedor) {
        this.documentoVendedor = documentoVendedor;
    }

    public Vendedores(Integer documentoVendedor, String nombres, String apellidos, String ciudad) {
        this.documentoVendedor = documentoVendedor;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.ciudad = ciudad;
    }

    public Integer getDocumentoVendedor() {
        return documentoVendedor;
    }

    public void setDocumentoVendedor(Integer documentoVendedor) {
        this.documentoVendedor = documentoVendedor;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @XmlTransient
    public Collection<Vehiculos> getVehiculosCollection() {
        return vehiculosCollection;
    }

    public void setVehiculosCollection(Collection<Vehiculos> vehiculosCollection) {
        this.vehiculosCollection = vehiculosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoVendedor != null ? documentoVendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedores)) {
            return false;
        }
        Vendedores other = (Vendedores) object;
        if ((this.documentoVendedor == null && other.documentoVendedor != null) || (this.documentoVendedor != null && !this.documentoVendedor.equals(other.documentoVendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.udea.mintic.db.Vendedores[ documentoVendedor=" + documentoVendedor + " ]";
    }
    
}

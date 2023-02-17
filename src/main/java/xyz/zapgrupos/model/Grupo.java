package xyz.zapgrupos.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.regex.Pattern;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "URLs")
@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@NamedNativeQuery(
        name = "GruposQuery",
        query = "db.URLs.find({})",
        resultClass = Grupo.class)

//@ResultSetMapping(
//        name="GruposResult",
//        classes={
//                @ConstructorResult(
//                        columns={
//                                @ColumnResult(name="id", type=String.class),
//                                @ColumnResult(name="titulo", type=String.class)
//                        },
//                        targetClass= Grupo.class)})

public abstract class Grupo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Type(type = "objectid")

    public String id;
    public String titulo;
    @Column(unique=true)
    public String url;
    //List<String> imgUrl;
    public Integer qtd_member;
    public Boolean status;
    public String tipo;
    public String type;
    public String descricao;
    public Boolean ativo;
    public String categoria;
    public String linkOrigem;
    public String pais;
    public Integer vizita;
    public String siteMae;
    public Date created_at;
    public Date updated_at;
    public Date deleted_at;
    public String imgGroupUrl;
    public boolean sensivel;

    public Grupo() {

    }

    public Grupo(String url) {
        this.url = url;
        this.categoria = "Outros";
        this.ativo = true;
        this.sensivel = false;
    }

    public void setId(String value){
        this.id = value;
    }
    public String getId() {
        return id;
    }

    @PrePersist
    protected void onCreate() {
        created_at = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated_at = new Date();
    }

    @PreRemove
    protected void onRemove() {
        deleted_at = new Date();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /*
    public List<String> getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(List<String> imgUrl) {
        this.imgUrl = imgUrl;
    }
    */
    public Integer getQtd_member() {
        return qtd_member;
    }

    public void setQtd_member(Integer qtd_members) {
        this.qtd_member = qtd_members;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLinkOrigem() {
        return linkOrigem;
    }

    public void setLinkOrigem(String linkOrigem) {
        this.linkOrigem = linkOrigem;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getVizita() {
        return vizita;
    }

    public void setVizita(Integer vizita) {
        this.vizita = vizita;
    }

    public String getSiteMae() {
        return siteMae;
    }

    public void setSiteMae(String siteMae) {
        this.siteMae = siteMae;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Date deleted_at) {
        this.deleted_at = deleted_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSensivel() {
        return sensivel;
    }

    public void setSensivel(boolean sensivel) {
        this.sensivel = sensivel;
    }

    public String getImgGroupUrl() {
        return imgGroupUrl;
    }

    public void setImgGroupUrl(String imgGroupUrl) {
        this.imgGroupUrl = imgGroupUrl;
    }

    abstract public Pattern getTitleRegex();
    abstract public Pattern getImgUrlRegex();
    abstract public Pattern getRegexDescription();
}


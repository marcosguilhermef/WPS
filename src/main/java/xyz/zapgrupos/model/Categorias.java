package xyz.zapgrupos.model;

import org.bson.types.ObjectId;

import javax.persistence.*;

@Entity
@Table(name = "Categorias")
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    ObjectId id;
    @Column(unique=true)
    String categoria;
    String img;
    String site;

    public Categorias(String categoria){
        this.categoria = categoria;
    }
}

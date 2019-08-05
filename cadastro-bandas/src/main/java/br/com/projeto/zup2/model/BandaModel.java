package br.com.projeto.zup2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Banda")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BandaModel {

    @Id
    @Column(name = "nome")
    private String name;

    @Column(name = "estilo")
    private String style;

    @Column(name = "musica")
    private String song;

}

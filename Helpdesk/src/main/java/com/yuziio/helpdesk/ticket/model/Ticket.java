package com.yuziio.helpdesk.ticket.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tabela") /*  @document diz que essa classe sera armazenada como um documento do MongoDB e ao lado o nome da coleção */
public class Ticket {

    @Id  /* Define a variavel que sera usada como ID no banco de dados*/
    private String id; /* ID do ticket */


    /* Campos principais que serão enviados pelo front end */

    private String name;
    private String sector;
    private String problem;


    /* Getters e Setters responsaveis por acessar os atributos principais ou altera-los */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}

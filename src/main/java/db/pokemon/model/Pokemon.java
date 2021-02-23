package db.pokemon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "poke")
public class Pokemon implements Serializable, Comparable<Pokemon> {

    @Serial
    private static final long serialVersionUID = 1L; //adding this to get rid of the warning message. We dont use it at all.

    @Id
    private int id;
    private String name;
    private String type;
    private String region;
    private String imageUrl;

    public int compareTo(Pokemon pokemon){
        if (this.getId() > pokemon.getId()){
            return 1;
        } else if (this.getId() < pokemon.getId()){
            return -1;
        } else{
            return 0;
        }
    }
}

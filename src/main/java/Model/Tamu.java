package Model;

//import Model.Kamar;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Tamu extends PanacheEntityBase {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "org.hibernate.id.UUIDGenerator")
    public String id;
    public String nama_tamu;
    public String no_ktp;
    public String alamat_tamu;
    public String no_hp;
    public String email;
//    @ManyToOne
//    @JoinColumn(name = "kamar_id")
//    public Kamar kamar;

    }

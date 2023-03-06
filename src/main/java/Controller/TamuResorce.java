package Controller;

import Model.Tamu;
import Service.TamuService;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;
import javax.persistence.EntityManager;

@Path("/tamu")
public class TamuResorce {
    @Inject
    TamuService tamuService;
    @GET
    public List<Tamu> listTamu(){
        return Tamu.listAll();
    }
    // add(menambahkan data)
    //kalau pake persist pake ini nambahin data ke database cuma pisa dipake kalau public
    @POST
    public Tamu postTamu(JsonObject body) {
        return tamuService.postTamu(body);
    }
    @Inject
    EntityManager entityManager;
    @PUT
//    @Path("/{nama_tamu}")
    @Path("/{nama_tamu: [a-zA-Z]+}")
    @Transactional
    @Produces("application/json")
    @Consumes("application/json")
    public JsonObject putTamu(@PathParam("nama_tamu") String nama_tamu, JsonObject body){
        String newNama = body.getString("nama_tamu");
        String newNo_KTP = body.getString("no_ktp");
        String newAlamat = body.getString("alamat_tamu");
        String newNo_Hp= body.getString("no_hp");
        String newEmail = body.getString("email");

        //Tamu.update("nama_tamu = ?1,no_ktp = ?2,alamat_tamu = ?3,no_hp = ?4,email = ?5 where nama_tamu =?6", newNama,newNo_KTP,newAlamat,newNo_Hp,newEmail,nama_tamu);
        Tamu tamu = Tamu.find("LOWER(nama_tamu)", nama_tamu.toLowerCase()).firstResult();
        tamu.nama_tamu = newNama;
        tamu.no_ktp = newNo_KTP;
        tamu.alamat_tamu = newAlamat;
        tamu.no_hp = newNo_Hp;
        tamu.email = newEmail;
        entityManager.persist(tamu);
        return body;
    }

    @DELETE
    public JsonObject deleteTamu(JsonObject body){
        return tamuService.deleteTamu(body);
    }
}






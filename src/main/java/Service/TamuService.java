package Service;

////import Model.Kamar;
import Model.Tamu;

import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class TamuService {
    @Transactional
    public Tamu postTamu(JsonObject body) {
////        Kamar kamar = Kamar.find("nomor_kamar = ?1", body.getString("nomor_kamar")).firstResult();
        Tamu tamu = new Tamu();
        tamu.nama_tamu = body.getString("nama_tamu");
        tamu.no_ktp = body.getString("no_ktp");
        tamu.alamat_tamu = body.getString("alamat_tamu");
        tamu.no_hp = body.getString("no_hp");
        tamu.email = body.getString("email");
////        tamu.kamar = kamar;
        tamu.persist();
        return tamu;
    }

    @Transactional
    public JsonObject deleteTamu(JsonObject body) {
        Tamu tamu = Tamu.find("nama_tamu = ?1", body.getString("nama_tamu")).firstResult();
        Tamu.delete("id =?1", tamu.id);
        Tamu.delete("nama_tamu", body.getString("nama_tamu"));
        return body;
    }



}





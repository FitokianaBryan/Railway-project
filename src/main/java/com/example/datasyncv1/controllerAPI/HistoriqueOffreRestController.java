package com.example.datasyncv1.controllerAPI;

import com.example.datasyncv1.connex.Connexion;
import com.example.datasyncv1.dao.EnchereDao;
import com.example.datasyncv1.dao.HistoriqueOffreDao;
import com.example.datasyncv1.dao.TokenUserDao;
import com.example.datasyncv1.dao.UtilisateurDao;
import com.example.datasyncv1.models.Enchere;
import com.example.datasyncv1.models.HistoriqueOffre;
import com.example.datasyncv1.models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.util.List;

@RestController
@RequestMapping("/api/HistoriqueOffre")
public class HistoriqueOffreRestController {
    Connexion con = new Connexion();
    HistoriqueOffreDao hod = new HistoriqueOffreDao();
    Connection con1;
    {
        try {
            con1 = objectBdd.ManipDb.pgConnect("postgres","railway","93owc40E08BF1Ih6aG6m");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    HistoriqueOffreDao ho = new HistoriqueOffreDao();
    @PostMapping("ReEncherir")
    public Response ReEncherir(@RequestParam("idEnchere") int idEnchere,@PathVariable int iduser,@RequestParam("montant") float montant_offre) throws Exception {
        Response response = new Response();
       // TokenUserDao tud = new TokenUserDao();
     //   if(tud.validTokenUser(token)!=0)
       // {
         float montant_user = new UtilisateurDao().getCompteUser(iduser,con);
         Enchere e = new EnchereDao().getObjetEchere(con,idEnchere);
         if(hod.siUserVendeur(con,idEnchere,iduser))
         {
             response.setMessage("vous ne pouvez pas participer sur votre propre enchere");
         }
         else
         {
             if(montant_user<montant_offre)
             {
                 response.setMessage("Solde insuffisante");
             }
             else if(montant_offre<=e.getPrixMinimumVente())
             {
                 response.setMessage("solde inferieur au prix minimum vente");
             }
             else {
                 ho.Encherir(con,idEnchere,iduser,montant_offre);
                 ho.setCompteUser(iduser,montant_offre,con);
                 response.setMessage("votre offre a ??t?? bien prise en compte");
             }
         }
       // }
       // else{
         //   response.setMessage("veuillez dabord vous authentifier");
       // }
        return response;
    }

    @GetMapping("listeOffre")
    public ResponseEntity<List<HistoriqueOffre>> listeOffre(@RequestParam("idEnchere") int idEnchere)
    {
        try {
            return new ResponseEntity<List<HistoriqueOffre>>(new HistoriqueOffreDao().ListeOffre(con1,idEnchere), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

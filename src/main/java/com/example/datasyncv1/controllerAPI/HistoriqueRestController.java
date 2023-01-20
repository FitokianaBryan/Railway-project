package com.example.datasyncv1.controllerAPI;

import com.example.datasyncv1.connex.Connexion;
import com.example.datasyncv1.dao.EnchereDao;
import com.example.datasyncv1.dao.HistoriqueEnchereDao;
import com.example.datasyncv1.dao.HistoriqueOffreDao;
import com.example.datasyncv1.dao.TokenUserDao;
import com.example.datasyncv1.models.Enchere;
import com.example.datasyncv1.models.ResultatEnchere;
import com.example.datasyncv1.models.TokenUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.util.List;

@RestController
@RequestMapping("/api/historique")
public class HistoriqueRestController {
    Connexion con = new Connexion();
    Connection con1;
    {
        try {
            con1 = objectBdd.ManipDb.pgConnect("postgres","railway","93owc40E08BF1Ih6aG6m");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("HistoriqueEncherisseur")
    public ResponseEntity<List<Object[]>> HistoriqueEncherisseur(@RequestHeader("token") String token)
    {
        TokenUserDao tud = new TokenUserDao();
        TokenUser tu = null;
         try {
             if(tud.validTokenUser(token)!=0)
             {
                 return new ResponseEntity<List<Object[]>>(new HistoriqueEnchereDao().HistoriqueEncherisseur(con,tu.getIdUtilisateur()), HttpStatus.OK);
             }
             else {
                 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
             }

         }
         catch(Exception e)
         {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
    }

    @GetMapping("HistoriqueVente")
    public ResponseEntity<List<Object[]>> HistoriqueVente(@RequestHeader("token") String token)
    {
        TokenUserDao tud = new TokenUserDao();
        TokenUser tu = null;
        try {
            if(tud.validTokenUser(token)!=0)
            {
                return new ResponseEntity<List<Object[]>>(new HistoriqueEnchereDao().HistoriqueVente(con,tu.getIdUtilisateur()), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("ResultatEnchere")
    public ResponseEntity<List<ResultatEnchere>> HistoriqueVente(@RequestParam("idEnchere") int idEnchere)
    {
        try {
                return new ResponseEntity<List<ResultatEnchere>>(new HistoriqueOffreDao().userGagnant(con1,idEnchere), HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
